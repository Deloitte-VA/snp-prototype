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
import org.glassfish.hk2.api.IterableProvider;
import org.glassfish.hk2.api.ServiceHandle;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 */
public class FhirElementProcessorFactoryImplTest {
    private AdverseReaction adverseReaction = new AdverseReaction();
    private Alert alert = new Alert();
    private AllergyIntolerance allergyIntolerance = new AllergyIntolerance();
    private Binary binary = new Binary();
    private CarePlan carePlan = new CarePlan();
    private Composition composition = new Composition();
    private ConceptMap conceptMap = new ConceptMap();
    private Condition condition = new Condition();
    private Conformance conformance = new Conformance();
    private DeviceObservationReport deviceObservationReport = new DeviceObservationReport();
    private Device device = new Device();
    private DiagnosticOrder diagnosticOrder = new DiagnosticOrder();
    private DiagnosticReport diagnosticReport = new DiagnosticReport();
    private DocumentManifest documentManifest = new DocumentManifest();
    private Encounter encounter = new Encounter();
    private FamilyHistory familyHistory = new FamilyHistory();
    private Group group = new Group();
    private ImagingStudy imagingStudy = new ImagingStudy();
    private Immunization immunization = new Immunization();
    private ImmunizationRecommendation immunizationRecommendation = new ImmunizationRecommendation();
    private List list = new List();
    private Location location = new Location();
    private Media media = new Media();
    private MedicationAdministration medicationAdministration = new MedicationAdministration();
    private MedicationDispense medicationDispense = new MedicationDispense();
    private MedicationPrescription medicationPrescription = new MedicationPrescription();
    private Medication medication = new Medication();
    private MedicationStatement medicationStatement = new MedicationStatement();
    private MessageHeader messageHeader = new MessageHeader();
    private Observation observation = new Observation();
    private OperationOutcome operationOutcome = new OperationOutcome();
    private Order order = new Order();
    private OrderResponse orderResponse = new OrderResponse();
    private Organization orgazation = new Organization();
    private Other other = new Other();
    private Patient patient = new Patient();
    private Practitioner practitioner = new Practitioner();
    private Procedure procedure = new Procedure();
    private Profile profile = new Profile();
    private Provenance provenance = new Provenance();
    private Query query = new Query();
    private Questionnaire questionnaire = new Questionnaire();
    private RelatedPerson relatedPerson = new RelatedPerson();
    private SecurityEvent securityEvent = new SecurityEvent();
    private Specimen specimen = new Specimen();
    private Substance substance = new Substance();
    private ValueSet valueSet = new ValueSet();

