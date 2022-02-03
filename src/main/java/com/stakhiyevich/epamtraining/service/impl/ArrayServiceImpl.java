package com.stakhiyevich.epamtraining.service.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.service.ArrayService;

import java.util.Optional;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public int getMinElement(ArrayEntity arrayEntity) {
        int minElement = 0;
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) < minElement) {
                    minElement = arrayEntity.getElement(i);
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return minElement;
    }

    @Override
    public int getMaxElement(ArrayEntity arrayEntity) {
        int maxElement = 0;
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) > maxElement) {
                    maxElement = arrayEntity.getElement(i);
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return maxElement;
    }

    @Override
    public Optional<ArrayEntity> changeAllNegativeToPositive(ArrayEntity arrayEntity) {
        ArrayEntity array = new ArrayEntity(arrayEntity.getArray());
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) < 0) {
                    arrayEntity.setElement(i, Math.abs(arrayEntity.getElement(i)));
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }

        return Optional.of(array);
    }

    @Override
    public Optional<ArrayEntity> replaceOddElementsByNumber(ArrayEntity arrayEntity, int number) {
        ArrayEntity array = new ArrayEntity(arrayEntity.getArray());
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) % 2 == 0) {
                    arrayEntity.setElement(i, number);
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return Optional.of(array);
    }

    @Override
    public int getAverageValue(ArrayEntity arrayEntity) {
        return getSumValue(arrayEntity) / arrayEntity.getArrayLength();
    }

    @Override
    public int getSumValue(ArrayEntity arrayEntity) {
        int sum = 0;
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                sum = sum + arrayEntity.getElement(i);
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return sum;
    }

    @Override
    public int countPositiveValues(ArrayEntity arrayEntity) {
        int countPositive = 0;
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) > 0) {
                    countPositive += 1;
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return countPositive;
    }

    @Override
    public int countNegativeValues(ArrayEntity arrayEntity) {
        int countNegative = 0;
        for (int i = 0; i < arrayEntity.getArrayLength(); i++) {
            try {
                if (arrayEntity.getElement(i) < 0) {
                    countNegative += 1;
                }
            } catch (ArrayException e) {
                e.printStackTrace();
            }
        }
        return countNegative;
    }
}
