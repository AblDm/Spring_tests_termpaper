package com.example.termtests.exceptions;

public class QuestionAlreadyExistsException extends RuntimeException {

    public QuestionAlreadyExistsException() {
    }

    public QuestionAlreadyExistsException(String message) {
        super(message);
    }

    public QuestionAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
