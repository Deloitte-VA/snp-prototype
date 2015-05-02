package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.EncounterTags;
import com.github.jlgrock.snp.core.domain.Encounter;
import com.github.jlgrock.snp.core.domain.Observation;
import com.mongodb.BasicDBList;
import org.bson.Document;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EncounterReadConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate date = LocalDate.ofEpochDay(99999l);
        Long patientId = 456l;

        Observation observation1 = mock(Observation.class);
        Observation observation2 = mock(Observation.class);
        List<Observation> observations = new ArrayList<Observation>() {{
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
        ObservationReadConverter observationReadConverter = mock(ObservationReadConverter.class);

        Document dbObject = new Document() {{
            put(EncounterTags.ID_TAG, 123l);
            put(EncounterTags.PATIENT_TAG, 456l);
            put(EncounterTags.DATE_TAG, date.toEpochDay());
            put(EncounterTags.TYPE_TAG, 1);
            put(EncounterTags.REASON_FOR_VISIT_TAG, "hernia");
            put(EncounterTags.OBSERVATIONS_TAG, observationObjs);
        }};

        when(observationReadConverter.convert(observation1Obj)).thenReturn(observation1);
        when(observationReadConverter.convert(observation2Obj)).thenReturn(observation2);

        EncounterReadConverter encounterReadConverter = new EncounterReadConverter(observationReadConverter);

        Encounter encounter = encounterReadConverter.convert(dbObject);
//        TODO: FIXME
//        assertEquals((Long) 123l, encounter.getId());
//        assertEquals(patientId, encounter.getPatientId());
//        assertEquals(date, encounter.getDate());
//        assertEquals((Integer) 1, encounter.getType());
//        assertEquals("hernia", encounter.getReasonForVisit());
//        assertEquals(observations, encounter.getObservations());
    }


}


