package dev.martyniuk.test.onseo.additional.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void subscribe(Observer<T> observer) {
        observers.add(observer);
    }

    public void notify(T value) {
        for (Observer<T> observer : observers) {
            observer.notify(value);
        }
    }
}
