package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Encounter object.
 */
@Service
@Named
public class EncounterReadConverter implements Converter<DBObject, Encounter> {

    private final ObservationReadConverter observationReadConverter;

    /**
     * @param observationReadConverterIn object of type ObservationReadConverter that has values from a MongoDB
     *                                   object stored in an Observation object.
     */
    @Inject
    public EncounterReadConverter(final ObservationReadConverter observationReadConverterIn) {
        observationReadConverter = observationReadConverterIn;
    }

    @Override
    public Encounter convert(final DBObject source) {
        Encounter encounter = new Encounter();
        encounter.setId(((Number) source.get(EncounterTags.ID_TAG)).longValue());
        encounter.setPatientId(((Number) source.get(EncounterTags.PATIENT_TAG)).longValue());
        encounter.setDate(LocalDate.ofEpochDay(((Number) source.get(EncounterTags.DATE_TAG)).longValue()));
        encounter.setType(((Number) source.get(EncounterTags.TYPE_TAG)).intValue());
        encounter.setReasonForVisit((String) source.get(EncounterTags.REASON_FOR_VISIT_TAG));

        List<DBObject> observationsObjs = (List<DBObject>) source.get(EncounterTags.OBSERVATIONS_TAG);
        List<Observation> observations = new ArrayList<>();
        if (observationsObjs != null) {
            observations = observationsObjs.stream().map(
                    observationObj->observationReadConverter.convert(observationObj)).collect(Collectors.toList());
        }
        encounter.setObservations(observations);
        return encounter;
    }
}



