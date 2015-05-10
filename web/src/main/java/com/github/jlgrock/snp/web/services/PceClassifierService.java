package com.github.jlgrock.snp.web.services;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface PceClassifierService<T> {
	
	public void classifyAssertion(final List<T> legos);
	
}
