using Contracts;
using DTO;
using EfcData.converters;
using EfcData.Entities;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcData.ServiceImpl;

public class TeamServiceImpl : ITeamService {
    private readonly DatabaseAccess _databaseAccess;
    private readonly TeamConverter _teamConverter;

    public TeamServiceImpl(DatabaseAccess databaseAccess, TeamConverter teamConverter) {
        _teamConverter = teamConverter;
        _databaseAccess = databaseAccess;
    }

    public async Task<TeamDTO> AddTeam(TeamDTO player) {
        try {
            TeamEntity teamEntity = _teamConverter.ToEntity(player);
            EntityEntry<TeamEntity> teamPlayer = await _databaseAccess.Teams.AddAsync(teamEntity);
            await _databaseAccess.SaveChangesAsync();
            return _teamConverter.ToDTO(teamPlayer.Entity);
        }
        catch (Exception e) {
            Console.WriteLine(e);
            throw new Exception("Name already exists. Please choose another");
        }
    }

    public async Task<List<TeamDTO>> GetAllTeams() {
        var all = await _databaseAccess.Teams.ToListAsync();
        return _teamConverter.ToDTOList(all);
    }
}