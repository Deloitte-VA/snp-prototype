package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

public interface XmlParser<T> {

	T parseDocument(final InputStream xmlInput);
}
