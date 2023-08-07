package com.example.server.grpc.clients;

import com.example.server.dto.PlayerDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PlayerClient {

    List<PlayerDTO> getAllPlayers();
    List<PlayerDTO> getPlayersByTeam(String teamName);
    PlayerDTO cretePlayer(PlayerDTO player);
}
