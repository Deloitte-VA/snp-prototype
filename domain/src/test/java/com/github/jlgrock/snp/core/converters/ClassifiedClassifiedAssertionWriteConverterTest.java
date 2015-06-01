package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.ClassifiedAssertionWriteConverter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.mongodb.DBObject;

import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class ClassifiedClassifiedAssertionWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate dob = LocalDate.now(); //final

        ClassifiedPce assertion = mock(ClassifiedPce.class);
        when(assertion.getId()).thenReturn((Long) 123l);
        when(assertion.getDesc()).thenReturn("bla");

        ClassifiedAssertionWriteConverter classifiedAssertionWriteConverter = new ClassifiedAssertionWriteConverter();
        DBObject dbObj = classifiedAssertionWriteConverter.convert(assertion);

        assertEquals((Long) 123l, dbObj.get(ClassifiedPceTags.ID_TAG));
        assertEquals("bla", dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG));

    }
}
