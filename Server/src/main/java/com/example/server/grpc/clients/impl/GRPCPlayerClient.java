package com.example.server.grpc.clients.impl;

import com.example.server.dto.PlayerDTO;
import com.example.server.grpc.GrpcStubFactory;
import com.example.server.grpc.clients.PlayerClient;
import com.example.server.grpc.converters.PlayerConverter;
import grpcProtoFiles.PlayerOuterClass;
import grpcProtoFiles.PlayerServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GRPCPlayerClient implements PlayerClient {
    private final PlayerServiceGrpc.PlayerServiceBlockingStub playerServiceBlockingStub;
    private final PlayerConverter playerConverter;

    public GRPCPlayerClient(PlayerConverter playerConverter, GrpcStubFactory factory) {
        this.playerConverter = playerConverter;
        this.playerServiceBlockingStub = factory.getPlayerServiceBlockingStub();
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        PlayerOuterClass.GetAllPlayersRequest request = PlayerOuterClass.GetAllPlayersRequest.newBuilder().build();
        PlayerOuterClass.GetAllPlayersResponse response = playerServiceBlockingStub.getAllPlayers(request);
        return playerConverter.toDtoList(response.getPlayersList());
    }

    @Override
    public List<PlayerDTO> getPlayersByTeam(String teamName) {
        PlayerOuterClass.GetPlayersByTeamRequest request = PlayerOuterClass.GetPlayersByTeamRequest.newBuilder()
                .setTeamName(teamName).build();
        PlayerOuterClass.GetPlayersByTeamResponse response = playerServiceBlockingStub.getPlayersByTeam(request);
        return playerConverter.toDtoList(response.getPlayersList());
    }

    @Override
    public PlayerDTO cretePlayer(PlayerDTO player) {
        PlayerOuterClass.CreatePlayerRequest request = PlayerOuterClass.CreatePlayerRequest.newBuilder()
                .setPlayer(playerConverter.toProto(player)).build();
        PlayerOuterClass.CreatePlayerResponse response = playerServiceBlockingStub.createPlayer(request);
        return playerConverter.toDto(response.getPlayer());
    }
}
