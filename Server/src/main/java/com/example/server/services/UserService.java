package com.example.server.services;

import com.example.server.dto.JwtTokenDTO;
import com.example.server.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByUsername(String username);

    JwtTokenDTO authenticateUser(UserDTO userDTO);
}
