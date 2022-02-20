package com.stakhiyevich.arrays.repository.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.repository.ArraySpecification;

public class ArraySpecificationLength implements ArraySpecification {

    private final int numberOfElements;

    public ArraySpecificationLength(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public boolean specify(ArrayEntity array) {
        return array.getArrayLength() == numberOfElements;
    }
}
