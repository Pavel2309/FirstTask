package com.stakhiyevich.epamtraining.service;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.Optional;

public interface ArrayService {

    int getMinElement(ArrayEntity arrayEntity);

    int getMaxElement(ArrayEntity arrayEntity);

    Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity);

    Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number);

    int getAverageValue(ArrayEntity arrayEntity);

    int getSumValue(ArrayEntity arrayEntity);

    int countPositiveValues(ArrayEntity arrayEntity);

    int countNegativeValues(ArrayEntity arrayEntity);
}
