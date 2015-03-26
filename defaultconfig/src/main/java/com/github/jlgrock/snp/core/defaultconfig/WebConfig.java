package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.configuration.WebConfiguration;
import org.jvnet.hk2.annotations.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The default configuration for the web container.  This will parse a properties
 * file and store this information into the variables.
 */
@Service
public class WebConfig implements WebConfiguration {

    private static final String TEMP_DIR_LOCATION = "/data/uploads";

    //TODO this should be parsing a config file for these properties
    @Override
    public Path fileLocation() {
        return Paths.get(WebConfig.TEMP_DIR_LOCATION);
    }
}