    private AdverseReactionProcessor adverseReactionProcessor = Mockito.mock(AdverseReactionProcessor.class);
    private AlertProcessor alertProcessor = Mockito.mock(AlertProcessor.class);
    private AllergyIntoleranceProcessor allergyIntoleranceProcessor = Mockito.mock(AllergyIntoleranceProcessor.class);
    private BinaryProcessor binaryProcessor = Mockito.mock(BinaryProcessor.class);
    private CarePlanProcessor carePlanProcessor = Mockito.mock(CarePlanProcessor.class);
    private CompositionProcessor compositionProcessor = Mockito.mock(CompositionProcessor.class);
    private ConceptMapProcessor conceptMapProcessor = Mockito.mock(ConceptMapProcessor.class);
    private ConditionProcessor conditionProcessor = Mockito.mock(ConditionProcessor.class);
    private ConformanceProcessor conformanceProcessor = Mockito.mock(ConformanceProcessor.class);
    private DeviceObservationReportProcessor deviceObservationReportProcessor = Mockito.mock(DeviceObservationReportProcessor.class);
    private DeviceProcessor deviceProcessor = Mockito.mock(DeviceProcessor.class);
    private DiagnosticOrderProcessor diagnosticOrderProcessor = Mockito.mock(DiagnosticOrderProcessor.class);
    private DiagnosticReportProcessor diagnosticReportProcessor = Mockito.mock(DiagnosticReportProcessor.class);
    private DocumentManifestProcessor documentManifestProcessor = Mockito.mock(DocumentManifestProcessor.class);
    private EncounterProcessor encounterProcessor = Mockito.mock(EncounterProcessor.class);
    private FamilyHistoryProcessor familyHistoryProcessor = Mockito.mock(FamilyHistoryProcessor.class);
    private GroupProcessor groupProcessor = Mockito.mock(GroupProcessor.class);
    private ImagingStudyProcessor imagingStudyProcessor = Mockito.mock(ImagingStudyProcessor.class);
    private ImmunizationProcessor immunizationProcessor = Mockito.mock(ImmunizationProcessor.class);
    private ImmunizationRecommendationProcessor immunizationRecommendationProcessor = Mockito.mock(ImmunizationRecommendationProcessor.class);
    private ListProcessor listProcessor = Mockito.mock(ListProcessor.class);
    private LocationProcessor locationProcessor = Mockito.mock(LocationProcessor.class);
    private MediaProcessor mediaProcessor = Mockito.mock(MediaProcessor.class);
    private MedicationAdministrationProcessor medicationAdministrationProcessor = Mockito.mock(MedicationAdministrationProcessor.class);
    private MedicationDispenseProcessor medicationDispenseProcessor = Mockito.mock(MedicationDispenseProcessor.class);
    private MedicationPrescriptionProcessor medicationPrescriptionProcessor = Mockito.mock(MedicationPrescriptionProcessor.class);
    private MedicationProcessor medicationProcessor = Mockito.mock(MedicationProcessor.class);
    private MedicationStatementProcessor medicationStatementProcessor = Mockito.mock(MedicationStatementProcessor.class);
    private MessageHeaderProcessor messageHeaderProcessor = Mockito.mock(MessageHeaderProcessor.class);
    private ObservationProcessor observationProcessor = Mockito.mock(ObservationProcessor.class);
    private OperationOutcomeProcessor operationOutcomeProcessor = Mockito.mock(OperationOutcomeProcessor.class);
    private OrderProcessor orderProcessor = Mockito.mock(OrderProcessor.class);
    private OrderResponseProcessor orderResponseProcessor = Mockito.mock(OrderResponseProcessor.class);
    private OrganizationProcessor organizationProcessor = Mockito.mock(OrganizationProcessor.class);
    private OtherProcessor otherProcessor = Mockito.mock(OtherProcessor.class);
    private PatientProcessor patientProcessor = Mockito.mock(PatientProcessor.class);
    private PractitionerProcessor practitionerProcessor = Mockito.mock(PractitionerProcessor.class);
    private ProcedureProcessor procedureProcessor = Mockito.mock(ProcedureProcessor.class);
    private ProfileProcessor profileProcessor = Mockito.mock(ProfileProcessor.class);
    private ProvenanceProcessor provenanceProcessor = Mockito.mock(ProvenanceProcessor.class);
    private QueryProcessor queryProcessor = Mockito.mock(QueryProcessor.class);
    private QuestionnaireProcessor questionnaireProcessor = Mockito.mock(QuestionnaireProcessor.class);
    private RelatedPersonProcessor relatedPersonProcessor = Mockito.mock(RelatedPersonProcessor.class);
    private SecurityEventProcessor securityEventProcessor = Mockito.mock(SecurityEventProcessor.class);
    private SpecimenProcessor specimenProcessor = Mockito.mock(SpecimenProcessor.class);
    private SubstanceProcessor substanceProcessor = Mockito.mock(SubstanceProcessor.class);
    private ValueSetProcessor valueSetProcessor = Mockito.mock(ValueSetProcessor.class);

    Collection<FhirElementProcessorService> processorCollection;

    class IterableProviderObjectList implements IterableProvider<FhirElementProcessorService> {

        private Collection coll;

        IterableProviderObjectList(final Collection<FhirElementProcessorService> processorCollectionIn) {
            coll = processorCollectionIn;
        }

        @Override
        public FhirElementProcessorService get() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterator iterator() {
            return coll.iterator();
        }

        @Override
        public ServiceHandle getHandle() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int getSize() {
            return coll.size();
        }

        @Override
        public IterableProvider named(String s) {
            throw new UnsupportedOperationException();
        }

        @Override
        public IterableProvider qualifiedWith(Annotation... annotations) {
            throw new UnsupportedOperationException();
        }

        @Override
        public Iterable<ServiceHandle<FhirElementProcessorService>> handleIterator() {
            throw new UnsupportedOperationException();
        }

        @Override
        public IterableProvider<?> ofType(java.lang.reflect.Type type) {
            throw new UnsupportedOperationException();
        }
    }

