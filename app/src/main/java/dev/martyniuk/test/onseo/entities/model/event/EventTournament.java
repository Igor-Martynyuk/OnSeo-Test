package dev.martyniuk.test.onseo.entities.model.event;

import java.util.Map;

import dev.martyniuk.test.onseo.entities.model.Participant;
import dev.martyniuk.test.onseo.entities.model.Sport;
import dev.martyniuk.test.onseo.entities.model.result.ResultScore;

public class EventTournament extends Event<ResultScore> {
    public EventTournament(String id,
                           Sport sport,
                           String name,
                           Long startTime,
                           String currentPeriod,
                           Map<Participant, ResultScore> participantsToScoreMap) {

        super(id, sport, name, startTime, currentPeriod, participantsToScoreMap);
    }
}
