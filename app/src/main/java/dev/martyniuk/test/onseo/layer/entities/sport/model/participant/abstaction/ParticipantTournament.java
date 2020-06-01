package dev.martyniuk.test.onseo.layer.entities.sport.model.participant.abstaction;

import dev.martyniuk.test.onseo.layer.entities.sport.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.sport.model.Result;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public abstract class ParticipantTournament extends Participant {

    public ParticipantTournament(int index,
                           DtoParticipantAsset participantDto,
                           DtoScoreboardAsset scoreboardDto) {

        super(index, participantDto, scoreboardDto);
    }

    @Override
    protected void parseDistances(int index, DtoScoreboardAsset scoreboardDto) {
        for (String distanceId : scoreboardDto.getScores().keySet()) {
            for (String resultId : scoreboardDto.getScores().keySet()) {
                Result result;

                //noinspection ConstantConditions
                result = new Result(
                        resultId,
                        Integer.parseInt(
                                scoreboardDto.getScores()
                                        .get(distanceId)
                                        .get(resultId)
                                        .get(index)
                        )
                );

                distances.add(new Distance(distanceId, result));
            }
        }
    }

}
