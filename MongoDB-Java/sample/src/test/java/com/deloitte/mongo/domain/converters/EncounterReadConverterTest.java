package com.deloitte.mongo.domain.converters;

import com.deloitte.mongo.domain.Encounter;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class EncounterReadConverterTest {
    @Test
    public void testConvert() {
        Date date = Mockito.mock(Date.class);
        Mockito.when(date.getTime()).thenReturn(99999l);
        DBObject dbObject = new BasicDBObject() {{
            put("_id", 123l);
            put("patient_id", 456l);
            put("date", date);
            put("type", 1);
            put("reason_for_visit", "hernia");
        }};
        EncounterReadConverter encounterReadConverter = new EncounterReadConverter();
        Encounter encounter = encounterReadConverter.convert(dbObject);
        Assert.assertEquals((Long) 123l, encounter.getId());
        Assert.assertEquals((Long) 456l, encounter.getId());
        Assert.assertEquals(date, encounter.getDate());
        Assert.assertEquals((Integer) 1, encounter.getType());
        Assert.assertEquals("hernia", encounter.getReasonForVisit());
    }


}
