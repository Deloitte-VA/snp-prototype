package com.github.jlgrock.snp.core.domain.fhir.classifiers;

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
