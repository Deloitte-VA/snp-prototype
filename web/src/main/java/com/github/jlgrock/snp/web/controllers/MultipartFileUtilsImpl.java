package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.apis.data.MultiPartFileUtils;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * A service that will do simple File utilities
 */
@Singleton
@Service
public class MultipartFileUtilsImpl implements MultiPartFileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipartFileUtilsImpl.class);
    private static final int BYTE_SIZE = 1024;

    @Override
    public void writeToFile(final InputStream uploadedInputStream,
                             final java.nio.file.Path uploadedFileLocation) {

        try (OutputStream out = new FileOutputStream(uploadedFileLocation.toFile())) {
            int read = 0;
            byte[] bytes = new byte[MultipartFileUtilsImpl.BYTE_SIZE];

            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
