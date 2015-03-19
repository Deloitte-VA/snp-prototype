package com.github.jlgrock.snp.web.controllers;

import com.github.jlgrock.snp.web.ApplicationConfig;
import com.github.jlgrock.snp.web.ApplicationObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.core.Application;

/**
 *
 */
public class LegoControllerTest extends JerseyTestNg.ContainerPerClassTest {
    @BeforeMethod
    public void setUp() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(new JacksonFeature()).register(ApplicationObjectMapper.class);
    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        //return all of the rest endpoints
        return ApplicationConfig.createApp();
    }
}
