package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.github.jlgrock.snp.core.model.xml.lego.Assertion;
import com.github.jlgrock.snp.core.model.xml.lego.AssertionComponent;
import com.github.jlgrock.snp.core.model.xml.lego.Bound;
import com.github.jlgrock.snp.core.model.xml.lego.Concept;
import com.github.jlgrock.snp.core.model.xml.lego.Destination;
import com.github.jlgrock.snp.core.model.xml.lego.Discernible;
import com.github.jlgrock.snp.core.model.xml.lego.Expression;
import com.github.jlgrock.snp.core.model.xml.lego.Lego;
import com.github.jlgrock.snp.core.model.xml.lego.LegoList;
import com.github.jlgrock.snp.core.model.xml.lego.LegoXmlConstants;
import com.github.jlgrock.snp.core.model.xml.lego.Measurement;
import com.github.jlgrock.snp.core.model.xml.lego.Pncs;
import com.github.jlgrock.snp.core.model.xml.lego.Point;
import com.github.jlgrock.snp.core.model.xml.lego.Qualifier;
import com.github.jlgrock.snp.core.model.xml.lego.Relation;
import com.github.jlgrock.snp.core.model.xml.lego.Stamp;
import com.github.jlgrock.snp.core.model.xml.lego.Timing;
import com.github.jlgrock.snp.core.model.xml.lego.Type;
import com.github.jlgrock.snp.core.model.xml.lego.Units;
import com.github.jlgrock.snp.core.model.xml.lego.Value;

/**
 * Parses LEGO XML document for retrieving Post Coordinated Expressions (PCEs)
 * @deprecated
 */
public class LegoXmlParser implements XmlParser<LegoList> {
	//this is the list which shall be populated while parsing the XML
	private LegoList legoList;

