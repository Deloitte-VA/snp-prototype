package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

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
        LocalDate dob = LocalDate.now(); //final
        ObjectId objectId = ObjectId.get();
        ClassifiedPce assertion = mock(ClassifiedPce.class);
        when(assertion.getId()).thenReturn(objectId);
        when(assertion.getDesc()).thenReturn("bla");

        ClassifiedPceWriteConverter classifiedPceWriteConverter = new ClassifiedPceWriteConverter();
        Document dbObj = classifiedPceWriteConverter.convert(assertion);

        Assert.assertEquals(objectId, dbObj.get(SharedTags.ID_TAG));
        Assert.assertEquals("bla", dbObj.get(ClassifiedPceTags.DESCRIPTION_TAG));

    }
}
