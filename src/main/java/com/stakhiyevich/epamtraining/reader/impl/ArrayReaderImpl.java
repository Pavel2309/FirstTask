package com.stakhiyevich.epamtraining.reader.impl;

import com.stakhiyevich.epamtraining.exception.ReadException;
import com.stakhiyevich.epamtraining.reader.ArrayReader;
import com.stakhiyevich.epamtraining.validator.InputValidator;
import com.stakhiyevich.epamtraining.validator.impl.ArrayElementValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayReaderImpl implements ArrayReader {

    private static final Logger logger = LogManager.getLogger();
    private static final String SEMICOLON_SPLITTER = ";";

    @Override
    public String readFile(String filePath) throws ReadException {

        logger.info("trying to read the \"{}\" file", filePath);

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        if (resource == null) {
            logger.error("file {} does not exist", filePath);
            throw new ReadException("file " + filePath + " does not exist");
        }

        String resultString;
        try {
            Stream<String> stream = Files.lines(Paths.get(resource.getPath()));
            InputValidator validator = new ArrayElementValidator();
            resultString = stream
                    .filter(validator::isValidNumber)
                    .collect(Collectors.joining(SEMICOLON_SPLITTER));

        } catch (IOException e) {
            logger.error("can't read {}", filePath, e);
            throw new ReadException("can't read " + filePath, e);
        }
        return resultString;
    }
}
