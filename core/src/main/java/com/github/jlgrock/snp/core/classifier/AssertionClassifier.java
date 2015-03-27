package com.github.jlgrock.snp.core.classifier;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;

/**
 * Classify an entire assertion object
 */
public interface AssertionClassifier {

    /**
     * Classify all of the PCEs within an assertion
     * @param assertion
     * @return
     */
    ClassifiedAssertion classify(Assertion assertion);
}
