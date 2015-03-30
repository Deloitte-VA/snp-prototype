package com.github.jlgrock.snp.core.classifier;

import java.io.IOException;

import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;

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
     * @throws ContradictionException 
     * @throws IOException 
     */
	ClassifiedAssertion classify(Assertion assertion) throws IOException, ContradictionException;

}
