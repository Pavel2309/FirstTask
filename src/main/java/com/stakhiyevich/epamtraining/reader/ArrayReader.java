package com.stakhiyevich.epamtraining.reader;

import com.stakhiyevich.epamtraining.exception.ReadException;

// validate when reading
public interface ArrayReader {

    String readFile(String filePath) throws ReadException;

}
