using DTO;
using Google.Protobuf.Collections;
using grpcProtoFiles;

namespace GrpcService.converters;

public class TournamentConverter
{
    private readonly TeamConverter teamConverter;

    public TournamentConverter(TeamConverter teamConverter)
    {
        this.teamConverter = teamConverter;
    }
    
    public TournamentDTO ToDTO(Tournament tournament) {
        return new TournamentDTO {
            Name = tournament.Name,
            Description = tournament.Description,
            Teams = teamConverter.ToDTOList(tournament.Teams.ToList())
        };
    }
    
    public Tournament ToProto(TournamentDTO tournament) {
        return new Tournament {
            Name = tournament.Name,
            Description = tournament.Description,
            Teams = { 
                teamConverter.ToProtoList(tournament.Teams)
            }
        };
    }
}