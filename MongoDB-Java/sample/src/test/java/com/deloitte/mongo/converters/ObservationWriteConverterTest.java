package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.ObservationTags;
import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.primitives.BooleanPrimitive;
import com.deloitte.mongo.domain.primitives.PrimitiveType;
import com.deloitte.mongo.domain.primitives.StringPrimitive;
import com.mongodb.DBObject;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ObservationWriteConverterTest {

    @Test
    public void testConvert() {
        Date date = new Date();

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
        assertEquals(date.getTime(), dbObj.get(ObservationTags.ISSUED_TAG));
        assertEquals("subject", dbObj.get(ObservationTags.SUBJECT_TAG));

    }
}