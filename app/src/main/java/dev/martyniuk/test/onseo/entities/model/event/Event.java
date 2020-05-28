package dev.martyniuk.test.onseo.entities.model.event;

import java.util.Map;

import dev.martyniuk.test.onseo.entities.model.Participant;
import dev.martyniuk.test.onseo.entities.model.Sport;
import dev.martyniuk.test.onseo.entities.model.result.Result;

public abstract class Event<T extends Result> {
    private String id;
    private Sport sport;
    private String name;
    private Long startTime;
    private String currentPeriod;
    private Map<Participant, T> participantsToResultsMap;

    public Event(String id,
                 Sport sport,
                 String name,
                 Long startTime,
                 String currentPeriod,
                 Map<Participant, T> participantsToResultsMap) {

        this.id = id;
        this.sport = sport;
        this.name = name;
        this.startTime = startTime;
        this.participantsToResultsMap = participantsToResultsMap;
    }

    public String getId() {
        return id;
    }

    public Sport getSport() {
        return sport;
    }

    public String getName() {
        return name;
    }

    public Long getStartTime() {
        return startTime;
    }

    public String getCurrentPeriod() {
        return this.currentPeriod;
    }

    public Map<Participant, T> getParticipantsToResultsMap() {
        return this.participantsToResultsMap;
    }
}
