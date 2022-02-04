package com.stakhiyevich.epamtraining.service.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.service.ArrayService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ArrayServiceImplTest {

    ArrayService arrayService;

    @BeforeMethod
    public void setUp() {
        arrayService = new ArrayServiceImpl();
    }

    @Test
    public void testGetMinElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 1;
        int actual = arrayService.getMinElement(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMaxElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 5;
        int actual = arrayService.getMaxElement(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeAllNegativeToPositive() {
        ArrayEntity array = new ArrayEntity(-5, -4, -3, -2, 1);
        ArrayEntity expected = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity actual = arrayService.changeAllNegativeToPositive(array).orElse(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReplaceOddElementsByNumber() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        ArrayEntity expected = new ArrayEntity(5, 0, 3, 0, 1);
        ArrayEntity actual = arrayService.replaceOddElementsByNumber(array, 0).orElse(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageValue() {
        ArrayEntity array = new ArrayEntity(1, 2, 3, 4, 5);
        int expected = 3;
        int actual = arrayService.getAverageValue(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSumValue() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 15;
        int actual = arrayService.getSumValue(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountPositiveValues() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 5;
        int actual = arrayService.countPositiveValues(array);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCountNegativeValues() {
        ArrayEntity array = new ArrayEntity(5, -4, -3, 2, 0);
        int expected = 2;
        int actual = arrayService.countNegativeValues(array);
        Assert.assertEquals(expected, actual);
    }
}