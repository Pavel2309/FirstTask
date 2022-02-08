package com.stakhiyevich.epamtraining.reader;

import com.stakhiyevich.epamtraining.exception.ReadException;

public interface ArrayReader {
    String readFile(String filePath) throws ReadException;
}
