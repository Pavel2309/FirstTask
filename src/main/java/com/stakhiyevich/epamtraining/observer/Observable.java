package com.stakhiyevich.epamtraining.observer;

public interface Observable {

    void attach(ArrayObserver observer);

    void detach(ArrayObserver observer);

    void notifyObservers();
}
