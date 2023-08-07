using DTO;

namespace Contracts; 

public interface IUserService {

    Task<UserDTO> CreateUserAsync(UserDTO userDto);
    Task<UserDTO> GetUserAsync(string username);
    Task<JwtTokenDTO> LoginAsync(string username, string password);
}