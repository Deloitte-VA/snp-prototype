package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Patient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by jlgrock on 1/12/15.
 */
public class PatientWriteConverter implements Converter<Patient, DBObject> {

    public DBObject convert(Patient source) {
        DBObject dbo = new BasicDBObject();
        dbo.put("_id", source.getId());
        dbo.put("first_name", source.getFirstName());
//        dbo.put("middle_name", source.getMiddleName());
//        dbo.put("last_name", source.getLastName());
//        dbo.put("gender", source.getGender().getId());
//        dbo.put("race", source.getRace().getId());
//        dbo.put("dob", source.getDob().getTime());
        return dbo;
    }
}
