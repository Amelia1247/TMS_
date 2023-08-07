using DTO;

namespace Contracts; 

public interface IUserService {
    Task<UserDTO> AddUser(UserDTO user);
    Task<UserDTO> GetUserByUsername(string username);
}