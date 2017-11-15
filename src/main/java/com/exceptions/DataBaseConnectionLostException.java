package com.exceptions;

/**
 * Created by Edvard Piri on 15.11.2017.
 */
public class DataBaseConnectionLostException extends BaseException {

    private static final String USER_MESSAGE = "Sorry, database seems to be down, please try latter";


    @Override
    public String getUserMessage() {
        return USER_MESSAGE;
    }

    public DataBaseConnectionLostException() {
        super();
    }
    public DataBaseConnectionLostException(String message, Throwable cause) {
        super(message, cause);
    }
    public DataBaseConnectionLostException(String message) {
        super(message);
    }
    public DataBaseConnectionLostException(Throwable cause) {
        super(cause);
    }
}
