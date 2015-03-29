package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.core.data.ObservationTags;
import com.github.jlgrock.snp.core.domain.Observation;
import com.github.jlgrock.snp.core.domain.primitives.SimplePrimitive;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Observation object.
 */
@Service
@Named
public class ObservationReadConverter extends AbstractReadConverter implements ReadConverter<DBObject, Observation> {

    @Override
    public Observation convert(final DBObject source) {
        Observation observation = new Observation();
        observation.setIdentifier(parseString(source, ObservationTags.ID_TAG));
        observation.setName(SimplePrimitive.createPrimitive(
                ((Number) source.get(ObservationTags.NAME_TYPE_TAG)).intValue(),
                source.get(ObservationTags.NAME_TAG)));
        observation.setValue(SimplePrimitive.createPrimitive(
                ((Number) source.get(ObservationTags.VALUE_TYPE_TAG)).intValue(),
                source.get(ObservationTags.VALUE_TAG)));
        observation.setApplies(parseString(source, ObservationTags.APPLIES_TAG));
        observation.setSubject(parseString(source, ObservationTags.SUBJECT_TAG));
        observation.setIssued(parseInstant(source, ObservationTags.ISSUED_TAG));
        return observation;
    }
}

