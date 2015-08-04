package com.github.jlgrock.snp.mockclassifier;

/**
 *
 */
public interface IdentifierConverter {
    int findNidForConceptSequence(int conceptSequence) throws IdentifierNotFoundException;

}
