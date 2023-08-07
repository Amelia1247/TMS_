using DTO;

namespace Contracts;

public interface IPlayerService
{
    Task<PlayerDTO> AddPlayer(PlayerDTO playerDto);
    Task<List<PlayerDTO>> GetAllPlayers();
    Task<List<PlayerDTO>> GetPlayerByTeam(string teamName);
}