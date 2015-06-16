package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.LogicClassifierStore;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifierQuery;
import com.github.jlgrock.snp.apis.connection.configuration.FileConfiguration;
import gov.vha.isaac.ochre.api.LookupService;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.utilities.ServiceLocatorUtilities;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LogicClassifierTest {


    @BeforeClass
    public void setUpTests() throws Exception {
        // Required to make this work on TestNG
        MockitoAnnotations.initMocks(this);
        setupInjection();
    }

    private void setupInjection() {
        ServiceLocator serviceLocator = LookupService.get();
        ServiceLocatorUtilities.bind(serviceLocator, new AbstractBinder() {
            @Override
            protected void configure() {
                bind(LogicClassifierStoreImpl.class).to(LogicClassifierStore.class);
                bind(LogicGraphClassifierImpl.class).to(LogicGraphClassifier.class);
                bind(LogicGraphClassifierQueryImpl.class).to(LogicGraphClassifierQuery.class);
                bind(new FileConfiguration() {

                    @Override
                    public Path fileUploadLocation() {
                        return Paths.get("/Users/jlgrock/workspace/snp/data2/uploads");
                    }

                    @Override
                    public Path chronicleLocation() {
                        return Paths.get("/Users/jlgrock/workspace/snp/data2/object-chronicles");
                    }

                    @Override
                    public Path luceneLocation() {
                        return Paths.get("/Users/jlgrock/workspace/snp/data2/run");
                    }
                }).to(FileConfiguration.class);
            }
        });
    }

    @Test
    private void testClassification() {
//        LogicGraphBuilder logicGraphBuilder = new LogicGraphBuilder() {
//            @Override
//            public void create() {
//                Concept(34343);
//            }
//        };
//        logicGraphBuilder.create();
//        LogicGraph logicGraph = (LogicGraph) logicGraphBuilder;
//
//        LogicGraphClassifier logicGraphClassifier = LookupService.getService(LogicGraphClassifier.class);
//        Integer a = logicGraphClassifier.classify(logicGraph);
//        Integer b = logicGraphClassifier.classify(logicGraph);
//        Assert.assertEquals(a, b);
    }




}