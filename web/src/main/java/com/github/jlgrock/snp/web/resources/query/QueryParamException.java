package com.github.jlgrock.snp.web.resources.query;

/**
 * Thrown to indicate an invalid web resource query parameter.
 */
public class QueryParamException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs an <code>QueryParamException</code> with no detail message.
	 */
	public QueryParamException() {
		super();
	}

	/**
	 * Constructs an <code>QueryParamException</code> with the specified detail
	 * message.
	 * 
	 * @param message
	 *            the detail message.
	 */
	public QueryParamException(final String message) {
		super(message);
	}

	/**
	 * Constructs a new exception with the specified cause and a detail message
	 * of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>). This
	 * constructor is useful for exceptions that are little more than wrappers
	 * for other throwables (for example,
	 * {@link java.security.PrivilegedActionException}).
	 *
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link Throwable#getCause()} method). (A <tt>null</tt> value
	 *            is permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public QueryParamException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Constructs a new exception with the specified detail message and cause.
	 *
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is
	 * <i>not</i> automatically incorporated in this exception's detail message.
	 *
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link Throwable#getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link Throwable#getCause()} method). (A <tt>null</tt> value
	 *            is permitted, and indicates that the cause is nonexistent or
	 *            unknown.)
	 */
	public QueryParamException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
