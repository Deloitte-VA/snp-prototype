package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class executes queries against the Patient 
 * Collection within MongoDB. 
 */
@Service
public class PatientRepositoryImpl extends
		AbstractRepositoryImpl<Patient, Long> implements PatientRepository {

	private final PatientReadConverter patientReadConverter;

	private final PatientWriteConverter patientWriteConverter;

	/**
	 * constructs PatientRepositoryImpl
	 * @param mongoDbFactoryIn MongoDbFactory
	 * @param patientReadConverterIn PatientReadConverter
	 * @param patientWriteConverterIn PatientWriteConverter
	 */
	@Inject
	protected PatientRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
									final PatientReadConverter patientReadConverterIn,
									final PatientWriteConverter patientWriteConverterIn) {
		super(mongoDbFactoryIn);
		patientReadConverter = patientReadConverterIn;
		patientWriteConverter = patientWriteConverterIn;
	}

	@Override
	protected Patient convertToDomainObject(final DBObject dbObjectin) {
		if (dbObjectin == null){return null;}
		else{
		return patientReadConverter.convert(dbObjectin);
		}
	}

	@Override
	protected String getCollectionName() {
		return "patients";
	}

	@Override
	protected DBObject convertToDBObject(final Patient s) {
		if(s == null){return null;}
		else{
		return patientWriteConverter.convert(s);
		}
	}
	
	@Override
	public List<Patient> findAllByLastName(final String lastName) {
		List<Patient> pList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("lastName", lastName);
		}};
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertToDomainObject(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByFirstNameAndLastName(final String firstName,
			final String lastName) {
		List<Patient> pList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("firstName", firstName);
			put("lastName", lastName);
		}};

		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertToDomainObject(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByDateOfBirth(final Date dateOfBirth) {
		List<Patient> pList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("dateOfBirth", dateOfBirth);
		}};
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertToDomainObject(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByGender(final Gender gender) {
		List<Patient> pList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("gender", gender);
		}};

		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertToDomainObject(o));
		}
		return pList;
	}

	@Override
	public List<Patient> findAllByRace(final Race race) {
		List<Patient> pList = new ArrayList<>();
		DBCollection dbc1 = dBCollection();
		BasicDBObject query = new BasicDBObject() {{
			put("race", race);
		}};
		DBCursor x = dbc1.find(query);
		for (DBObject o : x) {
			pList.add(convertToDomainObject(o));
		}
		return pList;
	}

}
