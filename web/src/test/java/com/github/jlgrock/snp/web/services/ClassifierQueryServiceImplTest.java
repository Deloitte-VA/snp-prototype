package com.github.jlgrock.snp.web.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.apis.classifier.ClassifierQuery;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;

public class ClassifierQueryServiceImplTest {

	@Mock
	private ClassifierQuery classifierQuery;

	@Mock
	private EncounterRepository encounterRepository;

	@Mock
	private PatientRepository patientRepository;

	@BeforeClass
	public void beforeClass() {
		// Required to make this work on TestNG
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Mockito.reset(classifierQuery);
		Mockito.reset(encounterRepository);
		Mockito.reset(patientRepository);
	}

	@SuppressWarnings("serial")
	@Test
	public void testExecuteKindOfQueryUUID() {
		UUID uuid = UUID.randomUUID();
		int[] queryResults = {456, 234};
		List<Integer> queryResultsList = new ArrayList<Integer>() {{add(456); add(234);}};
		
		// patient 1
		ObjectId patient1Id = new ObjectId();
		Patient patient1 = createPatient(patient1Id, "Joseph", "Smith", Gender.MALE);
		Encounter encounter1 = new Encounter();
		encounter1.setPatientId(patient1Id);
		
		// patient 2
		ObjectId patient2Id = new ObjectId();
		Patient patient2 = createPatient(patient2Id, "Brigham", "Young", Gender.MALE);
		Encounter encounter2 = new Encounter();
		encounter2.setPatientId(patient2Id);
		
		// patient 3
		ObjectId patient3Id = new ObjectId();
		Patient patient3 = createPatient(patient3Id, "Marie", "Osmond", Gender.FEMALE);
		
		List<Encounter> encounterList = new ArrayList<Encounter>() {{add(encounter1); add(encounter2);}};
		
		Mockito.when(classifierQuery.query(uuid)).thenReturn(queryResults);
		Mockito.when(encounterRepository.findByPceIdList(queryResultsList)).thenReturn(encounterList);
		Mockito.when(patientRepository.findOneById(patient1Id)).thenReturn(patient1);
		Mockito.when(patientRepository.findOneById(patient2Id)).thenReturn(patient2);
		Mockito.when(patientRepository.findOneById(patient3Id)).thenReturn(patient3);
		
		Set<Patient> patientExpected = new HashSet<Patient>() {{add(patient1); add(patient2);}};
		
		ClassifierQueryServiceImpl classifierQuerySvc = new ClassifierQueryServiceImpl(
				classifierQuery, encounterRepository,
				patientRepository);
		Set<Patient> patientActual = classifierQuerySvc.executeKindOfQuery(uuid);
		Assert.assertEquals(patientExpected, patientActual);
		Mockito.verify(classifierQuery).query(uuid);
		Mockito.verify(encounterRepository).findByPceIdList(queryResultsList);
		Mockito.verify(patientRepository, Mockito.never()).findOneById(patient3Id);
	}

	@SuppressWarnings("serial")
	@Test
	public void testExecuteKindOfQuerySctid() {
		String sctid = "444794000";
		int[] queryResults = {456, 234};
		List<Integer> queryResultsList = new ArrayList<Integer>() {{add(456); add(234);}};
		
		// patient 1
		ObjectId patient1Id = new ObjectId();
		Patient patient1 = createPatient(patient1Id, "Joseph", "Smith", Gender.MALE);
		Encounter encounter1 = new Encounter();
		encounter1.setPatientId(patient1Id);
		
		// patient 2
		ObjectId patient2Id = new ObjectId();
		Patient patient2 = createPatient(patient2Id, "Brigham", "Young", Gender.MALE);
		Encounter encounter2 = new Encounter();
		encounter2.setPatientId(patient2Id);
		
		// patient 3
		ObjectId patient3Id = new ObjectId();
		Patient patient3 = createPatient(patient3Id, "Marie", "Osmond", Gender.FEMALE);
		
		List<Encounter> encounterList = new ArrayList<Encounter>() {{add(encounter1); add(encounter2);}};
		
		Mockito.when(classifierQuery.query(sctid)).thenReturn(queryResults);
		Mockito.when(encounterRepository.findByPceIdList(queryResultsList)).thenReturn(encounterList);
		Mockito.when(patientRepository.findOneById(patient1Id)).thenReturn(patient1);
		Mockito.when(patientRepository.findOneById(patient2Id)).thenReturn(patient2);
		Mockito.when(patientRepository.findOneById(patient3Id)).thenReturn(patient3);
		
		Set<Patient> patientExpected = new HashSet<Patient>() {{add(patient1); add(patient2);}};
		
		ClassifierQueryServiceImpl classifierQuerySvc = new ClassifierQueryServiceImpl(
				classifierQuery, encounterRepository,
				patientRepository);
		Set<Patient> patientActual = classifierQuerySvc.executeKindOfQuery(sctid);
		Assert.assertEquals(patientExpected, patientActual);
		Mockito.verify(classifierQuery).query(sctid);
		Mockito.verify(encounterRepository).findByPceIdList(queryResultsList);
		Mockito.verify(patientRepository, Mockito.never()).findOneById(patient3Id);
	}

	@Test
	public void testExecuteKindOfQueryLogicGraph() {
//		TODO: logic graph query not implemented
//		throw new RuntimeException("Test not implemented");
	}

