package dev.martyniuk.test.onseo.gateway.assets;

import dev.martyniuk.test.onseo.additional.observer.Observer;
import dev.martyniuk.test.onseo.gateway.assets.dto.EventAssetDto;

public interface GatewayAssets {
    void updateEvents() throws Exception;

    void subscribeEvents(Observer<EventAssetDto> observer);

    void unSubscribeEvents(Observer<EventAssetDto> observer);
}
