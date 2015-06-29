package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.ObservationTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
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
        if (source.getIdentifier() != null) {
            dbo.put(SharedTags.ID_TAG, source.getIdentifier());
        }
        if (source.getName() != null) {
            dbo.put(ObservationTags.NAME_TAG, source.getName().getValue());
        }

        if (source.getName().getType() != null) {
            dbo.put(ObservationTags.NAME_TYPE_TAG, source.getName().getType().getId());
        }

        if (source.getValue() != null) {
            dbo.put(ObservationTags.VALUE_TAG, source.getValue().getValue());
        }

        if (source.getValue().getType() != null) {
            dbo.put(ObservationTags.VALUE_TYPE_TAG, source.getValue().getType().getId());
        }

        if (source.getApplies() != null) {
            dbo.put(ObservationTags.APPLIES_TAG, source.getApplies());
        }

        if (source.getSubject() != null) {
            dbo.put(ObservationTags.SUBJECT_TAG, source.getSubject());
        }

        if (source.getIssued() != null) {
            dbo.put(ObservationTags.ISSUED_TAG, source.getIssued().getEpochSecond());
        }

        return dbo;
    }
}

