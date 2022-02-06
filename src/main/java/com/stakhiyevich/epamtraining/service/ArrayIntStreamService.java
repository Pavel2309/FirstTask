package com.stakhiyevich.epamtraining.service;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.Optional;
import java.util.OptionalInt;

public interface ArrayIntStreamService {

    OptionalInt findMinElement(ArrayEntity arrayEntity);

    OptionalInt findMaxElement(ArrayEntity arrayEntity);

    Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity);

    Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number);

    OptionalInt calculateAverageValue(ArrayEntity arrayEntity);

    int calculateSumValue(ArrayEntity arrayEntity);

    int countPositiveValues(ArrayEntity arrayEntity);

    int countNegativeValues(ArrayEntity arrayEntity);

}
