using DTO;
using EfcData.Entities;

namespace EfcData.converters;

public class PlayerConverter
{
    public PlayerDTO ToDTO(PlayerEntity player) {
        return new PlayerDTO {
            Name = player.Name
        };
    }
    
    public List<PlayerDTO> ToDTOList(List<PlayerEntity> players)
    {
        List<PlayerDTO> _players = new List<PlayerDTO>();
        foreach (var player in players)
        {
            _players.Add(ToDTO(player));
        }

        return _players;
    }

    public PlayerEntity ToEntity(PlayerDTO player) {
        return new PlayerEntity {
            Name = player.Name
        };
    }

    public List<PlayerEntity> ToEntityList(List<PlayerDTO> players)
    {
        List<PlayerEntity> _players = new List<PlayerEntity>();
        foreach (var player in players)
        {
            _players.Add(ToEntity(player));
        }

        return _players;
    }
}