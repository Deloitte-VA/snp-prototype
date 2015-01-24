package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.PatientTags;
import com.deloitte.mongo.domain.Gender;
import com.deloitte.mongo.domain.Patient;
import com.deloitte.mongo.domain.Race;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public class PatientReadConverter implements Converter<DBObject, Patient> {

    public Patient convert(DBObject source) {
        Patient p = new Patient();
        p.setId((Long) source.get(PatientTags.ID_TAG));
        p.setFirstName((String) source.get(PatientTags.FIRST_NAME_TAG));
        p.setMiddleName((String) source.get(PatientTags.MIDDLE_NAME_TAG));
        p.setLastName((String) source.get(PatientTags.LAST_NAME_TAG));
        p.setGender(Gender.getValueById((Integer) source.get(PatientTags.GENDER_TAG)));
        p.setRace(Race.getValueById((Integer) source.get(PatientTags.RACE_TAG)));
        p.setDateOfBirth(new Date((Long) source.get(PatientTags.DATE_OF_BIRTH_TAG)));
        return p;
    }
}
