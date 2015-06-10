package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.EncounterReadConverter;
import com.github.jlgrock.snp.domain.converters.ObservationReadConverter;
import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Observation;
import com.mongodb.BasicDBList;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

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

        Long id = 123l;
        String fhirId = "abc";
        String participant = "def";
        String patientClass = "ghi";
        String status = "jkl";
        String subject = "mno";

        Document dbObject = new Document() {{
            put(SharedTags.ID_TAG, id);
            put(EncounterTags.FHIR_ID, fhirId);
            put(EncounterTags.PARTICIPANT, participant);
            put(EncounterTags.PATIENT_CLASS, patientClass);
            put(EncounterTags.STATUS, status);
            put(EncounterTags.SUBJECT, subject);
            put(EncounterTags.OBSERVATIONS_TAG, observationObjs);
        }};

        when(observationReadConverter.convert(observation1Obj)).thenReturn(observation1);
        when(observationReadConverter.convert(observation2Obj)).thenReturn(observation2);

        EncounterReadConverter encounterReadConverter = new EncounterReadConverter(observationReadConverter);

        Encounter encounter = encounterReadConverter.convert(dbObject);
        Assert.assertEquals(id, encounter.getId());
        Assert.assertEquals(fhirId, encounter.getFhirId());
        Assert.assertEquals(participant, encounter.getParticipant());
        Assert.assertEquals(patientClass, encounter.getPatientClass());
        Assert.assertEquals(status, encounter.getStatus());
        Assert.assertEquals(subject, encounter.getSubject());
        Assert.assertEquals(observations, encounter.getObservations());
    }


}


