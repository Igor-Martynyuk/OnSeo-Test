package dev.martyniuk.test.onseo.layer.gateway.assets.main;

import java.util.List;

import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public interface GatewayAssets {
    List<DtoEventAsset> loadEvents() throws Exception;
}
