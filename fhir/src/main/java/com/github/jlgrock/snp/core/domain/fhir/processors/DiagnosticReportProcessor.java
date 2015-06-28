package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

@Service
public class DiagnosticReportProcessor extends AbstractFhirProcessor {

    @Inject
    public DiagnosticReportProcessor(final LogicGraphClassifier logicGraphClassifierIn) {
        super(logicGraphClassifierIn);
    }

	@Override
	public void process(final String identifier, final Object unmarshalledObject) {
        DiagnosticReport diagnosticReport = (DiagnosticReport) unmarshalledObject;
		throw new UnsupportedOperationException();
	}

    @Override
    public Class processesType() {
        return DiagnosticReport.class;
    }

}
