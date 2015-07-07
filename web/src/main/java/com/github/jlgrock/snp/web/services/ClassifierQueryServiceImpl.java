package com.github.jlgrock.snp.web.services;


import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;

import gov.vha.isaac.logic.LogicGraph;

import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.inject.Inject;

/**
 * A Classifier service to be called when querying into the database
 */
@Contract
@Service
public class ClassifierQueryServiceImpl {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ClassifierQueryServiceImpl.class);

    private final LogicGraphClassifierQuery logicGraphClassifierQuery;
    private final EncounterRepository encounterRepository;
    private final PatientRepository patientRepository;

    /**
     * @param logicGraphClassifierQueryIn to classify logic graphs
     * @param encounterRepositoryIn the encounter repository, for executing encounter queries against
     * @param patientRepositoryIn the patient repository, for executing patient queries against
     */
    @Inject
    public ClassifierQueryServiceImpl(final LogicGraphClassifierQuery logicGraphClassifierQueryIn,
                                      final EncounterRepository encounterRepositoryIn,
                                      final PatientRepository patientRepositoryIn) {
        logicGraphClassifierQuery = logicGraphClassifierQueryIn;
        encounterRepository = encounterRepositoryIn;
        patientRepository = patientRepositoryIn;
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param uuid the uuid to identify the object passed in
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final UUID uuid) {
        int[] results = logicGraphClassifierQuery.query(uuid);
        return findPatientsByNids(convertToList(results));
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param sctid the snomed concept identifier to identify the object passed in
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final String sctid) {
        int[] results = logicGraphClassifierQuery.query(sctid);
        return findPatientsByNids(convertToList(results));
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param logicGraph the full logic graph to identify the object passed in
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final LogicGraph logicGraph) {
        int[] results = logicGraphClassifierQuery.query(logicGraph);

        return findPatientsByNids(convertToList(results));
    }

    /**
     * Execute a query to find objects that are a kind of the object passed in
     *
     * @param nid the native identifier to identify the object to find kinds of
     * @return the result
     */
    public Set<Patient> executeKindOfQuery(final int nid) {
    	LOGGER.trace("executeKindOfQuery(nid={})", nid);
        int[] results = logicGraphClassifierQuery.query(nid);
        return findPatientsByNids(convertToList(results));
    }

    private List<Integer> convertToList(final int[] ints) {
        return IntStream.of(ints)
                .boxed()
                .collect(Collectors.toList());
    }

    private Set<Patient> findPatientsByNids(final List<Integer> nids) {
    	LOGGER.trace("findPatientsByNids(nids={})", nids);
	
        // execute the custom query
        return encounterRepository.
                findByPceIdList(nids)
                .stream()
                .map(Encounter::getPatientId)
                .distinct()
                .map(patientId -> patientRepository.findOneById(patientId))
                .collect(Collectors.toSet());
    }
}
