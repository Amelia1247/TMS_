using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace EfcData.Entities;

public class TeamEntity
{
    [Key]
    public string Name { get; set; }
}