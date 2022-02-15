package com.stakhiyevich.epamtraining.repository.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.repository.ArraySpecification;
import com.stakhiyevich.epamtraining.service.ArrayService;
import com.stakhiyevich.epamtraining.service.impl.ArrayServiceImpl;

public class ArraySpecificationGreaterSum implements ArraySpecification {

    private int sumThreshold;

    public ArraySpecificationGreaterSum(int sumThreshold){
        this.sumThreshold = sumThreshold;
    }

    @Override
    public boolean specify(ArrayEntity array) {
        ArrayService service = new ArrayServiceImpl();
        return service.calculateSumValue(array) > sumThreshold;
    }
}
