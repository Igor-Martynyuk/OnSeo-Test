package dev.martyniuk.test.onseo.layer.entities.sport.model.event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import dev.martyniuk.test.onseo.layer.entities.sport.model.participant.abstaction.Participant;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public abstract class Event<T extends Participant> {
    private String id;
    private String sportId;
    private String name;
    private Long startTime;
    private String currentPeriod;
    protected List<T> participants;

    public Event(DtoEventAsset dto) throws ParseException {

        this.id = dto.getId();
        this.sportId = dto.getSportId();
        this.name = dto.getName();

        //noinspection ConstantConditions
        this.startTime = new SimpleDateFormat(DtoEventAsset.REGEX_DATE, Locale.getDefault())
                .parse(dto.getStartTime())
                .getTime();

        this.currentPeriod = dto.getScoreboard().getPeriod().getNameFull();
        this.participants = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public String getSportId() {
        return sportId;
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

    public List<T> getParticipants() {
        return this.participants;
    }
}
