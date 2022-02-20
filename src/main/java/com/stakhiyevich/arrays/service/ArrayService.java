package com.stakhiyevich.arrays.service;

import com.stakhiyevich.arrays.entity.ArrayEntity;

import java.util.Optional;

public interface ArrayService {

    int findMinElement(ArrayEntity arrayEntity);

    int findMaxElement(ArrayEntity arrayEntity);

    Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity);

    Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number);

    int calculateAverageValue(ArrayEntity arrayEntity);

    int calculateSumValue(ArrayEntity arrayEntity);

    int countPositiveValues(ArrayEntity arrayEntity);

    int countNegativeValues(ArrayEntity arrayEntity);
}
