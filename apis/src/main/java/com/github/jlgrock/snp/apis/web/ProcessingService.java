package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.apis.exceptions.ProcessingException;

/**
 * Binds a processor to the applicable media-type/mime-type.
 */
@Contract
public interface ProcessingService {
    /**
     * Process a string of characters.  It will only be asked to process input that
     * matches the media type string provided in the {@link #getMediaTypeString()} method
     * @param input the XML input
     * @param identifier the unique identifier - this is required by some input types as the id is not defined in the
     * @throws ProcessingException 
     */
    void processInput(final String input, final String identifier) throws ProcessingException;

    /**
     * @return the media types/mime-type that this process is applicable for.
     */
    String getMediaTypeString();
}
