package com.github.jlgrock.snp.core.defaultconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;

/**
 * Utility class for reading properties values from a configuration file.
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

    /**
     * Read the file at instantiation.
     */
    static {
        readFile();
    }

    /**
     * @return the user from the configuration file
     */
    public static String getUser() {
        return user;
    }

    /**
     * @return the password from the configuration file
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @return the hostname or ip address from the configuration file
     */
    public static String getHost() {
        return host;
    }

    /**
     * @return the port from the configuration file
     */
    public static Integer getPort() {
        return port;
    }

    /**
     * @return the name of the database from the configuration file
     */
    public static String getDatabase() {
        return database;
    }

    /**
     * @return the file location of the webserver, as identified in the
     * configuration file
     */
    public static String getFilelocation() {
        return filelocation;
    }

    /**
     * Private constructor for a utility class
     */
    private PropertiesFileReader() {
    }

    private static void readFile() {
        readFile(null);
    }

    /**
     * Read the properties from the file identified
     * @param filename the file to read in
     */
    static void readFile(final String filename) {
        Properties prop = new Properties();


        String fname = filename;
        if (fname == null) {
            fname = PROPERTIES_FILE_NAME;
        }
        LOGGER.info("Loading properties file [" + fname + "]");
        InputStream inputStream = PropertiesFileReader.class.getClassLoader().getResourceAsStream(fname);

        if (inputStream != null) {
            try {
                prop.load(inputStream);
                StringWriter s = new StringWriter();
                PrintWriter p = new PrintWriter(s);
                prop.list(p);
                LOGGER.info(s.toString());
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
            String parsedPort = prop.getProperty("mongodb.port");
            port = Integer.parseInt(parsedPort);
        } catch (NumberFormatException nfe) {
            LOGGER.error("mongodb.port is not a valid number.  Ignoring");
        }
        database = prop.getProperty("mongodb.database");
        try {
            filelocation = prop.getProperty("webserver.filelocation");
        } catch (Exception e) {
            LOGGER.error("webserver.filelocation is not a valid path.  Ignoring");
        }
    }
}
