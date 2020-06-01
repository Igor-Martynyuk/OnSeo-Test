package dev.martyniuk.test.onseo.layer.gateway.assets.dto;

public class DtoParticipantAsset {
    private String id;
    private String name;

    public DtoParticipantAsset(String id, String name) {
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
