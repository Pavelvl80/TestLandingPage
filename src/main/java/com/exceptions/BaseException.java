package com.exceptions;

/**
 * Created by Edvard Piri on 15.11.2017.
 */
public abstract class BaseException extends RuntimeException {

    public abstract String getUserMessage();

    public BaseException() {
        super();
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public BaseException(String message) {
        super(message);
    }
    public BaseException(Throwable cause) {
        super(cause);
    }
}
