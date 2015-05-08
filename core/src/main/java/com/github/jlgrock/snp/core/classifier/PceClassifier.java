package com.github.jlgrock.snp.core.classifier;

import org.jvnet.hk2.annotations.Contract;

import com.github.jlgrock.snp.core.domain.ClassifiedPce;

/**
 * Classify an entire assertion object
 */
@Contract
public interface PceClassifier<T> {

    /**
     * Classify all of the PCEs
     * @param pce Post Coordinated Expression
     * @return ClassifiedAssertion classified PCE
     */
	ClassifiedPce classify(T pce);

}
