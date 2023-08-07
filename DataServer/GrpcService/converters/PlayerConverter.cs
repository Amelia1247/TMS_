using DTO;
using Google.Protobuf.Collections;
using grpcProtoFiles;

namespace GrpcService.converters;

public class PlayerConverter
{
    public PlayerDTO ToDTO(Player player) {
        return new PlayerDTO {
            Name = player.Name
        };
    }
    
    public List<PlayerDTO> ToDTOList(List<Player> players)
    {
        List<PlayerDTO> _players = new List<PlayerDTO>();
        foreach (var player in players)
        {
            _players.Add(ToDTO(player));
        }

        return _players;
    }

    public Player ToProto(PlayerDTO player) {
        return new Player {
            Name = player.Name
        };
    }
    
    public RepeatedField<Player> ToProtoList(List<PlayerDTO> players)
    {
        List<Player> _players = new List<Player>();
        foreach (var player in players)
        {
            _players.Add(ToProto(player));
        }

        return new RepeatedField<Player>(){ _players };
    }
}