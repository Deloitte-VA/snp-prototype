package com.github.jlgrock.snp.core.domain.fhir.processors;

import com.github.jlgrock.snp.apis.classifier.LogicGraphClassifier;
import com.github.jlgrock.snp.core.domain.fhir.model.CodeableConcept;
import com.github.jlgrock.snp.core.domain.fhir.model.Condition;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import com.github.jlgrock.snp.domain.data.ClassifiedPceRepository;
import com.github.jlgrock.snp.domain.data.EncounterRepository;
import com.github.jlgrock.snp.domain.types.ClassifiedPce;
import com.github.jlgrock.snp.domain.types.Observation;
import org.mockito.Mockito;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class AbstractProcessorTest {
    protected Condition condition = Mockito.mock(Condition.class);
    protected Encounter encounter = Mockito.mock(Encounter.class);
    protected CodeableConcept codeableConcept = Mockito.mock(CodeableConcept.class);

    protected LogicGraphClassifier logicGraphClassifier = Mockito.mock(LogicGraphClassifier.class);

    protected ClassifiedPce classifiedPce = Mockito.mock(ClassifiedPce.class);

    protected EncounterRepository encounterRepository = Mockito.mock(EncounterRepository.class);
    protected ClassifiedPceRepository classifiedPceRepository = Mockito.mock(ClassifiedPceRepository.class);

    protected Observation observation1 = Mockito.mock(Observation.class);
    protected Observation observation2 = Mockito.mock(Observation.class);
    protected List<Observation> observationList;

    @BeforeClass
    public void setup() {
        observationList = new ArrayList<>();
        observationList.add(observation1);
        observationList.add(observation2);

        Mockito.when(condition.getEncounter()).thenReturn(encounter);
        Mockito.when().thenReturn(encounter);
    }
}
