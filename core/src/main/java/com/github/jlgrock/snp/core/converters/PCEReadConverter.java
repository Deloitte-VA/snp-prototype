package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.PCE;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an PCE object.
 */
@Service
@Named
public class PCEReadConverter implements ReadConverter<DBObject, PCE> {
    @Override
    public PCE convert(final DBObject source) {
        PCE pce = new PCE();
        pce.setId(((Number) source.get(PCETags.ID_TAG)).longValue());;
        pce.setDesc((String) source.get(PCETags.DESCRIPTION_TAG));
        return pce;
    }
}
