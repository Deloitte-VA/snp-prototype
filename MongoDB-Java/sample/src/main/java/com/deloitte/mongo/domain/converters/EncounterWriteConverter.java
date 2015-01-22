package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Encounter;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

/**
 *
 */
public class EncounterWriteConverter implements Converter<Encounter, DBObject> {

    @Autowired
    ObservationWriteConverter observationWriteConverter;

    EncounterWriteConverter(ObservationWriteConverter observationWriteConverterIn) {
        observationWriteConverter = observationWriteConverterIn;
    }

    @Override
    public DBObject convert(Encounter source) {
        DBObject dbo = new BasicDBObject();
        dbo.put("_id", source.getId());
        dbo.put("patient_id", source.getPatient().getId());
        dbo.put("date", source.getId());
        dbo.put("type", source.getId());

        BasicDBList observations = source.getObservations().
                stream().map(observationWriteConverter::convert).collect(Collectors.toCollection(() -> new BasicDBList()));

        dbo.put("observations", observations);
        return dbo;
    }
}
