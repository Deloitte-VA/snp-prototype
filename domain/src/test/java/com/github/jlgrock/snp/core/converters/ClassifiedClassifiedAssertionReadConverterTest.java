package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.domain.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.mongodb.DBObject;

import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class ClassifiedClassifiedAssertionReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        DBObject dbObj = mock(DBObject.class);
        when(dbObj.get(ClassifiedPceTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG)).thenReturn("bla");

        ClassifiedPceReadConverter patientReadConverter = new ClassifiedPceReadConverter();
        ClassifiedPce assertion = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, assertion.getId());
//        TODO: FIXME
//        assertEquals("bla", assertion.getDesc());
    }
}
