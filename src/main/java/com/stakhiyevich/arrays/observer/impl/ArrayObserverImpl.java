package com.stakhiyevich.arrays.observer.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.entity.ArrayStatisticEntity;
import com.stakhiyevich.arrays.entity.WarehouseEntity;
import com.stakhiyevich.arrays.observer.ArrayEvent;
import com.stakhiyevich.arrays.observer.ArrayObserver;
import com.stakhiyevich.arrays.service.ArrayService;
import com.stakhiyevich.arrays.service.impl.ArrayServiceImpl;


public class ArrayObserverImpl implements ArrayObserver {

    @Override
    public void elementChanged(ArrayEvent event) {
        ArrayService arrayService = new ArrayServiceImpl();
        ArrayEntity arrayEntity = event.getSource();

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
