package com.stakhiyevich.epamtraining.entity.comparator;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.Comparator;

public class ArrayComparatorLength implements Comparator<ArrayEntity> {

    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return o1.getArrayLength() - o2.getArrayLength();
    }
}
