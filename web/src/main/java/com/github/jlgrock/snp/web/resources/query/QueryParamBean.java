/**
 * 
 */
package com.github.jlgrock.snp.web.resources.query;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

/**
 *
 */
public class QueryParamBean {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryParamBean.class);
	
	@Context 
	UriInfo info;
	
	@QueryParam("filter")
	private String filter;
	
	@QueryParam("sort")
	private Map<String, QuerySortDirection> sort;
	
	private List<String> fields;
	
	private int limit;
	
	private int offset;
	
	public String getFilter() {
		return filter;
	}

	public Map<String, QuerySortDirection> getSort() {
		return sort;
	}

	public List<String> getFields() {
		return fields;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int parseLimit(List<String> limitList) throws QueryParamException {
		LOGGER.trace("Inside parseLimit: limitList = {}", Arrays.toString(limitList.toArray()));
		
		int limit = QueryTags.DEFAULT_LIMIT;
		
		if (limitList.size() > 1) {
			String s = "More than one limit parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		}
		else if (limitList.size() == 1) {
			try {
				limit = Integer.parseInt(limitList.get(0));
			}
			catch (NumberFormatException nfe) {
				String s = "Unable to parse limit";
				LOGGER.error(s, nfe);
				throw new QueryParamException(s, nfe);
			}
		}
		
		return limit;
	}
	
	public int parseOffset(List<String> offsetList) throws QueryParamException {
		LOGGER.trace("Inside parseOffset: offsetList = {}", Arrays.toString(offsetList.toArray()));
		
		int offset = QueryTags.DEFAULT_OFFSET;
		
		if (offsetList.size() > 1) {
			String s = "More than one offset parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		}
		else if (offsetList.size() == 1) {
			try {
				offset = Integer.parseInt(offsetList.get(0));
			}
			catch (NumberFormatException nfe) {
				String s = "Unable to parse offset";
				LOGGER.error(s, nfe);
				throw new QueryParamException(s, nfe);
			}
		}
		
		return offset;
	}
	
	public Map<String, QuerySortDirection> parseSort(List<String> sortList) throws QueryParamException {
		LOGGER.trace("Inside parseSort: sortList = {}", Arrays.toString(sortList.toArray()));
		
		Map<String, QuerySortDirection> sort = new LinkedHashMap<>();
		
		if (sortList.size() > 1) {
			String s = "More than one sort parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		}
		else if (sortList.size() == 1) {
			String sortString = sortList.get(0);
			LOGGER.debug("sort string: {}", sortString);
			String[] sortParams = sortString.split(",");
			LOGGER.debug("sort params: {}", Arrays.toString(sortParams));
			
			for (String param : sortParams) {
				String[] sortTokens = param.split(":");
				LOGGER.debug("sort tokens: {}", Arrays.toString(sortTokens));
				if (sortTokens.length != 2 || sortTokens[0] == null || sortTokens[0].trim().isEmpty()) {
					String s = "Invalid sort parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}
				try {
					QuerySortDirection direction = QuerySortDirection.valueOf(sortTokens[1]);
					sort.put(sortTokens[0].trim(), direction);
				}
				catch (IllegalArgumentException | NullPointerException e) {
					String s = "Invalid sort parameter: " + param;
					LOGGER.error(s);
					throw new QueryParamException(s);
				}
			}
		}
		
		return sort;
	}
	
	public List<String> parseFields(List<String> fieldsList) throws QueryParamException {
		LOGGER.trace("Inside parseFields: fieldsList = {}", Arrays.toString(fieldsList.toArray()));
		
		List<String> fields = new ArrayList<>();
		
		if (fieldsList.size() > 1) {
			String s = "More than one fields parameter found";
			LOGGER.error(s);
			throw new QueryParamException(s);
		} else if (fieldsList.size() == 1) {
			String fieldsString = fieldsList.get(0);
			LOGGER.debug("fields string: {}", fieldsString);
			String[] fieldsParams = fieldsString.split(",");
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
	
	public void parseQuery() {
		List<String> sortList = info.getQueryParameters().get(QueryTags.SORT);
		List<String> offsetList = info.getQueryParameters().get(QueryTags.OFFSET);
		List<String> limitList = info.getQueryParameters().get(QueryTags.LIMIT);
		List<String> fieldsList = info.getQueryParameters().get(QueryTags.FIELDS);
		
		sort = parseSort(sortList);
		offset = parseOffset(offsetList);
		limit = parseLimit(limitList);
		fields = parseFields(fieldsList);
	}
	
	public boolean isValid() {
		return true;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(QueryParamBean.class).add("filter", filter)
				.add("sort", sort).add("fields", fields).add("limit", limit).add("offset", offset).add("info", info.getRequestUri()).toString();
	}
	
}
