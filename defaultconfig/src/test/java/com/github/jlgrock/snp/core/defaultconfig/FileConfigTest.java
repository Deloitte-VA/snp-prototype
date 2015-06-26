package com.github.jlgrock.snp.core.defaultconfig;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class FileConfigTest {
    @Test
    public void testDefaults() {
/*
        FileConfig webConfig = new FileConfig();
*/
//        TODO: Need to fix this test...
//        Assert.assertEquals(webConfig.getFilepath(), WebConfig.TEMP_DIR_LOCATION);
    }

    @Test
    public void testParsed() {
        PropertiesFileReader.readFile("app.properties");
/*
        FileConfig fileConfig = new FileConfig();
        Assert.assertEquals(fileConfig.fileUploadLocation().toString(), "/data/bka");
*/
        //TODO add more
    }
}
