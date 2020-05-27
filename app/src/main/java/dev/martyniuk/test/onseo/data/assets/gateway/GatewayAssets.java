package dev.martyniuk.test.onseo.data.assets.gateway;

import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.data.assets.dto.EventAssetDto;

public interface GatewayAssets {
    void updateEvents() throws Exception;

    void subscribeEvents(Observer<EventAssetDto> observer);

    void unSubscribeEvents(Observer<EventAssetDto> observer);
}
