package dev.martyniuk.test.onseo.entities;

public class Period {
    private String id;
    private String nameFull;
    private String nameShort;

    public Period(String id, String nameFull, String nameShort) {
        this.id = id;
        this.nameFull = nameFull;
        this.nameShort = nameShort;
    }

    public String getId() {
        return this.id;
    }

    public String getNameFull() {
        return this.nameFull;
    }

    public String getNameShort() {
        return this.nameShort;
    }
}
