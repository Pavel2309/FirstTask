package com.stakhiyevich.arrays.service.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.exception.ArrayException;
import com.stakhiyevich.arrays.service.ArrayService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class ArrayServiceImpl implements ArrayService {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public int findMinElement(ArrayEntity arrayEntity) {
        int minElement = 0;
        logger.info("trying to find min element");

        try {
            minElement = arrayEntity.getElement(0);
            for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
                if (arrayEntity.getElement(i) < minElement) {
                    minElement = arrayEntity.getElement(i);
                }
            }
        } catch (ArrayException e) {
            logger.error("can't find min element", e);
        }

        return minElement;
    }

    @Override
    public int findMaxElement(ArrayEntity arrayEntity) {
        int maxElement = 0;
        logger.info("trying to find max element");

        try {
            maxElement = arrayEntity.getElement(0);
            for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
                if (arrayEntity.getElement(i) > maxElement) {
                    maxElement = arrayEntity.getElement(i);
                }
            }
        } catch (ArrayException e) {
            logger.error("can't find max element", e);
        }

        return maxElement;
    }

    @Override
    public Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity) {
        ArrayEntity array = new ArrayEntity(arrayEntity.getArray());
        logger.info("trying to change negative elements to positive");
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) < 0) {
                    array.setElement(i, Math.abs(arrayEntity.getElement(i)));
                }
            } catch (ArrayException e) {
                logger.error("can't change negative to positive", e);
            }
        }

        return Optional.of(array);
    }

    @Override
    public Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number) {
        ArrayEntity array = new ArrayEntity(arrayEntity.getArray());
        logger.info("trying to change odd elements by {} number", number);
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) % 2 != 0) {
                    array.setElement(i, number);
                }
            } catch (ArrayException e) {
                logger.error("can't replace odd elements by {} number", number, e);
            }
        }
        return Optional.of(array);
    }

    @Override
    public int calculateAverageValue(ArrayEntity arrayEntity) {
        logger.info("trying to get the average value");
        return (calculateSumValue(arrayEntity) / arrayEntity.getArrayLength());
    }

    @Override
    public int calculateSumValue(ArrayEntity arrayEntity) {
        int sum = 0;
        logger.info("trying to get the sum value");
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                sum = sum + arrayEntity.getElement(i);
            } catch (ArrayException e) {
                logger.error("can't get the sum", e);
            }
        }
        return sum;
    }

    @Override
    public int countPositiveValues(ArrayEntity arrayEntity) {
        int countPositive = 0;
        logger.info("trying to count positive values");
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) > 0) {
                    countPositive += 1;
                }
            } catch (ArrayException e) {
                logger.error("can't count positive values", e);
            }
        }
        return countPositive;
    }

    @Override
    public int countNegativeValues(ArrayEntity arrayEntity) {
        int countNegative = 0;
        logger.info("trying to count negative values");
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) < 0) {
                    countNegative += 1;
                }
            } catch (ArrayException e) {
                logger.error("can't count negative values", e);
            }
        }
        return countNegative;
    }
}
