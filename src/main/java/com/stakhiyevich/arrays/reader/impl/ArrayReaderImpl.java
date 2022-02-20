package com.stakhiyevich.arrays.reader.impl;

import com.stakhiyevich.arrays.exception.ReadException;
import com.stakhiyevich.arrays.reader.ArrayReader;
import com.stakhiyevich.arrays.validator.InputValidator;
import com.stakhiyevich.arrays.validator.impl.ArrayElementValidator;
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
    private static final String SPACE_SPLITTER = " ";

    @Override
    public String readFile(String filePath) throws ReadException {

        logger.info("trying to read the \"{}\" file", filePath);

        String resultString;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(filePath);
        if (resource == null) {
            logger.error("file {} does not exist", filePath);
            throw new ReadException("file " + filePath + " does not exist");
        }

        try (Stream<String> stream = Files.lines(Paths.get(resource.getPath()))) {
            InputValidator validator = new ArrayElementValidator();
            resultString = stream.filter(validator::isValidNumber)
                    .collect(Collectors.joining(SPACE_SPLITTER));

        } catch (IOException e) {
            logger.error("can't read {}", filePath, e);
            throw new ReadException("can't read " + filePath, e);
        }

        if (resultString.isEmpty()) {
            logger.error("the file is empty or no numbers are found");
            throw new ReadException("the file is empty or no numbers are found");
        }

        return resultString;
    }
}
