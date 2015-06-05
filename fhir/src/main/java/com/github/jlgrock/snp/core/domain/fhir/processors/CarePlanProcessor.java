package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;

import gov.vha.isaac.logic.LogicGraph;

import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

/**
 *
 */
public class CarePlanProcessor extends AbstractFhirProcessor {

    private final CarePlan carePlan;

    public CarePlanProcessor(final TerminologyStoreDI terminologyStoreDIIn, final CarePlan carePlanIn) {
        super(terminologyStoreDIIn);
        carePlan = carePlanIn;
    }

    @Override
    protected LogicGraph getLogicGraph() {
        throw new UnsupportedOperationException();
    }

	@Override
	public void process() {
		throw new UnsupportedOperationException();
		
	}

}
