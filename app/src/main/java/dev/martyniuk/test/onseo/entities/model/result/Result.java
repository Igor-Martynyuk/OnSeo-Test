package dev.martyniuk.test.onseo.entities.model.result;

public abstract class Result {
    private String id;

    Result(String name) {
        this.id = name;
    }

    public String getId() {
        return this.id;
    }
}
