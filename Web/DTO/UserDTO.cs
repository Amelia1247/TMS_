namespace DTO; 

public class UserDTO {
    public string Username { get; set; }
    public string Password { get; set; }
    public string? FirstName { get; set; }
    public string? LastName { get; set; }
    public string? Telephone { get; set; }
    public string? Role { get; set; }

    public override string ToString() {
        return $"username : {Username}, name : {FirstName}";
    }
}