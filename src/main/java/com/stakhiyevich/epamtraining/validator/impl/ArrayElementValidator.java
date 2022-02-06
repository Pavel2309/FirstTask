package com.stakhiyevich.epamtraining.validator.impl;

import com.stakhiyevich.epamtraining.validator.InputValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArrayElementValidator implements InputValidator {

    private static final String NUMBER_PATTERN = "^[0-9;-]+$";

    @Override
    public boolean isValid(String input) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

}
