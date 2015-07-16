package com.github.jlgrock.snp.core.domain.fhir;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 */
public class AbstractClassificationTest {

    protected static final String path = "com.github.jlgrock.snp.core.domain.fhir.model";

    /**
     * Prints the string content read from input stream
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
