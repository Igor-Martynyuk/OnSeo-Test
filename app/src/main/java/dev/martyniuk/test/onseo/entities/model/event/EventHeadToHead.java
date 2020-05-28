package dev.martyniuk.test.onseo.entities.model.event;

import java.util.Map;

import dev.martyniuk.test.onseo.entities.model.Participant;
import dev.martyniuk.test.onseo.entities.model.Sport;
import dev.martyniuk.test.onseo.entities.model.result.ResultPricePlace;

public class EventHeadToHead extends Event<ResultPricePlace> {
    public EventHeadToHead(String id,
                           Sport sport,
                           String name,
                           Long startTime,
                           String currentPeriod,
                           Map<Participant, ResultPricePlace> participantToPlaceMap) {

        super(id, sport, name, startTime, currentPeriod, participantToPlaceMap);
    }
}
