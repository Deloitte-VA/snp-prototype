package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.fhir.model.AdverseReaction;
import com.github.jlgrock.snp.core.domain.fhir.model.Alert;
import com.github.jlgrock.snp.core.domain.fhir.model.AllergyIntolerance;
import com.github.jlgrock.snp.core.domain.fhir.model.Binary;
import com.github.jlgrock.snp.core.domain.fhir.model.CarePlan;
import com.github.jlgrock.snp.core.domain.fhir.model.Composition;
import com.github.jlgrock.snp.core.domain.fhir.model.ConceptMap;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import com.github.jlgrock.snp.core.domain.fhir.model.Conformance;
import com.github.jlgrock.snp.core.domain.fhir.model.Device;
import com.github.jlgrock.snp.core.domain.fhir.model.DeviceObservationReport;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticOrder;
import com.github.jlgrock.snp.core.domain.fhir.model.DiagnosticReport;
import com.github.jlgrock.snp.core.domain.fhir.model.DocumentManifest;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
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
import com.github.jlgrock.snp.core.domain.fhir.model.Observation;
import com.github.jlgrock.snp.core.domain.fhir.model.OperationOutcome;
import com.github.jlgrock.snp.core.domain.fhir.model.Order;
import com.github.jlgrock.snp.core.domain.fhir.model.OrderResponse;
import com.github.jlgrock.snp.core.domain.fhir.model.Organization;
import com.github.jlgrock.snp.core.domain.fhir.model.Other;
import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import com.github.jlgrock.snp.core.domain.fhir.model.Practitioner;
import com.github.jlgrock.snp.core.domain.fhir.model.Procedure;
import com.github.jlgrock.snp.core.domain.fhir.model.Profile;
import com.github.jlgrock.snp.core.domain.fhir.model.Provenance;
import com.github.jlgrock.snp.core.domain.fhir.model.Query;
import com.github.jlgrock.snp.core.domain.fhir.model.Questionnaire;
import com.github.jlgrock.snp.core.domain.fhir.model.RelatedPerson;
import com.github.jlgrock.snp.core.domain.fhir.model.SecurityEvent;
import com.github.jlgrock.snp.core.domain.fhir.model.Specimen;
import com.github.jlgrock.snp.core.domain.fhir.model.Substance;
import com.github.jlgrock.snp.core.domain.fhir.model.ValueSet;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class FhirElementProcessorFactoryImpl implements FhirElementProcessorFactory {
    final TerminologyStoreDI terminologyStoreDI;

    @Inject
//    FhirElementProcessorFactoryImpl(final TerminologyStoreDI terminologyStoreDIIn) {
    FhirElementProcessorFactoryImpl() {
        terminologyStoreDI = null;
    }

    @Override
    public FhirElementProcessorService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        FhirElementProcessorService fhirElementProcessorService;

        if (unmarshalledObject instanceof AdverseReaction) {
            fhirElementProcessorService = new AdverseReactionProcessor(terminologyStoreDI, (AdverseReaction) unmarshalledObject);
        } else if (unmarshalledObject instanceof Alert) {
            fhirElementProcessorService = new AlertProcessor(terminologyStoreDI, (Alert) unmarshalledObject);
        } else if (unmarshalledObject instanceof AllergyIntolerance) {
            fhirElementProcessorService = new AllergyIntoleranceProcessor(terminologyStoreDI, (AllergyIntolerance) unmarshalledObject);
        } else if (unmarshalledObject instanceof CarePlan) {
            fhirElementProcessorService = new CarePlanProcessor(terminologyStoreDI, (CarePlan) unmarshalledObject);
        } else if (unmarshalledObject instanceof Composition) {
            fhirElementProcessorService = new CompositionProcessor(terminologyStoreDI, (Composition) unmarshalledObject);
        } else if (unmarshalledObject instanceof ConceptMap) {
            fhirElementProcessorService = new ConceptMapProcessor(terminologyStoreDI, (ConceptMap) unmarshalledObject);
        } else if (unmarshalledObject instanceof Condition) {
            fhirElementProcessorService = new ConditionProcessor(terminologyStoreDI, (Condition) unmarshalledObject);
        } else if (unmarshalledObject instanceof Conformance) {
            fhirElementProcessorService = new ConformanceProcessor(terminologyStoreDI, (Conformance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Device) {
            fhirElementProcessorService = new DeviceProcessor(terminologyStoreDI, (Device) unmarshalledObject);
        } else if (unmarshalledObject instanceof DeviceObservationReport) {
            fhirElementProcessorService = new DeviceObservationReportProcessor(terminologyStoreDI, (DeviceObservationReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticOrder) {
            fhirElementProcessorService = new DiagnosticOrderProcessor(terminologyStoreDI, (DiagnosticOrder) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticReport) {
            fhirElementProcessorService = new DiagnosticReportProcessor(terminologyStoreDI, (DiagnosticReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DocumentManifest) {
            fhirElementProcessorService = new DocumentManifestProcessor(terminologyStoreDI, (DocumentManifest) unmarshalledObject);
        } else if (unmarshalledObject instanceof Encounter) {
            fhirElementProcessorService = new EncounterProcessor(terminologyStoreDI, (Encounter) unmarshalledObject);
        } else if (unmarshalledObject instanceof FamilyHistory) {
            fhirElementProcessorService = new FamilyHistoryProcessor(terminologyStoreDI, (FamilyHistory) unmarshalledObject);
        } else if (unmarshalledObject instanceof Group) {
            fhirElementProcessorService = new GroupProcessor(terminologyStoreDI, (Group) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImagingStudy) {
            fhirElementProcessorService = new ImagingStudyProcessor(terminologyStoreDI, (ImagingStudy) unmarshalledObject);
        } else if (unmarshalledObject instanceof Immunization) {
            fhirElementProcessorService = new ImmunizationProcessor(terminologyStoreDI, (Immunization) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImmunizationRecommendation) {
            fhirElementProcessorService = new ImmunizationRecommendationProcessor(terminologyStoreDI, (ImmunizationRecommendation) unmarshalledObject);
        } else if (unmarshalledObject instanceof List) {
            fhirElementProcessorService = new ListProcessor(terminologyStoreDI, (List) unmarshalledObject);
        } else if (unmarshalledObject instanceof Location) {
            fhirElementProcessorService = new LocationProcessor(terminologyStoreDI, (Location) unmarshalledObject);
        } else if (unmarshalledObject instanceof Media) {
            fhirElementProcessorService = new MediaProcessor(terminologyStoreDI, (Media) unmarshalledObject);
        } else if (unmarshalledObject instanceof Medication) {
            fhirElementProcessorService = new MedicationProcessor(terminologyStoreDI, (Medication) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationAdministration) {
            fhirElementProcessorService = new MedicationAdministractionProcessor(terminologyStoreDI, (MedicationAdministration) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationDispense) {
            fhirElementProcessorService = new MedicationDispenseProcessor(terminologyStoreDI, (MedicationDispense) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationPrescription) {
            fhirElementProcessorService = new MedicationPrescriptionProcessor(terminologyStoreDI, (MedicationPrescription) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationStatement) {
            fhirElementProcessorService = new MedicationStatementProcessor(terminologyStoreDI, (MedicationStatement) unmarshalledObject);
        } else if (unmarshalledObject instanceof MessageHeader) {
            fhirElementProcessorService = new MessageHeaderProcessor(terminologyStoreDI, (MessageHeader) unmarshalledObject);
        } else if (unmarshalledObject instanceof Observation) {
            fhirElementProcessorService = new ObservationProcessor(terminologyStoreDI, (Observation) unmarshalledObject);
        } else if (unmarshalledObject instanceof OperationOutcome) {
            fhirElementProcessorService = new OperationOutcomeProcessor(terminologyStoreDI, (OperationOutcome) unmarshalledObject);
        } else if (unmarshalledObject instanceof Order) {
            fhirElementProcessorService = new OrderProcessor(terminologyStoreDI, (Order) unmarshalledObject);
        } else if (unmarshalledObject instanceof OrderResponse) {
            fhirElementProcessorService = new OrderResponseProcessor(terminologyStoreDI, (OrderResponse) unmarshalledObject);
        } else if (unmarshalledObject instanceof Organization) {
            fhirElementProcessorService = new OrgazationProcessor(terminologyStoreDI, (Organization) unmarshalledObject);
        } else if (unmarshalledObject instanceof Other) {
            fhirElementProcessorService = new OtherProcessor(terminologyStoreDI, (Other) unmarshalledObject);
        } else if (unmarshalledObject instanceof Patient) {
            fhirElementProcessorService = new PatientProcessor(terminologyStoreDI, (Patient) unmarshalledObject);
        } else if (unmarshalledObject instanceof Practitioner) {
            fhirElementProcessorService = new PractitionerProcessor(terminologyStoreDI, (Practitioner) unmarshalledObject);
        } else if (unmarshalledObject instanceof Procedure) {
            fhirElementProcessorService = new ProcedureProcessor(terminologyStoreDI, (Procedure) unmarshalledObject);
        } else if (unmarshalledObject instanceof Profile) {
            fhirElementProcessorService = new ProfileProcessor(terminologyStoreDI, (Profile) unmarshalledObject);
        } else if (unmarshalledObject instanceof Provenance) {
            fhirElementProcessorService = new ProvenanceProcessor(terminologyStoreDI, (Provenance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Query) {
            fhirElementProcessorService = new QueryProcessor(terminologyStoreDI, (Query) unmarshalledObject);
        } else if (unmarshalledObject instanceof Questionnaire) {
            fhirElementProcessorService = new QuestionnaireProcessor(terminologyStoreDI, (Questionnaire) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelatedPerson) {
            fhirElementProcessorService = new RelatedPersonProcessor(terminologyStoreDI, (RelatedPerson) unmarshalledObject);
        } else if (unmarshalledObject instanceof SecurityEvent) {
            fhirElementProcessorService = new SecurityEventProcessor(terminologyStoreDI, (SecurityEvent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Specimen) {
            fhirElementProcessorService = new SpecimenProcessor(terminologyStoreDI, (Specimen) unmarshalledObject);
        } else if (unmarshalledObject instanceof Substance) {
            fhirElementProcessorService = new SubstanceProcessor(terminologyStoreDI, (Substance) unmarshalledObject);
        } else if (unmarshalledObject instanceof ValueSet) {
            fhirElementProcessorService = new ValueSetProcessor(terminologyStoreDI, (ValueSet) unmarshalledObject);
        } else if (unmarshalledObject instanceof Binary) {
            fhirElementProcessorService = new BinaryProcessor(terminologyStoreDI, (Binary) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a fhir document?");
        }

        return fhirElementProcessorService;
    }
}
