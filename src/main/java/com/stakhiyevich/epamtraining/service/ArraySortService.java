package com.stakhiyevich.epamtraining.service;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

public interface ArraySortService {

    void heapSort(ArrayEntity arrayEntity);

    void insertionSort(ArrayEntity arrayEntity, int length);

    void bubbleSort(ArrayEntity arrayEntity, int length);

}
