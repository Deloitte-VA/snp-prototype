package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.Converter;
import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Encounter object.
 */
@Service
@Named
public class EncounterReadConverter extends AbstractReadConverter implements Converter<Document, Encounter> {

    private final ObservationReadConverter observationReadConverter;
    private final PatientRepository patientRepository;

    /**
     * @param observationReadConverterIn object of type ObservationReadConverter that has values from a MongoDB
     *                                   object stored in an Observation object.
     */
    @Inject
    public EncounterReadConverter(final ObservationReadConverter observationReadConverterIn,
                                  final PatientRepository patientRepositoryIn) {
        observationReadConverter = observationReadConverterIn;
        patientRepository = patientRepositoryIn;
    }

    @Override
    public Encounter convert(final Document source) {
        Encounter encounter = new Encounter();
        encounter.setId(parseId(source));
        encounter.setFhirId(parseString(source, EncounterTags.FHIR_ID));
        encounter.setEncounterClass(parseString(source, EncounterTags.ENCOUNTER_CLASS));
        encounter.setStatus(parseString(source, EncounterTags.STATUS));
        encounter.setSubject(parseString(source, EncounterTags.SUBJECT));
        encounter.setParticipant(parseString(source, EncounterTags.PARTICIPANT));
        encounter.setPatient(patientRepository.findOneById(parseLong(source, EncounterTags.PATIENT)));

        List<Document> observationsObjs = (List<Document>) source.get(EncounterTags.OBSERVATIONS_TAG);
        List<Observation> observations = new ArrayList<>();
        if (observationsObjs != null) {
            observations = observationsObjs
                    .stream()
                    .map(observationReadConverter::convert)
                    .collect(Collectors.toList());
        }
        encounter.setObservations(observations);
        return encounter;
    }
}



