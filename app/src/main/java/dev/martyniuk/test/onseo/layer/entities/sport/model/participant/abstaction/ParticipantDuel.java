package dev.martyniuk.test.onseo.layer.entities.sport.model.participant.abstaction;

import dev.martyniuk.test.onseo.layer.entities.sport.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.sport.model.Result;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public abstract class ParticipantDuel extends Participant {

    public ParticipantDuel(int index,
                           DtoParticipantAsset participantDto,
                           DtoScoreboardAsset scoreboardDto) {

        super(index, participantDto, scoreboardDto);
    }

    @Override
    public void parseDistances(int index, DtoScoreboardAsset scoreboardDto) {
        for (String distanceId : scoreboardDto.getScores().keySet()) {
            for (String resultId : scoreboardDto.getScores().get(distanceId).keySet()) {
                Result result;

                //noinspection ConstantConditions
                String value = scoreboardDto.getScores()
                        .get(distanceId)
                        .get(resultId)
                        .get(index);

                result = new Result(
                        resultId,
                        value.isEmpty() ? null : Integer.parseInt(value)
                );

                distances.add(new Distance(distanceId, result));
            }
        }
    }


}
