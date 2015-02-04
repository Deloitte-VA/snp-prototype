package com.github.jlgrock.snp.converters;

import com.github.jlgrock.snp.data.PatientTags;
import com.github.jlgrock.snp.domain.Gender;
import com.github.jlgrock.snp.domain.Patient;
import com.github.jlgrock.snp.domain.Race;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Patient object.
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
        p.setDateOfBirth(new DateTime((Long) source.get(PatientTags.DATE_OF_BIRTH_TAG)));
        return p;
    }
}
