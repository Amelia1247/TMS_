using DTO;
using grpcProtoFiles;

namespace GrpcService.converters;

public class UserConverter {
    public UserDTO ToDto(User user) {
        return new UserDTO() {
            Username = user.Username,
            Password = user.Password,
            FirstName = user.FirstName,
            LastName = user.LastName,
            Role = user.Role,
            Telephone = user.Telephone
        };
    }

    public User ToProto(UserDTO userDto) {
        return new User() {
            Username = userDto.Username,
            FirstName = userDto.FirstName,
            LastName = userDto.LastName,
            Password = userDto.Password,
            Role = userDto.Role,
            Telephone = userDto.Telephone
        };
    }
}