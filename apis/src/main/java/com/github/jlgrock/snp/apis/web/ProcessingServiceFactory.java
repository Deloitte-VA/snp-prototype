package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

import javax.ws.rs.core.MediaType;

/**
 * The Factory that determines what is available in the system and then determines
 * what processor to use, based on a particular media type.
 */
@Contract
public interface ProcessingServiceFactory {
    /**
     * Gets the service based on the media type passed in
     * @param snpMediaType the media type/mime-type to look up
     * @return the service that will process the request
     */
    ProcessingService getService(final MediaType snpMediaType);
}
