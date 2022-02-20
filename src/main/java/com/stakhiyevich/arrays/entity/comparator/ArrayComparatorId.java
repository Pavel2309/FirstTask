package com.stakhiyevich.arrays.entity.comparator;

import com.stakhiyevich.arrays.entity.ArrayEntity;

import java.util.Comparator;

public class ArrayComparatorId implements Comparator<ArrayEntity> {

    @Override
    public int compare(ArrayEntity o1, ArrayEntity o2) {
        return (int) o1.getArrayId() - (int) o2.getArrayId();
    }

}
