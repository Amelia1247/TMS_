using DTO;

namespace Contracts;

public interface ITeamService
{
    Task<TeamDTO> AddTeam(TeamDTO teamDto);
    Task<List<TeamDTO>> GetAllTeams();
    
}