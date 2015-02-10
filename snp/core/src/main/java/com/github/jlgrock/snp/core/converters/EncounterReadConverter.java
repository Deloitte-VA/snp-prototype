package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.github.jlgrock.snp.core.data.PatientRepository;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Encounter object.
 */
@Component
public class EncounterReadConverter implements Converter<DBObject, Encounter> {

    private final ObservationReadConverter observationReadConverter;

    private final PatientRepository patientRepository;

    @Autowired
    EncounterReadConverter(ObservationReadConverter observationReadConverterIn, PatientRepository patientRepositoryIn) {
        observationReadConverter = observationReadConverterIn;
        patientRepository = patientRepositoryIn;
    }

    @Override
    public Encounter convert(DBObject source) {
        Encounter encounter = new Encounter();
        encounter.setId(((Long) source.get(EncounterTags.ID_TAG)));
        encounter.setPatient(patientRepository.findOne(((Number) source.get(EncounterTags.PATIENT_TAG)).longValue()));
        encounter.setDate(new DateTime((Long) source.get(EncounterTags.DATE_TAG)));
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
