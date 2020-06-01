package dev.martyniuk.test.onseo.layer.gateway.assets.dto;

public class DtoPeriodAsset {
    private String id;
    private String nameFull;
    private String nameShort;

    public DtoPeriodAsset(String id, String nameFull, String nameShort) {
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
