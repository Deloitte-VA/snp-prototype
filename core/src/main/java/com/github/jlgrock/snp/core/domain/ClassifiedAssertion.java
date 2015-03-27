package com.github.jlgrock.snp.core.domain;

/**
 * Marker class for noting that the assertion PCEs have been replaced by classifier ids
 */
public class ClassifiedAssertion extends Assertion {
	private String uuid;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(final String uuidIn) {
		uuid = uuidIn;
	}
	
}
