package com.github.jlgrock.snp.converters;

import com.github.jlgrock.snp.data.PatientTags;
import com.github.jlgrock.snp.domain.Patient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * A Conversion class to convert between an Patient objects and a MongoDB DBObject.
 */
@Component
public class PatientWriteConverter implements Converter<Patient, DBObject> {

    public DBObject convert(Patient source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(PatientTags.ID_TAG, source.getId());
        dbo.put(PatientTags.FIRST_NAME_TAG, source.getFirstName());
        dbo.put(PatientTags.MIDDLE_NAME_TAG, source.getMiddleName());
        dbo.put(PatientTags.LAST_NAME_TAG, source.getLastName());
        dbo.put(PatientTags.GENDER_TAG, source.getGender().getId());
        dbo.put(PatientTags.RACE_TAG, source.getRace().getId());
        dbo.put(PatientTags.DATE_OF_BIRTH_TAG, source.getDateOfBirth().getMillis());
        return dbo;
    }
}

