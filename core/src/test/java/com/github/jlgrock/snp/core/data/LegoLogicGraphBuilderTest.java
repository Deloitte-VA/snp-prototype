package com.github.jlgrock.snp.core.data;

public class LegoLogicGraphBuilderTest {
	
//package com.github.jlgrock.snp.core.data;
//
//import gov.vha.isaac.logic.LogicGraph;
//import gov.vha.isaac.logic.Node;
//import gov.vha.isaac.lookup.constants.Constants;
//import gov.vha.isaac.ochre.api.LookupService;
//import gov.vha.isaac.ochre.api.tree.TreeNodeVisitData;
//
//import org.ihtsdo.otf.tcc.api.contradiction.ContradictionException;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.Test;
//
//import java.io.IOException;
//import java.util.UUID;
//
//import static org.testng.Assert.assertNotNull;
//
//public class LegoLogicGraphBuilderTest {

//	@BeforeSuite
//    public void setUpSuite() throws Exception {
//		//System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, "target/data/object-chronicles");
//		//System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, "target/data/search");
//
//        LookupService.getRunLevelController().proceedTo(2);
//        System.out.println("System up...");
//    }
//
//    @AfterSuite
//    public void tearDownSuite() throws Exception {
//    	LookupService.getRunLevelController().proceedTo(-1);
//        System.out.println("System down...");
//        System.exit(0);
//    }
    
//	@Test
//	public void testtestCreate() {
//        LogicGraph g = null;
//
//        /*Try to invoke new constructor for LEGO XML PCEs*/
//        try {
//			//Create the LogicGraph using the constructor meant for LEGO XMLs
//        	g = new LegoLogicGraphBuilder(439272007, "704647008", "46973005");  //Actual "IS ABOUT" concept id = 704647008 rather than 53
//    
//	@Test
//	public void testtestCreate() {
//        LogicGraph g = null;
//    	
//        /*Try to invoke new constructor for LEGO XML PCEs*/
//        try {
//			//Create the LogicGraph using the constructor meant for LEGO XMLs
//        	g = new LegoLogicGraphBuilder(439272007, "704647008", "46973005");  //Actual "IS ABOUT" concept id = 704647008 rather than 53 
//        } catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println("IO Exception occured!: " + e.getMessage() + "  ");
//			e.printStackTrace();
//		} catch (ContradictionException e) {
//			// TODO Auto-generated catch block
//			System.out.println("ContradictionException occured!: " + e.getMessage() + "  ");
//			e.printStackTrace();
//		}
//        System.out.println("Graph size=" + g.getNodeCount() );
//
//        
//        g.processDepthFirst((Node node, TreeNodeVisitData graphVisitData) -> {
//            for (int i = 0; i < graphVisitData.getDistance(node.getNodeIndex()); i++) {
//                System.out.print("  ");
//            }
//            System.out.println(node);
//        });
//	}
	
}
