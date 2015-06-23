package com.github.jlgrock.snp.apis.web;

/**
 * The media-type/mime-type, broken into the constituent parts.
 */
public interface MediaTypeService {
    /**
     * @return The media type to scan for when parsing uploads.
     */
    String getMediaTypeString();

    /**
     * @return The type part of the media type
     */
    String getTypeName();

    /**
     * @return The subtype part of the media type
     */
    String getSubTypeName();
}
