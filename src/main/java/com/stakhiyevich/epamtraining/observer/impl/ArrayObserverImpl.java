package com.stakhiyevich.epamtraining.observer.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.entity.ArrayStatisticEntity;
import com.stakhiyevich.epamtraining.entity.WarehouseEntity;
import com.stakhiyevich.epamtraining.observer.ArrayObserver;
import com.stakhiyevich.epamtraining.service.ArrayService;
import com.stakhiyevich.epamtraining.service.impl.ArrayServiceImpl;

public class ArrayObserverImpl implements ArrayObserver {

    @Override
    public void changeElement(ArrayEntity arrayEntity) {

        ArrayService arrayService = new ArrayServiceImpl();

        int maxElement = arrayService.findMaxElement(arrayEntity);
        int minElement = arrayService.findMinElement(arrayEntity);
        double averageElement = arrayService.calculateAverageValue(arrayEntity);
        int numberOfPositiveElements = arrayService.countPositiveValues(arrayEntity);
        int numberOfNegativeElements = arrayService.countNegativeValues(arrayEntity);

        ArrayStatisticEntity arrayStatistics = new ArrayStatisticEntity(maxElement, minElement, averageElement, numberOfPositiveElements, numberOfNegativeElements);
        Long arrayId = arrayEntity.getArrayId();

        WarehouseEntity warehouse = WarehouseEntity.getInstance();
        warehouse.updateStatistics(arrayId, arrayStatistics);

    }
}
