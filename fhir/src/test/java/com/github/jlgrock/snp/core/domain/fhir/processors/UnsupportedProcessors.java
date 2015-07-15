package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.AdverseReaction;
import com.github.jlgrock.snp.core.domain.fhir.model.Alert;
import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;
import com.github.jlgrock.snp.core.domain.fhir.model.Composition;
import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;
import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;
import com.github.jlgrock.snp.core.domain.fhir.model.DocumentManifest;
import com.github.jlgrock.snp.core.domain.fhir.model.FamilyHistory;
import com.github.jlgrock.snp.core.domain.fhir.model.Group;
import com.github.jlgrock.snp.core.domain.fhir.model.ImagingStudy;
import com.github.jlgrock.snp.core.domain.fhir.model.Immunization;
import com.github.jlgrock.snp.core.domain.fhir.model.ImmunizationRecommendation;
import com.github.jlgrock.snp.core.domain.fhir.model.List;
import com.github.jlgrock.snp.core.domain.fhir.model.Location;
import com.github.jlgrock.snp.core.domain.fhir.model.Media;
import com.github.jlgrock.snp.core.domain.fhir.model.Medication;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationAdministration;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationDispense;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationPrescription;
import com.github.jlgrock.snp.core.domain.fhir.model.MedicationStatement;
import com.github.jlgrock.snp.core.domain.fhir.model.MessageHeader;
import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;
import com.github.jlgrock.snp.core.domain.fhir.model.Order;
import com.github.jlgrock.snp.core.domain.fhir.model.OrderResponse;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;
import com.github.jlgrock.snp.core.domain.fhir.model.Other;
import com.github.jlgrock.snp.core.domain.fhir.model.Provenance;
import com.github.jlgrock.snp.core.domain.fhir.model.Query;
import com.github.jlgrock.snp.core.domain.fhir.model.Questionnaire;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;
import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;
import com.github.jlgrock.snp.core.domain.fhir.model.Substance;
import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 *
 */
