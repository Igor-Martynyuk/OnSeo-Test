package dev.martyniuk.test.onseo.layer.entities.model.participant.impl;

import dev.martyniuk.test.onseo.layer.entities.model.Distance;
import dev.martyniuk.test.onseo.layer.entities.model.participant.abstaction.ParticipantDuel;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public class ParticipantSoccer extends ParticipantDuel {

    public ParticipantSoccer(int index,
                             DtoParticipantAsset participantDto,
                             DtoScoreboardAsset scoreboardDto) {

        super(index, participantDto, scoreboardDto);
    }

    public Distance getFirstHalf() {
        return super.distances.get(0);
    }

    public Distance getSecondHalf() {
        return super.distances.get(1);
    }

    public Distance getRegularTime() {
        return super.distances.get(2);
    }

    public Distance getExtraTime() {
        return super.distances.get(3);
    }

    public Distance getTotal() {
        return super.distances.get(4);
    }

}
