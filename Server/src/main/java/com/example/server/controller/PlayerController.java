package com.example.server.controller;

import com.example.server.dto.PlayerDTO;
import com.example.server.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/player")
    public ResponseEntity createPlayer(@RequestBody PlayerDTO playerDTO) {
        try {
            PlayerDTO addedPlayer = playerService.cretePlayer(playerDTO);
            return ResponseEntity.ok(addedPlayer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }

    @GetMapping(value = "player")
    public ResponseEntity getPlayers(@RequestParam(required = false) String team) {
        try {
            List<PlayerDTO> players = new ArrayList<>();
            if (team == null || team.isEmpty()) {
                players = playerService.getAllPlayers();
            } else {
                players = playerService.getPlayersByTeam(team);
            }
            return ResponseEntity.ok(players);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }
}
