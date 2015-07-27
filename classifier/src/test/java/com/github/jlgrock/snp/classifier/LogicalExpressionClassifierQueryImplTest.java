package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
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
        LogicClassifierStore logicClassifierStore = Mockito.mock(LogicClassifierStore.class);
        int nid = 123;
        int[] result = {123, 345};
        LogicGraphClassifierQueryImpl logicGraphClassifierQuery = new LogicGraphClassifierQueryImpl(logicClassifierStore);
        TaxonomyService taxonomyService = Mockito.mock(TaxonomyService.class);
        Mockito.when(logicClassifierStore.getTaxonomyService()).thenReturn(taxonomyService);
        ViewCoordinate viewCoordinate = Mockito.mock(ViewCoordinate.class);
        Mockito.when(logicClassifierStore.getViewCoordinates()).thenReturn(viewCoordinate);
        ConceptSequenceSet conceptSequenceSet = Mockito.mock(ConceptSequenceSet.class);
        IntStream intStream = Mockito.mock(IntStream.class);
        Mockito.when(conceptSequenceSet.stream()).thenReturn(intStream);
        Mockito.when(intStream.toArray()).thenReturn(result);
        Mockito.when(taxonomyService.getKindOfSequenceSet(nid, viewCoordinate)).thenReturn(conceptSequenceSet);

        Assert.assertEquals(logicGraphClassifierQuery.query(nid), result);
    }

}
