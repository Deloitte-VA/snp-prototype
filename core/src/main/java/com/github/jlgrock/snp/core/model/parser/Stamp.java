package com.github.jlgrock.snp.core.model.parser;

/**
 * The Stamp class represents the stamp element in the LEGO XML document.
 *
 */
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

	public void setStatus(final String pStatus) {
		status = pStatus;
	}

	public String getTime() {
		return time;
	}

	public void setTime(final String pTime) {
		time = pTime;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(final String pAuthor) {
		author = pAuthor;
	}

	public String getModule() {
		return module;
	}

	public void setModule(final String pModule) {
		module = pModule;
	}

	public String getPath() {
		return path;
	}

	public void setPath(final String pPath) {
		path = pPath;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}

	@Override
	public String toString() {
		return "Stamp [status=" + status + ", time=" + time + ", author=" + author + ", module=" + module + ", path="
				+ path + ", uuid=" + uuid + "]";
	}	
	
}
