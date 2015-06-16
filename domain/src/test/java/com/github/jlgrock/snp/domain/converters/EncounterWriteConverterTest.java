package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
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

        Long id = 123l;
        String fhirId = "abc";
        String participant = "def";
        String encounterClass = "ghi";
        String status = "jkl";
        String subject = "mno";

        Encounter encounter = mock(Encounter.class);
        when(encounter.getId()).thenReturn(id);
        when(encounter.getFhirId()).thenReturn(fhirId);
        when(encounter.getParticipant()).thenReturn(participant);
        when(encounter.getEncounterClass()).thenReturn(encounterClass);
        when(encounter.getStatus()).thenReturn(status);
        when(encounter.getSubject()).thenReturn(subject);
        when(encounter.getObservations()).thenReturn(observations);

        EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(observationWriteConverter);
        Document dbObj = encounterWriteConverter.convert(encounter);

        assertEquals(id, dbObj.get(SharedTags.ID_TAG));
        assertEquals(fhirId, dbObj.get(EncounterTags.FHIR_ID));
        assertEquals(participant, dbObj.get(EncounterTags.PARTICIPANT));
        assertEquals(encounterClass, dbObj.get(EncounterTags.ENCOUNTER_CLASS));
        assertEquals(status, dbObj.get(EncounterTags.STATUS));
        assertEquals(subject, dbObj.get(EncounterTags.SUBJECT));
        assertEquals(observationObjs, dbObj.get(EncounterTags.OBSERVATIONS_TAG));
    }
}

