package dev.martyniuk.test.onseo.layer.entities.model.participant.abstaction;

import java.util.ArrayList;
import java.util.List;

import dev.martyniuk.test.onseo.layer.entities.model.Distance;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoParticipantAsset;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoScoreboardAsset;

public abstract class Participant {
    private String id;
    private String name;
    protected List<Distance> distances;

    public Participant(int index, DtoParticipantAsset participantDto, DtoScoreboardAsset scoreboardDto) {
        this.id = participantDto.getId();
        this.name = participantDto.getName();
        this.distances = new ArrayList<>();

        parseDistances(index, scoreboardDto);
    }

    protected abstract void parseDistances(int index, DtoScoreboardAsset scoreboardDto);

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


}
