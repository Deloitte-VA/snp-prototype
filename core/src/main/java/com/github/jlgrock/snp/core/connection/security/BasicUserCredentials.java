package com.github.jlgrock.snp.core.connection.security;

import com.github.jlgrock.snp.apis.connection.security.UserCredentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class BasicUserCredentials implements UserCredentials {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicUserCredentials.class);

    private final String username;
    private final String password;

    // TODO need to replace with properties file that is OSGI safe.
    // TODO See http://wiki.osgi.org/wiki/Configuration_Admin
    public BasicUserCredentials() {
        username = "";
        password = "";
    }

    public BasicUserCredentials(final String usernameIn, final String passwordIn) {
        if (usernameIn == null) {
            LOGGER.error("Username should not be null.");
        }
        if (passwordIn == null) {
            LOGGER.error("Password should not be null.");
        }
        username = usernameIn;
        password = passwordIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicUserCredentials that = (BasicUserCredentials) o;

        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
