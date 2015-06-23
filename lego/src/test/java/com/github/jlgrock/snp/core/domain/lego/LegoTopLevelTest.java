package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 *
 */
public class LegoTopLevelTest extends AbstractClassificationTest {

    @Test
    public void testLegoSerialization() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("lego.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof Lego);
    }

    @Test
    public void testLegoListSerialization() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("legolist.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof LegoList);
    }



}
