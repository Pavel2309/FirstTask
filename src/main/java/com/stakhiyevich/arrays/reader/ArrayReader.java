package com.stakhiyevich.arrays.reader;

import com.stakhiyevich.arrays.exception.ReadException;

public interface ArrayReader {
    String readFile(String filePath) throws ReadException;
}
