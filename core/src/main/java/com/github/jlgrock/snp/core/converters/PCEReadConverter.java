package com.github.jlgrock.snp.core.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.core.data.PCETags;
import com.github.jlgrock.snp.core.domain.Assertion;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an PCE object.
 */
@Service
@Named
public class PCEReadConverter implements ReadConverter<DBObject, Assertion> {
    @Override
    public Assertion convert(final DBObject source) {
        Assertion assertion = new Assertion();
        assertion.setId(((Number) source.get(PCETags.ID_TAG)).longValue());
        assertion.setDesc((String) source.get(PCETags.DESCRIPTION_TAG));
        return assertion;
    }
}
