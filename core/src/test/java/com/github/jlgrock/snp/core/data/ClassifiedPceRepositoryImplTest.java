package com.github.jlgrock.snp.core.data;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.core.converters.ClassifiedPceReadConverter;
import com.github.jlgrock.snp.core.converters.ClassifiedPceWriteConverter;
import com.github.jlgrock.snp.core.domain.ClassifiedPce;
import org.bson.Document;
import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClassifiedPceRepositoryImplTest {

    @Mock
    MongoDbFactory mdbf1;

    @Mock
    ClassifiedPceReadConverter carc1;

    @Mock
    ClassifiedPceWriteConverter cawc1;

    ClassifiedPce ca1 = new ClassifiedPce();

    Document d1 = new Document();

    ClassifiedPceRepositoryImpl cari1 = new ClassifiedPceRepositoryImpl(mdbf1, carc1, cawc1);

    @Test
    public void testConvertToDomainObject() {
        when(cari1.convertToDomainObject(d1)).thenReturn(ca1);
        ca1 = cari1.convertToDomainObject(d1);
        verify(cari1).convertToDomainObject(d1);
        Assert.assertEquals(ca1, cari1.convertToDomainObject(d1));

    }

    @Test
    public void testConvertToDBObject() {
        when(cari1.convertToDBObject(ca1)).thenReturn(d1);
        d1 = cari1.convertToDBObject(ca1);
        verify(cari1).convertToDBObject(ca1);
        Assert.assertEquals(d1, cari1.convertToDBObject(ca1));

    }

}