package com.example.server.grpc.converters;

import com.example.server.dto.TeamDTO;
import grpcProtoFiles.TeamOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamConverter {

    private PlayerConverter playerConverter;

    @Autowired
    public TeamConverter(PlayerConverter playerConverter) {
        this.playerConverter = playerConverter;
    }

    public TeamDTO toDto(TeamOuterClass.Team team) {
        return TeamDTO.builder()
                .name(team.getName())
                .players(playerConverter.toDtoList(team.getPlayerList()))
                .build();
    }

    public List<TeamDTO> toDtoList(List<TeamOuterClass.Team> teams) {
        return teams.stream().map(team -> toDto(team)).toList();
    }

    public TeamOuterClass.Team toProto(TeamDTO team) {
        TeamOuterClass.Team.Builder builder = TeamOuterClass.Team.newBuilder()
                .setName(team.getName());

        team.getPlayers().forEach(player -> builder.addPlayer(playerConverter.toProto(player)));

        return builder.build();
    }

    public List<TeamOuterClass.Team> toProtoList(List<TeamDTO> teams) {
        return teams.stream().map(team -> toProto(team)).toList();
    }
}
