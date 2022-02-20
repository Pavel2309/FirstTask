package com.stakhiyevich.arrays.parser.impl;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.exception.ArrayException;
import com.stakhiyevich.arrays.exception.ParseException;
import com.stakhiyevich.arrays.factory.ArrayFactory;
import com.stakhiyevich.arrays.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String SPACE_SPLITTER = " ";
    private static final String SPACE_DUPLICATES = "[ ]+";

    @Override
    public ArrayEntity parseValue(String value) throws ParseException {

        logger.info("trying to parse the \"{}\" string", value);

        String[] splintedString = value.replaceAll(SPACE_DUPLICATES, SPACE_SPLITTER).split(SPACE_SPLITTER);

        ArrayEntity arrayEntity = ArrayFactory.createArray(splintedString.length);

        for (int i = 0; i < splintedString.length; i++) {
            try {
                arrayEntity.setElement(i, Integer.parseInt(splintedString[i]));
            } catch (ArrayException e) {
                logger.error("index is out of bounds", e);
                throw new ParseException("can't parse file");
            } catch (NumberFormatException e) {
                logger.error("illegal character", e);
                throw new ParseException("can't parse file");
            }
        }

        return arrayEntity;
    }
}
