package com.example.server.grpc.clients.impl;
import com.example.server.dto.UserDTO;
import com.example.server.grpc.GrpcStubFactory;
import com.example.server.grpc.clients.UserClient;
import com.example.server.grpc.converters.UserConverter;
import grpcProtoFiles.UserOuterClass;
import grpcProtoFiles.UserServiceGrpc;
import org.springframework.stereotype.Service;

@Service
public class GRPCUserClient implements UserClient {
    private final UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;
    private final UserConverter userConverter;

    public GRPCUserClient( UserConverter userConverter, GrpcStubFactory factory) {
        this.userConverter = userConverter;
        this.userServiceBlockingStub = factory.getUserServiceBlockingStub();
    }
    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserOuterClass.User user =userConverter.toProto(userDTO);
        UserOuterClass.CreateUserRequest request = UserOuterClass.CreateUserRequest.newBuilder()
                .setUser(user).build();
        System.out.println("Sending request to create user");
        UserOuterClass.CreateUserResponse createdUserResponse = userServiceBlockingStub.createUser(request);
        return userConverter.toDto(createdUserResponse.getUser());
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        UserOuterClass.GetUserByUsernameRequest request = UserOuterClass.GetUserByUsernameRequest.newBuilder()
                .setUsername(username).build();
        UserOuterClass.GetUserByUsernameResponse userByUsername = userServiceBlockingStub.getUserByUsername(request);
        System.out.println(userConverter.toDto(userByUsername.getUser()));
        return userConverter.toDto(userByUsername.getUser());
    }
}
