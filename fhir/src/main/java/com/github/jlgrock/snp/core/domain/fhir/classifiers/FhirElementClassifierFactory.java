package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.fhir.AdverseReaction;
import com.github.jlgrock.snp.core.domain.fhir.Alert;
import com.github.jlgrock.snp.core.domain.fhir.AllergyIntolerance;
import com.github.jlgrock.snp.core.domain.fhir.Binary;
import com.github.jlgrock.snp.core.domain.fhir.CarePlan;
import com.github.jlgrock.snp.core.domain.fhir.Composition;
import com.github.jlgrock.snp.core.domain.fhir.ConceptMap;
import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.fhir.Conformance;
import com.github.jlgrock.snp.core.domain.fhir.Device;
import com.github.jlgrock.snp.core.domain.fhir.DeviceObservationReport;
import com.github.jlgrock.snp.core.domain.fhir.DiagnosticOrder;
import com.github.jlgrock.snp.core.domain.fhir.DiagnosticReport;
import com.github.jlgrock.snp.core.domain.fhir.DocumentManifest;
import com.github.jlgrock.snp.core.domain.fhir.Encounter;
import com.github.jlgrock.snp.core.domain.fhir.FamilyHistory;
import com.github.jlgrock.snp.core.domain.fhir.Group;
import com.github.jlgrock.snp.core.domain.fhir.ImagingStudy;
import com.github.jlgrock.snp.core.domain.fhir.Immunization;
import com.github.jlgrock.snp.core.domain.fhir.ImmunizationRecommendation;
import com.github.jlgrock.snp.core.domain.fhir.List;
import com.github.jlgrock.snp.core.domain.fhir.Location;
import com.github.jlgrock.snp.core.domain.fhir.Media;
import com.github.jlgrock.snp.core.domain.fhir.Medication;
import com.github.jlgrock.snp.core.domain.fhir.MedicationAdministration;
import com.github.jlgrock.snp.core.domain.fhir.MedicationDispense;
import com.github.jlgrock.snp.core.domain.fhir.MedicationPrescription;
import com.github.jlgrock.snp.core.domain.fhir.MedicationStatement;
import com.github.jlgrock.snp.core.domain.fhir.MessageHeader;
import com.github.jlgrock.snp.core.domain.fhir.Observation;
import com.github.jlgrock.snp.core.domain.fhir.OperationOutcome;
import com.github.jlgrock.snp.core.domain.fhir.Order;
import com.github.jlgrock.snp.core.domain.fhir.OrderResponse;
import com.github.jlgrock.snp.core.domain.fhir.Organization;
import com.github.jlgrock.snp.core.domain.fhir.Other;
import com.github.jlgrock.snp.core.domain.fhir.Patient;
import com.github.jlgrock.snp.core.domain.fhir.Practitioner;
import com.github.jlgrock.snp.core.domain.fhir.Procedure;
import com.github.jlgrock.snp.core.domain.fhir.Profile;
import com.github.jlgrock.snp.core.domain.fhir.Provenance;
import com.github.jlgrock.snp.core.domain.fhir.Query;
import com.github.jlgrock.snp.core.domain.fhir.Questionnaire;
import com.github.jlgrock.snp.core.domain.fhir.RelatedPerson;
import com.github.jlgrock.snp.core.domain.fhir.SecurityEvent;
import com.github.jlgrock.snp.core.domain.fhir.Specimen;
import com.github.jlgrock.snp.core.domain.fhir.Substance;
import com.github.jlgrock.snp.core.domain.fhir.ValueSet;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;

/**
 *
 */
@Service
public class FhirElementClassifierFactory {
    final TerminologyStoreDI terminologyStoreDI;

    @Inject
    FhirElementClassifierFactory(final TerminologyStoreDI terminologyStoreDIIn) {
        terminologyStoreDI = terminologyStoreDIIn;
    }

    public FhirElementClassifierService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        FhirElementClassifierService fhirElementClassifierService;

