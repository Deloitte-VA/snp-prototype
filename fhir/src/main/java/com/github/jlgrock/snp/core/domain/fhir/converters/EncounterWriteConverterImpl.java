package com.github.jlgrock.snp.core.domain.fhir.converters;

import com.github.jlgrock.snp.domain.types.Encounter;

public class EncounterWriteConverterImpl implements EncounterWriteConverter {

	@Override
	public Encounter convert(
			com.github.jlgrock.snp.core.domain.fhir.model.Encounter source) {
		com.github.jlgrock.snp.domain.types.Encounter encounterOut = new com.github.jlgrock.snp.domain.types.Encounter();
		
		encounterOut.setSubject(source.getSubject().getReference().getValue());
		encounterOut.setClazz(source.getClazz().getValue().name());
		encounterOut.setStatus(source.getStatus().getValue().name());
		encounterOut.setParticipant(source.getParticipant().get(0).getIndividual().getReference().getValue());
		return encounterOut;
	}

}
