package com.deloitte.mongo.converters;

import com.deloitte.mongo.data.ObservationTags;
import com.mongodb.DBObject;
import org.junit.Test;

import java.util.Date;

import static org.mockito.Mockito.*;

public class ObservationReadConverterTest {

    @Test
    public void testConvert() {
        Date date = new Date();

        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(ObservationTags.ID_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.NAME_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.NAME_TYPE_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.VALUE_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.VALUE_TYPE_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.APPLIES_TAG)).thenReturn("");
        when(dbObj.get(ObservationTags.ISSUED_TAG)).thenReturn(date.getTime());

        ObservationReadConverter observationReadConverter = new ObservationReadConverter();
        observationReadConverter.convert(dbObj);
    }
}