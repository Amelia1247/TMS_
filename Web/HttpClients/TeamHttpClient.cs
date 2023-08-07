using Contracts;
using DTO;

namespace HttpClients;

public class TeamHttpClient : ITeamService
{
    public async Task<TeamDTO> AddTeam(TeamDTO teamDto)
    {
        return await HttpClientUtil.SendHttpPostRequest<TeamDTO, TeamDTO>("team", teamDto);
    }

    public async Task<List<TeamDTO>> GetAllTeams()
    {
        return await HttpClientUtil.SendHttpGetRequest<TeamDTO, List<TeamDTO>>("team");
    }
}