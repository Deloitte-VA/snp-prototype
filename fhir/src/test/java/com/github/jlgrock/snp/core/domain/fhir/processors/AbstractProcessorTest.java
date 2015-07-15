package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirEncounterConverter;
import com.github.jlgrock.snp.core.domain.fhir.converters.FhirPatientConverter;
import com.github.jlgrock.snp.core.domain.fhir.logicgraph.FhirCodeableConceptGraphBuilder;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import com.github.jlgrock.snp.core.domain.fhir.model.ResourceReference;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import gov.vha.isaac.logic.LogicGraph;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AbstractProcessorTest {
    // Fhir Model objects
    protected Condition condition = Mockito.mock(Condition.class);
    protected Procedure procedure = Mockito.mock(Procedure.class);
    protected Patient patient = Mockito.mock(Patient.class);
    protected ResourceReference resourceReference = Mockito.mock(ResourceReference.class);
    protected com.github.jlgrock.snp.core.domain.fhir.model.String reference = Mockito.mock(com.github.jlgrock.snp.core.domain.fhir.model.String.class);
    protected CodeableConcept codeableConcept = Mockito.mock(CodeableConcept.class);
    protected Encounter encounter = Mockito.mock(Encounter.class);
    protected Observation observation = Mockito.mock(Observation.class);

    protected Assertion assertion1 = Mockito.mock(Assertion.class);
    protected Assertion assertion2 = Mockito.mock(Assertion.class);
    protected List<Assertion> assertionList;


    // Converter classes
    protected FhirPatientConverter fhirPatientConverter = Mockito.mock(FhirPatientConverter.class);
    protected FhirEncounterConverter fhirEncounterConverter = Mockito.mock(FhirEncounterConverter.class);

    // Domain classes
    protected ClassifiedPce classifiedPce = Mockito.mock(ClassifiedPce.class);
    com.github.jlgrock.snp.domain.types.Patient patientDomain = Mockito.mock(com.github.jlgrock.snp.domain.types.Patient.class);
    com.github.jlgrock.snp.domain.types.Encounter encounterDomain = Mockito.mock(com.github.jlgrock.snp.domain.types.Encounter.class);

    // Domain Repository classes
    protected EncounterRepository encounterRepository = Mockito.mock(EncounterRepository.class);
    protected ClassifiedPceRepository classifiedPceRepository = Mockito.mock(ClassifiedPceRepository.class);
    protected PatientRepository patientRepository = Mockito.mock(PatientRepository.class);

    protected LogicGraph logicGraph = Mockito.mock(LogicGraph.class);
    protected LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);
    protected FhirCodeableConceptGraphBuilder fhirCodeableConceptGraphBuilder = Mockito.mock(FhirCodeableConceptGraphBuilder.class);

    @BeforeClass
    public void setup() {
        assertionList = new ArrayList<>();
        assertionList.add(assertion1);
        assertionList.add(assertion2);

        Mockito.when(resourceReference.getReference()).thenReturn(reference);
        Mockito.when(reference.getValue()).thenReturn("bla_100");

        Mockito.when(condition.getEncounter()).thenReturn(resourceReference);
        Mockito.when(procedure.getEncounter()).thenReturn(resourceReference);
        Mockito.when(encounter.getSubject()).thenReturn(resourceReference);
        Mockito.when(observation.getSubject()).thenReturn(resourceReference);
        Mockito.when(observation.getName()).thenReturn(codeableConcept);
        Mockito.when(observation.getBodySite()).thenReturn(codeableConcept);
        Mockito.when(observation.getValueCodeableConcept()).thenReturn(codeableConcept);

        Mockito.when(fhirCodeableConceptGraphBuilder.build(Mockito.any(CodeableConcept.class))).thenReturn(logicGraph);

        Mockito.when(fhirPatientConverter.convert(patient)).thenReturn(patientDomain);
        Mockito.when(fhirEncounterConverter.convert(encounter)).thenReturn(encounterDomain);
    }
}
