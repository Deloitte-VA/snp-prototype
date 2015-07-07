package com.github.jlgrock.snp.core.domain.lego.marshallers;

import com.github.jlgrock.snp.core.domain.lego.AbstractClassificationTest;
import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 *
 */
public class LegoMarhsallerTest extends AbstractClassificationTest {
    @Test
    void unmarshallLegoList() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("legolist.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof LegoList);
    }

    @Test
    void unmarshallLego() throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("lego.xml");
        Object o = unmarshaller.unmarshal(reader);
        Assert.assertTrue(o instanceof Lego);
    }

}
