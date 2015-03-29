package com.github.jlgrock.snp.core.defaultconfig;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class WebConfigTest {
    @Test
    public void testDefaults() {
        WebConfig webConfig = new WebConfig();
        Assert.assertEquals(webConfig.getFilepath(), WebConfig.TEMP_DIR_LOCATION);
    }

    @Test
    public void testParsed() {
        PropertiesFileReader.readFile("app.properties");
        WebConfig webConfig = new WebConfig();
        Assert.assertEquals(webConfig.getFilepath(), "/data/bka");
    }
}
