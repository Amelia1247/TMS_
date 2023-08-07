using System.Runtime.InteropServices.JavaScript;
using Contracts;
using DTO;
using EfcData.converters;
using EfcData.Entities;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcData.ServiceImpl;

public class TournamentServiceImpl : ITournamentService {
    private readonly DatabaseAccess _databaseAccess;
    private readonly TournamentConverter _tournamentConverter;

    public TournamentServiceImpl(DatabaseAccess databaseAccess, TournamentConverter tournamentConverter) {
        _tournamentConverter = tournamentConverter;
        _databaseAccess = databaseAccess;
    }

    public async Task<TournamentDTO> AddTournament(TournamentDTO tournament) {
        try {
            List<TournamentEntity> tournamentsEntity = _tournamentConverter.ToEntityList(tournament);
            List<EntityEntry<TournamentEntity>> addedTournaments = new List<EntityEntry<TournamentEntity>>();
            
            long date = DateTimeOffset.Now.ToUnixTimeSeconds();
            
            foreach (var tournamentEntity in tournamentsEntity)
            {
                TeamEntity? teamEntity = await _databaseAccess.Teams.FindAsync(tournamentEntity.TeamName);
                PlayerEntity? playerEntity = await _databaseAccess.Players.FindAsync(tournamentEntity.PlayerName);
                tournamentEntity.Team = teamEntity ?? tournamentEntity.Team;
                tournamentEntity.Player = playerEntity ?? tournamentEntity.Player;
                tournamentEntity.Info.Date = date;
                Console.WriteLine(tournamentEntity.Info.Description);
                addedTournaments.Add(_databaseAccess.Tournaments.Add(tournamentEntity));
            }
            await _databaseAccess.SaveChangesAsync();
            return _tournamentConverter.ToDTOList(addedTournaments.Select(t => t.Entity).ToList())[0];
        }
        catch (Exception e) {
            Console.WriteLine(e);
            throw new Exception("Name already exists. Please choose another");
        }
    }
}