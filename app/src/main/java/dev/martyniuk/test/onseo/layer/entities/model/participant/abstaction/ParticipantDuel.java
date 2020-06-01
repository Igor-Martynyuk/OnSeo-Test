package dev.martyniuk.test.onseo.layer.entities.model.participant.abstaction;

import java.util.List;
import java.util.Objects;

import dev.martyniuk.test.onseo.layer.entities.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.model.Result;
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
            for (String resultId : scoreboardDto.getScores().keySet()) {
                Result result;

                //noinspection ConstantConditions
                List<String> values = scoreboardDto.getScores()
                        .get(distanceId)
                        .get(resultId);

                result = new Result(
                        resultId,
                        Objects.requireNonNull(values).contains(super.getId())
                                ? values.indexOf(super.getId()) + 1
                                : null
                );

                distances.add(new Distance(distanceId, result));
            }
        }
    }


}
