package com.github.jlgrock.snp.core.domain;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import com.google.common.base.MoreObjects;

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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;

		ClassifiedPce that = (ClassifiedPce) o;

		if (uuid != null ? !uuid.equals(that.uuid) : that.uuid != null) return false;
		if (id != null ? !id.equals(that.id) : that.id != null) return false;
		return !(desc != null ? !desc.equals(that.desc) : that.desc != null);

	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
		result = 31 * result + (id != null ? id.hashCode() : 0);
		result = 31 * result + (desc != null ? desc.hashCode() : 0);
		return result;
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
