package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ObservationTags;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an Observation objects and a MongoDB DBObject.
 */
@Service
@Named
public class ObservationWriteConverter  implements WriteConverter<Observation, DBObject> {

    @Override
    public DBObject convert(final Observation source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(ObservationTags.ID_TAG, source.getIdentifier());
        dbo.put(ObservationTags.NAME_TAG, source.getName().getValue());
        dbo.put(ObservationTags.NAME_TYPE_TAG, source.getName().getType().getId());
        dbo.put(ObservationTags.VALUE_TAG, source.getValue().getValue());
        dbo.put(ObservationTags.VALUE_TYPE_TAG, source.getValue().getType().getId());
        dbo.put(ObservationTags.APPLIES_TAG, source.getApplies());
        dbo.put(ObservationTags.SUBJECT_TAG, source.getSubject());
        dbo.put(ObservationTags.ISSUED_TAG, source.getIssued().getEpochSecond());
        return dbo;
    }
}

