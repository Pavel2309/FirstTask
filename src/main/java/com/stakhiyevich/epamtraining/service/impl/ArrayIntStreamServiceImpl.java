package com.stakhiyevich.epamtraining.service.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.service.ArrayIntStreamService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ArrayIntStreamServiceImpl implements ArrayIntStreamService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public OptionalInt findMinElement(ArrayEntity arrayEntity) {

        logger.info("trying to find min element");

        try {
            int min = IntStream.of(arrayEntity.getArray()).min().orElseThrow(ArrayException::new);
            return OptionalInt.of(min);
        } catch (ArrayException e) {
            logger.error("can't find min element");
            return OptionalInt.empty();
        }

    }

    @Override
    public OptionalInt findMaxElement(ArrayEntity arrayEntity) {

        logger.info("trying to find max element");

        try {
            int max = IntStream.of(arrayEntity.getArray()).max().orElseThrow(ArrayException::new);
            return OptionalInt.of(max);
        } catch (ArrayException e) {
            logger.error("can't find max element");
            return OptionalInt.empty();
        }
    }

    @Override
    public Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity) {
        logger.info("trying to change negative elements to positive");
        int[] processedArray = IntStream.of(arrayEntity.getArray()).map(Math::abs).toArray();
        ArrayEntity resultedArray = new ArrayEntity(processedArray);
        return Optional.of(resultedArray);
    }

    @Override
    public Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number) {
        logger.info("trying to change odd elements by {} number", number);
        int[] processedArray = IntStream.of(arrayEntity.getArray()).map(element -> {
            if (element % 2 == 0) {
                element = number;
            }
            return element;
        }).toArray();
        ArrayEntity resultedArray = new ArrayEntity(processedArray);
        return Optional.of(resultedArray);
    }

    @Override
    public OptionalInt calculateAverageValue(ArrayEntity arrayEntity) {
        logger.info("trying to get the average value");
        try {
            double average = IntStream.of(arrayEntity.getArray()).average().orElseThrow(ArrayException::new);
            return OptionalInt.of((int) average);
        } catch (ArrayException e) {
            logger.error("can't get the average");
            return OptionalInt.empty();
        }
    }

    @Override
    public int calculateSumValue(ArrayEntity arrayEntity) {
        logger.info("trying to get the sum value");
        return IntStream.of(arrayEntity.getArray()).sum();
    }

    @Override
    public int countPositiveValues(ArrayEntity arrayEntity) {
        logger.info("trying to count positive values");
        return (int) IntStream.of(arrayEntity.getArray()).filter(element -> element > 0).count();
    }

    @Override
    public int countNegativeValues(ArrayEntity arrayEntity) {
        logger.info("trying to count negative values");
        return (int) IntStream.of(arrayEntity.getArray()).filter(element -> element < 0).count();
    }
}
