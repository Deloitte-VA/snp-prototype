package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EncounterWriteConverterTest {

    @Test
    public void testConvert() {
        DateTime date = new DateTime(888l);
        Long patientId = (Long) 456l;

        Observation observation1 = mock(Observation.class);
        Observation observation2 = mock(Observation.class);
        List<Observation> observations = new ArrayList() {{
            add(observation1);
            add(observation1);
            add(observation2);
        }};
        DBObject observation1Obj = mock(BasicDBObject.class);
        DBObject observation2Obj = mock(BasicDBObject.class);
        BasicDBList observationObjs = new BasicDBList() {{
            add(observation1Obj);
            add(observation1Obj);
            add(observation2Obj);
        }};
        ObservationWriteConverter observationWriteConverter = mock(ObservationWriteConverter.class);
        when(observationWriteConverter.convert(observation1)).thenReturn(observation1Obj);
        when(observationWriteConverter.convert(observation2)).thenReturn(observation2Obj);

        Encounter encounter = mock(Encounter.class);
        when(encounter.getId()).thenReturn((Long) 123l);
        when(encounter.getDate()).thenReturn(date);
        when(encounter.getPatientId()).thenReturn(patientId);
        when(encounter.getReasonForVisit()).thenReturn("hernia");
        when(encounter.getType()).thenReturn(1);
        when(encounter.getObservations()).thenReturn(observations);

        EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(observationWriteConverter);
        DBObject dbObj = encounterWriteConverter.convert(encounter);

        assertEquals((Long) 123l, dbObj.get(EncounterTags.ID_TAG));
        assertEquals(date.getMillis(), dbObj.get(EncounterTags.DATE_TAG));
        assertEquals((Long) 456l, dbObj.get(EncounterTags.PATIENT_TAG));
        assertEquals("hernia", dbObj.get(EncounterTags.REASON_FOR_VISIT_TAG));
        assertEquals(1, dbObj.get(EncounterTags.TYPE_TAG));
        assertEquals(observationObjs, dbObj.get(EncounterTags.OBSERVATIONS_TAG));
    }
}
