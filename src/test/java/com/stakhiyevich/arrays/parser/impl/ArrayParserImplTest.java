package com.stakhiyevich.arrays.parser.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.exception.ParseException;
import com.stakhiyevich.arrays.parser.ArrayParser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.fail;


public class ArrayParserImplTest {

    private static final String CORRECT_VALUE = "4 8 15 16 23 42";
    private static final String WRONG_VALUE = "4!!! 8 15 16QQQ 23 42";
    ArrayParser arrayParser;

    @BeforeMethod
    public void setUp() {
        arrayParser = new ArrayParserImpl();
    }

    @Test
    public void testParseValue() {
        ArrayEntity expected = new ArrayEntity(4, 8, 15, 16, 23, 42);
        ArrayEntity actual = null;
        try {
            actual = arrayParser.parseValue(CORRECT_VALUE);
        } catch (ParseException e) {
            fail("can't parse the file");
        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expectedExceptions = ParseException.class)
    public void testParseValueException() throws ParseException {
        arrayParser.parseValue(WRONG_VALUE);
    }

}