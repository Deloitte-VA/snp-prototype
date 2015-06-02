package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceTags;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an PCE object.
 */
@Service
@Named
public class ClassifiedPceReadConverter extends AbstractReadConverter implements ReadConverter<Document, ClassifiedPce> {
    @Override
    public ClassifiedPce convert(final Document source) {
        ClassifiedPce classifiedPce = new ClassifiedPce();
        classifiedPce.setId(parseLong(source, ClassifiedPceTags.ID_TAG));
        classifiedPce.setDesc(parseString(source, ClassifiedPceTags.DESCRIPTION_TAG));
        return classifiedPce;
    }
}
