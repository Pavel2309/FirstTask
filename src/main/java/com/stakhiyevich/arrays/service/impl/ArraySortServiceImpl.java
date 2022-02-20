package com.stakhiyevich.arrays.service.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.exception.ArrayException;
import com.stakhiyevich.arrays.service.ArraySortService;

public class ArraySortServiceImpl implements ArraySortService {

    @Override
    public void heapSort(ArrayEntity arrayEntity) {
        int arrayLength = arrayEntity.getArrayLength();

        for (int i = arrayLength / 2 - 1; i >= 0; i--)
            heapify(arrayEntity, arrayLength, i);

        for (int i = arrayLength - 1; i >= 0; i--) {
            try {
                int temp = arrayEntity.getElement(0);
                arrayEntity.setElement(0, arrayEntity.getElement(i));
                arrayEntity.setElement(i, temp);
            } catch (ArrayException e) {
                e.getStackTrace();
            }

            heapify(arrayEntity, i, 0);
        }
    }

    @Override
    public void insertionSort(ArrayEntity arrayEntity, int length) {

        if (length <= 1) {
            return;
        }

        insertionSort(arrayEntity, length - 1);
        try {
            int last = arrayEntity.getElement(length - 1);
            int j = length - 2;

            while (j >= 0 && arrayEntity.getElement(j) > last) {
                arrayEntity.setElement(j + 1, arrayEntity.getElement(j));
                j--;
            }

            arrayEntity.setElement(j + 1, last);
        } catch (ArrayException e) {
            e.getStackTrace();
        }

    }

    @Override
    public void bubbleSort(ArrayEntity arrayEntity, int length) {
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length - 1; i++) {
            try {
                if (arrayEntity.getElement(i) > arrayEntity.getElement(i + 1)) {
                    int temp = arrayEntity.getElement(i);
                    arrayEntity.setElement(i, arrayEntity.getElement(i + 1));
                    arrayEntity.setElement(i + 1, temp);
                }
            } catch (ArrayException e) {
                e.getStackTrace();
            }

        }

        bubbleSort(arrayEntity, length - 1);
    }

    private void heapify(ArrayEntity array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        try {
            if (left < n && array.getElement(left) > array.getElement(largest))
                largest = left;

            if (right < n && array.getElement(right) > array.getElement(largest))
                largest = right;

            if (largest != i) {
                int swap = array.getElement(i);
                array.setElement(i, array.getElement(largest));
                array.setElement(largest, swap);

                heapify(array, n, largest);
            }
        } catch (ArrayException e) {
            e.getStackTrace();
        }
    }
}
