package com.stakhiyevich.arrays.service;

import com.stakhiyevich.arrays.entity.ArrayEntity;

public interface ArraySortService {

    void heapSort(ArrayEntity arrayEntity);

    void insertionSort(ArrayEntity arrayEntity, int length);

    void bubbleSort(ArrayEntity arrayEntity, int length);

}
