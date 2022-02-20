package com.stakhiyevich.arrays.factory;

import com.stakhiyevich.arrays.entity.ArrayEntity;

public final class ArrayFactory {

    public static ArrayEntity createArray(int... array) {
        return new ArrayEntity(array);
    }

    public static ArrayEntity createArray(int length) {
        return new ArrayEntity(length);
    }
}
