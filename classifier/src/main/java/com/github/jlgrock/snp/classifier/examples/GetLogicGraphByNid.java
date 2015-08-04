package com.github.jlgrock.snp.classifier.examples;

import gov.vha.isaac.metadata.coordinates.LogicCoordinates;
import gov.vha.isaac.metadata.coordinates.StampCoordinates;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.chronicle.LatestVersion;
import gov.vha.isaac.ochre.api.coordinate.LogicCoordinate;
import gov.vha.isaac.ochre.api.coordinate.StampCoordinate;
import gov.vha.isaac.ochre.api.logic.LogicService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Optional;

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

		LogicCoordinate logicCoordinate = LogicCoordinates.getStandardElProfile();
		StampCoordinate stampCoordinate = StampCoordinates.getDevelopmentLatest();

		int nid = -2147481445;

		// Print the results
		Optional<LatestVersion<? extends LogicalExpression>> lg1 = logicService.getLogicalExpression(nid, logicCoordinate.getStatedAssemblageSequence(), stampCoordinate);
		LOGGER.info("Stated logic graph:  {}", lg1);

		Optional<LatestVersion<? extends LogicalExpression>> lg2 = logicService.getLogicalExpression(nid, logicCoordinate.getInferredAssemblageSequence(), stampCoordinate);
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
