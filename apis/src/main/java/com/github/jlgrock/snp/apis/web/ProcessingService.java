package com.github.jlgrock.snp.apis.web;

/**
 *
 */
public interface ProcessingService<T> {
    void processInput(final String input);

    String getMediaTypeString();
}
