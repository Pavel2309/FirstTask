package com.stakhiyevich.arrays.observer;

import com.stakhiyevich.arrays.entity.AbstractArrayEntity;
import com.stakhiyevich.arrays.entity.ArrayEntity;

import java.util.EventObject;

public class ArrayEvent extends EventObject {

    public ArrayEvent(AbstractArrayEntity source) {
        super(source);
    }

    public ArrayEntity getSource() {
        return (ArrayEntity) super.getSource();
    }

}
