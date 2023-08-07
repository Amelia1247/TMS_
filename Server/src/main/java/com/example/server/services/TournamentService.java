package com.example.server.services;

import com.example.server.dto.TournamentDTO;
import org.springframework.stereotype.Service;

@Service
public interface TournamentService {
    TournamentDTO createTournament(TournamentDTO tournament);
}
