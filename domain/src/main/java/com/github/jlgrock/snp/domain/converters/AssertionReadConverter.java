package com.github.jlgrock.snp.domain.converters;

import com.github.jlgrock.snp.apis.converters.ReadConverter;
import com.github.jlgrock.snp.domain.data.AssertionTags;
import com.github.jlgrock.snp.domain.data.SharedTags;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.primitives.SimplePrimitive;
import org.bson.Document;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Named;

/**
 * A Conversion class to convert between a MongoDB DBObject to an Assertion object.
 */
@Service
@Named
public class AssertionReadConverter extends AbstractReadConverter implements ReadConverter<Document, Assertion> {

    @Override
    public Assertion convert(final Document source) {
        Assertion assertion = new Assertion();
        assertion.setIdentifier(parseString(source, SharedTags.ID_TAG));
        assertion.setObservable(SimplePrimitive.createPrimitive(
                        parseInteger(source, AssertionTags.OBSERVABLE_TYPE_TAG),
                        source.get(AssertionTags.OBSERVABLE_TAG)));
        assertion.setValue(SimplePrimitive.createPrimitive(
                parseInteger(source, AssertionTags.VALUE_TYPE_TAG),
                source.get(AssertionTags.VALUE_TAG)));
        assertion.setProvenance(SimplePrimitive.createPrimitive(
        		parseInteger(source, AssertionTags.PROVENANCE_TYPE_TAG), 
        		source.get(AssertionTags.PROVENANCE_TAG)));
        assertion.setApplies(parseString(source, AssertionTags.APPLIES_TAG));
        assertion.setSubject(parseString(source, AssertionTags.SUBJECT_TAG));
        assertion.setIssued(parseInstant(source, AssertionTags.ISSUED_TAG));
        return assertion;
    }
}

