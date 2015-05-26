package com.github.jlgrock.snp.core.domain.fhir.logicgraph;

import com.github.jlgrock.snp.core.domain.fhir.Code;
import com.github.jlgrock.snp.core.domain.fhir.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.Coding;
import com.github.jlgrock.snp.core.domain.fhir.Condition;
import com.github.jlgrock.snp.core.domain.fhir.ConditionLocation;
import gov.vha.isaac.logic.node.AbstractNode;
import gov.vha.isaac.logic.node.AndNode;
import gov.vha.isaac.logic.node.RootNode;
import org.ihtsdo.otf.tcc.api.store.TerminologyStoreDI;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class FhirConditionGraphBuilder extends AbstractFhirLogicGraphBuilder {
    final Condition condition;

    private static final String IS_ABOUT_SCTID = "53";
    private static final String HAS_LOCATION_SCTID = "57";

    @Override
    public void create() {
        //Add the nodes to the logic graph based on FHIR XML parameters
        //Create root node first
        RootNode root = getRoot();

        AbstractNode node = processCondition(condition);
        root.addChildren(SufficientSet(node));
    }

    public FhirConditionGraphBuilder(final TerminologyStoreDI terminologyStoreDIIn, final Condition conditionIn) {
        super(terminologyStoreDIIn);
        condition = conditionIn;
    }

    protected AbstractNode processCondition(final Condition condition) {
        RootNode root = getRoot();
        int typeConceptNid = getNidFromSNOMED(HAS_LOCATION_SCTID);

        List<AbstractNode> childrenList = new ArrayList<>();

        //TODO so many other possible fields to look into.  just using two currently

        // Get the source
        CodeableConcept sourceCode = condition.getCode();
        AbstractNode sourceNode = processCodeableConcept(sourceCode);
        childrenList.add(sourceNode);

        List<ConditionLocation> conditionLocationList = condition.getLocation();

        for (ConditionLocation conditionLocation : conditionLocationList) {
            CodeableConcept codeableConcept = conditionLocation.getCode();
            childrenList.add(SomeRole(typeConceptNid, processCodeableConcept(codeableConcept)));
        }

        AndNode andNode = And();
        andNode.addChildren(childrenList.toArray(new AbstractNode[childrenList.size()]));
        return andNode;
    }

    protected AbstractNode processCodeableConcept(final CodeableConcept codeableConcept) {
        List<Coding> codingList = codeableConcept.getCoding();
        List<AbstractNode> childrenList = new ArrayList<>();
        for (Coding coding : codingList) {
            Code code = coding.getCode();
            String destinationSctId = code.getValue();

            //Get NID from UUID

            int destinationNid = getNidFromSNOMED(destinationSctId);
            childrenList.add(Concept(destinationNid));
        }
        AndNode andNode = And();
        andNode.addChildren(childrenList.toArray(new AbstractNode[childrenList.size()]));
        return andNode;
    }
}
