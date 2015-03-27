package com.github.jlgrock.snp.apis.domain;

/**
 *
 */
public interface MongoDomainObject {
    /**
     * return the object identifier.  This can be any of the allowable BSON types.  Please note that this will not
     * be checked until it is sent to the MongoDB driver.
     * @return the unique identifier
     */
    public Object getId();
}
