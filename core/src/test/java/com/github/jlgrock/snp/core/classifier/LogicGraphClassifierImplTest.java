package com.github.jlgrock.snp.core.classifier;

import gov.vha.isaac.logic.LogicGraph;
import gov.vha.isaac.logic.Node;
import gov.vha.isaac.lookup.constants.Constants;
import gov.vha.isaac.ochre.api.LookupService;
import gov.vha.isaac.ochre.api.tree.TreeNodeVisitData;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class LogicGraphClassifierImplTest {
	
	@BeforeSuite
    public void setUpSuite() throws Exception {
		System.setProperty(Constants.CHRONICLE_COLLECTIONS_ROOT_LOCATION_PROPERTY, "target/data/object-chronicles");
		System.setProperty(Constants.SEARCH_ROOT_LOCATION_PROPERTY, "target/data/search");

        LookupService.getRunLevelController().proceedTo(2);
        System.out.println("System up...");
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
    	LookupService.getRunLevelController().proceedTo(-1);
        System.out.println("System down...");
        System.exit(0);
    }
    
	@Test
	public void testClassify() {
        LogicGraphClassifierImpl logicGraphClassifier = new LogicGraphClassifierImpl();
		String classifierID = logicGraphClassifier.classify((createLogicGraph()));
		assertNotNull(classifierID);
	}
	
	private LogicGraph createLogicGraph() {
        int parentConceptSequence = 1;
        int roleTypeConceptSequence = 2;
        int roleRestrictionConceptSequence = 3;

        int defParentConceptSequence1 = 4;
        int defParentConceptSequence2 = 5;
        
        MyLogicGraph g = new MyLogicGraph();
        g.getRoot().addChildren(
                g.NecessarySet(
                        g.And(g.Concept(parentConceptSequence),
                                g.SomeRole(roleTypeConceptSequence, g.Concept(roleRestrictionConceptSequence)))),
                g.SufficientSet(g.And(g.Concept(defParentConceptSequence1), g.Concept(defParentConceptSequence2)))
        );

        g.processDepthFirst((Node node, TreeNodeVisitData graphVisitData) -> {
            for (int i = 0; i < graphVisitData.getDistance(node.getNodeIndex()); i++) {
                System.out.print("  ");
            }
            System.out.println(node);
        });
        
       return g;
    }
	
	class MyLogicGraph extends LogicGraph {

		public MyLogicGraph() {
			super();
		}
	}
	
}
