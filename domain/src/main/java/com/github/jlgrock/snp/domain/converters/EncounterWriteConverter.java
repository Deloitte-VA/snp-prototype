package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Conversion class to convert between an Encounter objects and a MongoDB DBObject.
 */
@Service
@Named
public class EncounterWriteConverter implements WriteConverter<Encounter, DBObject> {

    private final ObservationWriteConverter observationWriteConverter;
    /**
     * 
     * @param observationWriteConverterIn object of type ObservationWriteConverter that has values from
     *                                    an Observation object stored in a MongoDB object.
     */
    @Inject
    public EncounterWriteConverter(final ObservationWriteConverter observationWriteConverterIn) {
        observationWriteConverter = observationWriteConverterIn;
    }

    @Override
    public DBObject convert(final Encounter source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(EncounterTags.ID_TAG, source.getId());
        dbo.put(EncounterTags.PATIENT_TAG, source.getPatientId());
        if (source.getDate() == null) {
            dbo.put(EncounterTags.DATE_TAG, null);
        } else {
            dbo.put(EncounterTags.DATE_TAG, source.getDate().toEpochDay());
        }
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