	@SuppressWarnings("serial")
	@Test
	public void testExecuteKindOfQueryNid() {
		int nid = 100;
		int[] queryResults = {456, 234};
		List<Integer> queryResultsList = new ArrayList<Integer>() {{add(456); add(234);}};
		
		// patient 1
		ObjectId patient1Id = new ObjectId();
		Patient patient1 = createPatient(patient1Id, "Joseph", "Smith", Gender.MALE);
		Encounter encounter1 = new Encounter();
		encounter1.setPatientId(patient1Id);
		
		// patient 2
		ObjectId patient2Id = new ObjectId();
		Patient patient2 = createPatient(patient2Id, "Brigham", "Young", Gender.MALE);
		Encounter encounter2 = new Encounter();
		encounter2.setPatientId(patient2Id);
		
		// patient 3
		ObjectId patient3Id = new ObjectId();
		Patient patient3 = createPatient(patient3Id, "Marie", "Osmond", Gender.FEMALE);
		
		List<Encounter> encounterList = new ArrayList<Encounter>() {{add(encounter1); add(encounter2);}};
		
		Mockito.when(classifierQuery.query(nid)).thenReturn(queryResults);
		Mockito.when(encounterRepository.findByPceIdList(queryResultsList)).thenReturn(encounterList);
		Mockito.when(patientRepository.findOneById(patient1Id)).thenReturn(patient1);
		Mockito.when(patientRepository.findOneById(patient2Id)).thenReturn(patient2);
		Mockito.when(patientRepository.findOneById(patient3Id)).thenReturn(patient3);
		
		Set<Patient> patientExpected = new HashSet<Patient>() {{add(patient1); add(patient2);}};
		
		ClassifierQueryServiceImpl classifierQuerySvc = new ClassifierQueryServiceImpl(
				classifierQuery, encounterRepository,
				patientRepository);
		Set<Patient> patientActual = classifierQuerySvc.executeKindOfQuery(nid);
		Assert.assertEquals(patientExpected, patientActual);
		Mockito.verify(classifierQuery).query(nid);
		Mockito.verify(encounterRepository).findByPceIdList(queryResultsList);
		Mockito.verify(patientRepository, Mockito.never()).findOneById(patient3Id);
	}

	@SuppressWarnings("serial")
	@Test
	public void testExecuteKindOfQueryObservableNidProvenanceNidValueNid() {
		int obsNid = 100;
		int provNid = 200;
		int valueNid = 300;
		int[] queryObsResults = {456, 234};
		int[] queryProvResults = {765};
		int[] queryValueResults = {300};
		List<Integer> queryObsResultsList = new ArrayList<Integer>() {{add(456); add(234);}};
		List<Integer> queryProvResultsList = new ArrayList<Integer>() {{add(765);}};
		List<Integer> queryValueResultsList = new ArrayList<Integer>() {{add(300);}};
		
		// patient 1
		ObjectId patient1Id = new ObjectId();
		Patient patient1 = createPatient(patient1Id, "Joseph", "Smith", Gender.MALE);
		Encounter encounter1 = new Encounter();
		encounter1.setPatientId(patient1Id);
		
		// patient 2
		ObjectId patient2Id = new ObjectId();
		Patient patient2 = createPatient(patient2Id, "Brigham", "Young", Gender.MALE);
		Encounter encounter2 = new Encounter();
		encounter2.setPatientId(patient2Id);
		
		// patient 3
		ObjectId patient3Id = new ObjectId();
		Patient patient3 = createPatient(patient3Id, "Marie", "Osmond", Gender.FEMALE);
		Encounter encounter3 = new Encounter();
		encounter3.setPatientId(patient3Id);
		
		List<Encounter> encounterList = new ArrayList<Encounter>() {{add(encounter1); add(encounter2);}};
		
		Mockito.when(classifierQuery.query(obsNid)).thenReturn(queryObsResults);
		Mockito.when(classifierQuery.query(provNid)).thenReturn(queryProvResults);
		Mockito.when(classifierQuery.query(valueNid)).thenReturn(queryValueResults);
		Mockito.when(encounterRepository.findByObservableIdListAndProvenanceIdListAndValueIdList(queryObsResultsList, queryProvResultsList, queryValueResultsList)).thenReturn(encounterList);
		Mockito.when(patientRepository.findOneById(patient1Id)).thenReturn(patient1);
		Mockito.when(patientRepository.findOneById(patient2Id)).thenReturn(patient2);
		Mockito.when(patientRepository.findOneById(patient3Id)).thenReturn(patient3);
		
		Set<Patient> patientExpected = new HashSet<Patient>() {{add(patient1); add(patient2);}};
		
		ClassifierQueryServiceImpl classifierQuerySvc = new ClassifierQueryServiceImpl(
				classifierQuery, encounterRepository,
				patientRepository);
		Set<Patient> patientActual = classifierQuerySvc.executeKindOfQuery(obsNid, provNid, valueNid);
		Assert.assertEquals(patientExpected, patientActual);
		Mockito.verify(classifierQuery).query(obsNid);
		Mockito.verify(classifierQuery).query(provNid);
		Mockito.verify(classifierQuery).query(valueNid);
		Mockito.verify(encounterRepository).findByObservableIdListAndProvenanceIdListAndValueIdList(queryObsResultsList, queryProvResultsList, queryValueResultsList);
		Mockito.verify(patientRepository, Mockito.never()).findOneById(patient3Id);
	}
	
	private Patient createPatient(ObjectId objectId, String fName, String lName, Gender gender) {
		Patient patient = new Patient();
		patient.setId(objectId);
		patient.setFirstName(fName);
		patient.setLastName(lName);
		patient.setGender(gender);
		
		return patient;
	}
}
