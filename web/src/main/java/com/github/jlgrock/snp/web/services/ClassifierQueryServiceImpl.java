package com.github.jlgrock.snp.web.services;


import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;
import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * A Classifier service to be called when querying into the database
 */
@Contract
@Service
public class ClassifierQueryServiceImpl {

    private final LogicGraphClassifierQuery logicGraphClassifierQuery;
    private final EncounterRepository encounterRepository;

    /**
     * @param logicGraphClassifierQueryIn to classify logic graphs
     * @param encounterRepositoryIn the encounter repository, for executing queries against
     */
    public ClassifierQueryServiceImpl(final LogicGraphClassifierQuery logicGraphClassifierQueryIn, final EncounterRepository encounterRepositoryIn) {
        logicGraphClassifierQuery = logicGraphClassifierQueryIn;
        encounterRepository = encounterRepositoryIn;
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param uuid the uuid to identify the object passed in
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final UUID uuid) {
        List<Integer> results = logicGraphClassifierQuery.query(uuid);
        return findPatientsByNids(results);
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param sctid the snomed concept identifier to identify the object passed in
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final String sctid) {
        List<Integer> results = logicGraphClassifierQuery.query(sctid);
        return findPatientsByNids(results);
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param logicGraph the full logic graph to identify the object passed in
     * @return the result
     */
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
