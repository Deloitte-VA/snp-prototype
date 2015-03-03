package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PatientTags;
import com.github.jlgrock.snp.core.domain.Gender;
import com.github.jlgrock.snp.core.domain.Patient;
import com.github.jlgrock.snp.core.domain.Race;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Patient object.
 */
@ReadingConverter
public class PatientReadConverter implements Converter<DBObject, Patient> {

    @Override
    public Patient convert(final DBObject source) {
        Patient p = new Patient();
        p.setId(((Number) source.get(PatientTags.ID_TAG)).longValue());
        p.setFirstName((String) source.get(PatientTags.FIRST_NAME_TAG));
        p.setMiddleName((String) source.get(PatientTags.MIDDLE_NAME_TAG));
        p.setLastName((String) source.get(PatientTags.LAST_NAME_TAG));
        p.setGender(Gender.getValueById((Integer) source.get(PatientTags.GENDER_TAG)));
        p.setRace(Race.getValueById((Integer) source.get(PatientTags.RACE_TAG)));
        p.setDateOfBirth(new DateTime(((Number) source.get(PatientTags.DATE_OF_BIRTH_TAG)).longValue()));
        return p;
    }
}

