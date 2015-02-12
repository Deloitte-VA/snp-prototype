package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ObservationTags;
import com.github.jlgrock.snp.core.domain.Observation;
import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Observation object.
 */
@Component
public class ObservationReadConverter implements Converter<DBObject, Observation> {

    @Override
    public Observation convert(final DBObject source) {
        Observation observation = new Observation();
        observation.setIdentifier((String) source.get(ObservationTags.ID_TAG));
        observation.setName(SimplePrimitive.createPrimitive((Integer) source.get(ObservationTags.NAME_TYPE_TAG), source.get(ObservationTags.NAME_TAG)));
        observation.setValue(SimplePrimitive.createPrimitive((Integer) source.get(ObservationTags.VALUE_TYPE_TAG), source.get(ObservationTags.VALUE_TAG)));
        observation.setApplies((String) source.get(ObservationTags.APPLIES_TAG));
        observation.setSubject((String) source.get(ObservationTags.SUBJECT_TAG));
        observation.setIssued(new DateTime(((Number) source.get(ObservationTags.ISSUED_TAG)).longValue()));
        return observation;
    }
}

