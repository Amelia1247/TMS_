using DTO;
using EfcData.Entities;

namespace EfcData.converters;

public class TournamentConverter
{
    private readonly TeamConverter teamConverter;
    private readonly PlayerConverter playerConverter;
    
    public TournamentConverter(TeamConverter teamConverter, PlayerConverter playerConverter)
    {
        this.teamConverter = teamConverter;
        this.playerConverter = playerConverter;
    }
    
    public List<TournamentDTO> ToDTOList(List<TournamentEntity> tournaments)
    {
        List<TournamentDTO> _tournaments = new List<TournamentDTO>();
        
        foreach (var tournament in tournaments)
        {
            TournamentDTO? tournamentDto = _tournaments.Find((TournamentDTO t) => t.Name == tournament.Info.Name);
            if (tournamentDto == null)
            {
                TournamentDTO _tournament = new TournamentDTO
                {
                    Name = tournament.Info.Name,
                    Description = tournament.Info.Description,
                    Teams = new List<TeamDTO>()
                };
                TeamDTO teamDto = teamConverter.ToDTO(tournament.Team);
                PlayerDTO playerDto = playerConverter.ToDTO(tournament.Player);
                teamDto.Players.Add(playerDto);
                _tournament.Teams.Add(teamDto);
                _tournaments.Add(_tournament);
            }
            else
            {
                TeamDTO? teamDto = tournamentDto.Teams.Find((TeamDTO t) => t.Name == tournament.Team.Name);
                if (teamDto == null)
                {
                    teamDto = teamConverter.ToDTO(tournament.Team);
                    tournamentDto.Teams.Add(teamDto);
                }
                PlayerDTO playerDto = playerConverter.ToDTO(tournament.Player);
                teamDto.Players.Add(playerDto);
            }
        }

        return _tournaments;
    }
    
    public List<TournamentEntity> ToEntityList(TournamentDTO tournament)
    {
        List<TournamentEntity> _tournament = new List<TournamentEntity>();
        TournamentInfoEntity info = new TournamentInfoEntity
        {
            Name = tournament.Name,
            Description = tournament.Description
        };
        
        foreach (var team in tournament.Teams)
        {
            TeamEntity teamEntity = teamConverter.ToEntity(team);
            foreach (var player in team.Players)
            {
                PlayerEntity playerEntity = playerConverter.ToEntity(player);
                _tournament.Add(new TournamentEntity
                {
                    Name = tournament.Name,
                    TeamName = teamEntity.Name,
                    PlayerName = playerEntity.Name,
                    Info = info,
                    Team = teamEntity,
                    Player = playerEntity
                });
            }
        }

        return _tournament;
    }
    
    public List<TournamentEntity> ToEntityList(List<TournamentDTO> tournaments) {
        List<TournamentEntity> _tournaments = new List<TournamentEntity>();
        foreach (var tournament in tournaments)
        {
            _tournaments.AddRange(ToEntityList(tournament));
        }

        return _tournaments;
    }
}