package com.github.jlgrock.snp.core.domain.lego;

import com.github.jlgrock.snp.core.domain.lego.model.Lego;
import com.github.jlgrock.snp.core.domain.lego.model.LegoList;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 *
 */
public class LegoTopLevelTest {

    private static final String path = "com.github.jlgrock.snp.core.domain.lego.model";
    @Test
    public void testBla() {
        Assert.assertEquals(1, 1);

    }

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


    /**
     * Prints the string content read from input stream
     * @return content in file
     */
    private Reader readFile(String xmlFile) {
        BufferedReader br = null;
        StringBuilder out = new StringBuilder();
        InputStream in = getClass().getClassLoader().getResourceAsStream(xmlFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        return reader;
    }
}
