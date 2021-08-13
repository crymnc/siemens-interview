package com.siemens.interview.validation;

public class LineValidator {
    public static boolean validate(String line) {
        return line.length() > 0 && line.length() <= 300000 && line.matches("[a-z]+");
    }
}
