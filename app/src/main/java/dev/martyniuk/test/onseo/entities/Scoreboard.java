package dev.martyniuk.test.onseo.entities;

import java.util.List;

public class Scoreboard {
    private Period period;
    private List<Score> scores;

    public Scoreboard(Period period, List<Score> scores) {
        this.period = period;
        this.scores = scores;
    }

    public Period getPeriod() {
        return period;
    }

    public List<Score> getScores() {
        return scores;
    }
}
