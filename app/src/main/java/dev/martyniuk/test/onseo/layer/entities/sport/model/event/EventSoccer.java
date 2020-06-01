package dev.martyniuk.test.onseo.layer.entities.sport.model.event;

import java.text.ParseException;

import dev.martyniuk.test.onseo.layer.entities.sport.model.participant.impl.ParticipantSoccer;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public class EventSoccer extends Event<ParticipantSoccer> {

    public EventSoccer(DtoEventAsset dto) throws ParseException {
        super(dto);

        for (int i = 0; i < dto.getParticipants().size(); i++)
            participants.add(new ParticipantSoccer(i, dto.getParticipants().get(i), dto.getScoreboard()));
    }

}
