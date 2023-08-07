using DTO;

namespace Contracts;

public interface ITournamentService
{
    Task<TournamentDTO> AddTournament(TournamentDTO tournamentDto);
    
}