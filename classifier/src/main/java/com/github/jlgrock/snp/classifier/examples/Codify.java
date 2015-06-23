package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.EditCoordinates;
import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * How to assign a unique identifier to a logic graph.  In the first instance of getting the concept sequence,
 * it is not found and will generate an id.  In the second occurance, it is and will return the same id.
 */
public class Codify extends AbstractQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateLogicExpression.class);

    @Override
    protected void run() throws IOException {
        //TaxonomyService taxonomy = LookupService.getService(TaxonomyService.class);
        LogicService logicService = LookupService.getService(LogicService.class);
        //TerminologyStoreDI termStore = LookupService.getService(TerminologyStoreDI.class);

        // get the logic graph for "bleeding of abdominal wall"
        LogicGraph abdominalWallBleedingDef = new CreateLogicExpression().execute();

        /*
         * Classification consists of converting the logic graph to axioms in memory, running the classification
         * algorithms over the axioms, retrieving the results, determining what changed, and then write back to the
         * logic graph assemblage.  Running a full classification will take several minutes.
         */
        logicService.fullClassification(
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());

        // get the code for "bleeding of abdominal wall".  If it does not exist, it will be created
        int newSequence = logicService.getConceptSequenceForExpression(abdominalWallBleedingDef,
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());
        LOGGER.info("sequence number: {}", newSequence);

        //Create a set out of the sequence number(s)
        ConceptSequenceSet newConcepts = ConceptSequenceSet.of(newSequence);
        LOGGER.info("new concepts: {}", newConcepts);


        // verify that the sequence comes out the same
        int newSequence2 = logicService.getConceptSequenceForExpression(abdominalWallBleedingDef,
                StampCoordinates.getDevelopmentLatest(),
                LogicCoordinates.getStandardElProfile(),
                EditCoordinates.getDefaultUserSolorOverlay());
        LOGGER.info("same sequence number: {}", newSequence2);

    }

    /**
     * Execute the Example
     *
     * @param args ignored
     */
    public static void main(final String[] args) {
        Codify codify = new Codify();
        codify.execute();
    }
}
