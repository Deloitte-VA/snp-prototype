package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.ochre.api.tree.TreeNodeVisitData;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.model.xml.fihr.Bundle;
import com.github.jlgrock.snp.core.model.xml.fihr.Condition;
import com.github.jlgrock.snp.core.parser.AbstractXmlParserTest;
import com.github.jlgrock.snp.core.parser.FhirXmlParser;

public class FhirLogicGraphBuilderTest extends AbstractXmlParserTest {
private static final Logger LOGGER = LoggerFactory.getLogger(FhirLogicGraphBuilderTest.class);
	
	@BeforeSuite
    public void setUpSuite() throws Exception {
		FhirLogicGraphBuilder.startExpressionService();
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
    	FhirLogicGraphBuilder.stopExpressionService();
    }
    
    @Test
	public void testCondition() {
		InputStream xmlInput = getClass().getClassLoader().getResourceAsStream("FHIRCondition-1_snp_prototype.xml");
		Bundle bundle = new FhirXmlParser().parseDocument(xmlInput);
		Condition condition = bundle.getEntries().get(0).getResource().getCondition();
				
		LogicGraph g = null;
    	
    	FhirLogicGraphBuilder fhirLogicGraphBuilder = new FhirLogicGraphBuilder(condition);
    	//LegoLogicGraphBuilder.create() gets called by LogicGraph.legoLogicGraphBuilderprocessDepthFirst()
    	//call this method if you don't call LogicGraph.legoLogicGraphBuilderprocessDepthFirst() in order
    	//to create logicGraph
    	//legoLogicGraphBuilder.create();
    	
    	g = (LogicGraph) fhirLogicGraphBuilder;
        
        //LogicGraph.legoLogicGraphBuilderprocessDepthFirst calls init() which calls create()
        //that is implemented by the LegoLogicGraphBuilder
        g.processDepthFirst((Node node, TreeNodeVisitData graphVisitData) -> {
            for (int i = 0; i < graphVisitData.getDistance(node.getNodeIndex()); i++) {
                System.out.print("  ");
            }
            System.out.println(node);
        });
        
        LOGGER.info("Graph size=" + g.getNodeCount() );
	}
}
