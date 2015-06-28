package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;

import javax.inject.Inject;
import java.util.Optional;

public class ObservationRepositoryImpl implements ObservationRepository {

    private final EncounterRepository encounterRepository;

    @Inject
    public ObservationRepositoryImpl(final EncounterRepository encounterRepositoryIn) {
        encounterRepository = encounterRepositoryIn;
    }

    @Override
    public Observation findObservationByFhirId(final String encounterFhirId, final String observationFhirId) {
        Encounter encounter = encounterRepository.findOneByFhirId(encounterFhirId);

        Optional<Observation> observationOptional = encounter.
                getObservations().
                stream().
                filter(observation -> observationFhirId.equals(observation.getFhirId())).
                findFirst();

        if (!observationOptional.isPresent()) {
            return null;
        }
        return observationOptional.get();
    }
}