    /**
     * Parse the XML input stream into java objects
     * @param xmlInput the input stream
     * @return the deserialized java objects
     */
	@Override
	public LegoList parseDocument(final InputStream xmlInput) {
		legoList = new LegoList();
		String tagContent = null;
		try {
			// parse
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLStreamReader reader = factory.createXMLStreamReader(xmlInput);

			while(reader.hasNext()) {
				int event = reader.next();

				switch (event) {
					case XMLStreamConstants.START_ELEMENT :
						if (LegoXmlConstants.LEGO.equals(reader.getLocalName())) {
							parseLegoAndAllChildren(reader);
						}
						break;
					case XMLStreamConstants.CHARACTERS :
						tagContent = reader.getText();
						break;
					case XMLStreamConstants.END_ELEMENT :
						switch(reader.getLocalName()) {
							case LegoXmlConstants.GROUP_NAME :
								legoList.setGroupName(tagContent);
								break;
							case LegoXmlConstants.LEGO_LIST_UUID :
								legoList.setUuid(tagContent);
								break;
							case LegoXmlConstants.GROUP_DESCRIPTION :
								legoList.setGroupDescription(tagContent);
								break;
							case LegoXmlConstants.COMMENT :
								legoList.setComment(tagContent);
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
		} catch (FactoryConfigurationError e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return legoList;
	}


	private void parseLegoAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Lego currentLego = new Lego();
		String tagContent = null;
		boolean inComment = false;
		String comment = "";
		
		while(reader.hasNext()) {			
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.LEGO :
							currentLego = new Lego();
							break;
						case LegoXmlConstants.STAMP :
							Stamp stamp = new Stamp();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (LegoXmlConstants.STATUS.equals(reader.getAttributeLocalName(index))) {
									stamp.setStatus(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.UUID.equals(reader.getAttributeLocalName(index))) {
									stamp.setUuid(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.PATH.equals(reader.getAttributeLocalName(index))) {
									stamp.setPath(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.MODULE.equals(reader.getAttributeLocalName(index))) {
									stamp.setModule(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.AUTHOR.equals(reader.getAttributeLocalName(index))) {
									stamp.setAuthor(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.TIME.equals(reader.getAttributeLocalName(index))) {
									stamp.setTime(reader.getAttributeValue(index));
								}
							}
							currentLego.setStamp(stamp);
							break;
						case LegoXmlConstants.PNCS :
							Pncs pncs = new Pncs();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if (LegoXmlConstants.VALUE.equals(reader.getAttributeLocalName(index))) {
									pncs.setValue(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.NAME.equals(reader.getAttributeLocalName(index))) {
									pncs.setName(reader.getAttributeValue(index));
								} else if (LegoXmlConstants.ID.equals(reader.getAttributeLocalName(index))) {
									pncs.setId(reader.getAttributeValue(index));
								}
							}
							currentLego.setPncs(pncs);
							break;
						case LegoXmlConstants.ASSERTION :
							currentLego.setAssertion(parseAssertionAndAllChildren(reader));
							break;
						case LegoXmlConstants.COMMENT :
							inComment = true;
							break;
						default :
							//not all local names are processed in this event
							break;
							
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText();
					if(inComment) {
						comment = comment.concat(tagContent);
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.LEGO :
							legoList.addLego(currentLego);
							break;
						case LegoXmlConstants.LEGO_UUID :
							currentLego.setUuid(tagContent);
							break;
						case LegoXmlConstants.COMMENT :
							currentLego.setComment(comment);
							inComment = false;
							comment = "";
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
	
	private Assertion parseAssertionAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Assertion assertion = new Assertion();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.DISCERNIBLE :
							assertion.setDiscernible(parseDiscernibleAndAllChildren(reader));
							break;
						case LegoXmlConstants.QUALIFIER :
							assertion.setQualifier(parseQualifierAndAllChildren(reader));
							break;
						case LegoXmlConstants.VALUE :
							assertion.setValue(parseValueAndAllChildren(reader));
							break;
						case LegoXmlConstants.TIMING :
							assertion.setTiming(parseTimingAndAllChildren(reader));
							break;
						case LegoXmlConstants.ASSERTION_COMPONENT :
							assertion.addAssertionComponent(parseAssertionComponentAndAllChildren(reader));
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
						case LegoXmlConstants.ASSERTION_UUID :
							assertion.setUuid(tagContent);
							break;
						case LegoXmlConstants.ASSERTION :
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
		return assertion;
	}
	
	private Discernible parseDiscernibleAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Discernible discernible = new Discernible();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.EXPRESSION :
							discernible.setExpression(parseExpressionAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.DISCERNIBLE :
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
		return discernible;
	}
	
	private Qualifier parseQualifierAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Qualifier qualifier = new Qualifier();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.EXPRESSION :
							qualifier.setExpression(parseExpressionAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.QUALIFIER :
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
		return qualifier;
	}
	
	private Value parseValueAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Value value = new Value();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.EXPRESSION :
							value.setExpression(parseExpressionAndAllChildren(reader));
							break;
						case LegoXmlConstants.MEASUREMENT :
							value.setMeasurement(parseMeasurementAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.VALUE :
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
		return value;
	}
	
	private Expression parseExpressionAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Expression expression = new Expression();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.CONCEPT :
							expression.setConcept(parseConcept(reader));
							break;
						case LegoXmlConstants.RELATION :
							expression.addRelation(parseRelationAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.EXPRESSION :
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
		return expression;
	}
	
	private Relation parseRelationAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Relation relation = new Relation();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.DESTINATION :
							relation.setDestination(parseDestinationAndAllChildren(reader));
							break;
						case LegoXmlConstants.TYPE :
							relation.setType(parseTypeAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.RELATION :
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
		return relation;
	}
	
	private Type parseTypeAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Type type = new Type();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.CONCEPT :
							type.setConcept(parseConcept(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.TYPE :
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
			if(exit) {
				break;
			}
		}
		//stop processing element
		return type;
	}
	
	private Destination parseDestinationAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Destination destination = new Destination();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.EXPRESSION :
							destination.setExpression(parseExpressionAndAllChildren(reader));
							break;
						case LegoXmlConstants.MEASUREMENT :
							destination.setMeasurement(parseMeasurementAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.DESTINATION :
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
		return destination;
	}
	
	private Measurement parseMeasurementAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Measurement measurement = new Measurement();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.UNITS :
							measurement.setUnits(parseUnitsAndAllChildren(reader));
							break;
						case LegoXmlConstants.POINT :
							measurement.setPoint(parsePointAndAllChildren(reader));
							break;
						case LegoXmlConstants.BOUND :
							measurement.setBound(parseBoundAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.MEASUREMENT :
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
		return measurement;
	}
	
	private Units parseUnitsAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Units units = new Units();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.CONCEPT :
							units.setConcept(parseConcept(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.UNITS :
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
		return units;
	}
	
	private Point parsePointAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		String tagContent = null;
		boolean exit = false;
		Point point = new Point();
		
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if (LegoXmlConstants.TYPE.equals(reader.getAttributeLocalName(index))) {
				point.setType(reader.getAttributeValue(index));
			}
		}
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.VALUE :
							point.setValue(tagContent);
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
		return point;
	}
	
	private Timing parseTimingAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Timing timing = new Timing();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.BOUND :
							timing.setBound(parseBoundAndAllChildren(reader));
							break;
						case LegoXmlConstants.UNITS :
							timing.setUnits(parseUnitsAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.TIMING :
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
		return timing;
	}
	
	private Bound parseBoundAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		Bound bound = new Bound();
		boolean exit = false;
		
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if (LegoXmlConstants.LOWER_POINT_INCLUSIVE.equals(reader.getAttributeLocalName(index))) {
				bound.setLowerPointInclusive(reader.getAttributeValue(index));
			} else if (LegoXmlConstants.UPPER_POINT_INCLUSIVE.equals(reader.getAttributeLocalName(index))) {
				bound.setUpperPointInclusive(reader.getAttributeValue(index));
			}
		}
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.LOWER_POINT :
							bound.setLowerPoint(parsePointAndAllChildren(reader));
							break;
						case LegoXmlConstants.UPPER_POINT :
							bound.setUpperPoint(parsePointAndAllChildren(reader));
							break;
						default :
							//not all local names are processed in this event
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.BOUND :
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
		return bound;
	}
	
	private AssertionComponent parseAssertionComponentAndAllChildren(final XMLStreamReader reader) throws XMLStreamException {
		AssertionComponent assertionComponent = new AssertionComponent();
		String tagContent = null;
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case LegoXmlConstants.TYPE :
							assertionComponent.setType(parseTypeAndAllChildren(reader));
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
						case LegoXmlConstants.ASSERTION_UUID :
							assertionComponent.setUuid(tagContent);
							break;
						case LegoXmlConstants.ASSERTION_COMPONENT :
							exit = true;
							break;
						default :
							//not all local names are processed in this event
							break;
					}
				default :
					//ignore unnecessary events
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return assertionComponent;
	}
	
	private Concept parseConcept(final XMLStreamReader reader) throws XMLStreamException {
		Concept concept = new Concept();
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if (LegoXmlConstants.UUID.equals(reader.getAttributeLocalName(index))) {
				concept.setUuid(reader.getAttributeValue(index));
			} else if (LegoXmlConstants.DESC.equals(reader.getAttributeLocalName(index))) {
				concept.setDesc(reader.getAttributeValue(index));
			} else if (LegoXmlConstants.SCTID.equals(reader.getAttributeLocalName(index))) {
				concept.setSctid(reader.getAttributeValue(index));
			}
		}
		return concept;
	}
	
}
