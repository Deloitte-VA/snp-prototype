package com.github.jlgrock.snp.core.data;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.ochre.api.tree.TreeNodeVisitData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.lego.Expression;
import com.github.jlgrock.snp.core.domain.lego.LegoList;
import com.github.jlgrock.snp.core.parser.AbstractXmlParserTest;

public class LegoLogicGraphBuilderTest extends AbstractXmlParserTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(LegoLogicGraphBuilderTest.class);
	
	@BeforeSuite
    public void setUpSuite() throws Exception {
		LegoLogicGraphBuilder.startExpressionService();
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
    	LegoLogicGraphBuilder.stopExpressionService();
    }
    
	@Test
	public void testExpressionOneRelation() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(LegoList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    
	    LegoList legoList = (LegoList)jaxbUnmarshaller.unmarshal(getClass().getClassLoader().getResourceAsStream("testExpressionOneRelation.xml"));
	    Expression expression = legoList.getLego().get(0).getAssertion().get(0).getDiscernible().getExpression();
	    		
		LogicGraph g = null;
    	
    	LegoLogicGraphBuilder legoLogicGraphBuilder = new LegoLogicGraphBuilder(expression);
    	//LegoLogicGraphBuilder.create() gets called by LogicGraph.legoLogicGraphBuilderprocessDepthFirst()
    	//call this method if you don't call LogicGraph.legoLogicGraphBuilderprocessDepthFirst() in order
    	//to create logicGraph
    	//legoLogicGraphBuilder.create();
    	
    	g = (LogicGraph) legoLogicGraphBuilder;
        
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
	
	@Test
	public void testExpressionThreeRelations() throws Exception {
		JAXBContext jaxbContext = JAXBContext.newInstance(LegoList.class);
	    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	    
	    LegoList legoList = (LegoList) jaxbUnmarshaller.unmarshal(getClass().getClassLoader().getResourceAsStream("testExpressionThreeRelations.xml"));
	    Expression expression = legoList.getLego().get(0).getAssertion().get(0).getDiscernible().getExpression();
	    
		LogicGraph g = null;
    	
    	LegoLogicGraphBuilder legoLogicGraphBuilder = new LegoLogicGraphBuilder(expression);
    	//LegoLogicGraphBuilder.create() gets called by LogicGraph.legoLogicGraphBuilderprocessDepthFirst()
    	//call this method if you don't call LogicGraph.legoLogicGraphBuilderprocessDepthFirst() in order
    	//to create logicGraph
    	//legoLogicGraphBuilder.create();
    	
    	g = (LogicGraph) legoLogicGraphBuilder;
        
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