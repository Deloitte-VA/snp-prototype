package com.github.jlgrock.snp.core.domain.fhir.classifiers;

import com.github.jlgrock.snp.apis.exceptions.ClassifierException;
import com.github.jlgrock.snp.core.domain.fhir.AdverseReaction;
import com.github.jlgrock.snp.core.domain.fhir.Alert;
import com.github.jlgrock.snp.core.domain.fhir.AllergyIntolerance;
import com.github.jlgrock.snp.core.domain.fhir.CarePlan;
import com.github.jlgrock.snp.core.domain.fhir.Composition;
import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.fhir.Encounter;
import com.github.jlgrock.snp.core.domain.fhir.Procedure;
import org.jvnet.hk2.annotations.Service;

/**
 *
 */
@Service
public class FhirElementClassifierFactory {
    public FhirElementClassifierService findClassifier(final Object unmarshalledObject) throws ClassifierException {

        FhirElementClassifierService fhirElementClassifierService;

        if (unmarshalledObject instanceof AdverseReaction) {
            fhirElementClassifierService = new AdverseReactionClassifier((AdverseReaction) unmarshalledObject);
        } else if (unmarshalledObject instanceof Alert) {
            fhirElementClassifierService = new AlertClassifier((Alert) unmarshalledObject);
        } else if (unmarshalledObject instanceof AllergyIntolerance) {
            fhirElementClassifierService = new AllergyIntoleranceClassifier((AllergyIntolerance) unmarshalledObject);
        } else if (unmarshalledObject instanceof CarePlan) {
            fhirElementClassifierService = new CarePlanClassifier((CarePlan) unmarshalledObject);
        } else if (unmarshalledObject instanceof Composition) {
            fhirElementClassifierService = new CompositionClassifier((Composition) unmarshalledObject);
//        } else if (unmarshalledObject instanceof ConceptMap) {
//            fhirEnvelope = new FhirEnvelope((ConceptMap) unmarshalledObject);
        } else if (unmarshalledObject instanceof Condition) {
            fhirElementClassifierService = new ConditionClassifier((Condition) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Conformance) {
//            fhirEnvelope = new FhirEnvelope((Conformance) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Device) {
//            fhirEnvelope = new FhirEnvelope((Device) unmarshalledObject);
//        } else if (unmarshalledObject instanceof DeviceObservationReport) {
//            fhirEnvelope = new FhirEnvelope((DeviceObservationReport) unmarshalledObject);
//        } else if (unmarshalledObject instanceof DiagnosticOrder) {
//            fhirEnvelope = new FhirEnvelope((DiagnosticOrder) unmarshalledObject);
//        } else if (unmarshalledObject instanceof DiagnosticReport) {
//            fhirEnvelope = new FhirEnvelope((DiagnosticReport) unmarshalledObject);
//        } else if (unmarshalledObject instanceof DocumentManifest) {
//            fhirEnvelope = new FhirEnvelope((DocumentManifest) unmarshalledObject);
        } else if (unmarshalledObject instanceof Encounter) {
            fhirElementClassifierService = new EncounterClassifier((Encounter) unmarshalledObject);
//        } else if (unmarshalledObject instanceof FamilyHistory) {
//            fhirEnvelope = new FhirEnvelope((FamilyHistory) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Group) {
//            fhirEnvelope = new FhirEnvelope((Group) unmarshalledObject);
//        } else if (unmarshalledObject instanceof ImagingStudy) {
//            fhirEnvelope = new FhirEnvelope((ImagingStudy) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Immunization) {
//            fhirEnvelope = new FhirEnvelope((Immunization) unmarshalledObject);
//        } else if (unmarshalledObject instanceof ImmunizationRecommendation) {
//            fhirEnvelope = new FhirEnvelope((ImmunizationRecommendation) unmarshalledObject);
//        } else if (unmarshalledObject instanceof List) {
//            fhirEnvelope = new FhirEnvelope((List) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Location) {
//            fhirEnvelope = new FhirEnvelope((Location) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Media) {
//            fhirEnvelope = new FhirEnvelope((Media) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Medication) {
//            fhirEnvelope = new FhirEnvelope((Medication) unmarshalledObject);
//        } else if (unmarshalledObject instanceof MedicationAdministration) {
//            fhirEnvelope = new FhirEnvelope((MedicationAdministration) unmarshalledObject);
//        } else if (unmarshalledObject instanceof MedicationDispense) {
//            fhirEnvelope = new FhirEnvelope((MedicationDispense) unmarshalledObject);
//        } else if (unmarshalledObject instanceof MedicationPrescription) {
//            fhirEnvelope = new FhirEnvelope((MedicationPrescription) unmarshalledObject);
//        } else if (unmarshalledObject instanceof MedicationStatement) {
//            fhirEnvelope = new FhirEnvelope((MedicationStatement) unmarshalledObject);
//        } else if (unmarshalledObject instanceof MessageHeader) {
//            fhirEnvelope = new FhirEnvelope((MessageHeader) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Observation) {
//            fhirEnvelope = new FhirEnvelope((Observation) unmarshalledObject);
//        } else if (unmarshalledObject instanceof OperationOutcome) {
//            fhirEnvelope = new FhirEnvelope((OperationOutcome) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Order) {
//            fhirEnvelope = new FhirEnvelope((Order) unmarshalledObject);
//        } else if (unmarshalledObject instanceof OrderResponse) {
//            fhirEnvelope = new FhirEnvelope((OrderResponse) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Organization) {
//            fhirEnvelope = new FhirEnvelope((Organization) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Other) {
//            fhirEnvelope = new FhirEnvelope((Other) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Patient) {
//            fhirEnvelope = new FhirEnvelope((Patient) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Practitioner) {
//            fhirEnvelope = new FhirEnvelope((Practitioner) unmarshalledObject);
        } else if (unmarshalledObject instanceof Procedure) {
            fhirElementClassifierService = new ProcedureClassifier((Procedure) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Profile) {
//            fhirEnvelope = new FhirEnvelope((Profile) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Provenance) {
//            fhirEnvelope = new FhirEnvelope((Provenance) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Query) {
//            fhirEnvelope = new FhirEnvelope((Query) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Questionnaire) {
//            fhirEnvelope = new FhirEnvelope((Questionnaire) unmarshalledObject);
//        } else if (unmarshalledObject instanceof RelatedPerson) {
//            fhirEnvelope = new FhirEnvelope((RelatedPerson) unmarshalledObject);
//        } else if (unmarshalledObject instanceof SecurityEvent) {
//            fhirEnvelope = new FhirEnvelope((SecurityEvent) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Specimen) {
//            fhirEnvelope = new FhirEnvelope((Specimen) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Substance) {
//            fhirEnvelope = new FhirEnvelope((Substance) unmarshalledObject);
//        } else if (unmarshalledObject instanceof ValueSet) {
//            fhirEnvelope = new FhirEnvelope((ValueSet) unmarshalledObject);
//        } else if (unmarshalledObject instanceof Binary) {
//            fhirEnvelope = new FhirEnvelope((Binary) unmarshalledObject);
        } else {
            throw new ClassifierException("Could not parse unmarshalled object.  Are you sure this is a fhir document?");
        }

        return fhirElementClassifierService;
    }
}
