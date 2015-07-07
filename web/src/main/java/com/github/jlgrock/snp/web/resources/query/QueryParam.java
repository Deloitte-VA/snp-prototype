package com.github.jlgrock.snp.web.resources.query;

import java.util.List;
import java.util.Map;

/**
 * Interface providing methods to access base web resource query parameters
 */
public interface QueryParam {

	/**
	 * Gets the source <code>QueryUriBean</code>.
	 * 
	 * @return source <code>QueryUriBean</code>
	 */
	QueryUriBean getQueryUriBean();

	/**
	 * Gets the filter query parameter.
	 * 
	 * @return filter query parameter
	 */
	Map<String, String> getFilter();

	/**
	 * Gets the sort query parameter.
	 * 
	 * @return sort query parameter
	 */
	Map<String, QuerySortDirection> getSort();

	/**
	 * Gets the fields query parameter.
	 * 
	 * @return fields query parameter
	 */
	List<String> getFields();

	/**
	 * Gets the limit query parameter.
	 * 
	 * @return limit query parameter
	 */
	int getLimit();

	/**
	 * Gets the offset query parameter.
	 * 
	 * @return offset query parameter
	 */
	int getOffset();
}
