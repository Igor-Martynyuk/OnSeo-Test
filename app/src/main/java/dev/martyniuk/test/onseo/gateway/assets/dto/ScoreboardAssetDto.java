package dev.martyniuk.test.onseo.gateway.assets.dto;

import java.util.List;
import java.util.Map;

public class ScoreboardAssetDto {
    private String eventId;
    private String sportId;
    private PeriodAssetDto period;
    private Map<String, Map<String, List<String>>> scores;

    public ScoreboardAssetDto(String eventId,
                              String sportId,
                              PeriodAssetDto period,
                              Map<String, Map<String, List<String>>> scores) {

        this.eventId = eventId;
        this.sportId = sportId;
        this.period = period;
        this.scores = scores;
    }

    public String getEventId() {
        return this.eventId;
    }

    public String getSportId() {
        return this.sportId;
    }

    public PeriodAssetDto getPeriod() {
        return this.period;
    }

    public Map<String, Map<String, List<String>>> getScores() {
        return this.scores;
    }
}
