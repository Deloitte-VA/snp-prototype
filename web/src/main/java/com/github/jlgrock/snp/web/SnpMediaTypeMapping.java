package com.github.jlgrock.snp.web;

import javax.ws.rs.core.MediaType;

import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.lego.LegoList;

/**
 * Mappings of {@link MediaType} to the JAXB XmlRootElement class that represents 
 * that data type
 */
public enum SnpMediaTypeMapping {
	LEGO (SnpMediaType.APPLICATION_LEGO_XML_TYPE, LegoList.class),
	FHIR (SnpMediaType.APPLICATION_FHIR_XML_TYPE, Condition.class);
	
	private MediaType mediaType;
	private Class<? extends Object> entityClass;
	
	/**
	 * Constructor
	 * 
	 * @param mediaType {@link SnpMediaType} of data type
	 * @param entityClass JAXB XmlRootElement class representing the data type
	 */
	private SnpMediaTypeMapping(final MediaType mediaTypeIn, final Class<? extends Object> entityClassIn) {
		mediaType = mediaTypeIn;
		entityClass = entityClassIn;
	}
	
	/**
	 * Returns the entity (JAXB XmlRootElement) class that is mapped to a given {@link SnpMediaType}
	 * 
	 * @param mediaType {@link SnpMediaType} of the respective entity type
	 * @return JAXB XmlRootElement class representing the data type
	 */
	public static  Class<? extends Object> getEntityClass(final MediaType mediaType) {
		
		if (mediaType == null) {
			throw new NullPointerException("mediaType argument is null");
		}
		
		for (SnpMediaTypeMapping mapping : SnpMediaTypeMapping.values()) {
			if (mapping.mediaType.equals(mediaType)) {
				return mapping.entityClass;
			}
		}
		
		throw new IllegalArgumentException("No class found for media type: " + mediaType);
	}
}
