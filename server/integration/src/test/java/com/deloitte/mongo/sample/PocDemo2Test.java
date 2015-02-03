package com.deloitte.mongo.sample;

import com.deloitte.mongo.converters.EncounterReadConverter;
import com.deloitte.mongo.data.EncounterTags;
import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.Patient;
import com.deloitte.mongo.domain.primitives.PrimitiveType;
import com.deloitte.mongo.domain.primitives.SimplePrimitive;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

//import org.mockito.ArgumentMatcher;

public class PocDemo2Test extends Mockito {
	
	@Test
    public void testConvertDBObjectToEncounterObj() {
        DateTime date = new DateTime(99999l);
        Patient patient = mock(Patient.class);

        Observation observation1 = mock(Observation.class);
        Observation observation2 = mock(Observation.class);
        List<Observation> observations = new ArrayList() {{
            add(observation1);
            add(observation1);
            add(observation2);
        }};
        
        DBObject observation1Obj = mock(BasicDBObject.class);
        DBObject observation2Obj = mock(BasicDBObject.class);
        BasicDBList observationObjs = new BasicDBList() {{
            add(observation1Obj);
            add(observation1Obj);
            add(observation2Obj);
        }};

        DBObject dbObject = new BasicDBObject() {{
            put(EncounterTags.ID_TAG, 123l);
            put(EncounterTags.PATIENT_TAG, 456l);
            put(EncounterTags.DATE_TAG, date);
            put(EncounterTags.TYPE_TAG, 1);
            put(EncounterTags.REASON_FOR_VISIT_TAG, "hernia");
            put(EncounterTags.OBSERVATIONS_TAG, observationObjs);
        }};
     
        DBCursor dbCursor = mock(DBCursor.class);
        when(dbCursor.hasNext()).thenReturn(true, true, false);  //Return true first and second time, and false subsequently
        when(dbCursor.next()).thenReturn(dbObject);      

        PocDemo2 pocDemo2 = new PocDemo2(); //You can't mock the class under test?
        //It was seen that @Autowired encounterReadConverter was not automatically getting populated inside pocDemo2
        EncounterReadConverter encounterReadConverter = mock (EncounterReadConverter.class);
        Encounter encounter1 = mock (Encounter.class);
        Encounter encounter2 = mock (Encounter.class);
        //Mock the values for 2nd item in the list just so we can cross check them later
        when(encounter2.getId()).thenReturn(2L);
        when(encounter2.getDate()).thenReturn(date);
        when(encounter2.getPatient()).thenReturn(patient);
        when(encounter2.getReasonForVisit()).thenReturn("Mocked reason 2");
        when(encounter2.getType()).thenReturn(1);
        when(encounter2.getObservations()).thenReturn(observations);

        when(encounterReadConverter.convert(dbObject)).thenReturn(encounter1, encounter2); //Return encounter1 first time, and encounter2 subsequently
        //pocDemo2 did not have encounterReadConverter populated based on @Autowired tag. So, use mock object to populate it.        
        pocDemo2.encounterReadConverter = encounterReadConverter; //"new" was not possible
        
        List<Encounter> encounters = pocDemo2.convertDBObjectToJavaEncounterObj(dbCursor);
        //System.out.println("encounters[0] =" + encounters.get(0).getId() + " Reason for visit =" + encounters.get(0).getReasonForVisit());
        assertEquals(2, encounters.size() );  //Verify length of the list
        //Verify that the item in the list (in this case 2nd item) has proper values
        assertEquals((Long) 2l, encounters.get(1).getId());
        assertEquals(patient, encounters.get(1).getPatient());
        assertEquals(date, encounters.get(1).getDate());
        assertEquals((Integer) 1, encounters.get(1).getType());
        assertEquals("Mocked reason 2", encounters.get(1).getReasonForVisit());
        assertEquals(observations, encounters.get(1).getObservations());
    }
    
