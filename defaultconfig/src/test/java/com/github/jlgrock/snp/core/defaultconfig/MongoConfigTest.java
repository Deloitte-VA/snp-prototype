package com.github.jlgrock.snp.core.defaultconfig;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class MongoConfigTest {

    @Test
    public void testDefaults() {
        MongoConfig mongoConfig = new MongoConfig();
        Assert.assertEquals(mongoConfig.getHost().get().getHost(), MongoConfig.DEFAULT_HOST);
        Assert.assertEquals(mongoConfig.getHost().get().getPort(), MongoConfig.DEFAULT_PORT.intValue());
        Assert.assertEquals(mongoConfig.getDefaultDatabase(), MongoConfig.DEFAULT_DATABASE);
    }

    @Test
    public void testParsed() {
        PropertiesFileReader.readFile("app.properties");
        MongoConfig mongoConfig = new MongoConfig();
        Assert.assertEquals(mongoConfig.getHost().get().getHost(), "123.456.65.121");
        Assert.assertEquals(mongoConfig.getHost().get().getPort(), 2345);
        Assert.assertEquals(mongoConfig.getDefaultDatabase(), "mydb");
    }
}
