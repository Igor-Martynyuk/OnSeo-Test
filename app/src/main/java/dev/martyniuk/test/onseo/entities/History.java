package dev.martyniuk.test.onseo.entities;

import java.util.ArrayList;
import java.util.List;

import dev.martyniuk.test.onseo.core.observer.Observable;
import dev.martyniuk.test.onseo.core.observer.Observer;

public class History {
    private List<Sport> sportList = new ArrayList<>();

    private Observable<Sport> sportAddedObservable = new Observable<>();
    private Observable<Sport> sportRemovedObservable = new Observable<>();

    public void addSport(Sport sport) {
        this.sportList.add(sport);
        this.sportAddedObservable.notify(sport);
    }

    public void subscribe(Observer<Sport> observer) {
        for (Sport sport : this.sportList) observer.notify(sport);

        this.sportAddedObservable.subscribe(observer);
    }

    public void unsubscribe(Observer<Sport> observer) {
        this.sportAddedObservable.unsubscribe(observer);
    }
}
