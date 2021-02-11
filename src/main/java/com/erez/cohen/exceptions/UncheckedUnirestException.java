package com.erez.cohen.exceptions;

public class UncheckedUnirestException extends RuntimeException {

    public UncheckedUnirestException() {
    }

    public UncheckedUnirestException(String message) {
        super(message);
    }

    public UncheckedUnirestException(Throwable cause) {
        super(cause);
    }
}
