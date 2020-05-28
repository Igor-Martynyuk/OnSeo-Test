package dev.martyniuk.test.onseo.gateway.assets.dto;

public class ParticipantAssetDto {
    private String id;
    private String name;

    public ParticipantAssetDto(String id, String name) {
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
