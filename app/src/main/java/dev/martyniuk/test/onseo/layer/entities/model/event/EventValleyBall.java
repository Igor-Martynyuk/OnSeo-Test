package dev.martyniuk.test.onseo.layer.entities.model.event;

import java.text.ParseException;

import dev.martyniuk.test.onseo.layer.entities.model.participant.impl.ParticipantValleyBall;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public class EventValleyBall extends Event<ParticipantValleyBall> {

    public EventValleyBall(DtoEventAsset dto) throws ParseException {
        super(dto);

        for (int i = 0; i < dto.getParticipants().size(); i++)
            participants.add(new ParticipantValleyBall(i, dto.getParticipants().get(i), dto.getScoreboard()));
    }

}
