package com.github.jlgrock.snp.apis.classifier;

import gov.vha.isaac.logic.LogicGraph;
import org.jvnet.hk2.annotations.Contract;

import java.util.UUID;

/**
 * Query utilities for searching the index for a particular classified
 * Logic Graph.
 */
@Contract
public interface LogicGraphClassifierQuery {

    /**
     * Query that will return all concept sequences that match the kind of
     * the concept with the uuid passed in
     *
     * @param nid the native identifier for the database
     * @return the list of matching Concept Sequences
     */
    int[] query(int nid);

    /**
     * Query that will return all concept sequences that match the kind of
     * the concept with the uuid passed in
     *
     * @param uuid the unique identifier for the database
     * @return the list of matching Concept Sequences
     */
    int[] query(UUID uuid);

    /**
     * Query that will return all concept sequences that match the kind of
     * the concept with the snomed identifier passed in
     *
     * @param sctid the snomed identifier
     * @return the list of matching Concept Sequences
     */
    int[] query(final String sctid);

    /**
     * Query that will return all concept sequences that match the kind of
     * the concept identified by the logic graph provided
     *
     * @param logicGraph the logic graph to classify, then search.
     * @return the list of matching Concept Sequences
     */
    int[] query(final LogicGraph logicGraph);
}
