package dev.martyniuk.test.onseo.layer.gateway.assets.dto;

import java.util.List;
import java.util.Map;

public class DtoScoreboardAsset {
    public final static String ID_FIRST_SET = "FIRST_SET";
    public final static String ID_SECOND_SET = "SECOND_SET";
    public final static String ID_THIRD_SET = "THIRD_SET";
    public final static String ID_POINTS = "POINTS";

    private String eventId;
    private String sportId;
    private DtoPeriodAsset period;
    private Map<String, Map<String, List<String>>> scores;

    public DtoScoreboardAsset(String eventId,
                              String sportId,
                              DtoPeriodAsset period,
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

    public DtoPeriodAsset getPeriod() {
        return this.period;
    }

    public Map<String, Map<String, List<String>>> getScores() {
        return this.scores;
    }
}
