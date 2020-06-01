package dev.martyniuk.test.onseo.layer.gateway.assets.dto;

import java.util.List;

public class DtoEventAsset {
    public static final String ID_SOCCER = "14";
    public static final String ID_TENNIS = "15";
    public static final String ID_VOLLEYBALL = "17";
    public static final String ID_FORMULA_1 = "99";
    public static final String TYPE_HEAD_TO_HEAD = "HeadToHead";
    public static final String TYPE_TOURNAMENT = "Tournament";
    public static final String REGEX_DATE = "yyyy-MM-dd hh:mm:ss";

    private String id;
    private String sportId;
    private String name;
    private String startTime;
    private String type;
    private boolean isInPlay;
    private List<DtoParticipantAsset> participants;
    private DtoScoreboardAsset scoreboard;

    public DtoEventAsset(String id,
                         String sportId,
                         String name,
                         String startTime,
                         String type,
                         boolean isInPlay,
                         List<DtoParticipantAsset> participants,
                         DtoScoreboardAsset scoreboard) {

        this.id = id;
        this.sportId = sportId;
        this.name = name;
        this.startTime = startTime;
        this.type = type;
        this.isInPlay = isInPlay;
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

    public List<DtoParticipantAsset> getParticipants() {
        return this.participants;
    }

    public DtoScoreboardAsset getScoreboard() {
        return this.scoreboard;
    }
}
