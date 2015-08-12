package com.github.jlgrock.snp.classifier;

import com.github.jlgrock.snp.apis.classifier.ClassifierStorage;
import com.github.jlgrock.snp.apis.classifier.LogicalExpressionClassifier;
import com.github.jlgrock.snp.apis.classifier.ClassifierQuery;
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
                bind(ClassifierStorageImpl.class).to(ClassifierStorage.class);
                bind(LogicalExpressionClassifierImpl.class).to(LogicalExpressionClassifier.class);
                bind(ClassifierQueryImpl.class).to(ClassifierQuery.class);
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