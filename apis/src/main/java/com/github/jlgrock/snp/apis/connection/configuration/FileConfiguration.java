package com.github.jlgrock.snp.apis.connection.configuration;

import org.jvnet.hk2.annotations.Contract;

import java.nio.file.Path;

/**
 * Any web server specific configuration.
 */
@Contract
public interface FileConfiguration {
    /**
     * The directory to store any files that will be uploaded.
     * @return the path to the directory
     */
    Path fileUploadLocation();

    /**
     * The directory that contains the concept database.
     * @return the path to the directory
     */
    Path chronicleLocation();

    /**
     * The directory that contains the lucene indexing files.
     * @return the path to the directory
     */
    Path luceneLocation();
}

