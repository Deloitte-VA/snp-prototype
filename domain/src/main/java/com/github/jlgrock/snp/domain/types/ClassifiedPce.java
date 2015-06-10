package com.github.jlgrock.snp.domain.types;

import com.google.common.base.MoreObjects;

import javax.validation.constraints.NotNull;
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

    @NotNull
    private Long id;

    private String desc;

    @Override
    public int hashCode() {
        return Objects.hash(uuid, id, desc);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final ClassifiedPce other = (ClassifiedPce) obj;
        return Objects.equals(this.uuid, other.uuid)
                && Objects.equals(this.id, other.id)
                && Objects.equals(this.desc, other.desc);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("uuid", uuid)
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
