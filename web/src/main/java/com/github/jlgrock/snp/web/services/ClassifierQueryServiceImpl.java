package com.github.jlgrock.snp.web.services;

import com.github.jlgrock.snp.apis.classifier.ClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import org.jvnet.hk2.annotations.Contract;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A Classifier service to be called when querying into the database
 */
@Contract
@Service
public class ClassifierQueryServiceImpl {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ClassifierQueryServiceImpl.class);

	private final ClassifierQuery classifierQuery;
	private final EncounterRepository encounterRepository;
	private final PatientRepository patientRepository;

    /**
     * @param classifierQueryIn to classify logic graphs
     * @param encounterRepositoryIn the encounter repository, for executing encounter queries against
     * @param patientRepositoryIn the patient repository, for executing patient queries against
     */
    @Inject
    public ClassifierQueryServiceImpl(final ClassifierQuery classifierQueryIn,
                                      final EncounterRepository encounterRepositoryIn,
                                      final PatientRepository patientRepositoryIn) {
        classifierQuery = classifierQueryIn;
        encounterRepository = encounterRepositoryIn;
        patientRepository = patientRepositoryIn;
    }

	/**
	 * Execute a query to find objects that are a kind of the object passed in
	 *
	 * @param uuid
	 *            the uuid to identify the object passed in
	 * @return the result
	 */
	public Set<Patient> executeKindOfQuery(final UUID uuid) {
		int[] results = classifierQuery.query(uuid);
		return findPatientsByNids(convertToList(results));
	}

	/**
	 * Execute a query to find objects that are a kind of the object passed in
	 *
	 * @param sctid
	 *            the snomed concept identifier to identify the object passed in
	 * @return the result
	 */
	public Set<Patient> executeKindOfQuery(final String sctid) {
		int[] results = classifierQuery.query(sctid);
		return findPatientsByNids(convertToList(results));
	}

	/**
	 * Execute a query to find objects that are a kind of the object passed in
	 *
	 * @param logicalExpression
	 *            the full logic graph to identify the object passed in
	 * @return the result
	 */
	public Set<Patient> executeKindOfQuery(final LogicalExpression logicalExpression) {
		int[] results = classifierQuery.query(logicalExpression);

		return findPatientsByNids(convertToList(results));
	}

	/**
	 * Execute a query to find objects that are a kind of the object passed in
	 *
	 * @param nid
	 *            the native identifier to identify the object to find kinds of
	 * @return the result
	 */
	public Set<Patient> executeKindOfQuery(final int nid) {
		LOGGER.trace("executeKindOfQuery(nid={})", nid);
		int[] results = classifierQuery.query(nid);
		return findPatientsByNids(convertToList(results));
	}

	/**
	 * Execute a query to find objects that are a kind of the object passed in
	 * 
	 * @param observableNid native identifier for an observable object
	 * @param provenanceNid native identifier for a provenance object
	 * @param valueNid native identifier for a value object
	 * @return set of patients
	 */
	public Set<Patient> executeKindOfQuery(final Integer observableNid,
			final Integer provenanceNid, final Integer valueNid) {
		LOGGER.trace(
				"executeKindOfQuery(observableNid={}, provenanceNid={}, valueNid={})",
				observableNid, provenanceNid, valueNid);
        int[] obsResults = {};
        if (observableNid != null) {
            obsResults = classifierQuery.query(observableNid);
        }
		int[] provResults = {};
        if (provenanceNid != null) {
            provResults = classifierQuery.query(provenanceNid);
        }
		int[] valueResults = {};
        if (valueNid != null) {
            valueResults = classifierQuery.query(valueNid);
        }
		return findPatientsByNids(convertToList(obsResults),
				convertToList(provResults), convertToList(valueResults));
	}

	private List<Integer> convertToList(final int[] arr) {
        if (arr.length == 0) {
            return null;
        }
		return IntStream.of(arr).boxed().collect(Collectors.toList());
	}

	private Set<Patient> findPatientsByNids(final List<Integer> nids) {
		LOGGER.trace("findPatientsByNids(nids={})", nids);

		// execute the custom query
		return encounterRepository.findByPceIdList(nids).stream()
				.map(Encounter::getPatientId).distinct()
				.map(patientId -> patientRepository.findOneById(patientId))
				.collect(Collectors.toSet());
	}

	private Set<Patient> findPatientsByNids(final List<Integer> observableNids,
			final List<Integer> provenanceNids, final List<Integer> valueNids) {
		LOGGER.trace(
				"findPatientsByNids(observableNids={}, provenanceNids={}, valueNids={})",
				observableNids, provenanceNids, valueNids);

		// execute the custom query
		return encounterRepository
				.findByObservableIdListAndProvenanceIdListAndValueIdList(
						observableNids, provenanceNids, valueNids).stream()
				.map(Encounter::getPatientId).distinct()
				.map(patientId -> patientRepository.findOneById(patientId))
				.collect(Collectors.toSet());
	}
}
