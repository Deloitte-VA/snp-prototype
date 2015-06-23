package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 *
 */
public class LogicGraphTest extends AbstractClassificationTest {

    @Test
    public void testSingleLegoClassification() throws Exception {
        // TODO parsing lego file, this could/should be mocked
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("lego.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof Lego);

        Lego lego = (Lego) o;

        //LegoExpressionGraphBuilder legoExpressionGraphBuilder = new LegoExpressionGraphBuilder(final LogicGraphClassifier logicGraphClassifierIn, final Expression expressionIn);

    }
}
