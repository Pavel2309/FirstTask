package com.stakhiyevich.epamtraining.observer;

import com.stakhiyevich.epamtraining.entity.AbstractArrayEntity;
import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(AbstractArrayEntity source) {
        super(source);
    }

    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }

}
