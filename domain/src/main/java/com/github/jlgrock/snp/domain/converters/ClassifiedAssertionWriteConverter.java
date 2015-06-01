package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an PCE objects and a MongoDB DBObject.
 */
@Service
@Named
public class ClassifiedAssertionWriteConverter implements WriteConverter<ClassifiedPce, DBObject> {
    @Override
    public DBObject convert(final ClassifiedPce source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(ClassifiedPceTags.ID_TAG, source.getId());
        dbo.put(ClassifiedPceTags.DESCRIPTION_TAG, source.getDesc());
        return dbo;

    }
}
