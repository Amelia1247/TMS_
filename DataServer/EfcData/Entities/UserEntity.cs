using System.ComponentModel.DataAnnotations;

namespace EfcData.Entities; 

public class UserEntity {
    [Key]
    public string Username { get; set; }
    public string Password { get; set; }
    public string FirstName { get; set; }
    public string LastName { get; set; }
    public string Telephone { get; set; }
    public string Role { get; set; }
}