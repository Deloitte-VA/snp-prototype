/**
 * 
 */
package com.github.jlgrock.snp.web.resources.query;

import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.MoreObjects;

/**
 *
 */
public class QueryParamBean {
//	Consider making this an implementation of an interface. Also, consider using a processor and 
//	chain of responsibility pattern
	
	private static final Logger LOGGER = LoggerFactory.getLogger(QueryParamBean.class);
	
	private UriInfo info;
	
//	@QueryParam("filter")
//	private String filter;
	
//	private Map<String, QuerySortDirection> sort;
	
//	private List<String> fields;
	
//	private int limit;
	
//	private int offset;
	
	public QueryParamBean(@Context UriInfo infoIn) {
		info = infoIn;
	}
	
	public UriInfo getUriInfo() {
		return info;
	}
	
//	public String getFilter() {
//		return filter;
//	}
//
//	public Map<String, QuerySortDirection> getSort() {
//		return sort;
//	}
//
//	public List<String> getFields() {
//		return fields;
//	}
//	
//	public int getLimit() {
//		return limit;
//	}
//	
//	public int getOffset() {
//		return offset;
//	}
	
	public boolean isValid() {
		return true;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(QueryParamBean.class).add("info", info.getRequestUri()).toString();
	}
	
}
