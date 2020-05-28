package dev.martyniuk.test.onseo.entities.model.result;

public class ResultScore extends Result {
    private int points;

    public ResultScore(String name, int points) {
        super(name);

        this.points = points;
    }

    public int getPoints() {
        return this.points;
    }
}
