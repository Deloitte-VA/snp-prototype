package com.github.jlgrock.snp.core.domain;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

import javax.validation.constraints.NotNull;

/**
 * The post-coordinated expression and the unique identifier, for reference purposes.
 */
public class Assertion {
    @NotNull
    private Long id;

    private String desc;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Assertion that = (Assertion) o;

        return Objects.equal(id, that.id) &&
                Objects.equal(desc, that.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, desc);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("desc", desc)
                .toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long pId) {
        this.id = pId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String pDesc) {
        this.desc = pDesc;
    }
}

