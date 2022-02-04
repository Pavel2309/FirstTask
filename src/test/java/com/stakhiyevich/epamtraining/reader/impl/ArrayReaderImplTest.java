package com.stakhiyevich.epamtraining.reader.impl;

import com.stakhiyevich.epamtraining.exception.ReadException;
import com.stakhiyevich.epamtraining.reader.ArrayReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayReaderImplTest {

    private static final String INPUT_DATA_PATH = "data/input_data.txt";
    private static final String WRONG_PATH = "data/wrong_path.txt";
    ArrayReader arrayReader;

    @BeforeMethod
    public void setUp() {
        arrayReader = new ArrayReaderImpl();
    }

    @Test
    public void testReadFile() {
        String expected = "4;8;15;16;23;42";
        String actual = null;
        try {
            actual = arrayReader.readFile(INPUT_DATA_PATH);
        } catch (ReadException e) {
            fail("can't read file", e);
        }
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = ReadException.class)
    public void testReadFileException() throws ReadException {
        arrayReader.readFile(WRONG_PATH);
    }

}