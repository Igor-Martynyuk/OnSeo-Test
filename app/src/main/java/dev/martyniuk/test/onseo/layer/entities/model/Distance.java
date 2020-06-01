package dev.martyniuk.test.onseo.layer.entities.model;

public class Distance {
    private String id;
    private Result result;

    public Distance(String id, Result results) {
        this.id = id;
        this.result = results;
    }

    public String getId() {
        return this.id;
    }

    public Result getResult() {
        return this.result;
    }

}
