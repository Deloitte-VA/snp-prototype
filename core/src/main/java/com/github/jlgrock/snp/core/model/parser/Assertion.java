package com.github.jlgrock.snp.core.model.parser;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.MoreObjects;
/**
 * The Assertion class represents the assertion element in the LEGO XML document.
 *
 */
public class Assertion {
	private String uuid;
	private Discernible discernible;
	private Qualifier qualifier;
	private Value value;
	private Timing timing;
	private List<AssertionComponent> assertionComponents = new ArrayList<AssertionComponent>();
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}
	
	public Discernible getDiscernible() {
		return discernible;
	}
	
	public void setDiscernible(final Discernible pDiscernible) {
		discernible = pDiscernible;
	}
	
	public Qualifier getQualifier() {
		return qualifier;
	}

	public void setQualifier(final Qualifier pQualifier) {
		qualifier = pQualifier;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(final Value pValue) {
		value = pValue;
	}

	public Timing getTiming() {
		return timing;
	}

	public void setTiming(final Timing pTiming) {
		timing = pTiming;
	}

	public List<AssertionComponent> getAssertionComponents() {
		return assertionComponents;
	}

	public void setAssertionComponents(final List<AssertionComponent> pAssertionComponents) {
		assertionComponents = pAssertionComponents;
	}
	
	/**
	 * Appends the AssertionComponet to the end of a list
	 * @param assertionComponent AssertionComponent to be appended to the list
	 */
	public void addAssertionComponent(final AssertionComponent assertionComponent) {
		assertionComponents.add(assertionComponent);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("uuid", uuid)
		.add("discernible", discernible)
		.add("qualifier", qualifier)
		.add("value", value)
		.add("timing", timing)
		.add("assertionComponents", assertionComponents)
		.toString();
	}
	
}
