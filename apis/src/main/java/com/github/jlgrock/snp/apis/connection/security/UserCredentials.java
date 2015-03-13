package com.github.jlgrock.snp.apis.connection.security;

import org.jvnet.hk2.annotations.Contract;

/**
 *
 */
@Contract
public interface UserCredentials {
    String getUsername();

    String getPassword();
}
