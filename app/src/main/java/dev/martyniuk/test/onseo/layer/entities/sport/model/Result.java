package dev.martyniuk.test.onseo.layer.entities.sport.model;

public class Result {
    private String id;
    private Integer value;

    public Result(String id, Integer value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return this.id;
    }

    public Integer getValue() {
        return value;
    }
}
