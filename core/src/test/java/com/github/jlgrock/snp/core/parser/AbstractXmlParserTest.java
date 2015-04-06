package com.github.jlgrock.snp.core.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class AbstractXmlParserTest {

	/**
	 * Prints the string content read from input stream
	 * @return content in file
	 */
	public String readFile(String xmlFile) {
		BufferedReader br = null;
		StringBuilder out = new StringBuilder();
		try {
			InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
	        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
	        String line;
	        while ((line = reader.readLine()) != null) {
	        	if(!"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>".equals(line.trim())) {
	        		out.append(line.trim());
	        	}
	        }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		 return out.toString();
	}
	
}
