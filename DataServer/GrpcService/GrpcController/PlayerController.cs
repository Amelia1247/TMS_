using Contracts;
using DTO;
using Grpc.Core;
using grpcProtoFiles;
using GrpcService.converters;

namespace GrpcService.GrpcController;


public class PlayerController : PlayerService.PlayerServiceBase {
    private readonly IPlayerService _playerService;
    private readonly PlayerConverter _playerConverter;

    public PlayerController(IPlayerService playerService, PlayerConverter playerConverter) {
        _playerService = playerService;
        _playerConverter = playerConverter;
    }

    public override async Task<CreatePlayerResponse> CreatePlayer(CreatePlayerRequest request, ServerCallContext context) {
        PlayerDTO player = _playerConverter.ToDTO(request.Player);
        var addedPlayer = await _playerService.AddPlayer(player);
        return new CreatePlayerResponse {
            Player = _playerConverter.ToProto(addedPlayer)
        };
    }

    public override async Task<GetAllPlayersResponse> GetAllPlayers(GetAllPlayersRequest request,
        ServerCallContext context) {
        var players = await _playerService.GetAllPlayers();
        return new GetAllPlayersResponse() {
            Players = { _playerConverter.ToProtoList(players) }
        };
    }

    public override async Task<GetPlayersByTeamResponse> GetPlayersByTeam(GetPlayersByTeamRequest request,
        ServerCallContext context)
    {
        var players = await _playerService.GetPlayerByTeam(request.TeamName);
        return new GetPlayersByTeamResponse()
        {
            Players = { _playerConverter.ToProtoList(players) }
        };
    }

}