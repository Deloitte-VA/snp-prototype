package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.ClassifierStorage;
import gov.vha.isaac.ochre.api.TaxonomyService;
import gov.vha.isaac.ochre.collections.ConceptSequenceSet;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

/**
 *
 */
public class LogicalExpressionClassifierQueryImplTest {


    @Test
    public void queryByNid() {
        ClassifierStorage classifierStorage = Mockito.mock(ClassifierStorage.class);
        int nid = 123;
        int[] result = {123, 345};
        ClassifierQueryImpl logicGraphClassifierQuery = new ClassifierQueryImpl(classifierStorage);
        TaxonomyService taxonomyService = Mockito.mock(TaxonomyService.class);
        Mockito.when(classifierStorage.getTaxonomyService()).thenReturn(taxonomyService);
        ViewCoordinate viewCoordinate = Mockito.mock(ViewCoordinate.class);
        Mockito.when(classifierStorage.getViewCoordinate()).thenReturn(viewCoordinate);
        ConceptSequenceSet conceptSequenceSet = Mockito.mock(ConceptSequenceSet.class);
        IntStream intStream = Mockito.mock(IntStream.class);
        Mockito.when(conceptSequenceSet.stream()).thenReturn(intStream);
        Mockito.when(intStream.toArray()).thenReturn(result);
        Mockito.when(taxonomyService.getKindOfSequenceSet(nid, viewCoordinate)).thenReturn(conceptSequenceSet);

        Assert.assertEquals(logicGraphClassifierQuery.query(nid), result);
    }

}
