package com.stakhiyevich.epamtraining.repository.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.repository.ArraySpecification;

public class ArraySpecificationId implements ArraySpecification {

    private final int id;

    public ArraySpecificationId(int id) {
        this.id = id;
    }

    @Override
    public boolean specify(ArrayEntity array) {
        return id == array.getArrayId();
    }
}
