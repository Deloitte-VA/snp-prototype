package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.Assertion;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an PCE objects and a MongoDB DBObject.
 */
@Service
@Named
public class PCEWriteConverter implements WriteConverter<Assertion, DBObject> {
    @Override
    public DBObject convert(final Assertion source) {
        DBObject dbo = new BasicDBObject();
        dbo.put(PCETags.ID_TAG, source.getId());
        dbo.put(PCETags.DESCRIPTION_TAG, source.getDesc());
        return dbo;

    }
}
