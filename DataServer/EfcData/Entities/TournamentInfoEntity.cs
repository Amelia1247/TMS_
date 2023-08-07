using System.ComponentModel.DataAnnotations;

namespace EfcData.Entities;

public class TournamentInfoEntity
{
    [Key]
    public string Name { get; set; }
    public string Description { get; set; }
    
    public long Date { get; set; }
}