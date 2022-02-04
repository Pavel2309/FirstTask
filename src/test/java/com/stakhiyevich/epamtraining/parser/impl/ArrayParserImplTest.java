package com.stakhiyevich.epamtraining.parser.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ParseException;
import com.stakhiyevich.epamtraining.exception.ReadException;
import com.stakhiyevich.epamtraining.factory.ArrayFactory;
import com.stakhiyevich.epamtraining.parser.ArrayParser;
import com.stakhiyevich.epamtraining.reader.ArrayReader;
import com.stakhiyevich.epamtraining.reader.impl.ArrayReaderImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.Assert.assertThrows;

public class ArrayParserImplTest {

    private static final String CORRECT_VALUE = "4;8;15;16;23;42";
    private static final String WRONG_VALUE = "4!!!;8;15;16;23;42";
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
            fail("can't parse file");
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseValueException() {
        assertThrows(ParseException.class, () -> arrayParser.parseValue(WRONG_VALUE));
    }
}