package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

import javax.ws.rs.core.MediaType;

/**
 *
 */
@Contract
public interface ProcessingServiceFactory {
    ProcessingService getService(final MediaType snpMediaType);
}
