package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.domain.data.ObservationTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Observation;
import com.github.jlgrock.snp.domain.types.primitives.SimplePrimitive;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Observation object.
 */
@Service
@Named
public class ObservationReadConverter extends AbstractReadConverter implements ReadConverter<Document, Observation> {

    @Override
    public Observation convert(final Document source) {
        Observation observation = new Observation();
        observation.setIdentifier(parseString(source, SharedTags.ID_TAG));
        observation.setName(SimplePrimitive.createPrimitive(
                        parseInteger(source, ObservationTags.NAME_TYPE_TAG),
                        parseInteger(source, ObservationTags.NAME_TAG)));
        observation.setValue(SimplePrimitive.createPrimitive(
                parseInteger(source, ObservationTags.VALUE_TYPE_TAG),
                parseInteger(source, ObservationTags.VALUE_TAG)));
        observation.setApplies(parseString(source, ObservationTags.APPLIES_TAG));
        observation.setSubject(parseString(source, ObservationTags.SUBJECT_TAG));
        observation.setIssued(parseInstant(source, ObservationTags.ISSUED_TAG));
        return observation;
    }
}

