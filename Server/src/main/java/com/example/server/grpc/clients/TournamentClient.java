package com.example.server.grpc.clients;

import com.example.server.dto.TournamentDTO;
import org.springframework.stereotype.Service;

@Service
public interface TournamentClient {
    TournamentDTO createTournament(TournamentDTO tournament);
}
