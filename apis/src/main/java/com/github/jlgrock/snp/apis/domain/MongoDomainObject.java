package com.github.jlgrock.snp.apis.domain;

/**
 * Simple interface that guarantees some form of ID on the object.
 * @param <T> This can be any of the allowable BSON types.  Please note that this will not
 * be checked until it is sent to the MongoDB driver.
 */
public interface MongoDomainObject<T> {
    /**
     * @return return the object identifier.
     */
    T getId();
}
