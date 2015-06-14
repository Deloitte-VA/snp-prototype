package com.github.jlgrock.snp.core.domain.fhir.converters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.jlgrock.snp.domain.types.Encounter;

public class EncounterWriteConverterImpl implements EncounterWriteConverter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EncounterWriteConverterImpl.class);

	@Override
	public Encounter convert(
			com.github.jlgrock.snp.core.domain.fhir.model.Encounter source) {
		com.github.jlgrock.snp.domain.types.Encounter encounterOut = new com.github.jlgrock.snp.domain.types.Encounter();
		
		LOGGER.trace("source={}", source);
		
		encounterOut.setFhirId(source.getSubject().getReference().getValue().replaceFirst("Patient/", ""));
		encounterOut.setSubject(source.getSubject().getReference().getValue());
		encounterOut.setPatientClass(source.getClazz().getValue().name());
		encounterOut.setStatus(source.getStatus().getValue().name());
		encounterOut.setParticipant(source.getParticipant().get(0).getIndividual().getReference().getValue());
		return encounterOut;
	}

}
