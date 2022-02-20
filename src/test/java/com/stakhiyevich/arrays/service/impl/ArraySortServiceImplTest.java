package com.stakhiyevich.arrays.service.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.service.ArraySortService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArraySortServiceImplTest {

    ArraySortService arraySortService;

    @BeforeMethod
    public void setUp() {
        arraySortService = new ArraySortServiceImpl();
    }

    @Test
    public void testHeapSort() {
        ArrayEntity actual = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity expected = new ArrayEntity(1, 2, 3, 4, 5);
        arraySortService.heapSort(actual);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testInsertionSort() {
        ArrayEntity actual = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity expected = new ArrayEntity(1, 2, 3, 4, 5);
        arraySortService.insertionSort(actual, actual.getArrayLength());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testBubbleSort() {
        ArrayEntity actual = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity expected = new ArrayEntity(1, 2, 3, 4, 5);
        arraySortService.bubbleSort(actual, actual.getArrayLength());
        Assert.assertEquals(expected, actual);
    }
}