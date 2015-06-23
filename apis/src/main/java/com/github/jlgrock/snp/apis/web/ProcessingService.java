package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

/**
 * Binds a processor to the applicable media-type/mime-type.
 */
@Contract
public interface ProcessingService {
    /**
     * Process a string of characters.  It will only be asked to process input that
     * matches the media type string provided in the {@link #getMediaTypeString()} method
     * @param input the XML input
     */
    void processInput(final String input);

    /**
     * @return the media types/mime-type that this process is applicable for.
     */
    String getMediaTypeString();
}
