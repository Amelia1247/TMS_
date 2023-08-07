package com.example.server.services.impl;

import com.example.server.dto.TournamentDTO;
import com.example.server.grpc.clients.TournamentClient;
import com.example.server.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentServiceImpl implements TournamentService {

    private TournamentClient tournamentClient;

    @Autowired
    public TournamentServiceImpl(TournamentClient tournamentClient) {
        this.tournamentClient = tournamentClient;
    }

    @Override
    public TournamentDTO createTournament(TournamentDTO tournament) {
        return tournamentClient.createTournament(tournament);
    }
}
