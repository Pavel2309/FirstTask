package com.stakhiyevich.epamtraining.factory;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

public final class ArrayFactory {

    public static ArrayEntity createArray() {
        return new ArrayEntity();
    }

    public static ArrayEntity createArray(int length) {
        return new ArrayEntity(length);
    }
}
