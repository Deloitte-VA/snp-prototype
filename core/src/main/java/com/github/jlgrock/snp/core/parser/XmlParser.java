package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

public interface XmlParser<T> {

	/**
     * Parse the XML input stream into java objects
     * @param xmlInput the input stream
     * @return the deserialized java objects
     */
	T parseDocument(final InputStream xmlInput);
}
