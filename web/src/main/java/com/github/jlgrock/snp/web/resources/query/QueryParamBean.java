/**
 * 
 */
package com.github.jlgrock.snp.web.resources.query;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

/**
 * Immutable class containing the parsed query parameters for web resource
 * queries
 */
public class QueryParamBean implements QueryParam {
	// TODO: Consider using a processor and chain of responsibility pattern

	private static final Logger LOGGER = LoggerFactory
			.getLogger(QueryParamBean.class);

	private QueryUriBean queryUriBean;

	private Map<String, String> filter;

	private Map<String, QuerySortDirection> sort;

	private List<String> fields;

	private int limit;

	private int offset;

	/**
	 * Constructor
	 * 
	 * @param queryUriBeanIn
	 *            source query URI
	 * @param filterIn
	 *            filter parameter
	 * @param sortIn
	 *            sort parameter
	 * @param fieldsIn
	 *            fields parameter
	 * @param limitIn
	 *            limit parameter
	 * @param offsetIn
	 *            offset parameter
	 */
	public QueryParamBean(final QueryUriBean queryUriBeanIn,
			final Map<String, String> filterIn,
			final Map<String, QuerySortDirection> sortIn,
			final List<String> fieldsIn, final int limitIn, final int offsetIn) {

		queryUriBean = queryUriBeanIn;
		filter = filterIn;
		sort = sortIn;
		fields = fieldsIn;
		limit = limitIn;
		offset = offsetIn;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryUriBean getQueryUriBean() {
		return queryUriBean;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, String> getFilter() {
		return filter;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, QuerySortDirection> getSort() {
		return sort;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> getFields() {
		return fields;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getLimit() {
		return limit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getOffset() {
		return offset;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(QueryParamBean.class)
				.add("queryUriBean", queryUriBean).add("filter", filter)
				.add("sort", sort).add("fields", fields).add("limit", limit)
				.add("offset", offset).toString();
	}

}
