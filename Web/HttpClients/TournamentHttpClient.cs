using Contracts;
using DTO;

namespace HttpClients;

public class TournamentHttpClient : ITournamentService
{
    public async Task<TournamentDTO> AddTournament(TournamentDTO tournamentDto)
    {
        return await HttpClientUtil.SendHttpPostRequest<TournamentDTO, TournamentDTO>("tournament", tournamentDto);
    }
}