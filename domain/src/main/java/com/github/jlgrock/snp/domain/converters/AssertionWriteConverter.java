package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.WriteConverter;
import com.github.jlgrock.snp.domain.data.AssertionTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Assertion;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between an Assertion objects and a MongoDB DBObject.
 */
@Service
@Named
public class AssertionWriteConverter  implements WriteConverter<Assertion, Document> {

    @Override
    public Document convert(final Assertion source) {
        Document dbo = new Document();
        if (source.getIdentifier() != null) {
            dbo.put(SharedTags.ID_TAG, source.getIdentifier());
        }
        if (source.getObservable() != null) {
            dbo.put(AssertionTags.OBSERVABLE_TAG, source.getObservable().getValue());
        }

        if (source.getObservable().getType() != null) {
            dbo.put(AssertionTags.OBSERVABLE_TYPE_TAG, source.getObservable().getType().getId());
        }

        if (source.getValue() != null) {
            dbo.put(AssertionTags.VALUE_TAG, source.getValue().getValue());
        }

        if (source.getValue().getType() != null) {
            dbo.put(AssertionTags.VALUE_TYPE_TAG, source.getValue().getType().getId());
        }
        
        if (source.getProvenance() != null) {
        	dbo.put(AssertionTags.PROVENANCE_TAG, source.getProvenance().getValue());
        }
        
        if (source.getProvenance().getType() != null) {
        	dbo.put(AssertionTags.PROVENANCE_TYPE_TAG, source.getProvenance().getType().getId());
        }

        if (source.getApplies() != null) {
            dbo.put(AssertionTags.APPLIES_TAG, source.getApplies());
        }

        if (source.getSubject() != null) {
            dbo.put(AssertionTags.SUBJECT_TAG, source.getSubject());
        }

        if (source.getIssued() != null) {
            dbo.put(AssertionTags.ISSUED_TAG, source.getIssued().getEpochSecond());
        }

        return dbo;
    }
}

