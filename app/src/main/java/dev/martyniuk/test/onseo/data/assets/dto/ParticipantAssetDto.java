package dev.martyniuk.test.onseo.data.assets.dto;

public class ParticipantAssetDto {
    private String id;
    private String name;

    public ParticipantAssetDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
