package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.AssertionTags;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.mongodb.DBObject;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class ClassifiedAssertionReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(AssertionTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(AssertionTags.DESCRIPTION_TAG)).thenReturn("bla");

        AssertionReadConverter patientReadConverter = new AssertionReadConverter();
        ClassifiedAssertion assertion = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, assertion.getId());
        assertEquals("bla", assertion.getDesc());
    }
}
