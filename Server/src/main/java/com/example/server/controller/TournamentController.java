package com.example.server.controller;

import com.example.server.dto.TournamentDTO;
import com.example.server.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {

    private TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/tournament")
    public ResponseEntity createTournament(@RequestBody TournamentDTO tournamentDTO) {
        try {
            TournamentDTO addedTournament = tournamentService.createTournament(tournamentDTO);
            return ResponseEntity.ok(addedTournament);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.internalServerError(e);
        }
    }
}
