package com.example.termtests.exceptions;

public class BedRequestException extends RuntimeException {
    public BedRequestException() {
    }

    public BedRequestException(String message) {
        super(message);
    }

    public BedRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BedRequestException(Throwable cause) {
        super(cause);
    }

    public BedRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
