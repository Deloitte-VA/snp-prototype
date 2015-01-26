package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.EncounterTags;
import com.deloitte.mongo.data.PatientRepository;
import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Encounter object.
 */
@Component
public class EncounterReadConverter implements Converter<DBObject, Encounter> {

    @Autowired
    ObservationReadConverter observationReadConverter;

    @Autowired
    PatientRepository patientRepository;

    EncounterReadConverter(ObservationReadConverter observationReadConverterIn, PatientRepository patientRepositoryIn) {
        observationReadConverter = observationReadConverterIn;
        patientRepository = patientRepositoryIn;
    }
    @Override
    public Encounter convert(DBObject source) {
        Encounter encounter = new Encounter();
        encounter.setId(((Long) source.get(EncounterTags.ID_TAG)));
        encounter.setPatient(patientRepository.findOne(((Number) source.get(EncounterTags.PATIENT_TAG)).longValue()));
        encounter.setDate((Date) source.get(EncounterTags.DATE_TAG));
        encounter.setType(((Number) source.get(EncounterTags.TYPE_TAG)).intValue());
        encounter.setReasonForVisit((String) source.get(EncounterTags.REASON_FOR_VISIT_TAG));

        List<DBObject> observationsObjs = (List<DBObject>) source.get(EncounterTags.OBSERVATIONS_TAG);
        List<Observation> observations = new ArrayList<>();
        if (observationsObjs != null) {
            observations = observationsObjs.stream().map(observationObj->observationReadConverter.convert(observationObj)).collect(Collectors.toList());
        }
        encounter.setObservations(observations);
        return encounter;
    }
}
