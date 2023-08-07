package com.example.server.grpc;
import grpcProtoFiles.PlayerServiceGrpc;
import grpcProtoFiles.TeamServiceGrpc;
import grpcProtoFiles.TournamentServiceGrpc;
import grpcProtoFiles.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope(value = "singleton")
public class GrpcStubFactory {
    private  ManagedChannel managedChannel;
    private  UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private PlayerServiceGrpc.PlayerServiceBlockingStub playerServiceBlockingStub;
    private TeamServiceGrpc.TeamServiceBlockingStub teamServiceBlockingStub;
    private TournamentServiceGrpc.TournamentServiceBlockingStub tournamentServiceBlockingStub;

    public ManagedChannel getManagedChannel() {
        if (managedChannel == null) {
            managedChannel = ManagedChannelBuilder.forAddress("localhost", 5081)
                    .usePlaintext()
                    .build();
        }
        return managedChannel;
    }

    public UserServiceGrpc.UserServiceBlockingStub getUserServiceBlockingStub() {
        if (userServiceBlockingStub == null) {
            userServiceBlockingStub = UserServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return userServiceBlockingStub;
    }

    public PlayerServiceGrpc.PlayerServiceBlockingStub getPlayerServiceBlockingStub() {
        if (playerServiceBlockingStub == null) {
            playerServiceBlockingStub = PlayerServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return playerServiceBlockingStub;
    }

    public TeamServiceGrpc.TeamServiceBlockingStub getTeamServiceBlockingStub() {
        if (teamServiceBlockingStub == null) {
            teamServiceBlockingStub = TeamServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return teamServiceBlockingStub;
    }

    public TournamentServiceGrpc.TournamentServiceBlockingStub getTournamentServiceBlockingStub() {
        if (tournamentServiceBlockingStub == null) {
            tournamentServiceBlockingStub = TournamentServiceGrpc.newBlockingStub(getManagedChannel());
        }
        return tournamentServiceBlockingStub;
    }


}
