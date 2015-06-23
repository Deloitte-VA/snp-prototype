package com.github.jlgrock.snp.domain.types;

import com.google.common.base.MoreObjects;

import java.util.Objects;
import java.util.UUID;

/**
 * An object that has classified all of the PCEs
 */
public class ClassifiedPce extends AbstractMongoDomainObject {
    private UUID uuid;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(final UUID uuidIn) {
        uuid = uuidIn;
    }

    private String desc;

    @Override
    public int hashCode() {
        return Objects.hash(uuid, desc);
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
        return Objects.equals(this.uuid, other.uuid)
                && Objects.equals(this.desc, other.desc);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", getId())
                .add("uuid", uuid)
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
