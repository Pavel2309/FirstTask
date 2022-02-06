package com.stakhiyevich.epamtraining.service.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.service.ArrayIntStreamService;
import com.stakhiyevich.epamtraining.service.ArrayService;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.OptionalInt;

import static org.testng.Assert.*;

public class ArrayIntStreamServiceImplTest {

    ArrayIntStreamService arrayIntStreamService;

    @BeforeMethod
    public void setUp() {
        arrayIntStreamService = new ArrayIntStreamServiceImpl();
    }

    @Test
    public void testGetMinElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 1;
        int actual = arrayIntStreamService.getMinElement(array).getAsInt();

//        // ask about this approach
//        if (arrayIntStreamService.getMinElement(array).isPresent()) {
//            actual = arrayIntStreamService.getMinElement(array).getAsInt();
//        } else {
//            fail();
//        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMaxElement() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 5;
        int actual = arrayIntStreamService.getMaxElement(array).getAsInt();
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
        ArrayEntity expected = new ArrayEntity(5, 0, 3, 0, 1);
        ArrayEntity actual = arrayIntStreamService.replaceOddElementsByNumber(array, 0).orElse(null);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetAverageValue() {
        ArrayEntity array = new ArrayEntity(1, 2, 3, 4, 5);
        int expected = 3;
        int actual = arrayIntStreamService.getAverageValue(array).getAsInt();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetSumValue() {
        ArrayEntity array = new ArrayEntity(5, 4, 3, 2, 1);
        int expected = 15;
        int actual = arrayIntStreamService.getSumValue(array);
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