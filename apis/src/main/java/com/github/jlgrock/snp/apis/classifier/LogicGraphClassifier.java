package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Contract;

/**
 * Classify Post Coordinated Expressions
 */
@Contract
public interface LogicGraphClassifier {

    /**
     * replace Post Coordinated Expressions with a classifier ID
     *
     * @param pce Post Coordinated Expression
     * @return the unique identifier
     */
    Long classify(LogicGraph pce);
}