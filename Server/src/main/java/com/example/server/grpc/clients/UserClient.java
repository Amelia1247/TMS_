package com.example.server.grpc.clients;

import com.example.server.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserClient {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByUsername(String username);
}
