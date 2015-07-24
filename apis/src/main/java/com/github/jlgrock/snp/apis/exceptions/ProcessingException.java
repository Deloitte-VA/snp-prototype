package com.github.jlgrock.snp.apis.exceptions;

public class ProcessingException extends Exception {

	public ProcessingException(String message) {
		super(message);
	}
	
	public ProcessingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ProcessingException(Throwable cause) {
		super(cause);
	}
}
