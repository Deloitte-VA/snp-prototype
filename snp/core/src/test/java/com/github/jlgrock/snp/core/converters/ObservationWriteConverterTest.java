package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ObservationTags;
import com.github.jlgrock.snp.core.domain.Observation;
import com.github.jlgrock.snp.core.domain.primitives.BooleanPrimitive;
import com.github.jlgrock.snp.core.domain.primitives.PrimitiveType;
import com.github.jlgrock.snp.core.domain.primitives.StringPrimitive;
import com.mongodb.DBObject;
import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ObservationWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        DateTime date = new DateTime();

        StringPrimitive primitiveString = mock(StringPrimitive.class);
        when(primitiveString.getType()).thenReturn(PrimitiveType.STRING);
        when(primitiveString.getValue()).thenReturn("asdf");
        BooleanPrimitive primitiveBoolean = mock(BooleanPrimitive.class);
        when(primitiveBoolean.getType()).thenReturn(PrimitiveType.BOOLEAN);
        when(primitiveBoolean.getValue()).thenReturn(true);

        Observation observation = mock(Observation.class);
        when(observation.getIdentifier()).thenReturn("stringId");
        when(observation.getName()).thenReturn(primitiveString);
        when(observation.getValue()).thenReturn(primitiveBoolean);
        when(observation.getApplies()).thenReturn("applies");
        when(observation.getIssued()).thenReturn(date);
        when(observation.getSubject()).thenReturn("subject");

        ObservationWriteConverter observationWriteConverter = new ObservationWriteConverter();
        DBObject dbObj = observationWriteConverter.convert(observation);

        assertEquals("stringId", dbObj.get(ObservationTags.ID_TAG));
        assertEquals("asdf", dbObj.get(ObservationTags.NAME_TAG));
        assertEquals(PrimitiveType.STRING.getId(), dbObj.get(ObservationTags.NAME_TYPE_TAG));
        assertEquals(true, dbObj.get(ObservationTags.VALUE_TAG));
        assertEquals(PrimitiveType.BOOLEAN.getId(), dbObj.get(ObservationTags.VALUE_TYPE_TAG));
        assertEquals("applies", dbObj.get(ObservationTags.APPLIES_TAG));
        assertEquals(date.getMillis(), dbObj.get(ObservationTags.ISSUED_TAG));
        assertEquals("subject", dbObj.get(ObservationTags.SUBJECT_TAG));

    }
}

