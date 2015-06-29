package com.github.jlgrock.snp.core.domain.lego.processors;

import com.github.jlgrock.snp.core.domain.lego.AbstractClassificationTest;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import org.jvnet.testing.hk2testng.HK2;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

@HK2
public class ProcessorTest extends AbstractClassificationTest {

//    @Inject
//    LegoElementProcessorFactory legoElementProcessorFactory;

    @Test
    public void testEndToEndForLegoElement() throws Exception {
        // TODO parsing lego file, this could/should be mocked
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("lego.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof Lego);

        Lego lego = (Lego) o;

        // mock up externals
//        ClassifiedPceStore classifiedPceStore = Mockito.mock(ClassifiedPceStore.class);
//        LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);
//        Mockito.when(logicGraphClassifier.classify(Mockito.any(LogicGraph.class))).thenReturn(111);
//
//        // execute factory
//        LegoElementProcessorService legoElementProcessorService = legoElementProcessorFactory.findElementProcessor(lego);
//
//        // verify that the Factory is working properly
//        Assert.assertTrue(legoElementProcessorService instanceof LegoProcessor);

        // TODO
        //legoElementProcessorService.process();

        //TODO check structure of logic graph, currently makes sure that ANY logic graph is used
        //Mockito.verify(logicGraphClassifier).classify(Mockito.any(LogicGraph.class));

        //TODO
        //Mockito.verify(classifiedPceStore.save(classifiedPce));


    }
}
