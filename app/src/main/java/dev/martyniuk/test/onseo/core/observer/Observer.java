package dev.martyniuk.test.onseo.core.observer;

public interface Observer<T> {
    void notify(T value);
}
