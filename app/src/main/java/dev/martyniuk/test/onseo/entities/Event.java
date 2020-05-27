package dev.martyniuk.test.onseo.entities;

import java.util.Calendar;
import java.util.List;

public class Event {
    private String id;
    private String name;
    private Calendar startTime;
    private Type type;
    private boolean isInPlay;
    private List<Boolean> participants;

    public Event(String id,
                 String name,
                 Calendar startTime,
                 Type type,
                 boolean isInPlay,
                 List<Boolean> participants) {

        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.type = type;
        this.isInPlay = isInPlay;
        this.participants = participants;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Calendar getStartTime() {
        return this.startTime;
    }

    public Type getType() {
        return this.type;
    }

    public boolean isInPlay() {
        return this.isInPlay;
    }

    public List<Boolean> getParticipants() {
        return this.participants;
    }

    enum Type {
        HEAD_TO_HEAD
    }
}
