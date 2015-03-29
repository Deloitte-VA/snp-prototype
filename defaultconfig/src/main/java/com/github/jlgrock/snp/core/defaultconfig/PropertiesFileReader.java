package com.github.jlgrock.snp.core.defaultconfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
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

    static void readFile() {
        readFile(null);
    }
    static void readFile(final String filename) {
        Properties prop = new Properties();


        String fname = filename;
        if (fname == null) {
            fname = PROPERTIES_FILE_NAME;
        }
        LOGGER.info("Loading properties file [" + fname + "]");
        InputStream inputStream = new PropertiesFileReader().getClass().getClassLoader().getResourceAsStream(fname);

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
            String parsedport = prop.getProperty("mongodb.port");
            port = Integer.parseInt(parsedport);
        } catch(NumberFormatException nfe) {
            LOGGER.error("mongodb.port is not a valid number.  Ignoring");
        }
        database = prop.getProperty("mongodb.database");
        try {
            filelocation = prop.getProperty("webserver.filelocation");
        } catch(Exception e) {
            LOGGER.error("webserver.filelocation is not a valid path.  Ignoring");
        }
    }
}
