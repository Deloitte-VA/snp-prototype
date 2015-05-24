package com.github.jlgrock.snp.core.domain.fhir;

import com.google.common.base.MoreObjects;

import java.lang.*;
import java.util.Objects;

//TODO delete
/**
 * A simple wrapper class to manage multiple top-level xml elements.
 */
public class FhirEnvelope {
    private final AdverseReaction adverseReaction;
    private final Alert alert;
    private final AllergyIntolerance allergyIntolerance;
    private final CarePlan carePlan;
    private final Composition composition;
    private final ConceptMap conceptMap;
    private final Condition condition;
    private final Conformance conformance;
    private final Device device;
    private final DeviceObservationReport deviceObservationReport;
    private final DiagnosticOrder diagnosticOrder;
    private final DiagnosticReport diagnosticReport;
    private final DocumentManifest documentManifest;
    private final DocumentReference documentReference;
    private final Encounter encounter;
    private final FamilyHistory familyHistory;
    private final Group group;
    private final ImagingStudy imagingStudy;
    private final Immunization immunization;
    private final ImmunizationRecommendation immunizationRecommendation;
    private final List list;
    private final Location location;
    private final Media media;
    private final Medication medication;
    private final MedicationAdministration medicationAdministration;
    private final MedicationDispense medicationDispense;
    private final MedicationPrescription medicationPrescription;
    private final MedicationStatement medicationStatement;
    private final MessageHeader messageHeader;
    private final Observation observation;
    private final OperationOutcome operationOutcome;
    private final Order order;
    private final OrderResponse orderResponse;
    private final Organization organization;
    private final Other other;
    private final Patient patient;
    private final Practitioner practitioner;
    private final Procedure procedure;
    private final Profile profile;
    private final Provenance provenance;
    private final Query query;
    private final Questionnaire questionnaire;
    private final RelatedPerson relatedPerson;
    private final SecurityEvent securityEvent;
    private final Specimen specimen;
    private final Substance substance;
    private final ValueSet valueSet;
    private final Binary binary;

