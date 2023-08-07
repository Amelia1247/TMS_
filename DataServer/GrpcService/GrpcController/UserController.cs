using Contracts;
using DTO;
using Grpc.Core;
using grpcProtoFiles;
using GrpcService.converters;

namespace GrpcService.GrpcController;

public class UserController : UserService.UserServiceBase {
    private readonly IUserService _userService;
    private readonly UserConverter _userConverter;

    public UserController(IUserService userService, UserConverter userConverter) {
        _userService = userService;
        _userConverter = userConverter;
    }

    public override async Task<CreateUserResponse> CreateUser(CreateUserRequest request, ServerCallContext context) {
        UserDTO userToAdd = _userConverter.ToDto(request.User);
        var addedUser = await _userService.AddUser(userToAdd);
        return new CreateUserResponse() {
            User = _userConverter.ToProto(addedUser)
        };
    }

    public override async Task<GetUserByUsernameResponse> GetUserByUsername(GetUserByUsernameRequest request,
        ServerCallContext context) {
        var userByUsername = await _userService.GetUserByUsername(request.Username);
        Console.WriteLine(userByUsername.Username);
        return new GetUserByUsernameResponse() {
            User = _userConverter.ToProto(userByUsername)
        };
    }

}