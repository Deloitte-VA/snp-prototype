package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.Assertion;
import com.mongodb.DBObject;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class AssertionReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(PCETags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(PCETags.DESCRIPTION_TAG)).thenReturn("bla");

        PCEReadConverter patientReadConverter = new PCEReadConverter();
        Assertion assertion = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, assertion.getId());
        assertEquals("bla", assertion.getDesc());
    }
}