    @BeforeClass
    void setup() {
        Mockito.when(adverseReactionProcessor.processesType()).thenReturn(AdverseReaction.class);
        Mockito.when(alertProcessor.processesType()).thenReturn(Alert.class);
        Mockito.when(allergyIntoleranceProcessor.processesType()).thenReturn(AllergyIntolerance.class);
        Mockito.when(binaryProcessor.processesType()).thenReturn(Binary.class);
        Mockito.when(carePlanProcessor.processesType()).thenReturn(CarePlan.class);
        Mockito.when(compositionProcessor.processesType()).thenReturn(Composition.class);
        Mockito.when(conceptMapProcessor.processesType()).thenReturn(ConceptMap.class);
        Mockito.when(conditionProcessor.processesType()).thenReturn(Condition.class);
        Mockito.when(conformanceProcessor.processesType()).thenReturn(Conformance.class);
        Mockito.when(deviceObservationReportProcessor.processesType()).thenReturn(DeviceObservationReport.class);
        Mockito.when(deviceProcessor.processesType()).thenReturn(Device.class);
        Mockito.when(diagnosticOrderProcessor.processesType()).thenReturn(DiagnosticOrder.class);
        Mockito.when(diagnosticReportProcessor.processesType()).thenReturn(DiagnosticReport.class);
        Mockito.when(documentManifestProcessor.processesType()).thenReturn(DocumentManifest.class);
        Mockito.when(encounterProcessor.processesType()).thenReturn(Encounter.class);
        Mockito.when(familyHistoryProcessor.processesType()).thenReturn(FamilyHistory.class);
        Mockito.when(groupProcessor.processesType()).thenReturn(Group.class);
        Mockito.when(imagingStudyProcessor.processesType()).thenReturn(ImagingStudy.class);
        Mockito.when(immunizationProcessor.processesType()).thenReturn(Immunization.class);
        Mockito.when(immunizationRecommendationProcessor.processesType()).thenReturn(ImmunizationRecommendation.class);
        Mockito.when(listProcessor.processesType()).thenReturn(List.class);
        Mockito.when(locationProcessor.processesType()).thenReturn(Location.class);
        Mockito.when(locationProcessor.processesType()).thenReturn(Location.class);
        Mockito.when(mediaProcessor.processesType()).thenReturn(Media.class);
        Mockito.when(medicationAdministrationProcessor.processesType()).thenReturn(MedicationAdministration.class);
        Mockito.when(medicationDispenseProcessor.processesType()).thenReturn(MedicationDispense.class);
        Mockito.when(medicationPrescriptionProcessor.processesType()).thenReturn(MedicationPrescription.class);
        Mockito.when(medicationProcessor.processesType()).thenReturn(Medication.class);
        Mockito.when(medicationStatementProcessor.processesType()).thenReturn(MedicationStatement.class);
        Mockito.when(messageHeaderProcessor.processesType()).thenReturn(MessageHeader.class);
        Mockito.when(observationProcessor.processesType()).thenReturn(Observation.class);
        Mockito.when(operationOutcomeProcessor.processesType()).thenReturn(OperationOutcome.class);
        Mockito.when(orderProcessor.processesType()).thenReturn(Order.class);
        Mockito.when(orderResponseProcessor.processesType()).thenReturn(OrderResponse.class);
        Mockito.when(organizationProcessor.processesType()).thenReturn(Organization.class);
        Mockito.when(otherProcessor.processesType()).thenReturn(Other.class);
        Mockito.when(patientProcessor.processesType()).thenReturn(Patient.class);
        Mockito.when(practitionerProcessor.processesType()).thenReturn(Practitioner.class);
        Mockito.when(procedureProcessor.processesType()).thenReturn(Procedure.class);
        Mockito.when(profileProcessor.processesType()).thenReturn(Profile.class);
        Mockito.when(provenanceProcessor.processesType()).thenReturn(Provenance.class);
        Mockito.when(queryProcessor.processesType()).thenReturn(Query.class);
        Mockito.when(questionnaireProcessor.processesType()).thenReturn(Questionnaire.class);
        Mockito.when(relatedPersonProcessor.processesType()).thenReturn(RelatedPerson.class);
        Mockito.when(securityEventProcessor.processesType()).thenReturn(SecurityEvent.class);
        Mockito.when(specimenProcessor.processesType()).thenReturn(Specimen.class);
        Mockito.when(substanceProcessor.processesType()).thenReturn(Substance.class);
        Mockito.when(valueSetProcessor.processesType()).thenReturn(ValueSet.class);


        processorCollection = new ArrayList<>();
        processorCollection.add(adverseReactionProcessor);
        processorCollection.add(alertProcessor);
        processorCollection.add(allergyIntoleranceProcessor);
        processorCollection.add(binaryProcessor);
        processorCollection.add(carePlanProcessor);
        processorCollection.add(compositionProcessor);
        processorCollection.add(conceptMapProcessor);
        processorCollection.add(conditionProcessor);
        processorCollection.add(conformanceProcessor);
        processorCollection.add(deviceObservationReportProcessor);
        processorCollection.add(deviceProcessor);
        processorCollection.add(diagnosticOrderProcessor);
        processorCollection.add(diagnosticReportProcessor);
        processorCollection.add(documentManifestProcessor);
        processorCollection.add(encounterProcessor);
        processorCollection.add(familyHistoryProcessor);
        processorCollection.add(groupProcessor);
        processorCollection.add(imagingStudyProcessor);
        processorCollection.add(immunizationProcessor);
        processorCollection.add(immunizationRecommendationProcessor);
        processorCollection.add(listProcessor);
        processorCollection.add(locationProcessor);
        processorCollection.add(mediaProcessor);
        processorCollection.add(medicationAdministrationProcessor);
        processorCollection.add(medicationDispenseProcessor);
        processorCollection.add(medicationPrescriptionProcessor);
        processorCollection.add(medicationProcessor);
        processorCollection.add(medicationStatementProcessor);
        processorCollection.add(messageHeaderProcessor);
        processorCollection.add(observationProcessor);
        processorCollection.add(operationOutcomeProcessor);
        processorCollection.add(orderProcessor);
        processorCollection.add(orderResponseProcessor);
        processorCollection.add(organizationProcessor);
        processorCollection.add(otherProcessor);
        processorCollection.add(patientProcessor);
        processorCollection.add(practitionerProcessor);
        processorCollection.add(procedureProcessor);
        processorCollection.add(profileProcessor);
        processorCollection.add(provenanceProcessor);
        processorCollection.add(queryProcessor);
        processorCollection.add(questionnaireProcessor);
        processorCollection.add(relatedPersonProcessor);
        processorCollection.add(securityEventProcessor);
        processorCollection.add(specimenProcessor);
        processorCollection.add(substanceProcessor);
        processorCollection.add(valueSetProcessor);

    }

