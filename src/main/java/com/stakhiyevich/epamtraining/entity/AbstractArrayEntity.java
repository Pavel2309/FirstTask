package com.stakhiyevich.epamtraining.entity;

import com.stakhiyevich.epamtraining.observer.ArrayObserver;
import com.stakhiyevich.epamtraining.util.IdGenerator;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractArrayEntity {

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
}
