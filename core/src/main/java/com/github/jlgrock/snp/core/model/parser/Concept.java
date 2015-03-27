package com.github.jlgrock.snp.core.model.parser;

import com.google.common.base.MoreObjects;

/**
 * The Concept class represents the concept element in the LEGO XML document.
 *
 */
public class Concept {
	private String uuid;
	private String desc;
	private String sctid;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(final String pDesc) {
		desc = pDesc;
	}
	
	public String getSctid() {
		return sctid;
	}
	
	public void setSctid(final String pSctid) {
		sctid = pSctid;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("uuid", uuid)
		.add("desc", desc)
		.add("sctid", sctid)
		.toString();
	}	
	
}
