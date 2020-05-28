package dev.martyniuk.test.onseo.entities.model;

import java.util.List;

import dev.martyniuk.test.onseo.entities.model.result.Result;

public class Participant {
    private String id;
    private String name;
    private List<Result> scores;

    public Participant(String id, String name, List<Result> scores) {
        this.id = id;
        this.name = name;
        this.scores = scores;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Result> getScores() {
        return this.scores;
    }
}
