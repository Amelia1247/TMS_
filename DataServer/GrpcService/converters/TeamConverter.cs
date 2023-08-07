using DTO;
using Google.Protobuf.Collections;
using grpcProtoFiles;

namespace GrpcService.converters;

public class TeamConverter
{
    
    private readonly PlayerConverter playerConverter;

    public TeamConverter(PlayerConverter playerConverter)
    {
        this.playerConverter = playerConverter;
    }
    
    public TeamDTO ToDTO(Team team) {
        return new TeamDTO {
            Name = team.Name,
            Players = playerConverter.ToDTOList(team.Players.ToList())
        };
    }

    public List<TeamDTO> ToDTOList(List<Team> teams)
    {
        List<TeamDTO> _teams = new List<TeamDTO>();
        foreach (var team in teams)
        {
            _teams.Add(ToDTO(team));
        }

        return _teams;
    }

    public Team ToProto(TeamDTO team) {
        return new Team {
            Name = team.Name,
            Players = { playerConverter.ToProtoList(team.Players) }
        };
    }
    
    public RepeatedField<Team> ToProtoList(List<TeamDTO> teams)
    {
        List<Team> _teams = new List<Team>();
        foreach (var team in teams)
        {
            _teams.Add(ToProto(team));
        }

        return new RepeatedField<Team>(){_teams};
    }
}