package com.example.server.services.impl;

import com.example.server.dto.TeamDTO;
import com.example.server.grpc.clients.TeamClient;
import com.example.server.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamClient teamClient;

    @Autowired
    public TeamServiceImpl(TeamClient teamClient){
        this.teamClient = teamClient;
    }

    @Override
    public TeamDTO createTeam(TeamDTO team) {
        return teamClient.createTeam(team);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return teamClient.getAllTeams();
    }


}
