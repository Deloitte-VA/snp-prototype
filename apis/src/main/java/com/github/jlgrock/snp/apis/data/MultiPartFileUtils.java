package com.github.jlgrock.snp.apis.data;

import org.jvnet.hk2.annotations.Contract;

import java.io.InputStream;
import java.nio.file.Path;

/**
 * A Contract for any number of File Utilities that might be useful.  This can differ by OS type, for example.
 */
@Contract
public interface MultiPartFileUtils {

    /**
     * Save the uploaded file to new location
     *
     * @param uploadedInputStream the input file, as a stream
     * @param uploadedFileLocation the output location, to write the stream
     */
    void writeToFile(InputStream uploadedInputStream, Path uploadedFileLocation);
}

