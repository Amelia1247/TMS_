using Contracts;
using DTO;
using EfcData.converters;
using EfcData.Entities;
using Microsoft.EntityFrameworkCore.ChangeTracking;

namespace EfcData.ServiceImpl;

public class UserServiceImpl : IUserService {
    private readonly DatabaseAccess _databaseAccess;
    private readonly UserConverter _userConverter;

    public UserServiceImpl(DatabaseAccess databaseAccess, UserConverter userConverter) {
        _userConverter = userConverter;
        _databaseAccess = databaseAccess;
    }

    public async Task<UserDTO> AddUser(UserDTO user) {
        try {
            UserEntity userEntity = _userConverter.ToEntity(user);
            EntityEntry<UserEntity> addedUser = await _databaseAccess.Users.AddAsync(userEntity);
            await _databaseAccess.SaveChangesAsync();
            return _userConverter.ToDTO(addedUser.Entity);
        }
        catch (Exception e) {
            Console.WriteLine(e);
            throw new Exception("Username already exists. Please choose another");
        }
    }

    public async Task<UserDTO> GetUserByUsername(string username) {
        var findAsync = await _databaseAccess.Users.FindAsync(username);
        if (findAsync == null) {
            throw new Exception("User not found");
        }

        return _userConverter.ToDTO(findAsync);
    }
}