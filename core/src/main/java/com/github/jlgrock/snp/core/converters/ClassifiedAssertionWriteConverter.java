package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.core.data.AssertionTags;
import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an PCE objects and a MongoDB DBObject.
 */
@Service
@Named
public class ClassifiedAssertionWriteConverter implements WriteConverter<ClassifiedAssertion, DBObject> {
    @Override
    public DBObject convert(final ClassifiedAssertion source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(AssertionTags.ID_TAG, source.getId());
        dbo.put(AssertionTags.DESCRIPTION_TAG, source.getDesc());
        return dbo;

    }
}
