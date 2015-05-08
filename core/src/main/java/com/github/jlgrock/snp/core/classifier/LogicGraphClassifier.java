package com.github.jlgrock.snp.core.classifier;

import java.util.UUID;

import org.jvnet.hk2.annotations.Contract;

/**
 * Classify Post Coordinated Expressions
 *
 */
@Contract
public interface LogicGraphClassifier<T> {

	/**
	 * replace Post Coordinated Expressions with a classifier ID
	 * 
	 * @param pce Post Coordinated Expression
	 * @return UUID UUID
	 */
	UUID classify(T pce);
}
