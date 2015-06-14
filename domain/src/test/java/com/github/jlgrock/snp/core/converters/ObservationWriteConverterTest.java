package com.github.jlgrock.snp.core.converters;


import com.github.jlgrock.snp.domain.converters.ObservationWriteConverter;
import com.github.jlgrock.snp.domain.data.ObservationTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Observation;
import com.github.jlgrock.snp.domain.types.primitives.BooleanPrimitive;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import com.github.jlgrock.snp.domain.types.primitives.StringPrimitive;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class ObservationWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Instant date = Instant.now();

        StringPrimitive primitiveString = Mockito.mock(StringPrimitive.class);
        Mockito.when(primitiveString.getType()).thenReturn(PrimitiveType.STRING);
        Mockito.when(primitiveString.getValue()).thenReturn("asdf");
        BooleanPrimitive primitiveBoolean = Mockito.mock(BooleanPrimitive.class);
        Mockito.when(primitiveBoolean.getType()).thenReturn(PrimitiveType.BOOLEAN);
        Mockito.when(primitiveBoolean.getValue()).thenReturn(true);

        Observation observation = Mockito.mock(Observation.class);
        Mockito.when(observation.getIdentifier()).thenReturn("stringId");
        Mockito.when(observation.getName()).thenReturn(primitiveString);
        Mockito.when(observation.getValue()).thenReturn(primitiveBoolean);
        Mockito.when(observation.getApplies()).thenReturn("applies");
        Mockito.when(observation.getIssued()).thenReturn(date);
        Mockito.when(observation.getSubject()).thenReturn("subject");

        ObservationWriteConverter observationWriteConverter = new ObservationWriteConverter();
        Document dbObj = observationWriteConverter.convert(observation);

        Assert.assertEquals("stringId", dbObj.get(SharedTags.ID_TAG));
        Assert.assertEquals("asdf", dbObj.get(ObservationTags.NAME_TAG));
        Assert.assertEquals(PrimitiveType.STRING.getId(), dbObj.get(ObservationTags.NAME_TYPE_TAG));
        Assert.assertEquals(true, dbObj.get(ObservationTags.VALUE_TAG));
        Assert.assertEquals(PrimitiveType.BOOLEAN.getId(), dbObj.get(ObservationTags.VALUE_TYPE_TAG));
        Assert.assertEquals("applies", dbObj.get(ObservationTags.APPLIES_TAG));
        Assert.assertEquals(date.getEpochSecond(), dbObj.get(ObservationTags.ISSUED_TAG));
        Assert.assertEquals("subject", dbObj.get(ObservationTags.SUBJECT_TAG));

    }
}

