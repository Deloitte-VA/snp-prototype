package com.github.jlgrock.snp.domain.types;

import com.google.common.base.MoreObjects;

import java.util.Objects;

/**
 * An object that has classified all of the PCEs
 */
public class ClassifiedPce extends AbstractMongoDomainObject {
    private Long nid;

    public Long getNid() {
        return nid;
    }

    public void setNid(final Long nidIn) {
        nid = nidIn;
    }

    private String desc;

    @Override
    public int hashCode() {
        return Objects.hash(nid, desc);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ClassifiedPce other = (ClassifiedPce) obj;
        return Objects.equals(this.nid, other.nid)
                && Objects.equals(this.desc, other.desc);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("nid", nid)
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
