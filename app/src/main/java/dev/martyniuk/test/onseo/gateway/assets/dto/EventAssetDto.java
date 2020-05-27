package dev.martyniuk.test.onseo.gateway.assets.dto;

import java.util.List;

public class EventAssetDto {
    private String id;
    private String sportId;
    private String name;
    private String startTime;
    private String type;
    private boolean inplay;
    private List<ParticipantAssetDto> participants;
    private ScoreboardAssetDto scoreboard;

    public EventAssetDto(String id,
                    String sportId,
                    String name,
                    String startTime,
                    String type,
                    boolean inplay,
                    List<ParticipantAssetDto> participants,
                    ScoreboardAssetDto scoreboard) {

        this.id = id;
        this.sportId = sportId;
        this.name = name;
        this.startTime = startTime;
        this.type = type;
        this.inplay = inplay;
        this.participants = participants;
        this.scoreboard = scoreboard;
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

    public String getStartTime() {
        return startTime;
    }

    public String getType() {
        return type;
    }

    public boolean getInplay() {
        return inplay;
    }

    public List<ParticipantAssetDto> getParticipants() {
        return participants;
    }
}
