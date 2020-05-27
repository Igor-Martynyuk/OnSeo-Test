package dev.martyniuk.test.onseo.data.assets.dto;

public class PeriodAssetDto {
    private String id;
    private String nameFull;
    private String nameShort;

    public PeriodAssetDto(String id, String nameFull, String nameShort) {
        this.id = id;
        this.nameFull = nameFull;
        this.nameShort = nameShort;
    }

    public String getId() {
        return id;
    }

    public String getNameFull() {
        return nameFull;
    }

    public String getNameShort() {
        return nameShort;
    }
}
