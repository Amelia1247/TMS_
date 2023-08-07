using Contracts;
using DTO;
using Grpc.Core;
using grpcProtoFiles;
using GrpcService.converters;

namespace GrpcService.GrpcController;


public class TournamentController : TournamentService.TournamentServiceBase
{
    private readonly ITournamentService _tournamentService;
    private readonly TournamentConverter _tournamentConverter;

    public TournamentController(ITournamentService tournamentService, TournamentConverter tournamentConverter) {
        _tournamentService = tournamentService;
        _tournamentConverter = tournamentConverter;
    }

    public override async Task<CreateTournamentResponse> CreateTournament(CreateTournamentRequest request, ServerCallContext context)
    {
        TournamentDTO tournament = _tournamentConverter.ToDTO(request.Tournament);
        var addedTournament = await _tournamentService.AddTournament(tournament);
        return new CreateTournamentResponse {
            Tournament = _tournamentConverter.ToProto(addedTournament)
        };
    }
}