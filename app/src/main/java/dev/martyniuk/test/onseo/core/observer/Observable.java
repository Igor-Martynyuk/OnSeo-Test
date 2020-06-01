package dev.martyniuk.test.onseo.core.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer<T> observer) {
        this.observers.remove(observer);
    }

    public void notify(T value) {
        for (Observer<T> observer : this.observers) {
            observer.notify(value);
        }
    }
}
