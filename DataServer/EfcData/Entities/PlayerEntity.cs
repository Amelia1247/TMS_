using System.ComponentModel.DataAnnotations;

namespace EfcData.Entities;

public class PlayerEntity
{
    [Key]
    public string Name { get; set; }
}