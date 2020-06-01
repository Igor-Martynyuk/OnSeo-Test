package dev.martyniuk.test.onseo.layer.entities.model.event;

import java.text.ParseException;

import dev.martyniuk.test.onseo.layer.entities.model.participant.impl.ParticipantTennis;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public class EventTennis extends Event<ParticipantTennis> {

    public EventTennis(DtoEventAsset dto) throws ParseException {
        super(dto);

        for (int i = 0; i < dto.getParticipants().size(); i++)
            participants.add(new ParticipantTennis(i, dto.getParticipants().get(i), dto.getScoreboard()));
    }

}
