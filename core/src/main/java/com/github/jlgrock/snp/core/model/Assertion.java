package com.github.jlgrock.snp.core.model;

import java.util.ArrayList;
import java.util.List;

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
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public Discernible getDiscernible() {
		return discernible;
	}
	
	public void setDiscernible(Discernible discernible) {
		this.discernible = discernible;
	}
	
	public Qualifier getQualifier() {
		return qualifier;
	}

	public void setQualifier(Qualifier qualifier) {
		this.qualifier = qualifier;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Timing getTiming() {
		return timing;
	}

	public void setTiming(Timing timing) {
		this.timing = timing;
	}

	public List<AssertionComponent> getAssertionComponents() {
		return assertionComponents;
	}

	public void setAssertionComponents(List<AssertionComponent> assertionComponents) {
		this.assertionComponents = assertionComponents;
	}

	public void addAssertionComponent(AssertionComponent assertionComponent) {
		assertionComponents.add(assertionComponent);
	}
	
	@Override
	public String toString() {
		return "Assertion [uuid=" + uuid + ", discernible=" + discernible + ", qualifier=" + qualifier + ", value="
				+ value + ", timing=" + timing + ", assertionComponents=" + assertionComponents + "]";
	}
	
}
