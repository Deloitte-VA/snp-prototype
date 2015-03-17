package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.core.converters.PCEWriteConverter;
import com.github.jlgrock.snp.core.domain.PCE;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.testng.annotations.Test;

import javax.ws.rs.core.Application;

import static org.testng.Assert.assertEquals;

/**
 *
 */
public class PCEControllerTest extends JerseyTest {
    @Override
    protected Application configure() {
        return new ResourceConfig(PCEController.class);
    }

    @Test
    public void testFindById() {
        final Long id = 1l;
        final PCE p = new PCE();
        p.setId(id);
        p.setDesc("bla");
        final String response = target("pce/" + id).request().get(String.class);
        final String converted = new PCEWriteConverter().convert(p).toString();
        assertEquals(converted, response);
    }
}
