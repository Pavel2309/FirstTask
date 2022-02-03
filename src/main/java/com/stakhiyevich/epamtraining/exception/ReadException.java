package com.stakhiyevich.epamtraining.exception;

public class ReadException extends Exception {

    public ReadException() {
        super();
    }

    public ReadException(String message) {
        super(message);
    }

    public ReadException(Exception exception) {
        super(exception);
    }

    public ReadException(String message, Exception exception) {
        super(message, exception);
    }
}
