package com.github.jlgrock.snp.apis.exceptions;

/**
 *
 */
public class DataAccessException extends Exception {
    public DataAccessException(final String s) {
        super(s);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

}
