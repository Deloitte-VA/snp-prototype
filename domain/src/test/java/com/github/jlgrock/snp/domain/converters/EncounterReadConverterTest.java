package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.EncounterTags;
import com.github.jlgrock.snp.domain.data.PatientRepository;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.mongodb.BasicDBList;
import org.bson.Document;
import org.bson.types.ObjectId;
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
        Assertion assertion1 = mock(Assertion.class);
        Assertion assertion2 = mock(Assertion.class);
        List<Assertion> assertions = new ArrayList<Assertion>() {{
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
        AssertionReadConverter assertionReadConverter = mock(AssertionReadConverter.class);
        PatientRepository patientRepository = mock(PatientRepository.class);

        ObjectId id = ObjectId.get();
        ObjectId patientId = ObjectId.get();
        String participant = "def";
        String encounterClass = "ghi";
        String status = "jkl";
        String subject = "mno";

        Document dbObject = new Document() {{
            put(SharedTags.ID_TAG, id);
            put(EncounterTags.PATIENT_ID, patientId);
            put(EncounterTags.PARTICIPANT, participant);
            put(EncounterTags.ENCOUNTER_CLASS, encounterClass);
            put(EncounterTags.STATUS, status);
            put(EncounterTags.SUBJECT, subject);
            put(EncounterTags.ASSERTIONS_TAG, assertionObjs);
        }};

        when(assertionReadConverter.convert(assertion1Obj)).thenReturn(assertion1);
        when(assertionReadConverter.convert(assertion2Obj)).thenReturn(assertion2);

        EncounterReadConverter encounterReadConverter =
                new EncounterReadConverter(assertionReadConverter, patientRepository);

        Encounter encounter = encounterReadConverter.convert(dbObject);
        Assert.assertEquals(id, encounter.getId());
        Assert.assertEquals(patientId, encounter.getPatientId());
        Assert.assertEquals(participant, encounter.getParticipant());
        Assert.assertEquals(encounterClass, encounter.getEncounterClass());
        Assert.assertEquals(status, encounter.getStatus());
        Assert.assertEquals(subject, encounter.getSubject());
        Assert.assertEquals(assertions, encounter.getAssertions());
    }


}


