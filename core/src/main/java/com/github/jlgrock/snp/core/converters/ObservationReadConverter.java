package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ObservationTags;
import com.github.jlgrock.snp.core.domain.Observation;
import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
import com.mongodb.DBObject;

import javax.inject.Named;
import java.time.Instant;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Observation object.
 */
@Named
public class ObservationReadConverter implements ReadConverter<DBObject, Observation> {

    @Override
    public Observation convert(final DBObject source) {
        Observation observation = new Observation();
        observation.setIdentifier((String) source.get(ObservationTags.ID_TAG));
        observation.setName(SimplePrimitive.createPrimitive(
                ((Number) source.get(ObservationTags.NAME_TYPE_TAG)).intValue(),
                source.get(ObservationTags.NAME_TAG)));
        observation.setValue(SimplePrimitive.createPrimitive(
                ((Number) source.get(ObservationTags.VALUE_TYPE_TAG)).intValue(),
                source.get(ObservationTags.VALUE_TAG)));
        observation.setApplies((String) source.get(ObservationTags.APPLIES_TAG));
        observation.setSubject((String) source.get(ObservationTags.SUBJECT_TAG));
        observation.setIssued(Instant.ofEpochMilli(((Number) source.get(ObservationTags.ISSUED_TAG)).longValue()));
        return observation;
    }
}

