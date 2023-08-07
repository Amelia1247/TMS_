using System.ComponentModel.DataAnnotations.Schema;
using Microsoft.EntityFrameworkCore;

namespace EfcData.Entities;

[PrimaryKey(nameof(Name), nameof(TeamName), nameof(PlayerName))]
public class TournamentEntity
{
    [ForeignKey("TournamentInfoEntity")]
    public string Name { get; set; }
    
    [ForeignKey("TeamEntity")]
    public string TeamName { get; set; }
    
    [ForeignKey("PlayerEntity")]
    public string PlayerName { get; set; }
    
    public virtual TournamentInfoEntity Info { get; set; }
    public virtual TeamEntity? Team { get; set; }
    public virtual PlayerEntity? Player { get; set; }
}