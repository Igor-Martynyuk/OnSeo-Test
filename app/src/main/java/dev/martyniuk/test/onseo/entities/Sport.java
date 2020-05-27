package dev.martyniuk.test.onseo.entities;

import java.util.ArrayList;
import java.util.List;

import dev.martyniuk.test.onseo.core.observer.Observable;
import dev.martyniuk.test.onseo.core.observer.Observer;

public class Sport {
    private String id;
    private Name name;
    private List<Event> events;

    private Observable<Event> eventAddedObserver;
    private Observable<Event> eventRemovedObserver;

    public Sport(String id) {
        this.id = id;
        this.name = mapName(id);
        this.events = new ArrayList<>();

        this.eventAddedObserver = new Observable<>();
        this.eventRemovedObserver = new Observable<>();
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void addEvent(Event value) {
        this.events.add(value);
        this.eventAddedObserver.notify(value);
    }

    public void removeEvent(Event value) {
        this.events.remove(value);
        this.eventRemovedObserver.notify(value);
    }

    public void subscribeEventAdded(Observer<Event> observer) {
        for (Event value : this.events) observer.notify(value);

        this.eventAddedObserver.subscribe(observer);
    }

    public void unSubscribeEventAdded(Observer<Event> observer) {
        this.eventAddedObserver.unsubscribe(observer);
    }

    public void subscribeEventRemoved(Observer<Event> observer) {
        this.eventRemovedObserver.subscribe(observer);
    }

    public void unsubscribeEventRemoved(Observer<Event> observer) {
        this.eventRemovedObserver.unsubscribe(observer);
    }

    private Name mapName(String id) {
        switch (id) {
            case "14":
                return Name.SOCCER;
            case "15":
                return Name.TENNIS;
            case "17":
                return Name.VOLLEYBALL;
            case "99":
                return Name.FORMULA_1;
            default:
                return Name.UNDEFINED;
        }
    }

    enum Name {
        SOCCER,
        TENNIS,
        VOLLEYBALL,
        FORMULA_1,
        UNDEFINED
    }
}
