package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PatientTags;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.DBObject;

import javax.inject.Named;
import java.time.LocalDate;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Patient object.
 */
@Named
public class PatientReadConverter implements ReadConverter<DBObject, Patient> {

    @Override
    public Patient convert(final DBObject source) {
        Patient p = new Patient();
        p.setId(((Number) source.get(PatientTags.ID_TAG)).longValue());
        p.setFirstName((String) source.get(PatientTags.FIRST_NAME_TAG));
        p.setMiddleName((String) source.get(PatientTags.MIDDLE_NAME_TAG));
        p.setLastName((String) source.get(PatientTags.LAST_NAME_TAG));
        p.setGender(Gender.getValueById((Integer) source.get(PatientTags.GENDER_TAG)));
        p.setRace(Race.getValueById((Integer) source.get(PatientTags.RACE_TAG)));
        p.setDateOfBirth(LocalDate.ofEpochDay(((Number) source.get(PatientTags.DATE_OF_BIRTH_TAG)).longValue()));
        return p;
    }
}

