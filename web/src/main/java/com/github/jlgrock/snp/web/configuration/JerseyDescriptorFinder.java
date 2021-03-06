package com.github.jlgrock.snp.web.configuration;

import org.glassfish.hk2.utilities.ClasspathDescriptorFileFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Finds the descriptor files on the classpath
 */
public class JerseyDescriptorFinder extends ClasspathDescriptorFileFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyDescriptorFinder.class);

    private final ServletContext servletContext;

    /**
     * Struct for storing inputstreams and exceptions
     */
    private static class UrlMapResult {
        private final InputStream inputStream;
        private final IOException ioException;

        public UrlMapResult(final InputStream inputStreamIn, final IOException ioExceptionIn) {
            inputStream = inputStreamIn;
            ioException = ioExceptionIn;
        }

        public InputStream getInputStream() {
            return inputStream;
        }

        public IOException getIoException() {
            return ioException;
        }
    }

    /**
     * @param servletContextIn the servlet context, for finding war descriptors.
     *                         If this is null, it is ignored.
     */
    JerseyDescriptorFinder(final ServletContext servletContextIn) {
        servletContext = servletContextIn;
    }

    @Override
    public List<InputStream> findDescriptorFiles() throws IOException {
        final Enumeration<URL> metaInfUrls = this.getClass().getClassLoader()
                .getResources("META-INF/hk2-locator/default");
        Collection<URL> urls = new ArrayList<>();
        urls.addAll(Collections.list(metaInfUrls));

        URL webInfUrl;
        if (servletContext != null) {
            webInfUrl = servletContext.getResource("/WEB-INF/classes/hk2-locator/default");

            LOGGER.debug("web-inf locator: {}", webInfUrl);

            if (webInfUrl != null) {
                urls.add(webInfUrl);
            }
        }


        LOGGER.debug("meta-inf locators: {}", Arrays.toString(urls.toArray()));

        // open the descriptor files
        List<UrlMapResult> mapResults = urls
                .stream()
                .map(this::openStream)
                .collect(Collectors.toList());

        // find all errors that occured during read
        Collection<IOException> ioExceptions =
                mapResults.stream()
                        .filter(x -> x.getIoException() != null)
                        .map(UrlMapResult::getIoException)
                        .collect(Collectors.toList());

        // print errors that occurred in reading descriptors
        for (IOException e : ioExceptions) {
            LOGGER.error("Unable to read descriptor file.", e);
        }

        //return everything else
        return mapResults.stream()
                .filter(x -> x.getIoException() == null)
                .map(UrlMapResult::getInputStream)
                .collect(Collectors.toList());
    }

    private UrlMapResult openStream(final URL url) {
        InputStream inputStream = null;
        IOException ioException = null;
        try {
            inputStream = url.openStream();
        } catch (final IOException e) {
            ioException = e;
        }

        return new UrlMapResult(inputStream, ioException);
    }
}
