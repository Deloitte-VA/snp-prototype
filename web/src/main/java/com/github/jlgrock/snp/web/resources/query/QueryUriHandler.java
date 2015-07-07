package com.github.jlgrock.snp.web.resources.query;

/**
 * Interface to be implemented by classes that can accept and process web
 * resource <code>QueryUriBean</code>s.
 */
public interface QueryUriHandler {

	/**
	 * Handles <code>QueryUriBean</code> for processing.
	 * 
	 * @param query
	 *            URI for processing
	 * @return instance <code>QueryParam</code> with the parsed query parameters
	 */
	QueryParam handleRequest(QueryUriBean query);
}
