package com.example.server.grpc.clients;

import com.example.server.dto.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamClient {

    TeamDTO createTeam(TeamDTO team);
    List<TeamDTO> getAllTeams();
}
