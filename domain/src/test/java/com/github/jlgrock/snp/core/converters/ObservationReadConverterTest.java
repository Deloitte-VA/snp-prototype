package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.ObservationReadConverter;
import com.github.jlgrock.snp.domain.data.ObservationTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Observation;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class ObservationReadConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Instant date = Instant.now();

        Document dbObj = Mockito.mock(Document.class);
        Mockito.when(dbObj.get(SharedTags.ID_TAG)).thenReturn("stringId");
        Mockito.when(dbObj.get(ObservationTags.NAME_TAG)).thenReturn("asdf");
        Mockito.when(dbObj.get(ObservationTags.NAME_TYPE_TAG)).thenReturn(PrimitiveType.STRING.getId());
        Mockito.when(dbObj.get(ObservationTags.VALUE_TAG)).thenReturn(true);
        Mockito.when(dbObj.get(ObservationTags.VALUE_TYPE_TAG)).thenReturn(PrimitiveType.BOOLEAN.getId());
        Mockito.when(dbObj.get(ObservationTags.APPLIES_TAG)).thenReturn("applies");
        Mockito.when(dbObj.get(ObservationTags.ISSUED_TAG)).thenReturn(date.toEpochMilli());
        Mockito.when(dbObj.get(ObservationTags.SUBJECT_TAG)).thenReturn("subject");

        ObservationReadConverter observationReadConverter = new ObservationReadConverter();
        Observation observation = observationReadConverter.convert(dbObj);

        Assert.assertEquals("stringId", observation.getIdentifier());
        Assert.assertEquals(PrimitiveType.STRING, observation.getName().getType());
        Assert.assertEquals("asdf", observation.getName().getValue());
        Assert.assertEquals(PrimitiveType.BOOLEAN, observation.getValue().getType());
        Assert.assertEquals(true, observation.getValue().getValue());
        Assert.assertEquals("applies", observation.getApplies());
        Assert.assertEquals(date, observation.getIssued());
        Assert.assertEquals("subject", observation.getSubject());

    }
}

