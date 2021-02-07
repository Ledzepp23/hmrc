package com.example.hmrc.Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean isPostcodeValid(String postcode) {
        Pattern postCodePattern = Pattern.compile("[a-zA-Z1-9\\s]{5,8}$");
        Matcher postCodeMatcher = postCodePattern.matcher(postcode);
        return postCodeMatcher.matches();
    }

    public static boolean isDateValid(String date) {
        Pattern datePattern = Pattern.compile("^[0-9]{4}-(0[1-9]{1}|1[0-2]{1})");
        Matcher dateMatcher = datePattern.matcher(date);
        return dateMatcher.matches();
    }
}
