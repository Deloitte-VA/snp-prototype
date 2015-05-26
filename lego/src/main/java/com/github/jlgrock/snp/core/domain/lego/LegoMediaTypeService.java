package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.apis.web.MediaTypeService;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * The media types related to LEGO
 */
@Service
@Named
public class LegoMediaTypeService implements MediaTypeService {
    private static final String MIME_APPLICATION = "application";

    private static final String MIME_SPECIFIC_XML = "lego+xml";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMediaTypeString() {
        return MIME_APPLICATION + "/" + MIME_SPECIFIC_XML;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTypeName() {
        return MIME_APPLICATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSubTypeName() {
        return MIME_SPECIFIC_XML;
    }
}
