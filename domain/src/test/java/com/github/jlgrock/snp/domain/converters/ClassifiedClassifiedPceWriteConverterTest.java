package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.bson.Document;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 */
public class ClassifiedClassifiedPceWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Integer id = 5;
        ClassifiedPce assertion = mock(ClassifiedPce.class);
        when(assertion.getId()).thenReturn(id);
        when(assertion.getDesc()).thenReturn("bla");

        ClassifiedPceWriteConverter classifiedPceWriteConverter = new ClassifiedPceWriteConverter();
        Document dbObj = classifiedPceWriteConverter.convert(assertion);

        Assert.assertEquals(id, dbObj.get(SharedTags.ID_TAG));
        Assert.assertEquals("bla", dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG));

    }
}
