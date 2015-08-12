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
public class ClassifiedClassifiedPceReadConverterTest {

    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Document dbObj = mock(Document.class);
        Integer id = 3;
        when(dbObj.get(SharedTags.ID_TAG)).thenReturn(id);
        when(dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG)).thenReturn("bla");

        ClassifiedPceReadConverter classifiedPceReadConverter = new ClassifiedPceReadConverter();
        ClassifiedPce assertion = classifiedPceReadConverter.convert(dbObj);

        Assert.assertEquals(id, assertion.getId());

        Assert.assertEquals(assertion.getDesc(), "bla");
    }
}
