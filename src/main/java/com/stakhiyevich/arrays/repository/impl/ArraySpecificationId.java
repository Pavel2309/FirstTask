package com.stakhiyevich.arrays.repository.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.repository.ArraySpecification;

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
