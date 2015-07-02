package com.github.jlgrock.snp.web.resources.query;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.google.common.base.MoreObjects;

/**
 * 
 *
 */
public class QueryUriBean {
	
	private UriInfo info;
	
	/**
	 * Constructor
	 * 
	 * @param infoIn query URI
	 */
	public QueryUriBean(@Context final UriInfo infoIn) {
		info = infoIn;
	}
	
	/**
	 * Returns the query URI
	 * 
	 * @return query URI
	 */
	public UriInfo getUriInfo() {
		return info;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(QueryParamBean.class).add("info", info.getRequestUri()).toString();
	}
}
