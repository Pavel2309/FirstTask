package com.stakhiyevich.arrays.parser;

import com.stakhiyevich.arrays.entity.ArrayEntity;
import com.stakhiyevich.arrays.exception.ParseException;

public interface ArrayParser {
    ArrayEntity parseValue(String value) throws ParseException;
}
