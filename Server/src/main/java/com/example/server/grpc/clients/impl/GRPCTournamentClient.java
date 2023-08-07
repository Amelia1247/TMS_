package com.example.server.grpc.clients.impl;

import com.example.server.dto.TournamentDTO;
import com.example.server.grpc.GrpcStubFactory;
import com.example.server.grpc.clients.TournamentClient;
import com.example.server.grpc.converters.TournamentConverter;
import grpcProtoFiles.TournamentOuterClass;
import grpcProtoFiles.TournamentServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GRPCTournamentClient implements TournamentClient {

    private final TournamentServiceGrpc.TournamentServiceBlockingStub tournamentServiceBlockingStub;
    private final TournamentConverter tournamentConverter;

    public GRPCTournamentClient( TournamentConverter tournamentConverter, GrpcStubFactory factory) {
        this.tournamentConverter = tournamentConverter;
        this.tournamentServiceBlockingStub = factory.getTournamentServiceBlockingStub();
    }

    @Override
    public TournamentDTO createTournament(TournamentDTO tournament) {
        TournamentOuterClass.CreateTournamentRequest request = TournamentOuterClass.CreateTournamentRequest.newBuilder()
                .setTournament(tournamentConverter.toProto(tournament))
                .build();
        TournamentOuterClass.CreateTournamentResponse response = tournamentServiceBlockingStub.createTournament(request);
        return tournamentConverter.toDto(response.getTournament());
    }
}
