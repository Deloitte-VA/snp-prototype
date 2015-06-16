package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.fhir.converters.PatientWriteConverter;
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
import com.github.jlgrock.snp.domain.data.PatientRepository;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class FhirElementProcessorFactoryImpl implements FhirElementProcessorFactory {
    final LogicGraphClassifier logicGraphClassifier;
    final PatientWriteConverter patientWriteConverter;
    final PatientRepository patientRepository;

    @Inject
    FhirElementProcessorFactoryImpl(final LogicGraphClassifier logicGraphClassifierIn,
    		final PatientWriteConverter patientWriteConverterIn, final PatientRepository patientRepositoryIn) {
        logicGraphClassifier = logicGraphClassifierIn;
        patientWriteConverter = patientWriteConverterIn;
        patientRepository = patientRepositoryIn;
    }

    @Override
    public FhirElementProcessorService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        FhirElementProcessorService fhirElementProcessorService;

        if (unmarshalledObject instanceof AdverseReaction) {
            fhirElementProcessorService = new AdverseReactionProcessor(logicGraphClassifier, (AdverseReaction) unmarshalledObject);
        } else if (unmarshalledObject instanceof Alert) {
            fhirElementProcessorService = new AlertProcessor(logicGraphClassifier, (Alert) unmarshalledObject);
        } else if (unmarshalledObject instanceof AllergyIntolerance) {
            fhirElementProcessorService = new AllergyIntoleranceProcessor(logicGraphClassifier, (AllergyIntolerance) unmarshalledObject);
        } else if (unmarshalledObject instanceof CarePlan) {
            fhirElementProcessorService = new CarePlanProcessor(logicGraphClassifier, (CarePlan) unmarshalledObject);
        } else if (unmarshalledObject instanceof Composition) {
            fhirElementProcessorService = new CompositionProcessor(logicGraphClassifier, (Composition) unmarshalledObject);
        } else if (unmarshalledObject instanceof ConceptMap) {
            fhirElementProcessorService = new ConceptMapProcessor(logicGraphClassifier, (ConceptMap) unmarshalledObject);
        } else if (unmarshalledObject instanceof Condition) {
            fhirElementProcessorService = new ConditionProcessor(logicGraphClassifier, (Condition) unmarshalledObject);
        } else if (unmarshalledObject instanceof Conformance) {
            fhirElementProcessorService = new ConformanceProcessor(logicGraphClassifier, (Conformance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Device) {
            fhirElementProcessorService = new DeviceProcessor(logicGraphClassifier, (Device) unmarshalledObject);
        } else if (unmarshalledObject instanceof DeviceObservationReport) {
            fhirElementProcessorService = new DeviceObservationReportProcessor(logicGraphClassifier, (DeviceObservationReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticOrder) {
            fhirElementProcessorService = new DiagnosticOrderProcessor(logicGraphClassifier, (DiagnosticOrder) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticReport) {
            fhirElementProcessorService = new DiagnosticReportProcessor(logicGraphClassifier, (DiagnosticReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DocumentManifest) {
            fhirElementProcessorService = new DocumentManifestProcessor(logicGraphClassifier, (DocumentManifest) unmarshalledObject);
        } else if (unmarshalledObject instanceof Encounter) {
            fhirElementProcessorService = new EncounterProcessor(logicGraphClassifier, (Encounter) unmarshalledObject);
        } else if (unmarshalledObject instanceof FamilyHistory) {
            fhirElementProcessorService = new FamilyHistoryProcessor(logicGraphClassifier, (FamilyHistory) unmarshalledObject);
        } else if (unmarshalledObject instanceof Group) {
            fhirElementProcessorService = new GroupProcessor(logicGraphClassifier, (Group) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImagingStudy) {
            fhirElementProcessorService = new ImagingStudyProcessor(logicGraphClassifier, (ImagingStudy) unmarshalledObject);
        } else if (unmarshalledObject instanceof Immunization) {
            fhirElementProcessorService = new ImmunizationProcessor(logicGraphClassifier, (Immunization) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImmunizationRecommendation) {
            fhirElementProcessorService = new ImmunizationRecommendationProcessor(logicGraphClassifier, (ImmunizationRecommendation) unmarshalledObject);
        } else if (unmarshalledObject instanceof List) {
            fhirElementProcessorService = new ListProcessor(logicGraphClassifier, (List) unmarshalledObject);
        } else if (unmarshalledObject instanceof Location) {
            fhirElementProcessorService = new LocationProcessor(logicGraphClassifier, (Location) unmarshalledObject);
        } else if (unmarshalledObject instanceof Media) {
            fhirElementProcessorService = new MediaProcessor(logicGraphClassifier, (Media) unmarshalledObject);
        } else if (unmarshalledObject instanceof Medication) {
            fhirElementProcessorService = new MedicationProcessor(logicGraphClassifier, (Medication) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationAdministration) {
            fhirElementProcessorService = new MedicationAdministractionProcessor(logicGraphClassifier, (MedicationAdministration) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationDispense) {
            fhirElementProcessorService = new MedicationDispenseProcessor(logicGraphClassifier, (MedicationDispense) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationPrescription) {
            fhirElementProcessorService = new MedicationPrescriptionProcessor(logicGraphClassifier, (MedicationPrescription) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationStatement) {
            fhirElementProcessorService = new MedicationStatementProcessor(logicGraphClassifier, (MedicationStatement) unmarshalledObject);
        } else if (unmarshalledObject instanceof MessageHeader) {
            fhirElementProcessorService = new MessageHeaderProcessor(logicGraphClassifier, (MessageHeader) unmarshalledObject);
        } else if (unmarshalledObject instanceof Observation) {
            fhirElementProcessorService = new ObservationProcessor(logicGraphClassifier, (Observation) unmarshalledObject);
        } else if (unmarshalledObject instanceof OperationOutcome) {
            fhirElementProcessorService = new OperationOutcomeProcessor(logicGraphClassifier, (OperationOutcome) unmarshalledObject);
        } else if (unmarshalledObject instanceof Order) {
            fhirElementProcessorService = new OrderProcessor(logicGraphClassifier, (Order) unmarshalledObject);
        } else if (unmarshalledObject instanceof OrderResponse) {
            fhirElementProcessorService = new OrderResponseProcessor(logicGraphClassifier, (OrderResponse) unmarshalledObject);
        } else if (unmarshalledObject instanceof Organization) {
            fhirElementProcessorService = new OrgazationProcessor(logicGraphClassifier, (Organization) unmarshalledObject);
        } else if (unmarshalledObject instanceof Other) {
            fhirElementProcessorService = new OtherProcessor(logicGraphClassifier, (Other) unmarshalledObject);
        } else if (unmarshalledObject instanceof Patient) {
            fhirElementProcessorService = new PatientProcessor(logicGraphClassifier, (Patient) unmarshalledObject, patientWriteConverter, patientRepository);
        } else if (unmarshalledObject instanceof Practitioner) {
            fhirElementProcessorService = new PractitionerProcessor(logicGraphClassifier, (Practitioner) unmarshalledObject);
        } else if (unmarshalledObject instanceof Procedure) {
            fhirElementProcessorService = new ProcedureProcessor(logicGraphClassifier, (Procedure) unmarshalledObject);
        } else if (unmarshalledObject instanceof Profile) {
            fhirElementProcessorService = new ProfileProcessor(logicGraphClassifier, (Profile) unmarshalledObject);
        } else if (unmarshalledObject instanceof Provenance) {
            fhirElementProcessorService = new ProvenanceProcessor(logicGraphClassifier, (Provenance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Query) {
            fhirElementProcessorService = new QueryProcessor(logicGraphClassifier, (Query) unmarshalledObject);
        } else if (unmarshalledObject instanceof Questionnaire) {
            fhirElementProcessorService = new QuestionnaireProcessor(logicGraphClassifier, (Questionnaire) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelatedPerson) {
            fhirElementProcessorService = new RelatedPersonProcessor(logicGraphClassifier, (RelatedPerson) unmarshalledObject);
        } else if (unmarshalledObject instanceof SecurityEvent) {
            fhirElementProcessorService = new SecurityEventProcessor(logicGraphClassifier, (SecurityEvent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Specimen) {
            fhirElementProcessorService = new SpecimenProcessor(logicGraphClassifier, (Specimen) unmarshalledObject);
        } else if (unmarshalledObject instanceof Substance) {
            fhirElementProcessorService = new SubstanceProcessor(logicGraphClassifier, (Substance) unmarshalledObject);
        } else if (unmarshalledObject instanceof ValueSet) {
            fhirElementProcessorService = new ValueSetProcessor(logicGraphClassifier, (ValueSet) unmarshalledObject);
        } else if (unmarshalledObject instanceof Binary) {
            fhirElementProcessorService = new BinaryProcessor(logicGraphClassifier, (Binary) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a fhir document?");
        }

        return fhirElementProcessorService;
    }
}
