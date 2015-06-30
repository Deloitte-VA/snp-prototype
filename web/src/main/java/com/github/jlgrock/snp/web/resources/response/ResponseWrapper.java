/**
 * 
 */
package com.github.jlgrock.snp.web.resources.response;


/**
 * Wrapper class for REST API responses
 */
public class ResponseWrapper {
	private final ResponseStatusCode status;
	private final Object results;
	private final String errorMessage;
	
	/**
	 * Constructor
	 * 
	 * @param statusIn query execution status
	 * @param resultsIn query results
	 */
	public ResponseWrapper(ResponseStatusCode statusIn, Object resultsIn) {
		this(statusIn, resultsIn, null);
	}

	/**
	 * Constructor
	 * 
	 * @param statusIn query execution status
	 * @param resultsIn query results
	 * @param errorMsgIn query execution error message
	 */
	public ResponseWrapper(final ResponseStatusCode statusIn, final Object resultsIn, final String errorMsgIn) {
		status = statusIn;
		results = resultsIn;
		errorMessage = errorMsgIn;
	}

	/**
	 * Returns the query execution status
	 * 
	 * @return query execution status
	 */
	public ResponseStatusCode getStatus() {
		return status;
	}
	
	/**
	 * Returns the query results
	 * 
	 * @return query results
	 */
	public Object getResults() {
		return results;
	}
	
	/**
	 * Returns the query execution error message
	 * 
	 * @return query execution error message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
}
