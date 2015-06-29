package com.github.jlgrock.snp.domain.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.domain.converters.PatientReadConverter;
import com.github.jlgrock.snp.domain.converters.PatientWriteConverter;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class executes queries against the Patient 
 * Collection within MongoDB. 
 */
@Service
public class PatientRepositoryImpl extends
        AbstractRepositoryImpl<Patient, ObjectId> implements PatientRepository {

    private final PatientReadConverter patientReadConverter;

    private final PatientWriteConverter patientWriteConverter;
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PatientRepositoryImpl.class);


	/**
	 * constructs PatientRepositoryImpl
	 * @param mongoDbFactoryIn MongoDbFactory
	 * @param patientReadConverterIn PatientReadConverter
	 * @param patientWriteConverterIn PatientWriteConverter
	 */
    @Inject
    public PatientRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
                                 final PatientReadConverter patientReadConverterIn,
                                 final PatientWriteConverter patientWriteConverterIn) {
        super(mongoDbFactoryIn);
        patientReadConverter = patientReadConverterIn;
        patientWriteConverter = patientWriteConverterIn;
    }

    @Override
    protected Patient convertToDomainObject(final Document dbObjectIn) {
    	LOGGER.trace("convertToDomainObject(Document dbObjectIn={})", dbObjectIn);
        if (dbObjectIn == null) {
            return null;
        }
        return patientReadConverter.convert(dbObjectIn);
    }
    
    @Override
    protected String getCollectionName() {
    	LOGGER.trace("getCollectionName()");
        return "patients";
    }
    
    @Override
    protected Document convertToDBObject(final Patient s) {
    	LOGGER.trace("convertToDBObject(Patient s={})", s);
        if (s == null) {
            return null;
        }
        return patientWriteConverter.convert(s);
    }

    @Override
    public List<Patient> findAllByLastName(final String lastName) {
    	LOGGER.trace("findAllByLastName(lastName={})", lastName);
        List<Patient> patientShell = new ArrayList<>();
    	if (lastName == null){
    		return patientShell;
    	}
        Document query = new Document() {{
            put(PatientTags.LAST_NAME_TAG, lastName);
        }};
        return executeQueryAndTransformResults(query);
    }
    
    @Override
    public List<Patient> findAllByFirstNameAndLastName(final String firstName, final String lastName) {
    	LOGGER.trace("findAllByFirstNameAndLastName(firstName={}, lastName={})", firstName, lastName);
        List<Patient> patientShell = new ArrayList<>();
        if (firstName == null || lastName == null){
    		return patientShell;
    	}
        Document query = new Document() {{
            put(PatientTags.FIRST_NAME_TAG, firstName);
            put(PatientTags.LAST_NAME_TAG, lastName);
        }};
        return executeQueryAndTransformResults(query);
    }
    
    @Override
    public List<Patient> findAllByDateOfBirth(final LocalDate dateOfBirth) {
    	LOGGER.trace("findAllByDateOfBirth(dateOfBirth={})", dateOfBirth);
        List<Patient> patientShell = new ArrayList<>();
        if (dateOfBirth == null){
    		return patientShell;
    	}
        Document query = new Document() {{
            put(PatientTags.DATE_OF_BIRTH_TAG, dateOfBirth);
        }};
        return executeQueryAndTransformResults(query);
    }
    
    @Override
    public List<Patient> findAllByGender(final Gender gender) {
    	LOGGER.trace("findAllByGender(gender={})", gender);
        List<Patient> patientShell = new ArrayList<>();
        if (gender == null){
    		return patientShell;
    	}
        Document query = new Document() {{
            put(PatientTags.GENDER_TAG, gender);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public Patient findOneByFhirId(final String fhirId) {
        LOGGER.trace("findOneByFhirId(fhirId={})", fhirId);
        if (fhirId == null){
            return null;
        }
        Document query = new Document() {{
            put(PatientTags.FHIR_ID_TAG, fhirId);
        }};
        List<Patient> x = executeQueryAndTransformResults(query);
        Patient returnVal = null;
        if (x.size() > 0) {
            returnVal = x.get(0);
        }
        return returnVal;
    }

}
