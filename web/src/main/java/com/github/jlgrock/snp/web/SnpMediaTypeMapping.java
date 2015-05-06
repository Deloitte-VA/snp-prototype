package com.github.jlgrock.snp.web;

import javax.ws.rs.core.MediaType;

import com.github.jlgrock.snp.core.model.xml.fihr.Bundle;
import com.github.jlgrock.snp.core.domain.lego.LegoList;

public enum SnpMediaTypeMapping {
	LEGO (SnpMediaType.APPLICATION_LEGO_XML_TYPE, LegoList.class),
	FHIR (SnpMediaType.APPLICATION_FHIR_XML_TYPE, Bundle.class);
	
	private MediaType mediaType;
	private Class<? extends Object> entityClass;
	
	private SnpMediaTypeMapping(MediaType mediaType, Class<? extends Object> entityClass) {
		this.mediaType = mediaType;
		this.entityClass = entityClass;
	}
	
	public static  Class<? extends Object> getEntityClass(MediaType mediaType) {
		
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
