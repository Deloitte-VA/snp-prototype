package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.Assertion;
import com.mongodb.DBObject;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class AssertionWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        LocalDate dob = LocalDate.now(); //final

        Assertion assertion = mock(Assertion.class);
        when(assertion.getId()).thenReturn((Long) 123l);
        when(assertion.getDesc()).thenReturn("bla");

        PCEWriteConverter pceWriteConverter = new PCEWriteConverter();
        DBObject dbObj = pceWriteConverter.convert(assertion);

        assertEquals((Long) 123l, dbObj.get(PCETags.ID_TAG));
        assertEquals("bla", dbObj.get(PCETags.DESCRIPTION_TAG));

    }
}
