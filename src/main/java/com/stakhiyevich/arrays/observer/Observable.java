package com.stakhiyevich.arrays.observer;

public interface Observable {

    void attach(ArrayObserver observer);

    void detach(ArrayObserver observer);

    void notifyObservers();
}
