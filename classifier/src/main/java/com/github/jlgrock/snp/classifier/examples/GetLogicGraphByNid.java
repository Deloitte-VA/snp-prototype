package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.LogicService;
import gov.vha.isaac.metadata.coordinates.ViewCoordinates;
import gov.vha.isaac.ochre.api.LookupService;

import java.io.IOException;

import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.ihtsdo.otf.tcc.model.cc.concept.ConceptVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gets a logic graph by a native id.
 */
public class GetLogicGraphByNid extends AbstractQuery {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(GetLogicGraphByNid.class);

	@Override
	protected void run() throws IOException {
		TerminologyStoreDI termStore = LookupService
				.getService(TerminologyStoreDI.class);
		LogicService logicService = LookupService
				.getService(LogicService.class);

		TerminologySnapshotDI statedTermSnapshot = termStore
				.getSnapshot(ViewCoordinates.getDevelopmentStatedLatest());
		TerminologySnapshotDI inferredTermSnapshot = termStore
				.getSnapshot(ViewCoordinates.getDevelopmentInferredLatest());

		// Print the results
		LogicGraph lg1 = logicService
				.createLogicGraph((ConceptVersion) statedTermSnapshot
						.getConceptVersion(-2147481445));
		LOGGER.info("Stated logic graph:  {}", lg1);
		LogicGraph lg2 = logicService
				.createLogicGraph((ConceptVersion) inferredTermSnapshot
						.getConceptVersion(-2147481445));
		LOGGER.info("Inferred logic graph: {}", lg2);
	}

	/**
	 * Execute the Example
	 *
	 * @param args
	 *            ignored
	 */
	public static void main(final String[] args) {
		GetLogicGraphByNid searchByNid = new GetLogicGraphByNid();
		searchByNid.execute();
	}

}
