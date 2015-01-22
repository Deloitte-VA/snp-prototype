package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.Patient;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jlgrock on 1/12/15.
 */
public class EncounterWriteConverter implements Converter<Encounter, DBObject> {

    @Autowired
    ObservationWriteConverter observationWriteConverter;

    @Override
    public DBObject convert(Encounter source) {
        DBObject dbo = new BasicDBObject();
        dbo.put("_id", source.getId());
        dbo.put("patient_id", source.getPatientId());
        dbo.put("date", source.getId());
        dbo.put("type", source.getId());

        BasicDBList observations = source.getObservations().
                stream().map(observationWriteConverter::convert).collect(Collectors.toCollection(() -> new BasicDBList()));

        dbo.put("observations", observations);
        return dbo;
    }
}