        if (unmarshalledObject instanceof AdverseReaction) {
            fhirElementClassifierService = new AdverseReactionClassifier(terminologyStoreDI, (AdverseReaction) unmarshalledObject);
        } else if (unmarshalledObject instanceof Alert) {
            fhirElementClassifierService = new AlertClassifier(terminologyStoreDI, (Alert) unmarshalledObject);
        } else if (unmarshalledObject instanceof AllergyIntolerance) {
            fhirElementClassifierService = new AllergyIntoleranceClassifier(terminologyStoreDI, (AllergyIntolerance) unmarshalledObject);
        } else if (unmarshalledObject instanceof CarePlan) {
            fhirElementClassifierService = new CarePlanClassifier(terminologyStoreDI, (CarePlan) unmarshalledObject);
        } else if (unmarshalledObject instanceof Composition) {
            fhirElementClassifierService = new CompositionClassifier(terminologyStoreDI, (Composition) unmarshalledObject);
        } else if (unmarshalledObject instanceof ConceptMap) {
            fhirElementClassifierService = new ConceptMapClassifier(terminologyStoreDI, (ConceptMap) unmarshalledObject);
        } else if (unmarshalledObject instanceof Condition) {
            fhirElementClassifierService = new ConditionClassifier(terminologyStoreDI, (Condition) unmarshalledObject);
        } else if (unmarshalledObject instanceof Conformance) {
            fhirElementClassifierService = new ConformanceClassifier(terminologyStoreDI, (Conformance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Device) {
            fhirElementClassifierService = new DeviceClassifier(terminologyStoreDI, (Device) unmarshalledObject);
        } else if (unmarshalledObject instanceof DeviceObservationReport) {
            fhirElementClassifierService = new DeviceObservationReportClassifier(terminologyStoreDI, (DeviceObservationReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticOrder) {
            fhirElementClassifierService = new DiagnosticOrderClassifier(terminologyStoreDI, (DiagnosticOrder) unmarshalledObject);
        } else if (unmarshalledObject instanceof DiagnosticReport) {
            fhirElementClassifierService = new DiagnosticReportClassifier(terminologyStoreDI, (DiagnosticReport) unmarshalledObject);
        } else if (unmarshalledObject instanceof DocumentManifest) {
            fhirElementClassifierService = new DocumentManifestClassifier(terminologyStoreDI, (DocumentManifest) unmarshalledObject);
        } else if (unmarshalledObject instanceof Encounter) {
            fhirElementClassifierService = new EncounterClassifier(terminologyStoreDI, (Encounter) unmarshalledObject);
        } else if (unmarshalledObject instanceof FamilyHistory) {
            fhirElementClassifierService = new FamilyHistoryClassifier(terminologyStoreDI, (FamilyHistory) unmarshalledObject);
        } else if (unmarshalledObject instanceof Group) {
            fhirElementClassifierService = new GroupClassifier(terminologyStoreDI, (Group) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImagingStudy) {
            fhirElementClassifierService = new ImagingStudyClassifier(terminologyStoreDI, (ImagingStudy) unmarshalledObject);
        } else if (unmarshalledObject instanceof Immunization) {
            fhirElementClassifierService = new ImmunizationClassifier(terminologyStoreDI, (Immunization) unmarshalledObject);
        } else if (unmarshalledObject instanceof ImmunizationRecommendation) {
            fhirElementClassifierService = new ImmunizationRecommendationClassifier(terminologyStoreDI, (ImmunizationRecommendation) unmarshalledObject);
        } else if (unmarshalledObject instanceof List) {
            fhirElementClassifierService = new ListClassifier(terminologyStoreDI, (List) unmarshalledObject);
        } else if (unmarshalledObject instanceof Location) {
            fhirElementClassifierService = new LocationClassifier(terminologyStoreDI, (Location) unmarshalledObject);
        } else if (unmarshalledObject instanceof Media) {
            fhirElementClassifierService = new MediaClassifier(terminologyStoreDI, (Media) unmarshalledObject);
        } else if (unmarshalledObject instanceof Medication) {
            fhirElementClassifierService = new MedicationClassifier(terminologyStoreDI, (Medication) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationAdministration) {
            fhirElementClassifierService = new MedicationAdministractionClassifier(terminologyStoreDI, (MedicationAdministration) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationDispense) {
            fhirElementClassifierService = new MedicationDispenseClassifier(terminologyStoreDI, (MedicationDispense) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationPrescription) {
            fhirElementClassifierService = new MedicationPrescriptionClassifier(terminologyStoreDI, (MedicationPrescription) unmarshalledObject);
        } else if (unmarshalledObject instanceof MedicationStatement) {
            fhirElementClassifierService = new MedicationStatementClassifier(terminologyStoreDI, (MedicationStatement) unmarshalledObject);
        } else if (unmarshalledObject instanceof MessageHeader) {
            fhirElementClassifierService = new MessageHeaderClassifier(terminologyStoreDI, (MessageHeader) unmarshalledObject);
        } else if (unmarshalledObject instanceof Observation) {
            fhirElementClassifierService = new ObservationClassifier(terminologyStoreDI, (Observation) unmarshalledObject);
        } else if (unmarshalledObject instanceof OperationOutcome) {
            fhirElementClassifierService = new OperationOutcomeClassifier(terminologyStoreDI, (OperationOutcome) unmarshalledObject);
        } else if (unmarshalledObject instanceof Order) {
            fhirElementClassifierService = new OrderClassifier(terminologyStoreDI, (Order) unmarshalledObject);
        } else if (unmarshalledObject instanceof OrderResponse) {
            fhirElementClassifierService = new OrderResponseClassifier(terminologyStoreDI, (OrderResponse) unmarshalledObject);
        } else if (unmarshalledObject instanceof Organization) {
            fhirElementClassifierService = new OrgazationClassifier(terminologyStoreDI, (Organization) unmarshalledObject);
        } else if (unmarshalledObject instanceof Other) {
            fhirElementClassifierService = new OtherClassifier(terminologyStoreDI, (Other) unmarshalledObject);
        } else if (unmarshalledObject instanceof Patient) {
            fhirElementClassifierService = new PatientClassifier(terminologyStoreDI, (Patient) unmarshalledObject);
        } else if (unmarshalledObject instanceof Practitioner) {
            fhirElementClassifierService = new PractitionerClassifier(terminologyStoreDI, (Practitioner) unmarshalledObject);
        } else if (unmarshalledObject instanceof Procedure) {
            fhirElementClassifierService = new ProcedureClassifier(terminologyStoreDI, (Procedure) unmarshalledObject);
        } else if (unmarshalledObject instanceof Profile) {
            fhirElementClassifierService = new ProfileClassifier(terminologyStoreDI, (Profile) unmarshalledObject);
        } else if (unmarshalledObject instanceof Provenance) {
            fhirElementClassifierService = new ProvenanceClassifier(terminologyStoreDI, (Provenance) unmarshalledObject);
        } else if (unmarshalledObject instanceof Query) {
            fhirElementClassifierService = new QueryClassifier(terminologyStoreDI, (Query) unmarshalledObject);
        } else if (unmarshalledObject instanceof Questionnaire) {
            fhirElementClassifierService = new QuestionnaireClassifier(terminologyStoreDI, (Questionnaire) unmarshalledObject);
        } else if (unmarshalledObject instanceof RelatedPerson) {
            fhirElementClassifierService = new RelatedPersonClassifier(terminologyStoreDI, (RelatedPerson) unmarshalledObject);
        } else if (unmarshalledObject instanceof SecurityEvent) {
            fhirElementClassifierService = new SecurityEventClassifier(terminologyStoreDI, (SecurityEvent) unmarshalledObject);
        } else if (unmarshalledObject instanceof Specimen) {
            fhirElementClassifierService = new SpecimenClassifier(terminologyStoreDI, (Specimen) unmarshalledObject);
        } else if (unmarshalledObject instanceof Substance) {
            fhirElementClassifierService = new SubstanceClassifier(terminologyStoreDI, (Substance) unmarshalledObject);
        } else if (unmarshalledObject instanceof ValueSet) {
            fhirElementClassifierService = new ValueSetClassifier(terminologyStoreDI, (ValueSet) unmarshalledObject);
        } else if (unmarshalledObject instanceof Binary) {
            fhirElementClassifierService = new BinaryClassifier(terminologyStoreDI, (Binary) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a fhir document?");
        }

        return fhirElementClassifierService;
    }
}
