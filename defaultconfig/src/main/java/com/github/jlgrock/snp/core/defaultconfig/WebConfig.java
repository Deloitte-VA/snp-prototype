package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;
import org.jvnet.hk2.annotations.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 */
@Service
public class WebConfig implements WebConfiguration {
    //TODO make sure this directory is updated and exists in docker container
    private final static String TEMP_DIR_LOCATION = "/tmp";

    @Override
    public Path fileLocation() {
        return Paths.get(WebConfig.TEMP_DIR_LOCATION);
    }
}
