package com.example.server.services.impl;

import com.example.server.dto.JwtTokenDTO;
import com.example.server.dto.UserDTO;
import com.example.server.grpc.clients.UserClient;
import com.example.server.jwt.JwtUtils;
import com.example.server.services.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserClient userClient;

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserClient userClient, AuthenticationManager authenticationManager, JwtUtils jwtUtils, PasswordEncoder passwordEncoder) {

        this.userClient = userClient;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.passwordEncoder = passwordEncoder;
//        UserDTO userDTO = new UserDTO();
//        userDTO.setUsername("admin");
//        userDTO.setPassword(passwordEncoder.encode("admin"));
//        userDTO.setRole("Admin");
//        userClient.createUser(userDTO);


    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return userClient.createUser(userDTO);
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userClient.getUserByUsername(username);
    }

    @Override
    public JwtTokenDTO authenticateUser(UserDTO userDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword())
        );

        UserDTO userByUsername = userClient.getUserByUsername(userDTO.getUsername());
        String token = jwtUtils.generateToken(userByUsername);
        JwtTokenDTO jwtTokenDTO = new JwtTokenDTO();
        jwtTokenDTO.setToken(token);
        return jwtTokenDTO;
    }

}
