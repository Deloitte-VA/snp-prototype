package com.github.jlgrock.snp.web.resources.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Parser for web resource query parameters.
 */
public class QueryParamParser implements QueryUriHandler {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(QueryParamParser.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QueryParam handleRequest(final QueryUriBean query) {
		return parseQuery(query);
	}

	/**
	 * Parses the filter arguments from list of filter query parameters.
	 * 
	 * @param filterList
	 *            list of filter query parameters
	 * @return map of filter arguments (field, value)
	 */
	public static Map<String, String> parseFilter(final List<String> filterList) {
		LOGGER.trace(
				"Inside parseFilter: filterList = {}",
				filterList == null ? null : Arrays.toString(filterList
						.toArray()));

		Map<String, String> filter = new HashMap<>();

		if (filterList == null || filterList.size() == 0) {
			return filter;
		}

		if (filterList.size() > 1) {
			String s = "More than one filter parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (filterList.size() == 1) {
			String filterString = filterList.get(0);
			LOGGER.debug("filter string: {}", filterString);
			String[] filterParams = filterString.trim().split(
					QueryConstants.PARAM_SEPARATOR);
			LOGGER.debug("filter params: {}", Arrays.toString(filterParams));

			for (String param : filterParams) {
				String[] filterTokens = param
						.split(QueryConstants.FILTER_PARAM_SEPARATOR);
				LOGGER.debug("filter tokens: {}", Arrays.toString(filterTokens));
				if (filterTokens.length != 2 || filterTokens[0] == null
						|| filterTokens[0].trim().isEmpty()) {
					String s = "Invalid filter parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}

				filter.put(filterTokens[0].trim(), filterTokens[1]);
			}
		}

		return filter;
	}

	/**
	 * Parses the limit from list of limit query parameters. Limit must be a
	 * non-zero positive whole number
	 * 
	 * @param limitList
	 *            list of limit query parameters
	 * @return limit value
	 * @throws QueryParamException
	 *             thrown an invalid limit argument is encountered
	 */
	public static int parseLimit(final List<String> limitList)
			throws QueryParamException {
		LOGGER.trace("Inside parseLimit: limitList = {}",
				limitList == null ? null : Arrays.toString(limitList.toArray()));

		int limit = QueryConstants.LIMIT_PARAM_DEFAULT;

		if (limitList == null || limitList.size() == 0) {
			return limit;
		}

		if (limitList.size() > 1) {
			String s = "More than one limit parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (limitList.size() == 1) {
			try {
				limit = Integer.parseInt(limitList.get(0));
			} catch (NumberFormatException nfe) {
				String s = "Unable to parse limit";
				LOGGER.error(s, nfe);
				throw new QueryParamException(s, nfe);
			}

			if (limit <= 0) {
				String s = "Limit must be a non-zero positive whole number: "
						+ limit;
				LOGGER.error(s);
				throw new QueryParamException(s);
			}
		}

		return limit;
	}

	/**
	 * Parses the offset from list of offset query parameters. Offset must be
	 * positive whole number.
	 * 
	 * @param offsetList
	 *            list of offset query parameters
	 * @return offset value
	 * @throws QueryParamException
	 *             thrown if an invalid offset argument is encountered
	 */
	public static int parseOffset(final List<String> offsetList)
			throws QueryParamException {
		LOGGER.trace(
				"Inside parseOffset: offsetList = {}",
				offsetList == null ? null : Arrays.toString(offsetList
						.toArray()));

		int offset = QueryConstants.OFFSET_PARAM_DEFAULT;

		if (offsetList == null || offsetList.size() == 0) {
			return offset;
		}

		if (offsetList.size() > 1) {
			String s = "More than one offset parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (offsetList.size() == 1) {
			try {
				offset = Integer.parseInt(offsetList.get(0));
			} catch (NumberFormatException nfe) {
				String s = "Unable to parse offset";
				LOGGER.error(s, nfe);
				throw new QueryParamException(s, nfe);
			}

			if (offset < 0) {
				String s = "Offset must be a positive whole number: " + offset;
				LOGGER.error(s);
				throw new QueryParamException(s);
			}
		}

		return offset;
	}

	/**
	 * Parses the sort arguments from list of sort query parameters.
	 * 
	 * @param sortList
	 *            list of sort query parameters
	 * @return map of fields and respective sort direction
	 * @throws QueryParamException
	 *             thrown if an invalid sort argument is encountered
	 */
	public static Map<String, QuerySortDirection> parseSort(
			final List<String> sortList) throws QueryParamException {
		LOGGER.trace("Inside parseSort: sortList = {}", sortList == null ? null
				: Arrays.toString(sortList.toArray()));

		Map<String, QuerySortDirection> sort = new LinkedHashMap<>();

		if (sortList == null || sortList.size() == 0) {
			return sort;
		}

		if (sortList.size() > 1) {
			String s = "More than one sort parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (sortList.size() == 1) {
			String sortString = sortList.get(0);
			LOGGER.debug("sort string: {}", sortString);
			String[] sortParams = sortString.trim().split(
					QueryConstants.PARAM_SEPARATOR);
			LOGGER.debug("sort params: {}", Arrays.toString(sortParams));

			for (String param : sortParams) {
				String[] sortTokens = param
						.split(QueryConstants.SORT_PARAM_SEPARATOR);
				LOGGER.debug("sort tokens: {}", Arrays.toString(sortTokens));
				if (sortTokens.length != 2 || sortTokens[0] == null
						|| sortTokens[0].trim().isEmpty()) {
					String s = "Invalid sort parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}
				try {
					QuerySortDirection direction = QuerySortDirection
							.valueOf(sortTokens[1].trim().toUpperCase());
					sort.put(sortTokens[0].trim(), direction);
				} catch (IllegalArgumentException | NullPointerException e) {
					String s = "Invalid sort parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}
			}
		}

		return sort;
	}

	/**
	 * Parses the fields arguments from list of fields query parameters.
	 * 
	 * @param fieldsList
	 *            list of fields query parameters
	 * @return list of fields
	 * @throws QueryParamException
	 *             thrown if an invalid fields argument is encountered
	 */
	public static List<String> parseFields(final List<String> fieldsList)
			throws QueryParamException {
		LOGGER.trace(
				"Inside parseFields: fieldsList = {}",
				fieldsList == null ? null : Arrays.toString(fieldsList
						.toArray()));

		List<String> fields = new ArrayList<>();

		if (fieldsList == null || fieldsList.size() == 0) {
			return fields;
		}

		if (fieldsList.size() > 1) {
			String s = "More than one fields parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (fieldsList.size() == 1) {
			String fieldsString = fieldsList.get(0);
			LOGGER.debug("fields string: {}", fieldsString);
			String[] fieldsParams = fieldsString.trim().split(
					QueryConstants.PARAM_SEPARATOR);
			LOGGER.debug("fields params: {}", Arrays.toString(fieldsParams));

			for (String param : fieldsParams) {
				if (param.trim().isEmpty()) {
					String s = "Invalid fields parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}

				fields.add(param.trim());
			}
		}

		return fields;
	}

	/**
	 * Parses the <code>QueryUriBean</code> object for filter, sort, offset,
	 * limit, and fields parameters.
	 * 
	 * @param query
	 *            web resource query URI
	 * @return object containing the parameters that parsed from the query URI
	 */
	public QueryParam parseQuery(final QueryUriBean query) {
		List<String> filterList = query.getUriInfo().getQueryParameters()
				.get(QueryConstants.FILTER_PARAM);
		List<String> sortList = query.getUriInfo().getQueryParameters()
				.get(QueryConstants.SORT_PARAM);
		List<String> offsetList = query.getUriInfo().getQueryParameters()
				.get(QueryConstants.OFFSET_PARAM);
		List<String> limitList = query.getUriInfo().getQueryParameters()
				.get(QueryConstants.LIMIT_PARAM);
		List<String> fieldsList = query.getUriInfo().getQueryParameters()
				.get(QueryConstants.FIELDS_PARAM);

		// parse and store results
		Map<String, QuerySortDirection> sort = parseSort(sortList);
		int offset = parseOffset(offsetList);
		int limit = parseLimit(limitList);
		List<String> fields = parseFields(fieldsList);
		Map<String, String> filter = parseFilter(filterList);

		return new QueryParamBean(query, filter, sort, fields, limit, offset);
	}

}
