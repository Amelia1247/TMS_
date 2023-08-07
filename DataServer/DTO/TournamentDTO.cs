namespace DTO;

public class TournamentDTO
{
    public string Name { get; set; }
    public string Description { get; set; }
    public List<TeamDTO> Teams { get; set; }

    public void addTeam(TeamDTO teamDto)
    {
        if (Teams == null)
        {
            Teams = new List<TeamDTO>();
        } else if (Teams.Contains(teamDto))
        {
            return;
        }
        
        Teams.Add(teamDto);
    }
}