package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.types.Gender;
import com.github.jlgrock.snp.domain.types.Patient;
import com.github.jlgrock.snp.domain.types.Race;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;
import java.time.LocalDate;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Patient object.
 */
@Service
@Named
public class PatientReadConverter implements ReadConverter<Document, Patient> {

    @Override
    public Patient convert(final Document source) {
        Patient p = new Patient();
        p.setId(((Number) source.get(PatientTags.ID_TAG)).longValue());
        p.setFirstName((String) source.get(PatientTags.FIRST_NAME_TAG));
        p.setMiddleName((String) source.get(PatientTags.MIDDLE_NAME_TAG));
        p.setLastName((String) source.get(PatientTags.LAST_NAME_TAG));
        p.setGender(Gender.getValueById((Integer) source.get(PatientTags.GENDER_TAG)));
//        p.setRace(Race.getValueById((Integer) source.get(PatientTags.RACE_TAG)));
        p.setDateOfBirth(LocalDate.ofEpochDay(((Number) source.get(PatientTags.DATE_OF_BIRTH_TAG)).longValue()));
        return p;
    }
}

