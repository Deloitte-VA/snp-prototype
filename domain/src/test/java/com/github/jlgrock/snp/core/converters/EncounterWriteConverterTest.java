package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.EncounterWriteConverter;
import com.github.jlgrock.snp.domain.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;
import com.mongodb.BasicDBList;
import org.bson.Document;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class EncounterWriteConverterTest {
    /**
     * public fuction returns void
     */
    @Test
    public void testConvert() {
        LocalDate date = LocalDate.ofEpochDay(888l);
        String patientId = "f456";

        Observation observation1 = mock(Observation.class);
        Observation observation2 = mock(Observation.class);
        List<Observation> observations = new ArrayList() {{
            add(observation1);
            add(observation1);
            add(observation2);
        }};
        Document observation1Obj = mock(Document.class);
        Document observation2Obj = mock(Document.class);
        BasicDBList observationObjs = new BasicDBList() {{
            add(observation1Obj);
            add(observation1Obj);
            add(observation2Obj);
        }};
        ObservationWriteConverter observationWriteConverter = mock(ObservationWriteConverter.class);
        when(observationWriteConverter.convert(observation1)).thenReturn(observation1Obj);
        when(observationWriteConverter.convert(observation2)).thenReturn(observation2Obj);

        Encounter encounter = mock(Encounter.class);
        when(encounter.getId()).thenReturn(123l);
//        when(encounter.getDate()).thenReturn(date);
        when(encounter.getPatientId()).thenReturn(patientId);
//        when(encounter.getType()).thenReturn(1);
//        when(encounter.getObservations()).thenReturn(observations);

        EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(observationWriteConverter);
        Document dbObj = encounterWriteConverter.convert(encounter);

        assertEquals(123L, dbObj.get(EncounterTags.ID_TAG));
//        assertEquals(date.toEpochDay(), dbObj.get(EncounterTags.DATE_TAG));
//        assertEquals(456l, dbObj.get(EncounterTags.PATIENT_TAG));
//        assertEquals(1, dbObj.get(EncounterTags.TYPE_TAG));
//        assertEquals(observationObjs, dbObj.get(EncounterTags.OBSERVATIONS_TAG));
    }
}