public class UnsupportedProcessors {
    protected LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAdverseReaction() {
        AdverseReaction adverseReaction = Mockito.mock(AdverseReaction.class);
        FhirElementProcessorService fhirElementProcessorService =
                new AdverseReactionProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", adverseReaction);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAlert() {
        Alert alert = Mockito.mock(Alert.class);
        FhirElementProcessorService fhirElementProcessorService =
                new AlertProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", alert);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testAllergyIntolerance() {
        AllergyIntolerance allergyIntolerance = Mockito.mock(AllergyIntolerance.class);
        FhirElementProcessorService fhirElementProcessorService =
                new AllergyIntoleranceProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", allergyIntolerance);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testBinary() {
        Binary binary = Mockito.mock(Binary.class);
        FhirElementProcessorService fhirElementProcessorService =
                new BinaryProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", binary);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testCarePlan() {
        CarePlan carePlan = Mockito.mock(CarePlan.class);
        FhirElementProcessorService fhirElementProcessorService =
                new CarePlanProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", carePlan);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testComposition() {
        Composition composition = Mockito.mock(Composition.class);
        FhirElementProcessorService fhirElementProcessorService =
                new CompositionProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", composition);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testConceptMap() {
        ConceptMap conceptMap = Mockito.mock(ConceptMap.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ConceptMapProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", conceptMap);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testDeviceObservationReport() {
        DeviceObservationReport deviceObservationReport = Mockito.mock(DeviceObservationReport.class);
        FhirElementProcessorService fhirElementProcessorService =
                new DeviceObservationReportProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", deviceObservationReport);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testDevice() {
        DeviceObservationReport deviceObservationReport = Mockito.mock(DeviceObservationReport.class);
        FhirElementProcessorService fhirElementProcessorService =
                new DeviceObservationReportProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", deviceObservationReport);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testDiagnosticOrder() {
        DiagnosticOrder diagnosticOrder = Mockito.mock(DiagnosticOrder.class);
        FhirElementProcessorService fhirElementProcessorService =
                new DiagnosticOrderProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", diagnosticOrder);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testDiagnosticReport() {
        DiagnosticReport diagnosticReport = Mockito.mock(DiagnosticReport.class);
        FhirElementProcessorService fhirElementProcessorService =
                new DiagnosticReportProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", diagnosticReport);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testDocumentManifest() {
        DocumentManifest documentManifest = Mockito.mock(DocumentManifest.class);
        FhirElementProcessorService fhirElementProcessorService =
                new DocumentManifestProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", documentManifest);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testFamilyHistory() {
        FamilyHistory familyHistory = Mockito.mock(FamilyHistory.class);
        FhirElementProcessorService fhirElementProcessorService =
                new FamilyHistoryProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", familyHistory);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testGroup() {
        Group group = Mockito.mock(Group.class);
        FhirElementProcessorService fhirElementProcessorService =
                new GroupProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", group);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testImagingStudy() {
        ImagingStudy imagingStudy = Mockito.mock(ImagingStudy.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ImagingStudyProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", imagingStudy);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testImmunization() {
        Immunization immunization = Mockito.mock(Immunization.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ImmunizationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", immunization);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testImmunizationRecommendation() {
        ImmunizationRecommendation immunizationRecommendation = Mockito.mock(ImmunizationRecommendation.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ImmunizationRecommendationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", immunizationRecommendation);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testList() {
        List list = Mockito.mock(List.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ListProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", list);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testLocation() {
        Location location = Mockito.mock(Location.class);
        FhirElementProcessorService fhirElementProcessorService =
                new LocationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", location);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedia() {
        Media media = Mockito.mock(Media.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MediaProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", media);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedicationAdministration() {
        MedicationAdministration medicationAdministration = Mockito.mock(MedicationAdministration.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MedicationAdministrationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", medicationAdministration);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedicationDispense() {
        MedicationDispense medicationDispense = Mockito.mock(MedicationDispense.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MedicationDispenseProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", medicationDispense);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedicationPrescription() {
        MedicationPrescription medicationPrescription = Mockito.mock(MedicationPrescription.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MedicationPrescriptionProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", medicationPrescription);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedication() {
        Medication medication = Mockito.mock(Medication.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MedicationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", medication);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMedicationStatement() {
        MedicationStatement medicationStatement = Mockito.mock(MedicationStatement.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MedicationStatementProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", medicationStatement);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testMessageHeader() {
        MessageHeader messageHeader = Mockito.mock(MessageHeader.class);
        FhirElementProcessorService fhirElementProcessorService =
                new MessageHeaderProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", messageHeader);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testOperationOutcome() {
        OperationOutcome operationOutcome = Mockito.mock(OperationOutcome.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OperationOutcomeProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", operationOutcome);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testOrder() {
        Order order = Mockito.mock(Order.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OrderProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", order);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testOrderResponse() {
        OrderResponse orderResponse = Mockito.mock(OrderResponse.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OrderResponseProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", orderResponse);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testOrganization() {
        Organization organization = Mockito.mock(Organization.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OrgazationProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", organization);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testOther() {
        Other other = Mockito.mock(Other.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OtherProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", other);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testPractitioner() {
        Other other = Mockito.mock(Other.class);
        FhirElementProcessorService fhirElementProcessorService =
                new OtherProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", other);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testProvenance() {
        Provenance provenance = Mockito.mock(Provenance.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ProvenanceProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", provenance);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testQuery() {
        Query query = Mockito.mock(Query.class);
        FhirElementProcessorService fhirElementProcessorService =
                new QueryProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", query);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testQuestionaire() {
        Questionnaire questionnaire = Mockito.mock(Questionnaire.class);
        FhirElementProcessorService fhirElementProcessorService =
                new QuestionnaireProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", questionnaire);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testRelatedPerson() {
        RelatedPerson relatedPerson = Mockito.mock(RelatedPerson.class);
        FhirElementProcessorService fhirElementProcessorService =
                new RelatedPersonProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", relatedPerson);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testSecurityEvent() {
        SecurityEvent securityEvent = Mockito.mock(SecurityEvent.class);
        FhirElementProcessorService fhirElementProcessorService =
                new SecurityEventProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", securityEvent);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testSpecimen() {
        Specimen specimen = Mockito.mock(Specimen.class);
        FhirElementProcessorService fhirElementProcessorService =
                new SpecimenProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", specimen);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testSubstance() {
        Substance substance = Mockito.mock(Substance.class);
        FhirElementProcessorService fhirElementProcessorService =
                new SubstanceProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", substance);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class)
    public void testValueSet() {
        ValueSet valueSet = Mockito.mock(ValueSet.class);
        FhirElementProcessorService fhirElementProcessorService =
                new ValueSetProcessor(logicGraphClassifier);
        fhirElementProcessorService.process("id", valueSet);
    }
}
