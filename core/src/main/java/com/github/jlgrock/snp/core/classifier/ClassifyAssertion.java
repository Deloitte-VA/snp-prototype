package com.github.jlgrock.snp.core.classifier;

import com.github.jlgrock.snp.core.model.parser.Assertion;

/**
 * Classify an entire assertion object
 */
public interface ClassifyAssertion {

    /**
     * Classify all of the PCEs within an assertion
     * @param assertion
     * @return
     */
    ClassifyAssertion classify(Assertion assertion);
}
