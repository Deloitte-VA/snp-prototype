package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirEncounterConverter;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class EncounterProcessor extends AbstractFhirProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(EncounterProcessor.class);

    private final Encounter encounter;
    private final EncounterRepository encounterRepository;
    private final FhirEncounterConverter fhirEncounterConverter;
    private final PatientRepository patientRepository;

    public EncounterProcessor(final LogicGraphClassifier logicGraphClassifierIn,
                              final FhirEncounterConverter fhirEncounterConverterIn,
                              final EncounterRepository encounterRepositoryIn,
                              final PatientRepository patientRepositoryIn,
                              final Encounter encounterIn) {
        super(logicGraphClassifierIn);
        encounter = encounterIn;
        fhirEncounterConverter = fhirEncounterConverterIn;
        encounterRepository = encounterRepositoryIn;
        patientRepository = patientRepositoryIn;
    }

	@Override
	public void process(final String identifier) {
        LOGGER.trace("Processing Encounter {}", encounter);
        com.github.jlgrock.snp.domain.types.Encounter saveVal = fhirEncounterConverter.convert(encounter);
        // TODO see if patient exists and create it if it doesn't
        // pull out the fhirId
        //encounter.get
        // find the patient by the fhir id
        //patientRepository.findOneByFhirId();
        // save the patient if it doesn't exists
        encounterRepository.save(saveVal);

//        FhirEncounterGraphBuilder fhirEncounterGraphBuilder = new FhirEncounterGraphBuilder(getLogicGraphClassifier(), encounter);
//        LogicGraph logicGraph = fhirEncounterGraphBuilder.build();
//        return logicGraph;
	}
}
