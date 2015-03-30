package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface AssertionClassifierService {
	
	void classifyAssertion(final String xml);
	
	void classifyAssertion(final InputStream inStream);
}
