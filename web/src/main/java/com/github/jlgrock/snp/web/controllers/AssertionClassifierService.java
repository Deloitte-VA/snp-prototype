package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;
import java.util.List;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.core.model.xml.lego.Lego;
import com.github.jlgrock.snp.core.model.xml.lego.LegoList;

@Contract
public interface AssertionClassifierService {
	
	void classifyAssertion(final String xml);
	
	void classifyAssertion(final InputStream inStream);
	
	public void classifyAssertion(final List<Lego> legos);
	
	LegoList parseStream(final InputStream inStream);
}
