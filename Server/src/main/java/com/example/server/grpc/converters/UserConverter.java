package com.example.server.grpc.converters;

import com.example.server.dto.UserDTO;
import grpcProtoFiles.UserOuterClass;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO toDto(UserOuterClass.User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setTelephone(user.getTelephone());
        return userDTO;
    }
    public UserOuterClass.User toProto(UserDTO userDTO) {
        return UserOuterClass.User.newBuilder()
                .setUsername(userDTO.getUsername())
                .setPassword(userDTO.getPassword())
                .setRole(userDTO.getRole())
                .setFirstName(userDTO.getFirstName())
                .setLastName(userDTO.getLastName())
                .setTelephone(userDTO.getTelephone())
                .build();
    }
}
