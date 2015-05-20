/**
 * 
 */
package com.github.jlgrock.snp.web.responses;

/**
 *
 */
public class SuccessResponse {
	private String status;
	private Object results;
	
	public SuccessResponse(String statusIn, Object resultsIn) {
		status = statusIn;
		results = resultsIn;
	}
	
	public String getStatus() {
		return status;
	}
	
	public Object getResults() {
		return results;
	}
}