    @Test
    public void factoryTest() throws ClassifierException {
        IterableProvider<FhirElementProcessorService> iterableProvider =
                new IterableProviderObjectList(processorCollection);
        FhirElementProcessorFactory legoElementProcessorFactory =
                new FhirElementProcessorFactoryImpl(iterableProvider);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(adverseReaction), adverseReactionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(alert), alertProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(allergyIntolerance), allergyIntoleranceProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(binary), binaryProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(carePlan), carePlanProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(composition), compositionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(conceptMap), conceptMapProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(conceptMap), conceptMapProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(condition), conditionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(conformance), conformanceProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(deviceObservationReport), deviceObservationReportProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(device), deviceProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(diagnosticOrder), diagnosticOrderProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(diagnosticReport), diagnosticReportProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(documentManifest), documentManifestProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(encounter), encounterProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(familyHistory), familyHistoryProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(group), groupProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(imagingStudy), imagingStudyProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(immunization), immunizationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(immunizationRecommendation), immunizationRecommendationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(list), listProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(location), locationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(media), mediaProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medicationAdministration), medicationAdministrationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medicationDispense), medicationDispenseProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medicationDispense), medicationDispenseProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medicationPrescription), medicationPrescriptionProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medication), medicationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(medicationStatement), medicationStatementProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(messageHeader), messageHeaderProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(observation), observationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(operationOutcome), operationOutcomeProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(order), orderProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(orderResponse), orderResponseProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(orgazation), organizationProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(other), otherProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(patient), patientProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(practitioner), practitionerProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(procedure), procedureProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(profile), profileProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(provenance), provenanceProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(query), queryProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(questionnaire), questionnaireProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(relatedPerson), relatedPersonProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(securityEvent), securityEventProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(specimen), specimenProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(substance), substanceProcessor);
        Assert.assertEquals(legoElementProcessorFactory.findProcessingService(valueSet), valueSetProcessor);
    }

    @Test(expectedExceptions = ClassifierException.class)
    public void factoryFailureTest() throws ClassifierException {
        IterableProvider<FhirElementProcessorService> iterableProvider =
                new IterableProviderObjectList(processorCollection);
        FhirElementProcessorFactory legoElementProcessorFactory =
                new FhirElementProcessorFactoryImpl(iterableProvider);
        legoElementProcessorFactory.findProcessingService(new Object());
    }
}
