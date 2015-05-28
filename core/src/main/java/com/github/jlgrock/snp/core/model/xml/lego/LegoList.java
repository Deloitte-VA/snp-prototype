package com.github.jlgrock.snp.core.model.xml.lego;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.google.common.base.MoreObjects;
/**
 * Represents the content of LEGO XML document
 * @deprecated
 */
public class LegoList {
	private String groupName;
	private String uuid;
	private String groupDescription;
	private String comment;
	private List<Lego> legos = new ArrayList<>();
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(final String pGroupName) {
		groupName = pGroupName;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(final String pUuid) {
		uuid = pUuid;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(final String pGroupDescription) {
		groupDescription = pGroupDescription;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(final String pComment) {
		comment = pComment;
	}
	
	public List<Lego> getLegos() {
		return legos;
	}
	
	public void setLegos(final List<Lego> pLegos) {
		legos = pLegos;
	}

	/**
	 * Appends the Lego to the end of a list
	 * @param lego Lego to be appended to the list
	 */
	public void addLego(final Lego lego) {
		legos.add(lego);
	}
	
	/**
	 * Write the Lego class as an XML element
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeLegosElem(final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(Lego lego : legos) {
			//start lego element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.LEGO);
			//start legoUUID element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.LEGO_UUID);
			xmlStreamWriter.writeCharacters(lego.getUuid());
			//end legoUUID element
			xmlStreamWriter.writeEndElement();			
			Stamp stamp = lego.getStamp();
			//start/end stamp element
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.STAMP);
            xmlStreamWriter.writeAttribute(LegoXmlConstants.STATUS, stamp.getStatus());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.TIME, stamp.getTime());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.AUTHOR, stamp.getAuthor());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.MODULE, stamp.getModule());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.PATH, stamp.getPath());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, stamp.getUuid());
			Pncs pncs = lego.getPncs();
			//start/end pncs element
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.PNCS);
            xmlStreamWriter.writeAttribute(LegoXmlConstants.ID, pncs.getId());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.NAME, pncs.getName());
            xmlStreamWriter.writeAttribute(LegoXmlConstants.VALUE, pncs.getValue());
            
            writeAssertionElem(lego.getAssertion(), xmlStreamWriter);
            
            //lego element does not always have an comment element
            String commentStr = lego.getComment();            
            if(commentStr != null) {
            	//start comment element
            	xmlStreamWriter.writeStartElement(LegoXmlConstants.COMMENT);
            	xmlStreamWriter.writeCharacters(lego.getComment());
                //end comment element
            	xmlStreamWriter.writeEndElement();
            }            
            
            //end lego element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	/**
	 * Write the Assertion class as an XML element
	 * @param assertion Assertion
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeAssertionElem(final Assertion assertion, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start assertion element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.ASSERTION);
		//start assertionUUID element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.ASSERTION_UUID);
		xmlStreamWriter.writeCharacters(assertion.getUuid());
		//end assertionUUID element
		xmlStreamWriter.writeEndElement();

		writeDiscernibleElem(assertion.getDiscernible(), xmlStreamWriter);
		writeQualifierElem(assertion.getQualifier(), xmlStreamWriter);
		writeValueElem(assertion.getValue(), xmlStreamWriter);
		//assertion element does not always have a timing element
		if(assertion.getTiming() != null) {
			writeTimingElem(assertion.getTiming(), xmlStreamWriter);
		}
		//assertion element does not always have a assertionComponent element
		if(assertion.getAssertionComponents() != null) {
			writeAssertionComponentElem(assertion.getAssertionComponents(), xmlStreamWriter);
		}
		//end assertion element
		xmlStreamWriter.writeEndElement();	
	}
	
	/**
	 * Write the Discernible class as an XML element
	 * @param discernible Discernible
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeDiscernibleElem(final Discernible discernible, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start discernible element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.DISCERNIBLE);
		writeExpressionElem(discernible.getExpression(), xmlStreamWriter);
		//end discernible element
		xmlStreamWriter.writeEndElement();	
	}
	
	/**
	 * Write the Qualifier class as an XML element
	 * @param qualifier Qualifier
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeQualifierElem(final Qualifier qualifier, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start qualifier element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.QUALIFIER);
		writeExpressionElem(qualifier.getExpression(), xmlStreamWriter);
		//end qualifier element
		xmlStreamWriter.writeEndElement();	
	}
	
	/**
	 * Write the Value class as an XML element
	 * @param value Value
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeValueElem(final Value value, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		if(value.getExpression() == null && value.getMeasurement() == null) {
			//start/end value element
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.VALUE);
		} else {
			//start value element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.VALUE);
			//value element does not always have an expression element
			if(value.getExpression() != null) {
				writeExpressionElem(value.getExpression(), xmlStreamWriter);
			}
			//value element does not always have an measurement element
			if(value.getMeasurement() != null) {
				writeMeasurementElem(value.getMeasurement(), xmlStreamWriter);
			}
			
			//end value element
			xmlStreamWriter.writeEndElement();	
		}
	}
	
	/**
	 * Write the Expression class as an XML element
	 * @param expression Expression
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeExpressionElem(final Expression expression, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start expression element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.EXPRESSION);
		Concept concept = expression.getConcept();
		//start/end concpet element
		xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
		if(concept.getSctid() != null) {
			 xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, concept.getSctid());
		}
       
		if(concept.getUuid() != null) {
			xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, concept.getUuid());
		}
        
		if(concept.getDesc() != null) {
			xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, concept.getDesc());
		}        
        
        writeRelationElem(expression.getRelations(), xmlStreamWriter);
        
		//end expression element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Measurement class as an XML element
	 * @param measurement Measurement
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeMeasurementElem(final Measurement measurement, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start measurement element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.MEASUREMENT);
		//measurement element does not always have a units element
		Units units = measurement.getUnits();
		if(units != null) {
			//start units element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.UNITS);
			//start/end concept element
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, units.getConcept().getSctid());
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, units.getConcept().getUuid());
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, units.getConcept().getDesc());
			//end units element
			xmlStreamWriter.writeEndElement();
		}
		
		Point point =  measurement.getPoint();
		//measurement element does not always have a point element
		if(point != null) {
			//start point element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.POINT);
			xmlStreamWriter.writeAttribute(LegoXmlConstants.XSI, "", LegoXmlConstants.TYPE, point.getType());
			//start value element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.VALUE);
			xmlStreamWriter.writeCharacters(point.getValue());
			//end value element
			xmlStreamWriter.writeEndElement();
			//end point element
			xmlStreamWriter.writeEndElement();
		}		
        
		Bound bound =  measurement.getBound();
		//measurement element does not always have a bound element
		if(bound != null) {
			writeBoundElem(bound, xmlStreamWriter);
		}	
		
		//end measurement element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Relation class as an XML element
	 * @param relations collection of Relation objects
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeRelationElem(final List<Relation> relations, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(Relation relation : relations) {
			//start relation element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.RELATION);
			//start type element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.TYPE);
			Type type = relation.getType();
			//start/end concept element			
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, type.getConcept().getSctid());
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, type.getConcept().getUuid());
	        xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, type.getConcept().getDesc());
			//end type element
			xmlStreamWriter.writeEndElement();
			//start destination element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.DESTINATION);
			Expression expression = relation.getDestination().getExpression();
			if(expression != null) {
				writeExpressionElem(expression, xmlStreamWriter);
			}
			Measurement measurement = relation.getDestination().getMeasurement();
			if(measurement != null) {
				//start measurement element
				xmlStreamWriter.writeStartElement(LegoXmlConstants.MEASUREMENT);
				Units units = measurement.getUnits();
				//start units element			
				xmlStreamWriter.writeStartElement(LegoXmlConstants.UNITS);
				//start/end concept element			
				xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
		        xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, units.getConcept().getSctid());
		        xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, units.getConcept().getUuid());
		        xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, units.getConcept().getDesc());
				//end units element
		        xmlStreamWriter.writeEndElement();
		        //start point element			
				xmlStreamWriter.writeStartElement(LegoXmlConstants.POINT);
				xmlStreamWriter.writeAttribute(LegoXmlConstants.XSI, "", LegoXmlConstants.TYPE, measurement.getPoint().getType());
				//start value element			
				xmlStreamWriter.writeStartElement(LegoXmlConstants.VALUE);
				xmlStreamWriter.writeCharacters(measurement.getPoint().getValue());
				//end value element
				xmlStreamWriter.writeEndElement();
				//end point element
				xmlStreamWriter.writeEndElement();
				//end measurement element
				xmlStreamWriter.writeEndElement();
			}
			//end destination element
			xmlStreamWriter.writeEndElement();
			//end relation element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	/**
	 * Write the Timing class as an XML element
	 * @param timing Timing
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeTimingElem(final Timing timing, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start timing element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.TIMING);
		
		//timing element does not always have a units element
		Units units = timing.getUnits();
		if(units != null) {
			//start units element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.UNITS);
			//start/end concept element
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
			xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, units.getConcept().getSctid());
			xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, units.getConcept().getUuid());
			xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, units.getConcept().getDesc());
			//end units element
			xmlStreamWriter.writeEndElement();
		}
				
		Bound bound =  timing.getBound();
		//timing element does not always have a bound element
		if(bound != null) {
			writeBoundElem(bound, xmlStreamWriter);
		}	

		//end timing element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Bound class as an XML element
	 * @param bound Bound
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeBoundElem(final Bound bound,  final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start bound element
		xmlStreamWriter.writeStartElement(LegoXmlConstants.BOUND);
		String lowerPointInclusive = bound.getLowerPointInclusive();
		if(lowerPointInclusive != null) {
			xmlStreamWriter.writeAttribute(LegoXmlConstants.LOWER_POINT_INCLUSIVE, lowerPointInclusive);
		}
		String upperPointInclusive = bound.getUpperPointInclusive();
		if(upperPointInclusive != null) {
			xmlStreamWriter.writeAttribute(LegoXmlConstants.UPPER_POINT_INCLUSIVE, upperPointInclusive);
		}
		Point lowerPoint = bound.getLowerPoint();
		if(lowerPoint != null) {
			//start lowerPoint element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.LOWER_POINT);
			xmlStreamWriter.writeAttribute(LegoXmlConstants.XSI, "", LegoXmlConstants.TYPE, lowerPoint.getType());
			//start value element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.VALUE);
			xmlStreamWriter.writeCharacters(lowerPoint.getValue());
			//end value element
			xmlStreamWriter.writeEndElement();
			//end lowerPoint element
			xmlStreamWriter.writeEndElement();
		}

		Point upperPoint = bound.getUpperPoint();
		if(upperPoint != null) {
			//start upperPoint element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.UPPER_POINT);
			xmlStreamWriter.writeAttribute(LegoXmlConstants.XSI, "", LegoXmlConstants.TYPE, upperPoint.getType());
			//start value element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.VALUE);
			xmlStreamWriter.writeCharacters(upperPoint.getValue());
			//end value element
			xmlStreamWriter.writeEndElement();
			//end upperPoint element
			xmlStreamWriter.writeEndElement();
		}
		
		//end bound element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the AssertionComponent class as an XML element
	 * @param assertionComponents collection of AssertionComponent objects
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeAssertionComponentElem(final List<AssertionComponent> assertionComponents, final XMLStreamWriter xmlStreamWriter)
			throws XMLStreamException {
		for(AssertionComponent assertionComponent : assertionComponents) {
			//start assertionComponent element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.ASSERTION_COMPONENT);
			//start assertionUUID element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.ASSERTION_UUID);
			xmlStreamWriter.writeCharacters(assertionComponent.getUuid());
			//end assertionUUID element
			xmlStreamWriter.writeEndElement();
			//start type element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.TYPE);
			Type type = assertionComponent.getType();
			//start/end concept element			
			xmlStreamWriter.writeEmptyElement(LegoXmlConstants.CONCEPT);
			xmlStreamWriter.writeAttribute(LegoXmlConstants.SCTID, type.getConcept().getSctid());
			xmlStreamWriter.writeAttribute(LegoXmlConstants.UUID, type.getConcept().getUuid());
			xmlStreamWriter.writeAttribute(LegoXmlConstants.DESC, type.getConcept().getDesc());
			//end type element
			xmlStreamWriter.writeEndElement();
			//end assertionComponent element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	/**
	 * Returns a formatted XML representation of the object
	 * @return a formatted XML representation of the object
	 * @throws Exception Exception
	 */
	public String prettyPrintXml() throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		StringWriter stringWriter = new StringWriter();
	    StreamResult streamResult = new StreamResult(stringWriter);
	 
	    transformer.transform(new StreamSource(new StringReader(toXml())), streamResult);
	    
	    return stringWriter.toString();
	}
	
	/**
	 * Returns an XML representation of the object
	 * @return an xml representation of the object
	 * @throws Exception Exception
	 */
	public String toXml() throws Exception {
		String xmlStr = "";
		StringWriter stringWriter = new StringWriter();
		XMLStreamWriter xmlStreamWriter = null;
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
			xmlStreamWriter = outputFactory.createXMLStreamWriter(stringWriter);			
			//start legoList element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.LEGO_LIST);
			xmlStreamWriter.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
			xmlStreamWriter.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance",
					"noNamespaceSchemaLocation", "LEGO.xsd");
			//start groupName element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.GROUP_NAME);
			xmlStreamWriter.writeCharacters(groupName);
			//end groupName element
			xmlStreamWriter.writeEndElement();
			//start legoListUUID element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.LEGO_LIST_UUID);
			xmlStreamWriter.writeCharacters(uuid);
			//end legoListUUID element
			xmlStreamWriter.writeEndElement();
			//start groupDescription element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.GROUP_DESCRIPTION);
			xmlStreamWriter.writeCharacters(groupDescription);
			//end groupDescription element
			xmlStreamWriter.writeEndElement();
			//start comment element
			xmlStreamWriter.writeStartElement(LegoXmlConstants.COMMENT);
			xmlStreamWriter.writeCharacters(comment.trim());
			//end comment element
			xmlStreamWriter.writeEndElement();			
			
			writeLegosElem(xmlStreamWriter);
			
			//end legoList element
			xmlStreamWriter.writeEndElement();
			//write end document
            xmlStreamWriter.writeEndDocument();            
            //flush data to file and close writer
			xmlStreamWriter.flush();
			xmlStr = stringWriter.getBuffer().toString();
		} finally {
			if(xmlStreamWriter != null) {
				xmlStreamWriter.close();
			}

			if(stringWriter != null) {
				stringWriter.close();
			}
		}

		return xmlStr;
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("groupName", groupName)
		.add("uuid", uuid)
		.add("groupDescription", groupDescription)
		.add("comment", comment)
		.add("legos", legos)
		.toString();
	}
	
}
