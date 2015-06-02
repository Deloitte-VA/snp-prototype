package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.core.data.ClassifiedPceTags;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import org.bson.Document;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

/**
 *
 */
public class ClassifiedClassifiedPceReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Document dbObj = mock(Document.class);
        when(dbObj.get(ClassifiedPceTags.ID_TAG)).thenReturn((Long) 123l);
        when(dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG)).thenReturn("bla");

        ClassifiedPceReadConverter patientReadConverter = new ClassifiedPceReadConverter();
        ClassifiedPce assertion = patientReadConverter.convert(dbObj);

        assertEquals((Long) 123l, assertion.getId());
//        TODO: FIXME
//        assertEquals("bla", assertion.getDesc());
    }
}
