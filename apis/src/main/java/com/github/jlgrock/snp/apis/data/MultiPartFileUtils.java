package com.github.jlgrock.snp.apis.data;

import org.jvnet.hk2.annotations.Contract;

import java.io.InputStream;

/**
 *
 */
@Contract
public interface MultiPartFileUtils {
    void writeToFile(InputStream uploadedInputStream, java.nio.file.Path uploadedFileLocation);
}
