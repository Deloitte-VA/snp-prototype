package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.github.jlgrock.snp.core.model.xml.fihr.Bundle;
import com.github.jlgrock.snp.core.model.xml.fihr.Category;
import com.github.jlgrock.snp.core.model.xml.fihr.Code;
import com.github.jlgrock.snp.core.model.xml.fihr.Coding;
import com.github.jlgrock.snp.core.model.xml.fihr.Condition;
import com.github.jlgrock.snp.core.model.xml.fihr.Display;
import com.github.jlgrock.snp.core.model.xml.fihr.Entry;
import com.github.jlgrock.snp.core.model.xml.fihr.FihrXmlConstants;
import com.github.jlgrock.snp.core.model.xml.fihr.Id;
import com.github.jlgrock.snp.core.model.xml.fihr.Location;
import com.github.jlgrock.snp.core.model.xml.fihr.Onset;
import com.github.jlgrock.snp.core.model.xml.fihr.OnsetDateTime;
import com.github.jlgrock.snp.core.model.xml.fihr.Resource;
import com.github.jlgrock.snp.core.model.xml.fihr.Status;
import com.github.jlgrock.snp.core.model.xml.fihr.System;
import com.github.jlgrock.snp.core.model.xml.fihr.Type;
/**
 * Parses FIHR XML document for retrieving Post Coordinated Expressions (PCEs)
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
							case FihrXmlConstants.ENTRY :
								parseEntryAndAllChildren(reader);
								break;
							case FihrXmlConstants.ID :
								Id id = new Id();
								for(int index = 0;index < reader.getAttributeCount();index++) {
									if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
										id.setValue(reader.getAttributeValue(index));
									}
								}
								bundle.setId(id);
								break;
							case FihrXmlConstants.TYPE :
								Type type = new Type();
								for(int index = 0;index < reader.getAttributeCount();index++) {
									if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
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
						case FihrXmlConstants.ENTRY :
							currentEntry = new Entry();
							break;
						case FihrXmlConstants.RESOURCE :
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
						case FihrXmlConstants.ENTRY :
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
						case FihrXmlConstants.CONDITION :
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
						case FihrXmlConstants.RESOURCE :
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
						case FihrXmlConstants.CODE :
							condition.setCode(parseCodeAndAllChildren(reader));
							break;
						case FihrXmlConstants.CATEGORY :
							condition.setCategory(parseCategoryAndAllChildren(reader));
							break;
						case FihrXmlConstants.STATUS :
							Status status = new Status();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									status.setValue(reader.getAttributeValue(index));
								}
							}
							condition.setStatus(status);
							break;
						case FihrXmlConstants.ONSET :
							condition.setOnset(parseOnsetAndAllChildren(reader));
							break;
						case FihrXmlConstants.LOCATION :
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
						case FihrXmlConstants.SUBJECT :
							condition.setSubject(tagContent);
							break;
						case FihrXmlConstants.ENCOUNTER :
							condition.setEncounter(tagContent);
							break;
						case FihrXmlConstants.ASSERTER :
							condition.setAsserter(tagContent);
							break;
						case FihrXmlConstants.DATE_ASSERTED :
							condition.setDateAsserted(tagContent);
							break;
						case FihrXmlConstants.NOTES :
							condition.setNotes(tagContent);
							break;
						case FihrXmlConstants.CONDITION :
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
						case FihrXmlConstants.CODING :
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
						case FihrXmlConstants.CODE :
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
						case FihrXmlConstants.CODE :
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
						case FihrXmlConstants.CATEGORY :
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
						case FihrXmlConstants.SYSTEM :
							System system = new System();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									system.setValue(reader.getAttributeValue(index));
								}
							}
							coding.setSystem(system);
							break;
						case FihrXmlConstants.CODE :
							Code code = new Code();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									code.setValue(reader.getAttributeValue(index));
								}
							}
							coding.setCode(code);
							break;
						case FihrXmlConstants.DISPLAY :
							Display display = new Display();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
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
						case FihrXmlConstants.CODING :
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
						case FihrXmlConstants.ONSET_DATE_TIME :
							OnsetDateTime onsetDateTime = new OnsetDateTime();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (FihrXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
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
						case FihrXmlConstants.ONSET :
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
						case FihrXmlConstants.CODE :
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
						case FihrXmlConstants.LOCATION :
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
