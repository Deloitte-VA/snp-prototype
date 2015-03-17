package com.github.jlgrock.snp.core.parser;

import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.github.jlgrock.snp.core.model.Assertion;
import com.github.jlgrock.snp.core.model.AssertionComponent;
import com.github.jlgrock.snp.core.model.Bound;
import com.github.jlgrock.snp.core.model.Concept;
import com.github.jlgrock.snp.core.model.Destination;
import com.github.jlgrock.snp.core.model.Discernible;
import com.github.jlgrock.snp.core.model.Expression;
import com.github.jlgrock.snp.core.model.Lego;
import com.github.jlgrock.snp.core.model.LegoList;
import com.github.jlgrock.snp.core.model.Measurement;
import com.github.jlgrock.snp.core.model.Pncs;
import com.github.jlgrock.snp.core.model.Point;
import com.github.jlgrock.snp.core.model.Qualifier;
import com.github.jlgrock.snp.core.model.Relation;
import com.github.jlgrock.snp.core.model.Stamp;
import com.github.jlgrock.snp.core.model.Timing;
import com.github.jlgrock.snp.core.model.Type;
import com.github.jlgrock.snp.core.model.Units;
import com.github.jlgrock.snp.core.model.Value;

/**
 * Parses LEGO XML document for retrieving Post Coordinated Expressions (PCEs)
 *
 */
public class LegoXmlParser {
	//this is the list which shall be populated while parsing the XML
	private LegoList legoList;
		
