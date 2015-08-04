package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.Converter;
import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Assertion;

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

    private final AssertionReadConverter assertionReadConverter;
    private final PatientRepository patientRepository;

    /**
     * @param assertionReadConverterIn object of type AssertionReadConverter that has values from a MongoDB
     *                                   object stored in an Assertion object.
     * @param patientRepositoryIn repository to look up the patient.
     */
    @Inject
    public EncounterReadConverter(final AssertionReadConverter assertionReadConverterIn,
                                  final PatientRepository patientRepositoryIn) {
        assertionReadConverter = assertionReadConverterIn;
        patientRepository = patientRepositoryIn;
    }

    @Override
    public Encounter convert(final Document source) {
        Encounter encounter = new Encounter();
        encounter.setId(parseId(source));
        encounter.setEncounterClass(parseString(source, EncounterTags.ENCOUNTER_CLASS));
        encounter.setStatus(parseString(source, EncounterTags.STATUS));
        encounter.setSubject(parseString(source, EncounterTags.SUBJECT));
        encounter.setParticipant(parseString(source, EncounterTags.PARTICIPANT));
        encounter.setPatientId(parseObjectId(source, EncounterTags.PATIENT_ID));

        @SuppressWarnings("unchecked")
		List<Document> assertionsObjs = (List<Document>) source.get(EncounterTags.ASSERTIONS_TAG);
        List<Assertion> assertions = new ArrayList<>();
        if (assertionsObjs != null) {
            assertions = assertionsObjs
                    .stream()
                    .map(assertionReadConverter::convert)
                    .collect(Collectors.toList());
        }
        encounter.setAssertions(assertions);
        return encounter;
    }
}



