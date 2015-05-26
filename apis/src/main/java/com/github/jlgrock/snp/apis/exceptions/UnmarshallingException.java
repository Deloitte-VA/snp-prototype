package com.github.jlgrock.snp.apis.exceptions;

/**
 * An exception that occurs when attempting to unmarshall from to a particular type of class.
 */
public class UnmarshallingException extends Exception {
    /**
     * Exception with message
     * @param s the message
     */
    public UnmarshallingException(final String s) {
        super(s);
    }

    /**
     * Exception with message and wrapped exception
     * @param message message
     * @param cause wrapped exception
     */
    public UnmarshallingException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
