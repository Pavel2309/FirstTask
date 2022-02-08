package com.stakhiyevich.epamtraining.entity;

import com.stakhiyevich.epamtraining.exception.ArrayException;

import java.util.Arrays;

public class ArrayEntity {

    private final int[] array;

    public ArrayEntity(int... array) {
        this.array = array;
    }

    public ArrayEntity(int size) {
        this.array = new int[size];
    }

    public int[] getArray() {
        return array.clone();
    }

    public int getArrayLength() {
        return array.length;
    }

    public int getElement(int index) throws ArrayException {
        if (index < 0 || index >= getArrayLength()) {
            throw new ArrayException("index " + index + "is out of bounds");
        }
        return array[index];
    }

    public void setElement(int index, int value) throws ArrayException {
        if (index < 0 || index >= getArrayLength()) {
            throw new ArrayException("index " + index + "is out of bounds");
        }
        array[index] = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayEntity that)) return false;

        return Arrays.equals(getArray(), that.getArray());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getArray());
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
