package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Assertion;

import javax.inject.Inject;
import java.util.Optional;

/**
 * This class executes queries against the Encounter
 * Collection (and the Assertion subobject) within MongoDB.
 */
public class AssertionRepositoryImpl implements AssertionRepository {

    private final EncounterRepository encounterRepository;

    /**
     * @param encounterRepositoryIn the encounter Repository, as it is a union of the assertion and encounter
     */
    @Inject
    public AssertionRepositoryImpl(final EncounterRepository encounterRepositoryIn) {
        encounterRepository = encounterRepositoryIn;
    }

    @Override
    public Assertion findAssertionByFhirId(final String encounterFhirId, final String assertionFhirId) {
        Encounter encounter = encounterRepository.findOneByFhirId(encounterFhirId);

        Optional<Assertion> assertionOptional = encounter.
                getAssertions().
                stream().
                filter(assertion -> assertionFhirId.equals(assertion.getFhirId())).
                findFirst();

        if (!assertionOptional.isPresent()) {
            return null;
        }
        return assertionOptional.get();
    }
}
