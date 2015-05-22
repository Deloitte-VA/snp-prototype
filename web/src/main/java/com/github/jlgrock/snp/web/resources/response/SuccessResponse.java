/**
 * 
 */
package com.github.jlgrock.snp.web.resources.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 */
@JsonInclude(Include.NON_NULL) // TODO: Don't like using jackson annotations randomly. Look into configuring the Object Mapper to ignore nulls
public class SuccessResponse {
	private ResponseStatusCode status;
	private Object results;
	private String errorMessage;
	
	public SuccessResponse(ResponseStatusCode statusIn, Object resultsIn) {
		this(statusIn, resultsIn, null);
	}

	public SuccessResponse(ResponseStatusCode statusIn, Object resultsIn, String errorMsgIn) {
		status = statusIn;
		results = resultsIn;
		errorMessage = errorMsgIn;
	}

	public ResponseStatusCode getStatus() {
		return status;
	}
	
	public Object getResults() {
		return results;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
