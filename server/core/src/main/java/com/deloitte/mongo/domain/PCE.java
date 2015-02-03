package com.deloitte.mongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by jlgrock on 1/11/15.
 */
@Document(collection = "pces")
public class PCE {
    @Id
    private Long id;

    private String desc;

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PCE pce = (PCE) o;

        if (desc != null ? !desc.equals(pce.desc) : pce.desc != null) return false;
        if (id != null ? !id.equals(pce.id) : pce.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PCE{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(final String desc) {
        this.desc = desc;
    }
}
