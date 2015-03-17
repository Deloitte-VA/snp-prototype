package com.github.jlgrock.snp.core.model;

public class Pncs {
	private String value;
	private String name;
	private String id;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pncs [value=" + value + ", name=" + name + ", id=" + id + "]";
	}	
	
}
