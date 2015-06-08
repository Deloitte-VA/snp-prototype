package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.logic.LogicGraph;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;
import org.jvnet.hk2.annotations.Contract;

/**
 * Classify Post Coordinated Expressions
 */
@Contract
public interface LogicGraphClassifier {

    /**
     * Get the native identifier
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    int getNidFromSNOMED(String sctid);

    /**
     * TODO
     * @param sctid SNOMED clinical terms identifier
     * @return native identifier
     */
    ConceptChronicleBI findChronicle(String sctid);

    /**
     * replace Post Coordinated Expressions with a classifier ID
     *
     * @param pce Post Coordinated Expression
     * @return the unique identifier
     */
    Integer classify(LogicGraph pce);
}