package com.github.jlgrock.snp.web.controllers;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 */
@Singleton
@Service
public class MultipartFileUtilsImpl implements MultiPartFileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MultipartFileUtilsImpl.class);

    /**
     * Save the uploaded file to new location
     */
    public void writeToFile(final InputStream uploadedInputStream,
                             final java.nio.file.Path uploadedFileLocation) {

        try {
            int read = 0;
            byte[] bytes = new byte[1024];

            OutputStream out = new FileOutputStream(uploadedFileLocation.toFile());
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.flush();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

    }
}
