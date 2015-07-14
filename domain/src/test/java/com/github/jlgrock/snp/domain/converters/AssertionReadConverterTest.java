package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.domain.data.AssertionTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class AssertionReadConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Instant date = Instant.now();

        Document dbObj = Mockito.mock(Document.class);
        Mockito.when(dbObj.get(SharedTags.ID_TAG)).thenReturn("stringId");
        Mockito.when(dbObj.get(AssertionTags.OBSERVABLE_TAG)).thenReturn("asdf");
        Mockito.when(dbObj.get(AssertionTags.OBSERVABLE_TYPE_TAG)).thenReturn(PrimitiveType.STRING.getId());
        Mockito.when(dbObj.get(AssertionTags.VALUE_TAG)).thenReturn(true);
        Mockito.when(dbObj.get(AssertionTags.VALUE_TYPE_TAG)).thenReturn(PrimitiveType.BOOLEAN.getId());
        Mockito.when(dbObj.get(AssertionTags.PROVENANCE_TAG)).thenReturn("hjkl");
        Mockito.when(dbObj.get(AssertionTags.PROVENANCE_TYPE_TAG)).thenReturn(PrimitiveType.STRING.getId());
        Mockito.when(dbObj.get(AssertionTags.APPLIES_TAG)).thenReturn("applies");
        Mockito.when(dbObj.get(AssertionTags.ISSUED_TAG)).thenReturn(date.toEpochMilli());
        Mockito.when(dbObj.get(AssertionTags.SUBJECT_TAG)).thenReturn("subject");

        AssertionReadConverter assertionReadConverter = new AssertionReadConverter();
        Assertion assertion = assertionReadConverter.convert(dbObj);

        Assert.assertEquals("stringId", assertion.getIdentifier());
        Assert.assertEquals(PrimitiveType.STRING, assertion.getObservable().getType());
        Assert.assertEquals("asdf", assertion.getObservable().getValue());
        Assert.assertEquals(PrimitiveType.BOOLEAN, assertion.getValue().getType());
        Assert.assertEquals(true, assertion.getValue().getValue());
        Assert.assertEquals(PrimitiveType.STRING,  assertion.getProvenance().getType());
        Assert.assertEquals("hjkl", assertion.getProvenance().getValue());
        Assert.assertEquals("applies", assertion.getApplies());
        Assert.assertEquals(date, assertion.getIssued());
        Assert.assertEquals("subject", assertion.getSubject());

    }
}

