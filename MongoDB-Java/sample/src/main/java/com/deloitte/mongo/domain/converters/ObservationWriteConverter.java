package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Observation;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by jlgrock on 1/12/15.
 */
public class ObservationWriteConverter  implements Converter<Observation, DBObject> {

    @Override
    public DBObject convert(Observation source) {
        DBObject dbo = new BasicDBObject();
        dbo.put("identifier", source.getIdentifier());
        dbo.put("name", source.getName());
        dbo.put("name_type", source.getNameType());
        dbo.put("value", source.getValue());
        dbo.put("value_type", source.getValueType());
        dbo.put("applies", source.getApplies());
        dbo.put("subject", source.getSubject());
        dbo.put("issued", source.getIssued());
        return dbo;
    }
}
