package com.example.server.services;

import com.example.server.dto.TeamDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {

    TeamDTO createTeam(TeamDTO team);
    List<TeamDTO> getAllTeams();
}
