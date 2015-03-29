package com.github.jlgrock.snp.core.defaultconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 */
public final class PropertiesFileReader {
    private static final Logger LOGGER = LoggerFactory.getLogger(MongoConfig.class);

    private static final String PROPERTIES_FILE_NAME = "config.properties";

    private static String user;
    private static String password;
    private static String host;
    private static Integer port;
    private static String database;
    private static String filelocation;

    static {
        readFile();
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    public static String getHost() {
        return host;
    }

    public static Integer getPort() {
        return port;
    }

    public static String getDatabase() {
        return database;
    }

    public static String getFilelocation() {
        return filelocation;
    }

    private PropertiesFileReader() {
    }

    private static void readFile() {
        Properties prop = new Properties();

        InputStream inputStream = new PropertiesFileReader().getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_NAME);

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
            filelocation = prop.getProperty("webserver.filelocation");
        } catch(Exception e) {
            LOGGER.error("webserver.filelocation is not a valid path.  Ignoring");
        }
    }
}
