package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ClassifiedPceTags;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import org.bson.Document;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class ClassifiedClassifiedPceWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate dob = LocalDate.now(); //final

        ClassifiedPce assertion = mock(ClassifiedPce.class);
        when(assertion.getId()).thenReturn((Long) 123l);
        when(assertion.getDesc()).thenReturn("bla");

        ClassifiedPceWriteConverter classifiedPceWriteConverter = new ClassifiedPceWriteConverter();
        Document dbObj = classifiedPceWriteConverter.convert(assertion);

        assertEquals((Long) 123l, dbObj.get(ClassifiedPceTags.ID_TAG));
        assertEquals("bla", dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG));

    }
}
