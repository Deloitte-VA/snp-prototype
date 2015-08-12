package com.github.jlgrock.snp.domain.types;

import org.bson.types.ObjectId;

/**
 * Abstract class that handles ObjectId generation and shared functionality
 */
public abstract class AbstractMongoDomainObjectIdObject extends AbstractMongoDomainObject<ObjectId> {
    /**
     * Empty constructor, creates a new ObjectId.
     */
    protected AbstractMongoDomainObjectIdObject() {
        super();
        setId(ObjectId.get());
    }
}
