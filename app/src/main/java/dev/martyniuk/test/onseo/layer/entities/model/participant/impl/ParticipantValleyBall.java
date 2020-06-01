package dev.martyniuk.test.onseo.layer.entities.model.participant.impl;

import dev.martyniuk.test.onseo.layer.entities.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.model.participant.abstaction.ParticipantDuel;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public class ParticipantValleyBall extends ParticipantDuel {

    public ParticipantValleyBall(int index,
                                 DtoParticipantAsset participantDto,
                                 DtoScoreboardAsset scoreboardDto) {

        super(index, participantDto, scoreboardDto);
    }

    public Distance getTotal() {
        return super.distances.get(0);
    }

    public Distance getSetScore(int setIndex) {
        if (setIndex > 4) throw new RuntimeException("There is only 5 sets exists");

        return super.distances.get(setIndex + 1);
    }
}
