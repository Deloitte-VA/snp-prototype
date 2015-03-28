package com.github.jlgrock.snp.core.defaultconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 *
 */
public class PropertiesFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);

    private static final String PROPERTIES_FILE_NAME = "config.properties";

    private String user;
    private String password;
    private String host;
    private int port;
    private String database;
    private Path filelocation;

    public PropertiesFileReader() {
        readFile();
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getDatabase() {
        return database;
    }

    public Path getFilelocation() {
        return filelocation;
    }

    private void readFile() {
        Properties prop = new Properties();

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                LOGGER.debug("Found no files for configuration on classpath");
                return;
            }
        } else {
            LOGGER.debug("Found no files for configuration on classpath");
        }


        // get the property value and print it out
        user = prop.getProperty("mongodb.user");
        password = prop.getProperty("mongodb.password");
        host = prop.getProperty("mongodb.host");
        try {
            port = Integer.parseInt(prop.getProperty("mongodb.port"));
        } catch(NumberFormatException nfe) {
            LOGGER.error("mongodb.port is not a valid number.  Ignoring");
        }
        database = prop.getProperty(" mongodb.database");
        try {
            filelocation = Paths.get(prop.getProperty("webserver.filelocation"));
        } catch(Exception e) {
            LOGGER.error("webserver.filelocation is not a valid path.  Ignoring");
        }
    }
}
