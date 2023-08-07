package com.example.server.grpc.converters;

import com.example.server.dto.PlayerDTO;
import grpcProtoFiles.PlayerOuterClass;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlayerConverter {
    public PlayerDTO toDto(PlayerOuterClass.Player player) {
        return PlayerDTO.builder()
                .name(player.getName())
                .build();
    }

    public List<PlayerDTO> toDtoList(List<PlayerOuterClass.Player> players) {
        return players.stream().map(player -> toDto(player)).toList();
    }

    public PlayerOuterClass.Player toProto(PlayerDTO player) {
        return PlayerOuterClass.Player.newBuilder()
                .setName(player.getName())
                .build();
    }

    public List<PlayerOuterClass.Player> toProtoList(List<PlayerDTO> players) {
        return players.stream().map(player -> toProto(player)).toList();
    }
}
