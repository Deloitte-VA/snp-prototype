package com.github.jlgrock.snp.converters;

import com.github.jlgrock.snp.data.ObservationTags;
import com.github.jlgrock.snp.domain.Observation;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A Conversion class to convert between an Observation objects and a MongoDB DBObject.
 */
@Component
public class ObservationWriteConverter  implements Converter<Observation, DBObject> {

    @Override
    public DBObject convert(Observation source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(ObservationTags.ID_TAG, source.getIdentifier());
        dbo.put(ObservationTags.NAME_TAG, source.getName().getValue());
        dbo.put(ObservationTags.NAME_TYPE_TAG, source.getName().getType().getId());
        dbo.put(ObservationTags.VALUE_TAG, source.getValue().getValue());
        dbo.put(ObservationTags.VALUE_TYPE_TAG, source.getValue().getType().getId());
        dbo.put(ObservationTags.APPLIES_TAG, source.getApplies());
        dbo.put(ObservationTags.SUBJECT_TAG, source.getSubject());
        dbo.put(ObservationTags.ISSUED_TAG, source.getIssued().getMillis());
        return dbo;
    }
}
