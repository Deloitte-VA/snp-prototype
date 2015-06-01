package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface MediaTypeService {
    /**
     * The media type to scan for when parsing uploads.
     */
    String getMediaTypeString();

    /**
     * The type part of the media type
     */
    String getTypeName();

    /**
     * The subtype part of the media type
     */
    String getSubTypeName();
}
