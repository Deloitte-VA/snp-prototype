package com.github.jlgrock.snp.core.model;

public class Point {
	private String type;
	private String value;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Point [type=" + type + ", value=" + value + "]";
	}
	
}
