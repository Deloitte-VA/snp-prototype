package com.deloitte.mongo.converters;

import com.deloitte.mongo.domain.Observation;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *
 */
@Component
public class ObservationReadConverter implements Converter<DBObject, Observation> {

    ObservationReadConverter() {
    }

    @Override
    public Observation convert(DBObject source) {
        Observation observation = new Observation();
        observation.setIdentifier((String) "identifier");
        //observation.setName();
        observation.setNameType(((Number) source.get("name_type")).intValue());
        //observation.setValue();
        observation.setValueType(((Number) source.get("value_type")).intValue());
        observation.setApplies((String) source.get("applies"));
        observation.setSubject((String) source.get("subject"));
        observation.setIssued((Date) source.get("issued") );
        return observation;

    }
}
