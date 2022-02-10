package com.stakhiyevich.epamtraining.entity;

import com.stakhiyevich.epamtraining.repository.ArraySpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WarehouseEntityTest {

    @BeforeMethod
    public void setUp() {

        WarehouseEntity warehouse = WarehouseEntity.getInstance();
        warehouse.putStatistics(1L, 10, 3, 7, 3, 2);
        warehouse.putStatistics(2L, 15, 4, 8, 4, 2);

    }

    @Test
    public void testGetStatistics() {
        WarehouseEntity warehouse = WarehouseEntity.getInstance();

        ArrayStatisticEntity actual = warehouse.getStatistics(1L);
        ArrayStatisticEntity expected = new ArrayStatisticEntity(10, 3, 7, 3, 2);

        assertEquals(actual, expected);

    }

    @Test
    public void testPutStatistics() {
        WarehouseEntity warehouse = WarehouseEntity.getInstance();
        warehouse.putStatistics(3L, 9, 2, 4, 5, 0);

        ArrayStatisticEntity actual = warehouse.getStatistics(3L);
        ArrayStatisticEntity expected = new ArrayStatisticEntity(9, 2, 4, 5, 0);

        assertEquals(actual, expected);
    }

    @Test
    public void testUpdateStatistics() {
        WarehouseEntity warehouse = WarehouseEntity.getInstance();
        warehouse.updateStatistics(2L, 15, 4, 8, 4, 2);

        ArrayStatisticEntity actual = warehouse.getStatistics(2L);
        ArrayStatisticEntity expected = new ArrayStatisticEntity(15, 4, 8, 4, 2);

        assertEquals(actual, expected);
    }
}