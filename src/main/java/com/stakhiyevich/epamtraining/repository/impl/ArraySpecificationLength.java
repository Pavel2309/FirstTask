package com.stakhiyevich.epamtraining.repository.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.repository.ArraySpecification;

public class ArraySpecificationLength implements ArraySpecification {

    int numberOfElements;

    public ArraySpecificationLength(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    @Override
    public boolean specify(ArrayEntity array) {
        return array.getLength() == numberOfElements;
    }
}
