package com.github.jlgrock.snp.web;

import com.github.jlgrock.snp.core.domain.fhir.FhirEnvelope;
import com.github.jlgrock.snp.core.domain.lego.LegoEnvelope;

import javax.ws.rs.core.MediaType;

/**
 * Mappings of {@link MediaType} to the JAXB XmlRootElement class that represents 
 * that data type
 */
public enum SnpMediaTypeMapping {
	LEGO (SnpMediaType.APPLICATION_LEGO_XML_TYPE, LegoEnvelope.class),
	FHIR (SnpMediaType.APPLICATION_FHIR_XML_TYPE, FhirEnvelope.class);
	
	private MediaType mediaType;
	private Class<? extends Object> entityClass;
	
	/**
	 * Constructor
	 * 
	 * @param mediaTypeIn {@link SnpMediaType} of data type
	 * @param entityClassIn JAXB XmlRootElement class representing the data type
	 */
	private SnpMediaTypeMapping(final MediaType mediaTypeIn, final Class<? extends Object> entityClassIn) {
		mediaType = mediaTypeIn;
		entityClass = entityClassIn;
	}

	/**
	 * @return the media type of the mapping
	 */
	public MediaType getMediaType() {
		return mediaType;
	}

	/**
	 * @return the entity class of the mapping
	 */
	public Class<? extends Object> getEntityClass() {
		return entityClass;
	}

	/**
	 * Returns the entity (JAXB XmlRootElement) class that is mapped to a given {@link SnpMediaType}
	 * 
	 * @param mediaType {@link SnpMediaType} of the respective entity type
	 * @return JAXB XmlRootElement class representing the data type
	 */
	public static  Class<? extends Object> getEntityClassByMediaType(final MediaType mediaType) {
		
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
