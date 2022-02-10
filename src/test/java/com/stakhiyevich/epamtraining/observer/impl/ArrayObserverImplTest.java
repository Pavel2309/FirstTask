package com.stakhiyevich.epamtraining.observer.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.entity.ArrayStatisticEntity;
import com.stakhiyevich.epamtraining.entity.WarehouseEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.observer.ArrayObserver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayObserverImplTest {

    @Test
    public void testChangeElement() {

        ArrayEntity arrayEntity = new ArrayEntity(1, 2, 3, 4, 5);

        ArrayStatisticEntity arrayStatistics = new ArrayStatisticEntity(1,
                5, 3, 5, 0);

        WarehouseEntity warehouseEntity = WarehouseEntity.getInstance();
        warehouseEntity.putStatistics(arrayEntity.getArrayId(), arrayStatistics);

        ArrayObserver observer = new ArrayObserverImpl();
        arrayEntity.attach(observer);

        try {
            arrayEntity.setElement(0, 10);
            arrayEntity.setElement(1, 10);
        } catch (ArrayException e) {
            fail();
        }

        ArrayStatisticEntity actual = warehouseEntity.getStatistics(arrayEntity.getArrayId());
        ArrayStatisticEntity expected = new ArrayStatisticEntity(10,
                3, 6, 5, 0);

        assertEquals(actual, expected);
    }
}