package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.EncounterTags;
import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
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
 *
 */
@Component
public class EncounterWriteConverter implements Converter<Encounter, DBObject> {

    @Autowired
    ObservationWriteConverter observationWriteConverter;

    EncounterWriteConverter(ObservationWriteConverter observationWriteConverterIn) {
        observationWriteConverter = observationWriteConverterIn;
    }

    @Override
    public DBObject convert(Encounter source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(EncounterTags.ID_TAG, source.getId());
        dbo.put(EncounterTags.PATIENT_TAG, source.getPatient().getId());
        dbo.put(EncounterTags.DATE_TAG, source.getDate());
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
