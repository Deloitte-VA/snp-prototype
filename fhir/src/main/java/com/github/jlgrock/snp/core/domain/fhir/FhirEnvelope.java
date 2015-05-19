package com.github.jlgrock.snp.core.domain.fhir;

/**
 * A simple wrapper class to manage multiple top-level xml elements.
 */
public class FhirEnvelope {
    private AdverseReaction adverseReaction;
    private Alert alert;
    private AllergyIntolerance allergyIntolerance;
    private CarePlan carePlan;
    private Composition composition;
    private ConceptMap conceptMap;
    private Condition condition;
    private Conformance conformance;
    private Device device;
    private DeviceObservationReport deviceObservationReport;
    private DiagnosticOrder diagnosticOrder;
    private DiagnosticReport diagnosticReport;
    private DocumentManifest documentManifest;
    private DocumentReference documentReference;
    private Encounter encounter;
    private FamilyHistory familyHistory;
    private Group group;
    private ImagingStudy imagingStudy;
    private Immunization immunization;
    private ImmunizationRecommendation immunizationRecommendation;
    private List list;
    private Location location;
    private Media media;
    private Medication medication;
    private MedicationAdministration medicationAdministration;
    private MedicationDispense medicationDispense;
    private MedicationPrescription medicationPrescription;
    private MedicationStatement medicationStatement;
    private MessageHeader messageHeader;
    private Observation observation;
    private OperationOutcome operationOutcome;
    private Order order;
    private OrderResponse orderResponse;
    private Organization organization;
    private Other other;
    private Patient patient;
    private Practitioner practitioner;
    private Procedure procedure;
    private Profile profile;
    private Provenance provenance;
    private Query query;
    private Questionnaire questionnaire;
    private RelatedPerson relatedPerson;
    private SecurityEvent securityEvent;
    private Specimen specimen;
    private Substance substance;
    private ValueSet valueSet;
    private Binary binary;

    FhirEnvelope(
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
}
