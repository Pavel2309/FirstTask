package com.stakhiyevich.epamtraining.entity;

import com.stakhiyevich.epamtraining.observer.ArrayEvent;
import com.stakhiyevich.epamtraining.observer.ArrayObserver;
import com.stakhiyevich.epamtraining.observer.Observable;
import com.stakhiyevich.epamtraining.util.IdGenerator;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractArrayEntity implements Observable {

    private long arrayId;

    private Set<ArrayObserver> observers = new HashSet<>();

    {
        arrayId = IdGenerator.generateId();
    }

    public long getArrayId() {
        return arrayId;
    }

    public void setArrayId(long arrayId) {
        this.arrayId = arrayId;
    }

    public Set<ArrayObserver> getObservers() {
        return observers;
    }

    public void setObservers(Set<ArrayObserver> observers) {
        this.observers = observers;
    }

    @Override
    public void attach(ArrayObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {

        if (observers.isEmpty()) {
            return;
        }
        ArrayEvent event = new ArrayEvent(this);
        for (ArrayObserver observer : observers) {

            observer.elementChanged(event);
        }
    }
}
