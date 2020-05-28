package dev.martyniuk.test.onseo.gateway.assets.dto;

import java.util.List;

public class EventAssetDto {
    private String id;
    private String sportId;
    private String name;
    private String startTime;
    private String type;
    private boolean isInPlay;
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
        this.isInPlay = inplay;
        this.participants = participants;
        this.scoreboard = scoreboard;
    }

    public String getId() {
        return this.id;
    }

    public String getSportId() {
        return this.sportId;
    }

    public String getName() {
        return this.name;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public String getType() {
        return this.type;
    }

    public boolean isInPlay() {
        return this.isInPlay;
    }

    public List<ParticipantAssetDto> getParticipants() {
        return this.participants;
    }

    public ScoreboardAssetDto getScoreboard() {
        return this.scoreboard;
    }
}
