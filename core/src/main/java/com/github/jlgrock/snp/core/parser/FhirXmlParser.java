package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.github.jlgrock.snp.core.model.xml.fhir.Bundle;
import com.github.jlgrock.snp.core.model.xml.fhir.Category;
import com.github.jlgrock.snp.core.model.xml.fhir.Code;
import com.github.jlgrock.snp.core.model.xml.fhir.Coding;
import com.github.jlgrock.snp.core.model.xml.fhir.Condition;
import com.github.jlgrock.snp.core.model.xml.fhir.Display;
import com.github.jlgrock.snp.core.model.xml.fhir.Entry;
import com.github.jlgrock.snp.core.model.xml.fhir.FhirXmlConstants;
import com.github.jlgrock.snp.core.model.xml.fhir.Id;
import com.github.jlgrock.snp.core.model.xml.fhir.Location;
import com.github.jlgrock.snp.core.model.xml.fhir.Onset;
import com.github.jlgrock.snp.core.model.xml.fhir.OnsetDateTime;
import com.github.jlgrock.snp.core.model.xml.fhir.Resource;
import com.github.jlgrock.snp.core.model.xml.fhir.Status;
import com.github.jlgrock.snp.core.model.xml.fhir.System;
import com.github.jlgrock.snp.core.model.xml.fhir.Type;
/**
 * Parses FHIR XML document for retrieving Post Coordinated Expressions (PCEs)
 *
 */
public class FhirXmlParser implements XmlParser<Bundle> {
	private Bundle bundle;
	
	@Override
	public Bundle parseDocument(final InputStream xmlInput) {
		bundle =  new Bundle();
		String tagContent = null;
		try {
			// parse
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(xmlInput);

			while(reader.hasNext()) {
				int event = reader.next();

				switch (event) {
					case XMLStreamConstants.START_ELEMENT :
						switch(reader.getLocalName()) {
							case FhirXmlConstants.ENTRY :
								parseEntryAndAllChildren(reader);
								break;
							case FhirXmlConstants.ID :
								Id id = new Id();
								for(int index = 0;index < reader.getAttributeCount();index++) {
									if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
										id.setValue(reader.getAttributeValue(index));
									}
								}
								bundle.setId(id);
								break;
							case FhirXmlConstants.TYPE :
								Type type = new Type();
								for(int index = 0;index < reader.getAttributeCount();index++) {
									if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
										type.setValue(reader.getAttributeValue(index));
									}
								}
								bundle.setType(type);
								break;
							default :
								//not all local names are processed in this event
								break;
					}
						break;
					case XMLStreamConstants.CHARACTERS :
						tagContent = reader.getText();
						break;
					case XMLStreamConstants.END_ELEMENT :
						break;
					default :
						//ignore unnecessary events
						break;
				}
			}
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return bundle;
	}
	
	private void parseEntryAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Entry currentEntry = new Entry();
		String tagContent = null;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.ENTRY :
							currentEntry = new Entry();
							break;
						case FhirXmlConstants.RESOURCE :
							currentEntry.setResource(parseResourceAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.ENTRY :
							bundle.addEntry(currentEntry);
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
		}	
	}

	private Resource parseResourceAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Resource resource = new Resource();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CONDITION :
							resource.setCondition(parseConditionAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.RESOURCE :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}	
		return resource;		
	}
	
	private Condition parseConditionAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Condition condition = new Condition();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODE :
							condition.setCode(parseCodeAndAllChildren(reader));
							break;
						case FhirXmlConstants.CATEGORY :
							condition.setCategory(parseCategoryAndAllChildren(reader));
							break;
						case FhirXmlConstants.STATUS :
							Status status = new Status();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									status.setValue(reader.getAttributeValue(index));
								}
							}
							condition.setStatus(status);
							break;
						case FhirXmlConstants.ONSET :
							condition.setOnset(parseOnsetAndAllChildren(reader));
							break;
						case FhirXmlConstants.LOCATION :
							condition.setLocation(parseLocationAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.SUBJECT :
							condition.setSubject(tagContent);
							break;
						case FhirXmlConstants.ENCOUNTER :
							condition.setEncounter(tagContent);
							break;
						case FhirXmlConstants.ASSERTER :
							condition.setAsserter(tagContent);
							break;
						case FhirXmlConstants.DATE_ASSERTED :
							condition.setDateAsserted(tagContent);
							break;
						case FhirXmlConstants.NOTES :
							condition.setNotes(tagContent);
							break;
						case FhirXmlConstants.CONDITION :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return condition;
	}
	
	private Code parseCodeAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Code code = new Code();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODING :
							code.setCoding(parseCodingAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODE :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return code;
	}
	
	private Category parseCategoryAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Category category = new Category();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODE :
							category.setCode(parseCodeAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CATEGORY :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return category;
	}
	
	private Coding parseCodingAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Coding coding = new Coding();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.SYSTEM :
							System system = new System();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									system.setValue(reader.getAttributeValue(index));
								}
							}
							coding.setSystem(system);
							break;
						case FhirXmlConstants.CODE :
							Code code = new Code();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									code.setValue(reader.getAttributeValue(index));
								}
							}
							coding.setCode(code);
							break;
						case FhirXmlConstants.DISPLAY :
							Display display = new Display();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									display.setValue(reader.getAttributeValue(index));
								}
							}
							coding.setDisplay(display);
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODING :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return coding;
	}
	
	private Onset parseOnsetAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Onset onset = new Onset();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.ONSET_DATE_TIME :
							OnsetDateTime onsetDateTime = new OnsetDateTime();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FhirXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									onsetDateTime.setValue(reader.getAttributeValue(index));
								}
							}
							onset.setOnsetDateTime(onsetDateTime);
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.ONSET :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return onset;
	}
	
	private Location parseLocationAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Location location = new Location();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.CODE :
							location.setCode(parseCodeAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case FhirXmlConstants.LOCATION :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return location;
	}
	
}
