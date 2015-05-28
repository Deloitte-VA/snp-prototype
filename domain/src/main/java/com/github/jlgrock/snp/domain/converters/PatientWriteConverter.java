package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.PatientTags;
import com.github.jlgrock.snp.domain.types.Patient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an Patient objects and a MongoDB DBObject.
 */
@Service
@Named
public class PatientWriteConverter implements WriteConverter<Patient, DBObject> {

    @Override
    public DBObject convert(final Patient source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(PatientTags.ID_TAG, source.getId());
        dbo.put(PatientTags.FIRST_NAME_TAG, source.getFirstName());
        dbo.put(PatientTags.MIDDLE_NAME_TAG, source.getMiddleName());
        dbo.put(PatientTags.LAST_NAME_TAG, source.getLastName());
        dbo.put(PatientTags.GENDER_TAG, source.getGender().getId());
        dbo.put(PatientTags.RACE_TAG, source.getRace().getId());
        if (source.getDateOfBirth() == null) {
            dbo.put(PatientTags.DATE_OF_BIRTH_TAG, null);
        } else {
            dbo.put(PatientTags.DATE_OF_BIRTH_TAG, source.getDateOfBirth().toEpochDay());
        }
        return dbo;
    }
}

