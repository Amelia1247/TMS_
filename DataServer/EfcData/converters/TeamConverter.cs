using DTO;
using EfcData.Entities;

namespace EfcData.converters;

public class TeamConverter
{
    public TeamDTO ToDTO(TeamEntity team) {
        return new TeamDTO {
            Name = team.Name,
            Players = new List<PlayerDTO>()
        };
    }

    public List<TeamDTO> ToDTOList(List<TeamEntity> teams)
    {
        List<TeamDTO> _teams = new List<TeamDTO>();
        foreach (var team in teams)
        {
            _teams.Add(ToDTO(team));
        }

        return _teams;
    }
    
    public TeamEntity ToEntity(TeamDTO team) {
        return new TeamEntity {
            Name = team.Name
        };
    }
    
    public List<TeamEntity> ToEntityList(List<TeamDTO> teams)
    {
        List<TeamEntity> _teams = new List<TeamEntity>();
        foreach (var team in teams)
        {
            _teams.Add(ToEntity(team));
        }

        return _teams;
    }
}