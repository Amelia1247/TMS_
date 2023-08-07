using Contracts;
using DTO;
using Grpc.Core;
using grpcProtoFiles;
using GrpcService.converters;

namespace GrpcService.GrpcController;


public class TeamController : TeamService.TeamServiceBase {
    private readonly ITeamService _teamService;
    private readonly TeamConverter _teamConverter;

    public TeamController(ITeamService teamService, TeamConverter teamConverter) {
        _teamService = teamService;
        _teamConverter = teamConverter;
    }

    public override async Task<CreateTeamResponse> CreateTeam(CreateTeamRequest request, ServerCallContext context) {
        TeamDTO team = _teamConverter.ToDTO(request.Team);
        var addedTeam = await _teamService.AddTeam(team);
        return new CreateTeamResponse {
            Team = _teamConverter.ToProto(addedTeam)
        };
    }

    public override async Task<GetAllTeamsResponse> GetAllTeams(GetAllTeamsRequest request,
        ServerCallContext context) {
        var teams = await _teamService.GetAllTeams();
        return new GetAllTeamsResponse() {
            Teams = { _teamConverter.ToProtoList(teams) }
        };
    }

}