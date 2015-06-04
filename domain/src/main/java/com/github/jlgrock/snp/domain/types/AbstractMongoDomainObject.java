package com.github.jlgrock.snp.domain.types;

import com.github.jlgrock.snp.apis.domain.MongoDomainObject;

import javax.validation.constraints.NotNull;

/**
 *
 */
public abstract class AbstractMongoDomainObject implements MongoDomainObject<Long> {
    @NotNull
    private Long id;

    /**
     * @param pId the identifier object
     */
    public void setId(final Long pId) {
        id = pId;
    }

    @Override
    public Long getId() {
        return id;
    }
}
