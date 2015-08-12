package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.ClassifierStorage;
import org.ihtsdo.otf.tcc.api.coordinate.ViewCoordinate;
import org.ihtsdo.otf.tcc.api.store.TerminologySnapshotDI;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;
import org.jvnet.testing.hk2testng.HK2;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

/**
 *
 */
@HK2(populate = false)
public class LogicalExpressionClassifierImplTest {

    @Test(expectedExceptions = NumberFormatException.class)
    public void testNidLookupBadNumber() {
        ClassifierStorage classifierStorage = Mockito.mock(ClassifierStorage.class);
        TerminologyStoreDI terminologyStoreDI = Mockito.mock(TerminologyStoreDI.class);
        Mockito.when(classifierStorage.getTerminologyStore()).thenReturn(terminologyStoreDI);
        TerminologySnapshotDI terminologySnapshotDI = Mockito.mock(TerminologySnapshotDI.class);
        Mockito.when(terminologyStoreDI.getSnapshot(Mockito.any())).thenReturn(terminologySnapshotDI);
        Mockito.when(terminologySnapshotDI.getNidForUuids(Mockito.<UUID> any())).thenReturn(5);
        ViewCoordinate viewCoordinate = Mockito.mock(ViewCoordinate.class);
        Mockito.when(classifierStorage.getViewCoordinate()).thenReturn(viewCoordinate);

        LogicalExpressionClassifierImpl logicGraphClassifier = new LogicalExpressionClassifierImpl(classifierStorage);
        Assert.assertEquals(logicGraphClassifier.getNidFromSNOMED("asd"), 5);

    }

    @Test
    public void testNidLookupGoodNumber() {
        ClassifierStorage classifierStorage = Mockito.mock(ClassifierStorage.class);
        TerminologyStoreDI terminologyStoreDI = Mockito.mock(TerminologyStoreDI.class);
        Mockito.when(classifierStorage.getTerminologyStore()).thenReturn(terminologyStoreDI);
        TerminologySnapshotDI terminologySnapshotDI = Mockito.mock(TerminologySnapshotDI.class);
        Mockito.when(terminologyStoreDI.getSnapshot(Mockito.any())).thenReturn(terminologySnapshotDI);
        Mockito.when(terminologySnapshotDI.getNidForUuids(Mockito.<UUID> any())).thenReturn(5);
        ViewCoordinate viewCoordinate = Mockito.mock(ViewCoordinate.class);
        Mockito.when(classifierStorage.getViewCoordinate()).thenReturn(viewCoordinate);

        LogicalExpressionClassifierImpl logicGraphClassifier = new LogicalExpressionClassifierImpl(classifierStorage);
        Assert.assertEquals(logicGraphClassifier.getNidFromSNOMED("123"), 5);

    }

}
