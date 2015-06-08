package com.github.jlgrock.snp.core.defaultconfig;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class PropertiesFileReaderTest {
    @Test
    public void testParsed() {
        PropertiesFileReader.readFile("app.properties");
        Assert.assertEquals(PropertiesFileReader.getHost(), "123.456.65.121");
        Assert.assertEquals(PropertiesFileReader.getPort(), new Integer(2345));
        Assert.assertEquals(PropertiesFileReader.getDatabaseName(), "mydb");
        Assert.assertEquals(PropertiesFileReader.getFilelocation(), "/data/bka");
    }
}
