package com.example.server.controller;

import com.example.server.dto.JwtTokenDTO;
import com.example.server.dto.UserDTO;
import com.example.server.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/users")
    public ResponseEntity createUser(@RequestBody UserDTO userDTO) {
        try {

            System.out.println("Create user controller" + userDTO);
            UserDTO addedUser = userService.createUser(userDTO);
            return ResponseEntity.ok(addedUser);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "/users/{username}")
    @ResponseBody
    public ResponseEntity getUser(@PathVariable String username) {
        try {
            UserDTO userFromServer = userService.getUserByUsername(username);
            return ResponseEntity.ok(userFromServer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }

    @PostMapping(value = "/users/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            JwtTokenDTO jwtToken = userService.authenticateUser(userDTO);
            return ResponseEntity.ok(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.notFound(e);
        }
    }

}
