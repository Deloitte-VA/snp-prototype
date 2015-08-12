package com.github.jlgrock.snp.domain.types;

import com.github.jlgrock.snp.apis.domain.MongoDomainObject;

import javax.validation.constraints.NotNull;

/**
 * Shared ID functionality between domain objects.
 * @param <T> the type to use for the ID
 */
public abstract class AbstractMongoDomainObject<T> implements MongoDomainObject<T> {
    @NotNull
    private T id;

    /**
     * Empty constructor, creates a new ObjectId.
     */
    protected AbstractMongoDomainObject() {
    }

    /**
     * @param pId the identifier object
     */
    public void setId(final T pId) {
        if (pId == null) {
            return;
        }
        id = pId;
    }

    @Override
    public T getId() {
        return id;
    }
}
