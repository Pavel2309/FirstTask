package com.stakhiyevich.epamtraining.parser.impl;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.exception.ParseException;
import com.stakhiyevich.epamtraining.factory.ArrayFactory;
import com.stakhiyevich.epamtraining.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {

    private static final Logger logger = LogManager.getLogger();
    private static final String SEMICOLON_SPLITTER = ";";
    private static final String SEMICOLON_DUPLICATES = "[;]{1,}";

    @Override
    public ArrayEntity parseValue(String value) throws ParseException {

        logger.info("trying to parse the \"{}\" string", value);

        String[] splintedString = value
                .replaceAll(SEMICOLON_DUPLICATES, SEMICOLON_SPLITTER)
                .split(SEMICOLON_SPLITTER);

        ArrayEntity arrayEntity = ArrayFactory.createArray(splintedString.length);

        for (int i = 0; i < splintedString.length; i++) {
            try {
                arrayEntity.setElement(i, Integer.parseInt(splintedString[i]));
            } catch (ArrayException e) {
                logger.error("index is out of bounds", e);
                throw new  ParseException("can't parse file");
            } catch (NumberFormatException e) {
                logger.error("illegal character or out of integer's min max value", e);
                throw new  ParseException("can't parse file");
            }
        }

        return arrayEntity;
    }
}
