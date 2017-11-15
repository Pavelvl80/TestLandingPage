package com.exceptions;

/**
 * Created by Edvard Piri on 15.11.2017.
 */
public class CustomXPathException extends BaseException {

    private static final String USER_MESSAGE = "Sorry, Something go wrong ";

    @Override
    public String getUserMessage() {
        return USER_MESSAGE;
    }

    public CustomXPathException() {
        super();
    }
    public CustomXPathException(String message, Throwable cause) {
        super(message, cause);
    }
    public CustomXPathException(String message) {
        super(message);
    }
    public CustomXPathException(Throwable cause) {
        super(cause);
    }
}
