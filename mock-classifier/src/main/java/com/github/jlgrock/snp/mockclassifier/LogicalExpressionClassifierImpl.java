package com.github.jlgrock.snp.mockclassifier;

import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import gov.vha.isaac.ochre.api.IdentifierService;
import gov.vha.isaac.ochre.api.logic.LogicalExpression;
import org.ihtsdo.otf.tcc.api.concept.ConceptChronicleBI;

import javax.inject.Inject;
import java.io.IOException;
import java.util.UUID;

/**
 *
 */
public class LogicalExpressionClassifierImpl implements LogicalExpressionClassifier {

    private final ClassifierStorage classifierStorage;
    private final IdentifierConverter identifierConverter;

    @Inject
    public LogicalExpressionClassifierImpl(final ClassifierStorage classifierStorageIn, final IdentifierConverter identifierConverterIn) {
        classifierStorage = classifierStorageIn;
        identifierConverter = identifierConverterIn;
    }

    @Override
    public int getNidFromSNOMED(String sctid) {
        return 0;
    }

    @Override
    public UUID getUUIDFromSNOMED(String sctid) {
        return null;
    }

    @Override
    public ConceptChronicleBI findChronicle(String sctid) {
        return null;
    }

    @Override
    public ConceptChronicleBI findChronicle(final int nid) {

        return classifierStorage.getByNid(nid);
    }

    @Override
    public Integer classify(final LogicalExpression pce) {
        // convert the concept sequence to the native id
        int conceptSequence = pce.getConceptSequence();
        try {
            identifierConverter.findNidForConceptSequence(conceptSequence);
        } catch (IdentifierNotFoundException infe) {

        }

        // it's not in the system, so store it
        if (nid == null) {
            classifierStorage.add(pce);
        }

        if (classifierStorage.expressionExists(nid)) {

        }

    }

    @Override
    public LogicalExpression getInferredTermLogicalExpression(int nid) throws IOException {
        return null;
    }
}
