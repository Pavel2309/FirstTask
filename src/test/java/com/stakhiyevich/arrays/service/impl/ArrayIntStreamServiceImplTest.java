package com.stakhiyevich.arrays.service.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.service.ArrayIntStreamService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayIntStreamServiceImplTest {

    ArrayIntStreamService arrayIntStreamService;

    @BeforeMethod
    public void setUp() {
        arrayIntStreamService = new ArrayIntStreamServiceImpl();
    }

    @Test
    public void testFindMinElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 1;
        int actual = arrayIntStreamService.findMinElement(array).getAsInt();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindMaxElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 5;
        int actual = arrayIntStreamService.findMaxElement(array).getAsInt();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeAllNegativeToPositive() {
        ArrayEntity array = new ArrayEntity(-5, -4, -3, -2, 1);
        ArrayEntity expected = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity actual = arrayIntStreamService.changeAllNegativeToPositive(array).orElse(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceOddElementsByNumber() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity expected = new ArrayEntity(0, 4, 0, 2, 0);
        ArrayEntity actual = arrayIntStreamService.replaceOddElementsByNumber(array, 0).orElse(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateAverageValue() {
        ArrayEntity array = new ArrayEntity(1, 2, 3, 4, 5);
        int expected = 3;
        int actual = arrayIntStreamService.calculateAverageValue(array).getAsInt();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCalculateSumValue() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 15;
        int actual = arrayIntStreamService.calculateSumValue(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountPositiveValues() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 5;
        int actual = arrayIntStreamService.countPositiveValues(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountNegativeValues() {
        ArrayEntity array = new ArrayEntity(5, -4, -3, 2, 0);
        int expected = 2;
        int actual = arrayIntStreamService.countNegativeValues(array);
        Assert.assertEquals(expected, actual);
    }
}