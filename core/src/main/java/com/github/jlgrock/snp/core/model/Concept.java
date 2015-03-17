package com.github.jlgrock.snp.core.model;


public class Concept {
	private String uuid;
	private String desc;
	private String sctid;
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getSctid() {
		return sctid;
	}
	
	public void setSctid(String sctid) {
		this.sctid = sctid;
	}
	
	@Override
	public String toString() {
		return "Concept [uuid=" + uuid + ", desc=" + desc + ", sctid=" + sctid + "]";
	}	
	
}
