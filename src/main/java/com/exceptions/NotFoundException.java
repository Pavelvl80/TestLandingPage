package com.exceptions;

/**
 * Created by Edvard Piri on 15.11.2017.
 */
public class NotFoundException extends BaseException {
    private static final String USER_MESSAGE = "Not found";

    @Override
    public String getUserMessage() {
        return USER_MESSAGE;
    }

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }

}
