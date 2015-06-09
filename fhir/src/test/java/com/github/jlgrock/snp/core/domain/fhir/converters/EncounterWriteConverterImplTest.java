package com.github.jlgrock.snp.core.domain.fhir.converters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.testng.annotations.Test;

import com.github.jlgrock.snp.core.domain.fhir.model.Encounter;

public class EncounterWriteConverterImplTest extends AbstractConverterTest {
	
	
	public final static String xmlFile = "Encounter-example-f201-20130404.xml";

	@Test
	public void testConvert() throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(path);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<Encounter> je = (JAXBElement<Encounter>) jaxbUnmarshaller.unmarshal(
				readFile(xmlFile));
		Encounter encounter = je.getValue();
		System.out.println("ENCOUNTER: " + encounter);
	}
}
