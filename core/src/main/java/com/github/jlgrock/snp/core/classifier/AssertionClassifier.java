package com.github.jlgrock.snp.core.classifier;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.core.domain.ClassifiedAssertion;
import com.github.jlgrock.snp.core.model.parser.Assertion;

/**
 * Classify an entire assertion object
 */
@Contract
public interface AssertionClassifier {

    /**
     * Classify all of the PCEs within an assertion
     * @param assertion
     * @return
     */
	ClassifiedAssertion classify(Assertion assertion);

}
