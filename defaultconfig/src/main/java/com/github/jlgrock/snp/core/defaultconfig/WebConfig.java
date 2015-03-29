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

    static final String TEMP_DIR_LOCATION = "/data/uploads";

    private String filepath;

    WebConfig() {
        filepath = PropertiesFileReader.getFilelocation();
        if (filepath == null) {
            filepath = WebConfig.TEMP_DIR_LOCATION;
        }
    }
    /**
     * @return the location, in string format
     */
    public String getFilepath() {
        return filepath;
    }

    @Override
    public Path fileLocation() {
        return Paths.get(filepath);
    }
}
