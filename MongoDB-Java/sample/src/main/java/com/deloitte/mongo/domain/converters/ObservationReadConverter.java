package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.Patient;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * Created by jlgrock on 1/12/15.
 */
public class ObservationReadConverter implements Converter<DBObject, Observation> {
    @Override
    public Observation convert(DBObject source) {
        Observation observation = new Observation();
        observation.setIdentifier((String) "identifier");
        observation.setName();
        observation.setNameType(((Number) source.get("name_type")).intValue());
        observation.setValue();
        observation.setValueType(((Number) source.get("value_type")).intValue());
        observation.setApplies((String) source.get("applies"));
        observation.setSubject((String) source.get("subject"));
        observation.setIssued((Date) source.get("issued") );
        return observation;

    }
}
