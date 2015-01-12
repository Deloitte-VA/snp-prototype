package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Gender;
import com.deloitte.mongo.domain.Patient;
import com.deloitte.mongo.domain.Race;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by jlgrock on 1/12/15.
 */
public class PatientReadConverter implements Converter<DBObject, Patient> {
    public Patient convert(DBObject source) {
        Patient p = new Patient();
        p.setId((Long) source.get("_id"));
        p.setFirstName((String) source.get("first_name"));
//        p.setMiddleName((String) source.get("middle_name"));
//        p.setLastName((String) source.get("last_name"));
//        p.setGender(Gender.getValueById((Integer) source.get("gender")));
//        p.setRace(Race.getValueById((Integer) source.get("race")));
//        p.setDob(new Date((Long) source.get("dob")));
        return p;
    }
}
