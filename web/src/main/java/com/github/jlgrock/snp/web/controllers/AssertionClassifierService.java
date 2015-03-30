package com.github.jlgrock.snp.web.controllers;

import java.io.InputStream;

public interface AssertionClassifierService {
	
	void classifyAssertion(final String xml);
	
	void classifyAssertion(final InputStream inStream);
}
