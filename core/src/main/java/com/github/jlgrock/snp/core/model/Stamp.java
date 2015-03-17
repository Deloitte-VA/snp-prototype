package com.github.jlgrock.snp.core.model;

public class Stamp {
	private String status;
	private String time;
	private String author;
	private String module;
	private String path;
	private String uuid;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "Stamp [status=" + status + ", time=" + time + ", author=" + author + ", module=" + module + ", path="
				+ path + ", uuid=" + uuid + "]";
	}	
	
}
