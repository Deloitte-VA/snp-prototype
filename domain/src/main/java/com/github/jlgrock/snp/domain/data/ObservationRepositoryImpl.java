package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;

import javax.inject.Inject;
import java.util.Optional;

/**
 * This class executes queries against the Encounter
 * Collection (and the Observation subobject) within MongoDB.
 */
public class ObservationRepositoryImpl implements ObservationRepository {

    private final EncounterRepository encounterRepository;

    /**
     * @param encounterRepositoryIn the encounter Repository, as it is a union of the observation and encounter
     */
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
