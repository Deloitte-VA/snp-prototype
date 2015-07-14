package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.mongodb.BasicDBList;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

public class EncounterWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate date = LocalDate.ofEpochDay(888l);
        ObjectId objectId = ObjectId.get();

        Assertion assertion1 = mock(Assertion.class);
        Assertion assertion2 = mock(Assertion.class);
        List<Assertion> assertions = new ArrayList() {{
            add(assertion1);
            add(assertion1);
            add(assertion2);
        }};
        Document assertion1Obj = mock(Document.class);
        Document assertion2Obj = mock(Document.class);
        BasicDBList assertionObjs = new BasicDBList() {{
            add(assertion1Obj);
            add(assertion1Obj);
            add(assertion2Obj);
        }};
        AssertionWriteConverter assertionWriteConverter = mock(AssertionWriteConverter.class);
        when(assertionWriteConverter.convert(assertion1)).thenReturn(assertion1Obj);
        when(assertionWriteConverter.convert(assertion2)).thenReturn(assertion2Obj);

        ObjectId patientId = ObjectId.get();
        String participant = "def";
        String encounterClass = "ghi";
        String status = "jkl";
        String subject = "mno";

        Encounter encounter = mock(Encounter.class);
        when(encounter.getId()).thenReturn(objectId);
        when(encounter.getPatientId()).thenReturn(patientId);
        when(encounter.getParticipant()).thenReturn(participant);
        when(encounter.getEncounterClass()).thenReturn(encounterClass);
        when(encounter.getStatus()).thenReturn(status);
        when(encounter.getSubject()).thenReturn(subject);
        when(encounter.getAssertions()).thenReturn(assertions);

        EncounterWriteConverter encounterWriteConverter = new EncounterWriteConverter(assertionWriteConverter);
        Document dbObj = encounterWriteConverter.convert(encounter);

        assertEquals(objectId, dbObj.get(SharedTags.ID_TAG));
        assertEquals(patientId, dbObj.get(EncounterTags.PATIENT_ID));
        assertEquals(participant, dbObj.get(EncounterTags.PARTICIPANT));
        assertEquals(encounterClass, dbObj.get(EncounterTags.ENCOUNTER_CLASS));
        assertEquals(status, dbObj.get(EncounterTags.STATUS));
        assertEquals(subject, dbObj.get(EncounterTags.SUBJECT));
        assertEquals(assertionObjs, dbObj.get(EncounterTags.ASSERTIONS_TAG));
    }
}

