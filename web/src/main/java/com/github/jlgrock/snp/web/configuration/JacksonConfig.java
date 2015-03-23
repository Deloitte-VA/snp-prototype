package com.github.jlgrock.snp.web.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.dropwizard.jackson.AnnotationSensitivePropertyNamingStrategy;
import io.dropwizard.jackson.LogbackModule;

/**
 * The configuration objects associated with Jackson
 */
public class JacksonConfig {

    /**
     * Singleton.
     */
    private JacksonConfig() { }

    /**
     * Creates a new {@link ObjectMapper} with JDK 8 Time and Optional support.
     */
    public static ObjectMapper newObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new LogbackModule());
        mapper.setPropertyNamingStrategy(new AnnotationSensitivePropertyNamingStrategy());
        return mapper;
    }
}
