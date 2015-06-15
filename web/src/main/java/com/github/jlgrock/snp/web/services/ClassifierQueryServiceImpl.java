package com.github.jlgrock.snp.web.services;


import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;
import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class ClassifierQueryServiceImpl implements ClassifierQueryServiceImpl {

    private final LogicGraphClassifierQuery logicGraphClassifierQuery;
    private final EncounterRepository encounterRepository;

    public ClassifierQueryServiceImpl(final LogicGraphClassifierQuery logicGraphClassifierQueryIn, final EncounterRepository encounterRepositoryIn) {
        logicGraphClassifierQuery = logicGraphClassifierQueryIn;
        encounterRepository = encounterRepositoryIn;
    }

    public Set<Patient> executeKindOfQuery(final UUID uuid) {
        List<Integer> results = logicGraphClassifierQuery.query(uuid);
        return findPatientsByNids(results);
    }

    public Set<Patient> executeKindOfQuery(final String sctid) {
        List<Integer> results = logicGraphClassifierQuery.query(sctid);
        return findPatientsByNids(results);
    }

    public Set<Patient> executeKindOfQuery(final LogicGraph logicGraph) {
        List<Integer> results = logicGraphClassifierQuery.query(logicGraph);
        return findPatientsByNids(results);
    }

    private Set<Patient> findPatientsByNids(final List<Integer> nids) {
        // Convert the int list to a long list
        List<Long> longNids = nids
                .stream()
                .map(a -> 1l)
                .collect(Collectors.toList());

        // execute the custom query
        return encounterRepository.
                findByPceIdList(longNids)
                .stream()
                .map(Encounter::getPatient)
                .distinct()
                .collect(Collectors.toSet());
    }
}
