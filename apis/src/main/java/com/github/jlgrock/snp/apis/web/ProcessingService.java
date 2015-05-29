package com.github.jlgrock.snp.apis.web;

import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface ProcessingService {
    void processInput(final String input);

    String getMediaTypeString();
}
