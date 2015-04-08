package com.github.jlgrock.snp.core.model.xml.fihr;

import com.google.common.base.MoreObjects;

/**
 * The Onset class represents the onset element in the FIHR XML document.
 *
 */
public class Onset {
	private OnsetDateTime onsetDateTime;

	public OnsetDateTime getOnsetDateTime() {
		return onsetDateTime;
	}

	public void setOnsetDateTime(final OnsetDateTime pOnsetDateTime) {
		onsetDateTime = pOnsetDateTime;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("onsetDateTime", onsetDateTime)
		.toString();
	}
	
}
