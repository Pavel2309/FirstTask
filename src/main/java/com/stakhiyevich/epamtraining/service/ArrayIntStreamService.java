package com.stakhiyevich.epamtraining.service;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;

import java.util.Optional;
import java.util.OptionalInt;

public interface ArrayIntStreamService {

    OptionalInt getMinElement(ArrayEntity arrayEntity);

    OptionalInt getMaxElement(ArrayEntity arrayEntity);

    Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity);

    Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number);

    OptionalInt getAverageValue(ArrayEntity arrayEntity);

    int getSumValue(ArrayEntity arrayEntity);

    int countPositiveValues(ArrayEntity arrayEntity);

    int countNegativeValues(ArrayEntity arrayEntity);

}
