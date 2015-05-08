package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;
import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.core.domain.lego.Lego;
import com.github.jlgrock.snp.core.domain.lego.LegoList;

@Contract
public interface AssertionClassifierService<T> {
	
//	void classifyAssertion(final String xml);
	
//	void classifyAssertion(final InputStream inStream);
	
	public void classifyAssertion(final List<T> legos);
	
//	LegoList parseStream(final InputStream inStream);
}
