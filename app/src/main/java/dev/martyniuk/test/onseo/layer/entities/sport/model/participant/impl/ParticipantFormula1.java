package dev.martyniuk.test.onseo.layer.entities.sport.model.participant.impl;

import dev.martyniuk.test.onseo.layer.entities.sport.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.sport.model.participant.abstaction.ParticipantTournament;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public class ParticipantFormula1 extends ParticipantTournament {

    public ParticipantFormula1(int index,
                               DtoParticipantAsset participantDto,
                               DtoScoreboardAsset scoreboardDto) {

        super(index, participantDto, scoreboardDto);
    }

    public Distance getLastLap() {
        return distances.get(0);
    }

}