	public LegoList parseDocument(InputStream xmlInput) {
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
						if ("lego".equals(reader.getLocalName())) {
							parseLegoAndAllChildren(reader);
						}
						break;
					case XMLStreamConstants.CHARACTERS :
						tagContent = reader.getText();
						break;
					case XMLStreamConstants.END_ELEMENT :
						switch(reader.getLocalName()) {
							case "groupName" :
								legoList.setGroupName(tagContent);
								break;
							case "legoListUUID" :
								legoList.setUuid(tagContent);
								break;
							case "groupDescription" :
								legoList.setGroupDescription(tagContent);
								break;
							case "comment" :
								legoList.setComment(tagContent);
								break;
						}
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
	
	public void parseLegoAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Lego currentLego = new Lego();
		String tagContent = null;
		boolean inComment = false;
		String comment = "";
		
		while(reader.hasNext()) {			
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "lego" :
							currentLego = new Lego();
							break;
						case "stamp" :
							Stamp stamp = new Stamp();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if ("status".equals(reader.getAttributeLocalName(index))) {
									stamp.setStatus(reader.getAttributeValue(index));
								} else if ("uuid".equals(reader.getAttributeLocalName(index))) {
									stamp.setUuid(reader.getAttributeValue(index));
								} else if ("path".equals(reader.getAttributeLocalName(index))) {
									stamp.setPath(reader.getAttributeValue(index));
								} else if ("module".equals(reader.getAttributeLocalName(index))) {
									stamp.setModule(reader.getAttributeValue(index));
								} else if ("author".equals(reader.getAttributeLocalName(index))) {
									stamp.setAuthor(reader.getAttributeValue(index));
								} else if ("time".equals(reader.getAttributeLocalName(index))) {
									stamp.setTime(reader.getAttributeValue(index));
								}
							}
							currentLego.setStamp(stamp);
							break;
						case "pncs" :
							Pncs pncs = new Pncs();
							for(int index = 0;index < reader.getAttributeCount();index++) {
								if ("value".equals(reader.getAttributeLocalName(index))) {
									pncs.setValue(reader.getAttributeValue(index));
								} else if ("name".equals(reader.getAttributeLocalName(index))) {
									pncs.setName(reader.getAttributeValue(index));
								} else if ("id".equals(reader.getAttributeLocalName(index))) {
									pncs.setId(reader.getAttributeValue(index));
								}
							}
							currentLego.setPncs(pncs);
							break;
						case "assertion" :
							currentLego.setAssertion(parseAssertionAndAllChildren(reader));
							break;
						case "comment" :
							inComment = true;
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
						case "lego" :
							legoList.addLego(currentLego);
							break;
						case "legoUUID" :
							currentLego.setUuid(tagContent);
							break;
						case "comment" :
							currentLego.setComment(comment);
							inComment = false;
							comment = "";
							break;
					}
					break;
			}
		}
	}
	
	public Assertion parseAssertionAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Assertion assertion = new Assertion();
		String tagContent = null;
		boolean exit = false;
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "discernible" :
							assertion.setDiscernible(parseDiscernibleAndAllChildren(reader));
							break;
						case "qualifier" :
							assertion.setQualifier(parseQualifierAndAllChildren(reader));
							break;
						case "value" :
							assertion.setValue(parseValueAndAllChildren(reader));
							break;
						case "timing" :
							assertion.setTiming(parseTimingAndAllChildren(reader));
							break;
						case "assertionComponent" :
							assertion.addAssertionComponent(parseAssertionComponentAndAllChildren(reader));
							break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "assertionUUID" :
							assertion.setUuid(tagContent);
							break;
						case "assertion" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return assertion;
	}
	
	public Discernible parseDiscernibleAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Discernible discernible = new Discernible();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "expression" :
							discernible.setExpression(parseExpressionAndAllChildren(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "discernible" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return discernible;
	}
	
	public Qualifier parseQualifierAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Qualifier qualifier = new Qualifier();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "expression" :
							qualifier.setExpression(parseExpressionAndAllChildren(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "qualifier" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return qualifier;
	}
	
	public Value parseValueAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Value value = new Value();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "expression" :
							value.setExpression(parseExpressionAndAllChildren(reader));
							break;
						case "measurement" :
							value.setMeasurement(parseMeasurementAndAllChildren(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "value" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return value;
	}
	
	public Expression parseExpressionAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Expression expression = new Expression();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "concept" :
							expression.setConcept(parseConcept(reader));
							break;
						case "relation" :
							expression.addRelation(parseRelationAndAllChildren(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "expression" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return expression;
	}
	
	public Relation parseRelationAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Relation relation = new Relation();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
					case "destination" :
						relation.setDestination(parseDestinationAndAllChildren(reader));
						break;
					case "type" :
						relation.setType(parseTypeAndAllChildren(reader));
						break;
				}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "relation" :
							exit = true;
							break;
				}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return relation;
	}
	
	public Type parseTypeAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Type type = new Type();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "concept" :
							type.setConcept(parseConcept(reader));
						break;
				}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "type" :
							exit = true;
							break;
				}
					break;
			}
			if(exit) {
				break;
			}
		}
		//stop processing element
		return type;
	}
	
	public Destination parseDestinationAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Destination destination = new Destination();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "expression" :
							destination.setExpression(parseExpressionAndAllChildren(reader));
							break;
						case "measurement" :
							destination.setMeasurement(parseMeasurementAndAllChildren(reader));
							break;
						}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "destination" :
							exit = true;
							break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return destination;
	}
	
	public Measurement parseMeasurementAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Measurement measurement = new Measurement();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
					case "units" :
						measurement.setUnits(parseUnitsAndAllChildren(reader));
						break;
					case "point" :
						switch(reader.getLocalName()) {
							case "point" :
								measurement.setPoint(parsePointAndAllChildren(reader));
								break;
						}
						break;
					case "bound" :
						measurement.setBound(parseBoundAndAllChildren(reader));
						break;
				}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "measurement" :
							exit = true;
							break;
				}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return measurement;
	}
	
	public Units parseUnitsAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Units units = new Units();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "concept" :
							units.setConcept(parseConcept(reader));
							break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "units" :
							exit = true;
							break;
				}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return units;
	}
	
	public Point parsePointAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		String tagContent = null;
		boolean exit = false;
		Point point = new Point();
		
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if ("type".equals(reader.getAttributeLocalName(index))) {
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
						case "value" :
							point.setValue(tagContent);
							exit = true;
							break;
				}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return point;
	}
	
	public Timing parseTimingAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Timing timing = new Timing();
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
						case "bound" :
							timing.setBound(parseBoundAndAllChildren(reader));
							break;
						case "units" :
							timing.setUnits(parseUnitsAndAllChildren(reader));
							break;
				}
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "timing" :
							exit = true;
							break;
				}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return timing;
	}
	
	public Bound parseBoundAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		Bound bound = new Bound();
		boolean exit = false;
		
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if ("lowerPointInclusive".equals(reader.getAttributeLocalName(index))) {
				bound.setLowerPointInclusive(reader.getAttributeValue(index));
			} else if ("upperPointInclusive".equals(reader.getAttributeLocalName(index))) {
				bound.setUpperPointInclusive(reader.getAttributeValue(index));
			}
		}
		
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
					case "lowerPoint" :
						bound.setLowerPoint(parsePointAndAllChildren(reader));
						break;
					case "upperPoint" :
						bound.setUpperPoint(parsePointAndAllChildren(reader));
						break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
					case "bound" :
						exit = true;
						break;
					}
					break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return bound;
	}
	
	public AssertionComponent parseAssertionComponentAndAllChildren(XMLStreamReader reader) throws XMLStreamException {
		AssertionComponent assertionComponent = new AssertionComponent();
		String tagContent = null;
		boolean exit = false;
		while(reader.hasNext()) {
			int event = reader.next();
			switch (event) {
				case XMLStreamConstants.START_ELEMENT :
					switch(reader.getLocalName()) {
					case "type" :
						assertionComponent.setType(parseTypeAndAllChildren(reader));
						break;
					}
					break;
				case XMLStreamConstants.CHARACTERS :
					tagContent = reader.getText().trim();
					break;
				case XMLStreamConstants.END_ELEMENT :
					switch(reader.getLocalName()) {
						case "assertionUUID" :
							assertionComponent.setUuid(tagContent);
							break;
						case "assertionComponent" :
							exit = true;
							break;
					}
				break;
			}
			//stop processing element
			if(exit) {
				break;
			}
		}
		return assertionComponent;
	}
	
	public Concept parseConcept(XMLStreamReader reader) throws XMLStreamException {
		Concept concept = new Concept();
		for(int index = 0;index < reader.getAttributeCount();index++) {
			if ("uuid".equals(reader.getAttributeLocalName(index))) {
				concept.setUuid(reader.getAttributeValue(index));
			} else if ("desc".equals(reader.getAttributeLocalName(index))) {
				concept.setDesc(reader.getAttributeValue(index));
			} else if ("sctid".equals(reader.getAttributeLocalName(index))) {
				concept.setSctid(reader.getAttributeValue(index));
			}
		}
		return concept;
	}
	
}
