package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.EncounterReadConverter;
import com.github.jlgrock.snp.core.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
public class PatientRepositoryImpl extends
		AbstractRepositoryImpl<Patient, Long> implements PatientRepository {

	protected PatientRepositoryImpl(MongoDbFactory mongoDbFactoryIn) {
		mongoDbFactory = mongoDbFactoryIn;
	}


	
	private final PatientReadConverter patientReadConverter;
	
	private final PatientWriteConverter patientWriteConverter;

	@Override
	protected Patient convertCollection(DBObject dbObjectin) {
		
		Patient patient = patientReadConverter.convert(dbObjectin);
		return patient;
		
	}

	@Override
	protected DBObject convertToDBObject(Patient s) {
		
		DBObject dBObject = patientWriteConverter.convert(s);
		return dBObject;
		
	}
	
	@Override
	public List<Patient> findAllByLastName(String lastName) {

		List<Patient> pList = new ArrayList<Patient>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Patient.lastName", lastName);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertCollection(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByFirstNameAndLastName(String firstName,
			String lastName) {
		List<Patient> pList = new ArrayList<Patient>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Patient.firstName", firstName)
				.append("Patient.lastName", lastName);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertCollection(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByDateOfBirth(Date dateOfBirth) {
		List<Patient> pList = new ArrayList<Patient>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Patient.dateOfBirth",
				dateOfBirth);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertCollection(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByGender(Gender gender) {
		List<Patient> pList = new ArrayList<Patient>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Patient.gender", gender);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertCollection(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByRace(Race race) {
		List<Patient> pList = new ArrayList<Patient>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject("Patient.race", race);
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertCollection(o));
		}
		return pList;
	}

	@Override
	protected String getCollection() {
		// TODO Auto-generated method stub
		return null;
	}

}
