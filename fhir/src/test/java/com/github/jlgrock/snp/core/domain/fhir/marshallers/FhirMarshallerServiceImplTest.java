package com.github.jlgrock.snp.core.domain.fhir.marshallers;

import com.github.jlgrock.snp.core.domain.fhir.AbstractClassificationTest;
import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;
import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;

/**
 *
 */
public class FhirMarshallerServiceImplTest extends AbstractClassificationTest {

    @Test
    public void testLegoUnmarshalling() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("Encounter-example-f201-20130404.xml");
        Object o = unmarshaller.unmarshal(reader);
        if (o.getClass().equals(JAXBElement.class)) {
            o = ((JAXBElement) o).getValue();
        }
        Assert.assertTrue(o instanceof Encounter);
    }

    @Test
    public void testLegoListUnmarshalling() throws Exception {
        JAXBContext jc = JAXBContext.newInstance(path);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Reader reader = readFile("Patient-example-f001-pieter.xml");
        Object o = unmarshaller.unmarshal(reader);
        if (o.getClass().equals(JAXBElement.class)) {
            o = ((JAXBElement) o).getValue();
        }
        Assert.assertTrue(o instanceof Patient);
    }

}
