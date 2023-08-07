package com.example.server.services.impl;

import com.example.server.dto.PlayerDTO;
import com.example.server.grpc.clients.PlayerClient;
import com.example.server.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements PlayerService {

    private PlayerClient playerClient;

    @Autowired
    public PlayerServiceImpl(PlayerClient playerClient) {
        this.playerClient = playerClient;
    }

    @Override
    public List<PlayerDTO> getAllPlayers() {
        return playerClient.getAllPlayers();
    }

    @Override
    public List<PlayerDTO> getPlayersByTeam(String teamName) {
        return playerClient.getPlayersByTeam(teamName);
    }

    @Override
    public PlayerDTO cretePlayer(PlayerDTO player) {
        return playerClient.cretePlayer(player);
    }
}
