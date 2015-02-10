package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Conversion class to convert between an Encounter objects and a MongoDB DBObject.
 */
@Component
public class EncounterWriteConverter implements Converter<Encounter, DBObject> {

    private final ObservationWriteConverter observationWriteConverter;

    @Autowired
    EncounterWriteConverter(ObservationWriteConverter observationWriteConverterIn) {
        observationWriteConverter = observationWriteConverterIn;
    }

    @Override
    public DBObject convert(Encounter source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(EncounterTags.ID_TAG, source.getId());
        dbo.put(EncounterTags.PATIENT_TAG, source.getPatient().getId());
        dbo.put(EncounterTags.DATE_TAG, source.getDate().getMillis());
        dbo.put(EncounterTags.TYPE_TAG, source.getType());
        dbo.put(EncounterTags.REASON_FOR_VISIT_TAG, source.getReasonForVisit());

        List<Observation> observations = source.getObservations();
        BasicDBList observationObjs = new BasicDBList();
        if (observations != null) {
            Stream<Observation> s1 = observations.stream();
            Stream<DBObject> s2 = s1.map(observation -> observationWriteConverter.convert(observation));
            observationObjs = s2.collect(Collectors.toCollection(BasicDBList::new));
        }

        dbo.put(EncounterTags.OBSERVATIONS_TAG, observationObjs);
        return dbo;
    }
}
