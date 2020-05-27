package dev.martyniuk.test.onseo.entities;

public class Participant {
    private String id;
    private String name;

    public Participant(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
