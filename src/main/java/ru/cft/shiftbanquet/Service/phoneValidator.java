package ru.cft.shiftbanquet.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class phoneValidator {

    private Pattern pattern;

    private static final String PHONE_PATTERN = "[0-9*#+() -]*";

    public phoneValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    public boolean validate(final String hex) {
        Matcher matcher = pattern.matcher(hex);

        return matcher.matches();
    }

}
