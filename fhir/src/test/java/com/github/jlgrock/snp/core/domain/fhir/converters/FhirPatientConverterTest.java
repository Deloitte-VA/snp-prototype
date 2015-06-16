package com.github.jlgrock.snp.core.domain.fhir.converters;

import com.github.jlgrock.snp.core.domain.fhir.model.Patient;
import com.github.jlgrock.snp.domain.types.Gender;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.time.LocalDate;

import static org.testng.Assert.assertEquals;

public class FhirPatientConverterTest extends AbstractConverterTest {
	
	public final static String xmlFile = "Patient-example-f001-pieter.xml";

	@Test
	public void testConvert() throws JAXBException {

		JAXBContext jaxbContext = JAXBContext.newInstance(path);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		@SuppressWarnings("unchecked")
		JAXBElement<Patient> je = (JAXBElement<Patient>) jaxbUnmarshaller.unmarshal(
				readFile(xmlFile));
		Patient patientIn = je.getValue();
		
		FhirPatientConverter patientConverter = new FhirPatientConverter();
		
		com.github.jlgrock.snp.domain.types.Patient patient = patientConverter.convert(patientIn);
		
		assertEquals(patient.getFirstName(), "Pieter");
		assertEquals(patient.getMiddleName(), null);
		assertEquals(patient.getLastName(), "van de Heuvel");
		assertEquals(patient.getDateOfBirth(), LocalDate.of(1944, 11, 17));
		assertEquals(patient.getGender(), Gender.MALE);
		assertEquals(patient.isDeceased(), Boolean.FALSE);
		assertEquals(patient.getDateDeceased(), null);
	}
}
