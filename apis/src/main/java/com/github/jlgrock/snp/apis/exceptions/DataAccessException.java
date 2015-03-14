package com.github.jlgrock.snp.apis.exceptions;

/**
 * An exception that indicates that either the application was unable to access MongoDB or that it was unable to
 * execute a query.
 */
public class DataAccessException extends Exception {
    /**
     * Exception with message
     * @param s the message
     */
    public DataAccessException(final String s) {
        super(s);
    }

    /**
     * Exception with message and wrapped exception
     * @param message message
     * @param cause wrapped exception
     */
    public DataAccessException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
