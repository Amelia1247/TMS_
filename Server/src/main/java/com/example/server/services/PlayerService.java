package com.example.server.services;

import com.example.server.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerService {

    List<PlayerDTO> getAllPlayers();
    List<PlayerDTO> getPlayersByTeam(String teamName);
    PlayerDTO cretePlayer(PlayerDTO player);
}
