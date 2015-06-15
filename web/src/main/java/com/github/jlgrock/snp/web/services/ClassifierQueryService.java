package com.github.jlgrock.snp.web.services;


import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepositoryImpl;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Patient;
import gov.vha.isaac.logic.LogicGraph;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 *
 */
public class ClassifierQueryService {

    final LogicGraphClassifierQuery logicGraphClassifierQuery;

    public ClassifierQueryService(final LogicGraphClassifierQuery logicGraphClassifierQueryIn) {
        logicGraphClassifierQuery = logicGraphClassifierQueryIn;
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
        //TODO do query based on these nids
//        EncounterRepositoryImpl r = new EncounterRepositoryImpl();
//        Encounter e;
//        e.getPatient()

    }
}
