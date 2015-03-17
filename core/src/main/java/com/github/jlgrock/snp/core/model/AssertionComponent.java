package com.github.jlgrock.snp.core.model;

public class AssertionComponent {
	private String uuid;
	private Type type;
	
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "AssertionComponent [uuid=" + uuid + ", type=" + type + "]";
	}
	
}
