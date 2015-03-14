package com.github.jlgrock.snp.apis.connection.security;

import org.jvnet.hk2.annotations.Contract;

/**
 * User credentials used for logging into MongoDB
 */
@Contract
public interface UserCredentials {
    /**
     * @return the username that will be used to access the database
     */
    String getUsername();

    /**
     * @return the password that will be used to access the database
     */
    char[] getPassword();
}
