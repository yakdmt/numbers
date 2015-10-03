package com.yakdmt.numbers.util;

/**
 * Created by yakdmt on 04/10/15.
 */
public class ParseException extends Exception {

    public enum ErrorType {
        NOT_A_NUMBER,
        TOO_LONG,
    }

    private ErrorType errorType;
    private String message;

    public ParseException(ErrorType errorType, String message) {
        super(message);
        this.message = message;
        this.errorType = errorType;
    }

    /**
     * Returns the error type of the exception that has been thrown.
     */
    public ErrorType getErrorType() {
        return errorType;
    }

    @Override
    public String toString() {
        return "Error type: " + errorType + ". " + message;
    }

}
