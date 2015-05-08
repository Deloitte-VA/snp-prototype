/**
 * 
 */
package com.github.jlgrock.snp.web;

import javax.ws.rs.core.MediaType;

/**
 * An abstraction for a media type. Instances are immutable. 
 * Types are specific to the data types that are specific to the SNP application.
 * 
 * @author shalewis
 *
 */
public class SnpMediaType extends MediaType {
	
    /**
     * A {@code String} constant representing {@value #APPLICATION_LEGO_XML} media type.
     */
    public final static String APPLICATION_LEGO_XML = "application/lego+xml";
    /**
     * A {@link MediaType} constant representing {@value #APPLICATION_LEGO_XML} media type.
     */
    public final static MediaType APPLICATION_LEGO_XML_TYPE = new MediaType("application", "lego+xml");
	
    /**
     * A {@code String} constant representing {@value #APPLICATION_FHIR_XML} media type.
     */
    public final static String APPLICATION_FHIR_XML = "application/fhir+xml";
    /**
     * A {@link MediaType} constant representing {@value #APPLICATION_FHIR_XML} media type.
     */
    public final static MediaType APPLICATION_FHIR_XML_TYPE = new MediaType("application", "fhir+xml");
}
