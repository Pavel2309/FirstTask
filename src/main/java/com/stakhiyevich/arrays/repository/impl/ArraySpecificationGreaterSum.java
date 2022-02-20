package com.stakhiyevich.arrays.repository.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.repository.ArraySpecification;
import com.stakhiyevich.arrays.service.ArrayService;
import com.stakhiyevich.arrays.service.impl.ArrayServiceImpl;

public class ArraySpecificationGreaterSum implements ArraySpecification {

    private final int sumThreshold;

    public ArraySpecificationGreaterSum(int sumThreshold){
        this.sumThreshold = sumThreshold;
    }

    @Override
    public boolean specify(ArrayEntity array) {
        ArrayService service = new ArrayServiceImpl();
        return service.calculateSumValue(array) > sumThreshold;
    }
}
