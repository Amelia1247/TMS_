using Contracts;
using DTO;

namespace HttpClients;

public class PlayerHttpClient : IPlayerService
{
    public async Task<PlayerDTO> AddPlayer(PlayerDTO playerDto)
    {
        return await HttpClientUtil.SendHttpPostRequest<PlayerDTO, PlayerDTO>("player", playerDto);
    }

    public async Task<List<PlayerDTO>> GetAllPlayers()
    {
        return await HttpClientUtil.SendHttpGetRequest<PlayerDTO, List<PlayerDTO>>("player");
    }

    public async Task<List<PlayerDTO>> GetPlayerByTeam(string teamName)
    {
        return await HttpClientUtil.SendHttpGetRequest<PlayerDTO, List<PlayerDTO>>($"player?team={teamName}");
    }
}