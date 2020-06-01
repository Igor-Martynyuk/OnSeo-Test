package dev.martyniuk.test.onseo.layer.entities.sport.holder;

import java.util.ArrayList;
import java.util.List;

import dev.martyniuk.test.onseo.core.observer.Observable;
import dev.martyniuk.test.onseo.core.observer.Observer;
import dev.martyniuk.test.onseo.layer.entities.sport.model.event.Event;

@SuppressWarnings("rawtypes")
public class SportDataHolder {
    private List<Event> data = new ArrayList<>();
    private Observable<Event> newEventObservable = new Observable<>();

    public void addEvent(Event event) {
        this.data.add(event);
        this.newEventObservable.notify(event);
    }

    public void subscribeEvents(Observer<Event> observer) {
        for (Event event : this.data) {
            observer.notify(event);
        }

        this.newEventObservable.subscribe(observer);
    }

    public void unsubscribeEvents(Observer<Event> observer) {
        this.newEventObservable.unsubscribe(observer);
    }
}
