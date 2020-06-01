package dev.martyniuk.test.onseo.layer.gateway.assets.main;

import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.layer.gateway.assets.dto.DtoEventAsset;

public interface GatewayAssets {
    void updateEvents() throws Exception;

    void subscribeEvents(Observer<DtoEventAsset> observer);

    void unSubscribeEvents(Observer<DtoEventAsset> observer);
}
