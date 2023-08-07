package com.example.server.grpc.converters;

import com.example.server.dto.TournamentDTO;
import grpcProtoFiles.TournamentOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TournamentConverter {

    private TeamConverter teamConverter;

    @Autowired
    public TournamentConverter(TeamConverter teamConverter) {
        this.teamConverter = teamConverter;
    }

    public TournamentDTO toDto(TournamentOuterClass.Tournament tournament) {
        return TournamentDTO.builder()
                .name(tournament.getName())
                .Description(tournament.getDescription())
                .teams(teamConverter.toDtoList(tournament.getTeamsList()))
                .build();
    }

    public List<TournamentDTO> toDtoList(List<TournamentOuterClass.Tournament> tournaments) {
        return tournaments.stream().map(tournament -> toDto(tournament)).toList();
    }

    public TournamentOuterClass.Tournament toProto(TournamentDTO tournament) {
        TournamentOuterClass.Tournament.Builder builder = TournamentOuterClass.Tournament.newBuilder()
                .setName(tournament.getName())
                .setDescription(tournament.getDescription());

        tournament.getTeams().forEach(team -> builder.addTeams(teamConverter.toProto(team)));

        return builder.build();
    }

    public List<TournamentOuterClass.Tournament> toProtoList(List<TournamentDTO> tournaments) {
        return tournaments.stream().map(tournament -> toProto(tournament)).toList();
    }
}
