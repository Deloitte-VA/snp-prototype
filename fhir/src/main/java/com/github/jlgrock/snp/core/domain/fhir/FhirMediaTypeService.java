package com.github.jlgrock.snp.core.domain.fhir;

import com.github.jlgrock.snp.apis.web.MediaTypeService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;
import java.lang.String;

/**
 * The media types related to Fhir
 */
@Service
@Named
public class FhirMediaTypeService implements MediaTypeService {
    private static final java.lang.String MIME_APPLICATION = "application";

    private static final java.lang.String MIME_SPECIFIC_XML = "fhir+xml";

    @Override
    public java.lang.String getMediaTypeString() {
        return MIME_APPLICATION + "/" + MIME_SPECIFIC_XML;
    }

    @Override
    public java.lang.String getTypeName() {
        return MIME_APPLICATION;
    }

    @Override
    public String getSubTypeName() {
        return MIME_SPECIFIC_XML;
    }
}
