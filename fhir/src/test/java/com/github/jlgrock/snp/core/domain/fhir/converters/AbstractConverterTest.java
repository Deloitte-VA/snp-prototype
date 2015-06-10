package com.github.jlgrock.snp.core.domain.fhir.converters;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class AbstractConverterTest {

	protected static final String path = "com.github.jlgrock.snp.core.domain.fhir.model";
	
    /**
     * Reads the content from a file
     * @return content in file
     */
    protected Reader readFile(String xmlFile) {
        BufferedReader br = null;
        StringBuilder out = new StringBuilder();
        InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader;
    }
}
