package com.github.jlgrock.snp.web.configuration;

import org.glassfish.hk2.utilities.ClasspathDescriptorFileFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
 *
 */
public class JerseyDescriptorFinder extends ClasspathDescriptorFileFinder {

    private static final Logger LOGGER = LoggerFactory.getLogger(JerseyDescriptorFinder.class);

    @Override
    public List<InputStream> findDescriptorFiles() throws IOException {
        final Enumeration<URL> metaInfUrls = this.getClass().getClassLoader()
                .getResources("META-INF/hk2-locator/default");
        final Enumeration<URL> webInfUrls = this.getClass().getClassLoader()
                .getResources("META-INF/hk2-locator/default");

        Collection<URL> urls = new ArrayList<URL>();
        urls.addAll(Collections.list(metaInfUrls));
        urls.addAll(Collections.list(webInfUrls));

        LOGGER.debug("locators: {}", Arrays.toString(urls.toArray()));

        return urls.stream().map(x -> {
            try {
                return x.openStream();
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }
}
