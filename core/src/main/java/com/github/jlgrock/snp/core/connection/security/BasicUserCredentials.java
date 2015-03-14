package com.github.jlgrock.snp.core.connection.security;

import com.github.jlgrock.snp.apis.connection.security.UserCredentials;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * The user credentials file that will be populated using the Mongo configuration and help for the duration of the
 * program.
 */
public class BasicUserCredentials implements UserCredentials {
    private static final Logger LOGGER = LoggerFactory.getLogger(BasicUserCredentials.class);

    /**
     * The username for the connection
     */
    private final String username;

    /**
     * The password for the connection (kept in char[] to make sure that it is not added to the String pool)
     */
    private final char[] password;

    /**
     * Null credentials constructor.
     */
    public BasicUserCredentials() {
        username = "";
        password = null;
    }

    /**
     * Set the username/password, where neither the username nor password should be null.
     * @param usernameIn the username to use for the connection
     * @param passwordIn the password to use for the connection
     */
    public BasicUserCredentials(final String usernameIn, final char[] passwordIn) {
        Preconditions.checkNotNull(usernameIn, "Username cannot be null.");
        Preconditions.checkNotNull(passwordIn , "Password cannot be null.");
        username = usernameIn;
        password = Arrays.copyOf(passwordIn, passwordIn.length);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicUserCredentials that = (BasicUserCredentials) o;

        return Objects.equal(username, that.username) &&
                Arrays.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(username, password);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public char[] getPassword() {
        return Arrays.copyOf(password, password.length);
    }
}
