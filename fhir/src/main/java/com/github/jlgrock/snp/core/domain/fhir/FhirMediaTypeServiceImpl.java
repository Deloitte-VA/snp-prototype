package com.github.jlgrock.snp.core.domain.fhir;

import org.jvnet.hk2.annotations.Service;

/**
 * The media types related to Fhir.
 */
@Service
public class FhirMediaTypeServiceImpl implements FhirMediaTypeService {
    private static final String MIME_APPLICATION = "application";

    private static final String MIME_SPECIFIC_XML = "fhir+xml";

    @Override
    public String getMediaTypeString() {
        return MIME_APPLICATION + "/" + MIME_SPECIFIC_XML;
    }

    @Override
    public String getTypeName() {
        return MIME_APPLICATION;
    }

    @Override
    public String getSubTypeName() {
        return MIME_SPECIFIC_XML;
    }
}
