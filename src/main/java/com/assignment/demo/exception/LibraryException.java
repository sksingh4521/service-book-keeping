package com.assignment.demo.exception;

public class LibraryException extends Exception {
    public LibraryException() {
        super();
    }

    public LibraryException(String message) {
        super(message);
    }

    public LibraryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LibraryException(Throwable cause) {
        super(cause);
    }

    protected LibraryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
