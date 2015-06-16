package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.jvnet.hk2.annotations.Contract;

import java.util.UUID;

/**
 * Classify Post Coordinated Expressions using the classification store.
 */
@Contract
public interface LogicGraphClassifier {

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return the native identifier (for all objects)
     */
    int getNidFromSNOMED(String sctid);

    /**
     *
     * @param sctid SNOMED clinical terms identifier
     * @return the UUID
     */
    UUID getUUIDFromSNOMED(String sctid);

    /**
     * Find a chronicle based on the sctId
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    ConceptChronicleBI findChronicle(String sctid);

    /**
     * Find the native id for the indexed LogicGraph.  If one does not exist,
     * it will create one and return the native id.
     *
     * @param pce Post Coordinated Expression
     * @return the native identifier
     */
    Integer classify(LogicGraph pce);

}
