package com.github.jlgrock.snp.domain.converters;


import com.github.jlgrock.snp.domain.data.AssertionTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.primitives.BooleanPrimitive;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import com.github.jlgrock.snp.domain.types.primitives.StringPrimitive;
import org.bson.Document;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public class AssertionWriteConverterTest {
    /**
     * public function returns void
     */
    @Test
    public void testConvert() {
        Instant date = Instant.now();

        StringPrimitive primitiveString = Mockito.mock(StringPrimitive.class);
        Mockito.when(primitiveString.getType()).thenReturn(PrimitiveType.STRING);
        Mockito.when(primitiveString.getValue()).thenReturn("asdf");
        BooleanPrimitive primitiveBoolean = Mockito.mock(BooleanPrimitive.class);
        Mockito.when(primitiveBoolean.getType()).thenReturn(PrimitiveType.BOOLEAN);
        Mockito.when(primitiveBoolean.getValue()).thenReturn(true);

        Assertion assertion = Mockito.mock(Assertion.class);
        Mockito.when(assertion.getIdentifier()).thenReturn("stringId");
        Mockito.when(assertion.getObservable()).thenReturn(primitiveString);
        Mockito.when(assertion.getValue()).thenReturn(primitiveBoolean);
        Mockito.when(assertion.getProvenance()).thenReturn(primitiveString);
        Mockito.when(assertion.getApplies()).thenReturn("applies");
        Mockito.when(assertion.getIssued()).thenReturn(date);
        Mockito.when(assertion.getSubject()).thenReturn("subject");

        AssertionWriteConverter assertionWriteConverter = new AssertionWriteConverter();
        Document dbObj = assertionWriteConverter.convert(assertion);

        Assert.assertEquals(dbObj.get(SharedTags.ID_TAG), "stringId");
        Assert.assertEquals(dbObj.get(AssertionTags.OBSERVABLE_TAG), "asdf");
        Assert.assertEquals(dbObj.get(AssertionTags.OBSERVABLE_TYPE_TAG), PrimitiveType.STRING.getId());
        Assert.assertEquals(dbObj.get(AssertionTags.VALUE_TAG), true);
        Assert.assertEquals(dbObj.get(AssertionTags.VALUE_TYPE_TAG), PrimitiveType.BOOLEAN.getId());
        Assert.assertEquals(dbObj.get(AssertionTags.PROVENANCE_TAG), "asdf");
        Assert.assertEquals(dbObj.get(AssertionTags.PROVENANCE_TYPE_TAG), PrimitiveType.STRING.getId());
        Assert.assertEquals(dbObj.get(AssertionTags.APPLIES_TAG), "applies");
        Assert.assertEquals(dbObj.get(AssertionTags.ISSUED_TAG), date.getEpochSecond());
        Assert.assertEquals(dbObj.get(AssertionTags.SUBJECT_TAG), "subject");

    }
}

