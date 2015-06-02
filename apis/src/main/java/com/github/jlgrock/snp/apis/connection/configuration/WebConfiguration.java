package com.github.jlgrock.snp.apis.connection.configuration;

import org.jvnet.hk2.annotations.Contract;

import java.nio.file.Path;

/**
 * Any web server specific configuration.
 */
@Contract
public interface WebConfiguration {
    /**
     * The directory to store any files that will be uploaded.
     * @return the path to the directory
     */
    Path fileLocation();
}

