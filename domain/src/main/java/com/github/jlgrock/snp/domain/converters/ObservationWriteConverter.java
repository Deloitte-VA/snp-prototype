package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.ObservationTags;
import com.github.jlgrock.snp.domain.types.Observation;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an Observation objects and a MongoDB DBObject.
 */
@Service
@Named
public class ObservationWriteConverter  implements WriteConverter<Observation, Document> {

    @Override
    public Document convert(final Observation source) {
        Document dbo = new Document();
        dbo.put(ObservationTags.ID_TAG, source.getIdentifier());
        dbo.put(ObservationTags.NAME_TYPE_TAG, null);
        dbo.put(ObservationTags.NAME_TAG, source.getName().getValue());
        dbo.put(ObservationTags.NAME_TYPE_TAG, source.getName().getType().getId());
        dbo.put(ObservationTags.VALUE_TAG, source.getValue().getValue());
        dbo.put(ObservationTags.VALUE_TAG, source.getValue().getValue());
        dbo.put(ObservationTags.VALUE_TYPE_TAG, source.getValue().getType().getId());
        dbo.put(ObservationTags.APPLIES_TAG, source.getApplies());
        dbo.put(ObservationTags.SUBJECT_TAG, source.getSubject());
        dbo.put(ObservationTags.ISSUED_TAG, source.getIssued().getEpochSecond());
        return dbo;
    }
}

