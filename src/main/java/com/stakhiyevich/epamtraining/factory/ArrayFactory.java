package com.stakhiyevich.epamtraining.factory;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

public final class ArrayFactory {

    public static ArrayEntity createArray(int... array) {
        return new ArrayEntity(array);
    }

    public static ArrayEntity createArray(int length) {
        return new ArrayEntity(length);
    }
}
