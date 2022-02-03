package com.stakhiyevich.epamtraining.parser;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ParseException;

public interface ArrayParser {
    ArrayEntity parseValue(String value) throws ParseException;
}
