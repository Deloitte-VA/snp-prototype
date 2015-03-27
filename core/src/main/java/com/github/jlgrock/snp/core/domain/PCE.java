package com.github.jlgrock.snp.core.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * The post-coordinated expression and the unique identifier, for reference purposes.
 */
public class PCE extends AbstractMongoDomainObject {
    private String desc;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PCE that = (PCE) o;

        return Objects.equal(getId(), that.getId()) &&
                Objects.equal(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId(), desc);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("desc", desc)
                .toString();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String pDesc) {
        this.desc = pDesc;
    }
}

