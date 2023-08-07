package com.example.server.grpc.clients.impl;

import com.example.server.dto.TeamDTO;
import com.example.server.grpc.GrpcStubFactory;
import com.example.server.grpc.clients.TeamClient;
import com.example.server.grpc.converters.TeamConverter;
import grpcProtoFiles.TeamOuterClass;
import grpcProtoFiles.TeamServiceGrpc;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GRPCTeamClient implements TeamClient {

    private final TeamServiceGrpc.TeamServiceBlockingStub teamServiceBlockingStub;
    private final TeamConverter teamConverter;

    public GRPCTeamClient( TeamConverter teamConverter, GrpcStubFactory factory) {
        this.teamConverter = teamConverter;
        this.teamServiceBlockingStub = factory.getTeamServiceBlockingStub();
    }
    @Override
    public TeamDTO createTeam(TeamDTO team) {
        TeamOuterClass.CreateTeamRequest request = TeamOuterClass.CreateTeamRequest.newBuilder()
                .setTeam(teamConverter.toProto(team))
                .build();
        TeamOuterClass.CreateTeamResponse response = teamServiceBlockingStub.createTeam(request);
        return teamConverter.toDto(response.getTeam());
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        TeamOuterClass.GetAllTeamsRequest request = TeamOuterClass.GetAllTeamsRequest.newBuilder()
                .build();
        TeamOuterClass.GetAllTeamsResponse response = teamServiceBlockingStub.getAllTeams(request);
        return teamConverter.toDtoList(response.getTeamsList());
    }
}
