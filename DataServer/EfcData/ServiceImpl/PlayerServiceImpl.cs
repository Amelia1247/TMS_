using Contracts;
using DTO;
using EfcData.converters;
using EfcData.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcData.ServiceImpl;

public class PlayerServiceImpl : IPlayerService {
    private readonly DatabaseAccess _databaseAccess;
    private readonly PlayerConverter _playerConverter;

    public PlayerServiceImpl(DatabaseAccess databaseAccess, PlayerConverter playerConverter) {
        _playerConverter = playerConverter;
        _databaseAccess = databaseAccess;
    }

    public async Task<PlayerDTO> AddPlayer(PlayerDTO player) {
        try {
            PlayerEntity playerEntity = _playerConverter.ToEntity(player);
            EntityEntry<PlayerEntity> addedPlayer = await _databaseAccess.Players.AddAsync(playerEntity);
            await _databaseAccess.SaveChangesAsync();
            return _playerConverter.ToDTO(addedPlayer.Entity);
        }
        catch (Exception e) {
            Console.WriteLine(e);
            throw new Exception("Name already exists. Please choose another");
        }
    }

    public async Task<List<PlayerDTO>> GetAllPlayers() {
        var all = await _databaseAccess.Players.ToListAsync();
        return _playerConverter.ToDTOList(all);
    }

    public async Task<List<PlayerDTO>> GetPlayerByTeam(string teamName)
    {
        var teams = _databaseAccess.Tournaments
            .Where(t => t.Team.Name.Equals(teamName));

        long lastTournamentDate = teams.Max(t => t.Info.Date);
            
        var players = teams.Where(t => t.Info.Date == lastTournamentDate)
                .Select(t => t.Player);
            
        List<PlayerEntity> playersEntity = await players.ToListAsync();
        return _playerConverter.ToDTOList(playersEntity);
    }
}