    public FhirEnvelope(final AdverseReaction adverseReactionIn) {
        this(adverseReactionIn, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Alert alertIn) {
        this(null, alertIn, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final AllergyIntolerance allergyIntoleranceIn) {
        this(null, null, allergyIntoleranceIn, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final CarePlan carePlanIn) {
        this(null, null, null, carePlanIn, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Composition compositionIn) {
        this(null, null, null, null, compositionIn, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final ConceptMap conceptMapIn) {
        this(null, null, null, null, null, conceptMapIn, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Condition conditionIn) {
        this(null, null, null, null, null, null, conditionIn, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Conformance conformanceIn) {
        this(null, null, null, null, null, null, null, conformanceIn, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Device deviceIn) {
        this(null, null, null, null, null, null, null, null, deviceIn, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final DeviceObservationReport deviceObservationReportIn) {
        this(null, null, null, null, null, null, null, null, null, deviceObservationReportIn, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final DiagnosticOrder diagnosticOrderIn) {
        this(null, null, null, null, null, null, null, null, null, null, diagnosticOrderIn, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final DiagnosticReport diagnosticReportIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, diagnosticReportIn, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final DocumentManifest documentManifestIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, documentManifestIn, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final DocumentReference documentReferenceIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, documentReferenceIn,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Encounter encounterIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                encounterIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final FamilyHistory familyHistoryIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, familyHistoryIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Group groupIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, groupIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final ImagingStudy imagingStudyIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, imagingStudyIn, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Immunization immunizationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, immunizationIn, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final ImmunizationRecommendation immunizationRecommendationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, immunizationRecommendationIn, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final List listIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, listIn, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Location locationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, locationIn, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Media mediaIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, mediaIn, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Medication medicationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, medicationIn, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final MedicationAdministration medicationAdministrationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, medicationAdministrationIn, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final MedicationDispense medicationDispenseIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, medicationDispenseIn, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final MedicationPrescription medicationPrescriptionIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, medicationPrescriptionIn, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final MedicationStatement medicationStatementIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, medicationStatementIn, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final MessageHeader messageHeaderIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, messageHeaderIn, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Observation observationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, observationIn, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final OperationOutcome operationOutcomeIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, operationOutcomeIn,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Order orderIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                orderIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final OrderResponse orderResponseIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, orderResponseIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Organization organizationIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, organizationIn, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Other otherIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, otherIn, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Patient patientIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, patientIn, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Practitioner practitionerIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, practitionerIn, null, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Procedure procedureIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, procedureIn, null, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Profile profileIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, profileIn, null, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Provenance provenanceIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, provenanceIn, null, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Query queryIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, queryIn, null, null, null, null, null, null, null);
    }

    public FhirEnvelope(final Questionnaire questionnaireIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, questionnaireIn, null, null, null, null, null, null);
    }

    public FhirEnvelope(final RelatedPerson relatedPersonIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, relatedPersonIn, null, null, null, null, null);
    }

    public FhirEnvelope(final SecurityEvent securityEventIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, securityEventIn, null, null, null, null);
    }

    public FhirEnvelope(final Specimen specimenIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, specimenIn, null, null, null);
    }

    public FhirEnvelope(final Substance substanceIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, substanceIn, null, null);
    }

    public FhirEnvelope(final ValueSet valueSetIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, valueSetIn, null);
    }

    public FhirEnvelope(final Binary binaryIn) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, binaryIn);
    }

    private FhirEnvelope(
            final AdverseReaction adverseReactionIn,
            final Alert alertIn,
            final AllergyIntolerance allergyIntoleranceIn,
            final CarePlan carePlanIn,
            final Composition compositionIn,
            final ConceptMap conceptMapIn,
            final Condition conditionIn,
            final Conformance conformanceIn,
            final Device deviceIn,
            final DeviceObservationReport deviceObservationReportIn,
            final DiagnosticOrder diagnosticOrderIn,
            final DiagnosticReport diagnosticReportIn,
            final DocumentManifest documentManifestIn,
            final DocumentReference documentReferenceIn,
            final Encounter encounterIn,
            final FamilyHistory familyHistoryIn,
            final Group groupIn,
            final ImagingStudy imagingStudyIn,
            final Immunization immunizationIn,
            final ImmunizationRecommendation immunizationRecommendationIn,
            final List listIn,
            final Location locationIn,
            final Media mediaIn,
            final Medication medicationIn,
            final MedicationAdministration medicationAdministrationIn,
            final MedicationDispense medicationDispenseIn,
            final MedicationPrescription medicationPrescriptionIn,
            final MedicationStatement medicationStatementIn,
            final MessageHeader messageHeaderIn,
            final Observation observationIn,
            final OperationOutcome operationOutcomeIn,
            final Order orderIn,
            final OrderResponse orderResponseIn,
            final Organization organizationIn,
            final Other otherIn,
            final Patient patientIn,
            final Practitioner practitionerIn,
            final Procedure procedureIn,
            final Profile profileIn,
            final Provenance provenanceIn,
            final Query queryIn,
            final Questionnaire questionnaireIn,
            final RelatedPerson relatedPersonIn,
            final SecurityEvent securityEventIn,
            final Specimen specimenIn,
            final Substance substanceIn,
            final ValueSet valueSetIn,
            final Binary binaryIn
    ) {
        adverseReaction = adverseReactionIn;
        alert = alertIn;
        allergyIntolerance = allergyIntoleranceIn;
        carePlan = carePlanIn;
        composition = compositionIn;
        conceptMap = conceptMapIn;
        condition = conditionIn;
        conformance = conformanceIn;
        device = deviceIn;
        deviceObservationReport = deviceObservationReportIn;
        diagnosticOrder = diagnosticOrderIn;
        diagnosticReport = diagnosticReportIn;
        documentManifest = documentManifestIn;
        documentReference = documentReferenceIn;
        encounter = encounterIn;
        familyHistory = familyHistoryIn;
        group = groupIn;
        imagingStudy = imagingStudyIn;
        immunization = immunizationIn;
        immunizationRecommendation = immunizationRecommendationIn;
        list = listIn;
        location = locationIn;
        media = mediaIn;
        medication = medicationIn;
        medicationAdministration = medicationAdministrationIn;
        medicationDispense = medicationDispenseIn;
        medicationPrescription = medicationPrescriptionIn;
        medicationStatement = medicationStatementIn;
        messageHeader = messageHeaderIn;
        observation = observationIn;
        operationOutcome = operationOutcomeIn;
        order = orderIn;
        orderResponse = orderResponseIn;
        organization = organizationIn;
        other = otherIn;
        patient = patientIn;
        practitioner = practitionerIn;
        procedure = procedureIn;
        profile = profileIn;
        provenance = provenanceIn;
        query = queryIn;
        questionnaire = questionnaireIn;
        relatedPerson = relatedPersonIn;
        securityEvent = securityEventIn;
        specimen = specimenIn;
        substance = substanceIn;
        valueSet = valueSetIn;
        binary = binaryIn;
    }

    public AdverseReaction getAdverseReaction() {
        return adverseReaction;
    }

    public Alert getAlert() {
        return alert;
    }

    public AllergyIntolerance getAllergyIntolerance() {
        return allergyIntolerance;
    }

    public CarePlan getCarePlan() {
        return carePlan;
    }

    public Composition getComposition() {
        return composition;
    }

    public ConceptMap getConceptMap() {
        return conceptMap;
    }

    public Condition getCondition() {
        return condition;
    }

    public Conformance getConformance() {
        return conformance;
    }

    public Device getDevice() {
        return device;
    }

    public DeviceObservationReport getDeviceObservationReport() {
        return deviceObservationReport;
    }

    public DiagnosticOrder getDiagnosticOrder() {
        return diagnosticOrder;
    }

    public DiagnosticReport getDiagnosticReport() {
        return diagnosticReport;
    }

    public DocumentManifest getDocumentManifest() {
        return documentManifest;
    }

    public DocumentReference getDocumentReference() {
        return documentReference;
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public FamilyHistory getFamilyHistory() {
        return familyHistory;
    }

    public Group getGroup() {
        return group;
    }

    public ImagingStudy getImagingStudy() {
        return imagingStudy;
    }

    public Immunization getImmunization() {
        return immunization;
    }

    public ImmunizationRecommendation getImmunizationRecommendation() {
        return immunizationRecommendation;
    }

    public List getList() {
        return list;
    }

    public Location getLocation() {
        return location;
    }

    public Media getMedia() {
        return media;
    }

    public Medication getMedication() {
        return medication;
    }

    public MedicationAdministration getMedicationAdministration() {
        return medicationAdministration;
    }

    public MedicationDispense getMedicationDispense() {
        return medicationDispense;
    }

    public MedicationPrescription getMedicationPrescription() {
        return medicationPrescription;
    }

    public MedicationStatement getMedicationStatement() {
        return medicationStatement;
    }

    public MessageHeader getMessageHeader() {
        return messageHeader;
    }

    public Observation getObservation() {
        return observation;
    }

    public OperationOutcome getOperationOutcome() {
        return operationOutcome;
    }

    public Order getOrder() {
        return order;
    }

    public OrderResponse getOrderResponse() {
        return orderResponse;
    }

    public Organization getOrganization() {
        return organization;
    }

    public Other getOther() {
        return other;
    }

    public Patient getPatient() {
        return patient;
    }

    public Practitioner getPractitioner() {
        return practitioner;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public Profile getProfile() {
        return profile;
    }

    public Provenance getProvenance() {
        return provenance;
    }

    public Query getQuery() {
        return query;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public RelatedPerson getRelatedPerson() {
        return relatedPerson;
    }

    public SecurityEvent getSecurityEvent() {
        return securityEvent;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public Substance getSubstance() {
        return substance;
    }

    public ValueSet getValueSet() {
        return valueSet;
    }

    public Binary getBinary() {
        return binary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(adverseReaction, alert, allergyIntolerance, carePlan, composition, conceptMap, condition, conformance, device, deviceObservationReport, diagnosticOrder, diagnosticReport, documentManifest, documentReference, encounter, familyHistory, group, imagingStudy, immunization, immunizationRecommendation, list, location, media, medication, medicationAdministration, medicationDispense, medicationPrescription, medicationStatement, messageHeader, observation, operationOutcome, order, orderResponse, organization, other, patient, practitioner, procedure, profile, provenance, query, questionnaire, relatedPerson, securityEvent, specimen, substance, valueSet, binary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final FhirEnvelope other = (FhirEnvelope) obj;
        return Objects.equals(this.adverseReaction, other.adverseReaction)
                && Objects.equals(this.alert, other.alert)
                && Objects.equals(this.allergyIntolerance, other.allergyIntolerance)
                && Objects.equals(this.carePlan, other.carePlan)
                && Objects.equals(this.composition, other.composition)
                && Objects.equals(this.conceptMap, other.conceptMap)
                && Objects.equals(this.condition, other.condition)
                && Objects.equals(this.conformance, other.conformance)
                && Objects.equals(this.device, other.device)
                && Objects.equals(this.deviceObservationReport, other.deviceObservationReport)
                && Objects.equals(this.diagnosticOrder, other.diagnosticOrder)
                && Objects.equals(this.diagnosticReport, other.diagnosticReport)
                && Objects.equals(this.documentManifest, other.documentManifest)
                && Objects.equals(this.documentReference, other.documentReference)
                && Objects.equals(this.encounter, other.encounter)
                && Objects.equals(this.familyHistory, other.familyHistory)
                && Objects.equals(this.group, other.group)
                && Objects.equals(this.imagingStudy, other.imagingStudy)
                && Objects.equals(this.immunization, other.immunization)
                && Objects.equals(this.immunizationRecommendation, other.immunizationRecommendation)
                && Objects.equals(this.list, other.list)
                && Objects.equals(this.location, other.location)
                && Objects.equals(this.media, other.media)
                && Objects.equals(this.medication, other.medication)
                && Objects.equals(this.medicationAdministration, other.medicationAdministration)
                && Objects.equals(this.medicationDispense, other.medicationDispense)
                && Objects.equals(this.medicationPrescription, other.medicationPrescription)
                && Objects.equals(this.medicationStatement, other.medicationStatement)
                && Objects.equals(this.messageHeader, other.messageHeader)
                && Objects.equals(this.observation, other.observation)
                && Objects.equals(this.operationOutcome, other.operationOutcome)
                && Objects.equals(this.order, other.order)
                && Objects.equals(this.orderResponse, other.orderResponse)
                && Objects.equals(this.organization, other.organization)
                && Objects.equals(this.other, other.other)
                && Objects.equals(this.patient, other.patient)
                && Objects.equals(this.practitioner, other.practitioner)
                && Objects.equals(this.procedure, other.procedure)
                && Objects.equals(this.profile, other.profile)
                && Objects.equals(this.provenance, other.provenance)
                && Objects.equals(this.query, other.query)
                && Objects.equals(this.questionnaire, other.questionnaire)
                && Objects.equals(this.relatedPerson, other.relatedPerson)
                && Objects.equals(this.securityEvent, other.securityEvent)
                && Objects.equals(this.specimen, other.specimen)
                && Objects.equals(this.substance, other.substance)
                && Objects.equals(this.valueSet, other.valueSet)
                && Objects.equals(this.binary, other.binary);
    }

    @Override
    public java.lang.String toString() {
        return MoreObjects.toStringHelper(this)
                .add("adverseReaction", adverseReaction)
                .add("alert", alert)
                .add("allergyIntolerance", allergyIntolerance)
                .add("carePlan", carePlan)
                .add("composition", composition)
                .add("conceptMap", conceptMap)
                .add("condition", condition)
                .add("conformance", conformance)
                .add("device", device)
                .add("deviceObservationReport", deviceObservationReport)
                .add("diagnosticOrder", diagnosticOrder)
                .add("diagnosticReport", diagnosticReport)
                .add("documentManifest", documentManifest)
                .add("documentReference", documentReference)
                .add("encounter", encounter)
                .add("familyHistory", familyHistory)
                .add("group", group)
                .add("imagingStudy", imagingStudy)
                .add("immunization", immunization)
                .add("immunizationRecommendation", immunizationRecommendation)
                .add("list", list)
                .add("location", location)
                .add("media", media)
                .add("medication", medication)
                .add("medicationAdministration", medicationAdministration)
                .add("medicationDispense", medicationDispense)
                .add("medicationPrescription", medicationPrescription)
                .add("medicationStatement", medicationStatement)
                .add("messageHeader", messageHeader)
                .add("observation", observation)
                .add("operationOutcome", operationOutcome)
                .add("order", order)
                .add("orderResponse", orderResponse)
                .add("organization", organization)
                .add("other", other)
                .add("patient", patient)
                .add("practitioner", practitioner)
                .add("procedure", procedure)
                .add("profile", profile)
                .add("provenance", provenance)
                .add("query", query)
                .add("questionnaire", questionnaire)
                .add("relatedPerson", relatedPerson)
                .add("securityEvent", securityEvent)
                .add("specimen", specimen)
                .add("substance", substance)
                .add("valueSet", valueSet)
                .add("binary", binary)
                .toString();
    }
}
