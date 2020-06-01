package dev.martyniuk.test.onseo.layer.interactor;

import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.layer.entities.sport.holder.SportDataHolder;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.Event;

public class UseCaseObserveEvents {
    private SportDataHolder holder;

    public UseCaseObserveEvents(SportDataHolder holder) {
        this.holder = holder;
    }

    public void invoke(Observer<Event> args) {
        this.holder.subscribeEvents(args);
    }
}