    @Test
    public void testQueryMethod() {
    	
    	PocDemo2 pocDemo2 = new PocDemo2(); //You can't mock the class under test?
        //It was seen that @Autowired encounterReadConverter was not automatically getting populated inside pocDemo2
        EncounterReadConverter encounterReadConverter = mock (EncounterReadConverter.class);
        //Encounter objects to mock the convert() method in encounterReadConverter class which would be invoked inside query
        /*
         Note that we generate 3 different Encounter objects for testing purpose. The first two Encounter objects are meant for 
         patient Id 10000001 to simulate left arm and right arm observations with disparity greater than 10. 
         The third Encounter object would be used as a proxy for all other other Encounter test data.
         */
        Encounter encounter1 = null; 
        Encounter encounter2 = null;
        Encounter encounter3 = null;
        
        try {
				encounter1 = generateMockEncounterData(1);
				encounter2 = generateMockEncounterData(2);
				encounter3 = generateMockEncounterData(3);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        //To mock convert() method on encounterReadConverter, with any parameter, one technique is to use anyObject() or any()
		when(encounterReadConverter.convert(anyObject())).thenReturn(encounter1, encounter2, encounter3, encounter1); //Return encounter1 first time, and encounter2 subsequently
        //when(encounterReadConverter.convert(any())).thenReturn(encounter1, encounter2, encounter3, encounter1); //Return encounter1 first time, and encounter2 subsequently
		pocDemo2.encounterReadConverter = encounterReadConverter;       
        
        pocDemo2.query();
    	
    }
    

	/**
	 * Generates Encounter object for testing. Note that the Encounter object for testing is 
	 * created using conventional way so that mocked convert() method generates full-fledged Encounter object with list of 
	 * observation objects as per the test data. Also note that the method generates 3 different Encounter objects depending 
	 * on the encounter object index parameter i. The first two Encounter objects are meant for patient Id 10000001 to 
	 * simulate left arm and right arm observations with disparity greater than 10. The third Encounter object would be used 
	 * as a proxy for any other Encounter.
	 * @param i - Simulated Encounter object index.
	 * @return
	 * @throws Exception
	 */
    private Encounter generateMockEncounterData (int i) throws Exception  {
    	Encounter encounter=null;
    	if (i==1) {
    		encounter = new Encounter();
    		encounter.setId(3049593922L);
    		Patient patient = new Patient();
    		patient.setId(10000001L);
    		encounter.setPatient(patient);
    		//String inputDateStr = "06/29/2014"; //"dd-MM-yyyy" or "dd/MM/yyyy"
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    		Date inputDate = dateFormat.parse("06/29/2014"); //inputDateStr
    		encounter.setDate(new DateTime());
    		encounter.setType(4);
    		encounter.setReasonForVisit("Emergency room visit for heart palpitations.");
    		
    		Observation observation1 = new Observation();
    		observation1.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930304L));
    		observation1.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 110L));
    		
    		Observation observation2 = new Observation();
    		observation2.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930310L));
    		observation2.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 145L));
    		
    		List<Observation> observations = new ArrayList<Observation>();
    		observations.add(observation1);
    		observations.add(observation2);
    		
    		encounter.setObservations(observations);
    	}
    	if (i==2) {
    		encounter = new Encounter();
    		encounter.setId(3049593923L);
    		Patient patient = new Patient();
    		patient.setId(10000001L);
    		encounter.setPatient(patient);
    		//String inputDateStr = "06/29/2014"; //"dd-MM-yyyy" or "dd/MM/yyyy"
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    		Date inputDate = dateFormat.parse("06/29/2014"); //inputDateStr
    		encounter.setDate(new DateTime());
    		encounter.setType(4);
    		encounter.setReasonForVisit("Emergency room visit for heart palpitations.");
    		
    		Observation observation1 = new Observation();
    		observation1.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930304L));
    		observation1.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 120L));
    		
    		Observation observation2 = new Observation();
    		observation2.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930307L));
    		observation2.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 80L));
    		
    		Observation observation3 = new Observation();
    		observation3.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930310L));
    		observation3.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 120L));
    		
    		Observation observation4 = new Observation();
    		observation4.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930313L));
    		observation4.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 80L));
    		
    		
    		List<Observation> observations = new ArrayList<Observation>();
    		observations.add(observation1);
    		observations.add(observation2);
    		observations.add(observation3);
    		observations.add(observation4);
    		
    		encounter.setObservations(observations);
    	}
    	if (i==3) {
    		encounter = new Encounter();
    		encounter.setId(3049593924L);
    		Patient patient = new Patient();
    		patient.setId(10000002L);
    		encounter.setPatient(patient);
    		//String inputDateStr = "06/29/2014"; //"dd-MM-yyyy" or "dd/MM/yyyy"
    		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    		Date inputDate = dateFormat.parse("01/17/2014"); //inputDateStr
    		encounter.setDate(new DateTime());
    		encounter.setType(4);
    		encounter.setReasonForVisit("Emergency room visit for heart palpitations.");
    		
    		Observation observation1 = new Observation();
    		observation1.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930304L));
    		observation1.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 165L));
    		
    		Observation observation2 = new Observation();
    		observation2.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930307L));
    		observation2.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 100L));
    		
    		Observation observation3 = new Observation();
    		observation3.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930310L));
    		observation3.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 100L));
    		
    		Observation observation4 = new Observation();
    		observation4.setName(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 5695930313L));
    		observation4.setValue(SimplePrimitive.createPrimitive (PrimitiveType.INTEGER.getId(), 50L));
    		
    		
    		List<Observation> observations = new ArrayList<Observation>();
    		observations.add(observation1);
    		observations.add(observation2);
    		observations.add(observation3);
    		observations.add(observation4);
    		
    		encounter.setObservations(observations);
    	}
    	return encounter;
    }


}
