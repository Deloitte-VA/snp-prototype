package com.github.jlgrock.snp.web.configuration;

import io.dropwizard.jackson.AnnotationSensitivePropertyNamingStrategy;
import io.dropwizard.jackson.LogbackModule;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;

/**
 * The configuration objects associated with Jackson
 */
public final class JacksonConfig {

    /**
     * Singleton.
     */
    private JacksonConfig() { }

    /**
     * Creates a new {@link ObjectMapper} with JDK 8 Time and Optional support.
     * @return the object mapper, for use in serialization/deserialization
     */
    public static ObjectMapper newObjectMapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());
        mapper.registerModule(new LogbackModule());
        mapper.setPropertyNamingStrategy(new AnnotationSensitivePropertyNamingStrategy());
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        return mapper;
    }
}
