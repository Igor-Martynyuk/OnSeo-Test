package dev.martyniuk.test.onseo.layer.entities.model.event;

import java.text.ParseException;

import dev.martyniuk.test.onseo.layer.entities.model.participant.impl.ParticipantFormula1;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public class EventFormula1 extends Event<ParticipantFormula1> {

    public EventFormula1(DtoEventAsset dto) throws ParseException {
        super(dto);

        for (int i = 0; i < dto.getParticipants().size(); i++)
            participants.add(new ParticipantFormula1(i, dto.getParticipants().get(i), dto.getScoreboard()));
    }

}
