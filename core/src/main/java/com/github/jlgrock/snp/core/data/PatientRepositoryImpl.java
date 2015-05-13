package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.PatientReadConverter;
import com.github.jlgrock.snp.core.converters.PatientWriteConverter;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;

import org.bson.Document;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Service
public class PatientRepositoryImpl extends
        AbstractRepositoryImpl<Patient, Long> implements PatientRepository {

    private final PatientReadConverter patientReadConverter;

    private final PatientWriteConverter patientWriteConverter;
    
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PatientRepositoryImpl.class);
    
    List<Patient> patientShell = new ArrayList<>(6);

    @Inject
    public PatientRepositoryImpl(final MongoDbFactory mongoDbFactoryIn,
                                 final PatientReadConverter patientReadConverterIn,
                                 final PatientWriteConverter patientWriteConverterIn) {
        super(mongoDbFactoryIn);
        patientReadConverter = patientReadConverterIn;
        patientWriteConverter = patientWriteConverterIn;
    }

    @Override
    protected Patient convertToDomainObject(final Document dbObjectin) {
    	LOGGER.trace("convertToDomainObject(Document dbObjectin=" + dbObjectin + ")");
        if (dbObjectin == null) {
            return null;
        }
        return patientReadConverter.convert(dbObjectin);
    }

    @Override
    protected String getCollectionName() {
    	LOGGER.trace("getCollectionName()");
        return "patients";
    }

    @Override
    protected Document convertToDBObject(final Patient s) {
    	LOGGER.trace("convertToDBObject(Patient s=" + s + ")");
        if (s == null) {
            return null;
        }
        return patientWriteConverter.convert(s);
    }


    @Override
    public List<Patient> findAllByLastName(String lastName) {
    	if (lastName == null){
    		return patientShell;
    	}
    	LOGGER.trace("findAllByLastName(lastName=" + lastName + ")");
        Document query = new Document() {{
            put("lastName", lastName);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public List<Patient> findAllByFirstNameAndLastName(final String firstName, final String lastName) {
    	if (firstName == null || lastName == null){
    		return patientShell;
    	}
    	LOGGER.trace("findAllByFirstNameAndLastName(firstName=" + firstName + ", lastName=" + lastName + ")");
        Document query = new Document() {{
            put("firstName", firstName);
            put("lastName", lastName);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public List<Patient> findAllByDateOfBirth(final LocalDate dateOfBirth) {
    	if (dateOfBirth == null){
    		return patientShell;
    	}
    	LOGGER.trace("findAllByDateOfBirth(dateOfBirth=" + dateOfBirth + ")");
        Document query = new Document() {{
            put("dateOfBirth", dateOfBirth);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public List<Patient> findAllByGender(final Gender gender) {
    	if (gender == null){
    		return patientShell;
    	}
    	LOGGER.trace("findAllByGender(gender=" + gender + ")");
        Document query = new Document() {{
            put("gender", gender);
        }};
        return executeQueryAndTransformResults(query);
    }

    @Override
    public List<Patient> findAllByRace(final Race race) {
    	if (race == null){
    		return patientShell;
    	}
    	LOGGER.trace("findAllByRace(race=" + race + ")");
        Document query = new Document() {{
            put("race", race);
        }};
        return executeQueryAndTransformResults(query);
    }

}
