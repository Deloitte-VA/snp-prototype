package com.github.jlgrock.snp.web.resources.query;

public class QueryParamException extends IllegalArgumentException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryParamException() {
		super();
	}
	
	public QueryParamException(String message) {
		super(message);
	}
	
	public QueryParamException(Throwable cause) {
		super(cause);
	}
	
	public QueryParamException(String message, Throwable cause) {
		super(message, cause);
	}
}
