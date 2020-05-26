package dev.martyniuk.test.onseo.additional.observer;

public interface Observer<T> {
    void notify(T value);
}
