package com.yakdmt.numbers.util;

/**
 * Created by yakdmt on 03/10/15.
 */
public class Parser {

    private static final long MAX_NUMBER = 1000000000000l-1;

    private static class InstanceHolder {
        public static Parser instance = new Parser();
    }

    private Parser() {

    }

    public static Parser getInstance() {
        return InstanceHolder.instance;
    }

    public long parseString(String string) throws ParseException {
        String regex = "\\d+";
        if (!string.matches(regex)) {
            throw new ParseException(ParseException.ErrorType.NOT_A_NUMBER, "Not a number!");
        }
        long result = -1;
        result = Long.parseLong(string);
        if (result==-1) {
            throw new ParseException(ParseException.ErrorType.NOT_A_NUMBER, "Can't parse long value from string!");
        }
        return result;
    }

    public String normalizeString(String rawString) throws ParseException {
        String normalizedString = rawString;
        while (normalizedString.length()>0 && normalizedString.startsWith("0")) {
            normalizedString = normalizedString.substring(1);
        }
        if (normalizedString.length()>String.valueOf(MAX_NUMBER).length()) {
            throw new ParseException(ParseException.ErrorType.TOO_LONG, "Number is too long");
        }
        return normalizedString;
    }
}
