package com.github.jlgrock.snp.core.defaultconfig;

import com.github.jlgrock.snp.apis.connection.configuration.FileConfiguration;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The default configuration for the web container.  This will parse a properties
 * file and store this information into the variables.
 */
@Service
public class FileConfig implements FileConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileConfig.class);

    private static final String DEFAULT_DIR_LOCATION = System.getProperty("default.dir.location");
    private static final String DEFAULT_CHRONICLE_LOCATION = System.getProperty("default.chronicle.location");
    private static final String DEFAULT_INDEX_LOCATION = System.getProperty("default.index.location");

    private final Path fileUploadPath;
    private final Path chroniclePath;
    private final Path fileIndexPath;

    /**
     * Create the configuration object.  This will read the default properties
     * file and use it for the web application.
     */
    public FileConfig() {

        LOGGER.debug("FileConfig: DEFAULT_DIR_LOCATION-->" + DEFAULT_DIR_LOCATION);
        LOGGER.debug("FileConfig: DEFAULT_CHRONICLE_LOCATION-->" + DEFAULT_CHRONICLE_LOCATION);
        LOGGER.debug("FileConfig: DEFAULT_INDEX_LOCATION-->" + DEFAULT_INDEX_LOCATION);

        String fileLocationString = PropertiesFileReader.getFilelocation();
        Path fileUploadPathIn = null;
        if (fileLocationString != null) {
            LOGGER.debug("Unable to find application property webserver.filelocation");
            fileUploadPathIn = Paths.get(fileLocationString);
        }
        if (fileUploadPathIn == null) {
            LOGGER.debug("file upload path is not valid, using default");
            fileUploadPathIn = Paths.get(DEFAULT_DIR_LOCATION);
        }
        fileUploadPath = fileUploadPathIn;
        LOGGER.debug("fileUploadPath={}", fileUploadPath);

        Path chroniclePathIn = null;
        String chronicleLocationString = PropertiesFileReader.getChronicleLocation();
        if (chronicleLocationString != null) {
            LOGGER.debug("Unable to find application property webserver.chronicleLocation");
            chroniclePathIn = Paths.get(chronicleLocationString);
        }
        if (chroniclePathIn == null) {
            LOGGER.debug("chronicle path is not valid, using default");
            chroniclePathIn = Paths.get(DEFAULT_CHRONICLE_LOCATION);
        }
        chroniclePath = chroniclePathIn;
        LOGGER.debug("chroniclePath={}", chroniclePath);

        Path fileIndexPathIn = null;
        String fileIndexPathString = PropertiesFileReader.getIndexLocation();
        if (fileIndexPathString != null) {
            LOGGER.debug("Unable to find application property webserver.indexLocation");
            fileIndexPathIn = Paths.get(fileIndexPathString);
        }
        if (fileIndexPathIn == null) {
            LOGGER.debug("index path is not valid, using default");
            fileIndexPathIn = Paths.get(DEFAULT_INDEX_LOCATION);
        }
        fileIndexPath = fileIndexPathIn;
        LOGGER.debug("fileIndexPathIn={}", fileIndexPathIn);
    }

    @Override
    public Path fileUploadLocation() {
        return fileUploadPath;
    }

    @Override
    public Path chronicleLocation() {
        return chroniclePath;
    }

    @Override
    public Path luceneLocation() {
        return fileIndexPath;
    }
}
