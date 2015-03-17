package com.github.jlgrock.snp.core.model;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
/**
 * Represents the content of LEGO XML document
 *
 */
public class LegoList {
	private String groupName;
	private String uuid;
	private String groupDescription;
	private String comment;
	private List<Lego> legos = new ArrayList<Lego>();
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getUuid() {
		return uuid;
	}
	
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public List<Lego> getLegos() {
		return legos;
	}
	
	public void setLegos(List<Lego> legos) {
		this.legos = legos;
	}

	public void addLego(Lego lego) {
		legos.add(lego);
	}
	
	public void writeLegosElem(XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(Lego lego : legos) {
			//start lego element
			xmlStreamWriter.writeStartElement("lego");
			//start legoUUID element
			xmlStreamWriter.writeStartElement("legoUUID");
			xmlStreamWriter.writeCharacters(lego.getUuid());
			//end legoUUID element
			xmlStreamWriter.writeEndElement();			
			Stamp stamp = lego.getStamp();
			//start/end stamp element
			xmlStreamWriter.writeEmptyElement("stamp");
            xmlStreamWriter.writeAttribute("status", stamp.getStatus());
            xmlStreamWriter.writeAttribute("time", stamp.getTime());
            xmlStreamWriter.writeAttribute("author", stamp.getAuthor());
            xmlStreamWriter.writeAttribute("module", stamp.getModule());
            xmlStreamWriter.writeAttribute("path", stamp.getPath());
            xmlStreamWriter.writeAttribute("uuid", stamp.getUuid());
			Pncs pncs = lego.getPncs();
			//start/end pncs element
			xmlStreamWriter.writeEmptyElement("pncs");
            xmlStreamWriter.writeAttribute("id", pncs.getId());
            xmlStreamWriter.writeAttribute("name", pncs.getName());
            xmlStreamWriter.writeAttribute("value", pncs.getValue());
            
            writeAssertionElem(lego.getAssertion(), xmlStreamWriter);
            
            //lego element does not always have an comment element
            String comment = lego.getComment();            
            if(comment != null) {
            	//start comment element
            	xmlStreamWriter.writeStartElement("comment");
            	xmlStreamWriter.writeCharacters(lego.getComment());
                //end comment element
            	xmlStreamWriter.writeEndElement();
            }            
            
            //end lego element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	public void writeAssertionElem(Assertion assertion, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start assertion element
		xmlStreamWriter.writeStartElement("assertion");
		//start assertionUUID element
		xmlStreamWriter.writeStartElement("assertionUUID");
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
	
	public void writeDiscernibleElem(Discernible discernible, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start discernible element
		xmlStreamWriter.writeStartElement("discernible");
		writeExpressionElem(discernible.getExpression(), xmlStreamWriter);
		//end discernible element
		xmlStreamWriter.writeEndElement();	
	}
	
	public void writeQualifierElem(Qualifier qualifier, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start qualifier element
		xmlStreamWriter.writeStartElement("qualifier");
		writeExpressionElem(qualifier.getExpression(), xmlStreamWriter);
		//end qualifier element
		xmlStreamWriter.writeEndElement();	
	}
	
	public void writeValueElem(Value value, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		if(value.getExpression() == null && value.getMeasurement() == null) {
			//start/end value element
			xmlStreamWriter.writeEmptyElement("value");
		} else {
			//start value element
			xmlStreamWriter.writeStartElement("value");
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
	
	public void writeExpressionElem(Expression expression, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start expression element
		xmlStreamWriter.writeStartElement("expression");
		Concept concept = expression.getConcept();
		//start/end concpet element
		xmlStreamWriter.writeEmptyElement("concept");
		if(concept.getSctid() != null) {
			 xmlStreamWriter.writeAttribute("sctid", concept.getSctid());
		}
       
		if(concept.getUuid() != null) {
			xmlStreamWriter.writeAttribute("uuid", concept.getUuid());
		}
        
		if(concept.getDesc() != null) {
			xmlStreamWriter.writeAttribute("desc", concept.getDesc());
		}        
        
        writeRelationElem(expression.getRelations(), xmlStreamWriter);
        
		//end expression element
		xmlStreamWriter.writeEndElement();
	}
	
	public void writeMeasurementElem(Measurement measurement, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start measurement element
		xmlStreamWriter.writeStartElement("measurement");
		//measurement element does not always have a units element
		Units units = measurement.getUnits();
		if(units != null) {
			//start units element
			xmlStreamWriter.writeStartElement("units");
			//start/end concept element
			xmlStreamWriter.writeEmptyElement("concept");
	        xmlStreamWriter.writeAttribute("sctid", units.getConcept().getSctid());
	        xmlStreamWriter.writeAttribute("uuid", units.getConcept().getUuid());
	        xmlStreamWriter.writeAttribute("desc", units.getConcept().getDesc());
			//end units element
			xmlStreamWriter.writeEndElement();
		}
		
		Point point =  measurement.getPoint();
		//measurement element does not always have a point element
		if(point != null) {
			//start point element
			xmlStreamWriter.writeStartElement("point");
			xmlStreamWriter.writeAttribute("xsi", "", "type", point.getType());
			//start value element
			xmlStreamWriter.writeStartElement("value");
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
	
	public void writeRelationElem(List<Relation> relations, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(Relation relation : relations) {
			//start relation element
			xmlStreamWriter.writeStartElement("relation");
			//start type element
			xmlStreamWriter.writeStartElement("type");
			Type type = relation.getType();
			//start/end concept element			
			xmlStreamWriter.writeEmptyElement("concept");
	        xmlStreamWriter.writeAttribute("sctid", type.getConcept().getSctid());
	        xmlStreamWriter.writeAttribute("uuid", type.getConcept().getUuid());
	        xmlStreamWriter.writeAttribute("desc", type.getConcept().getDesc());
			//end type element
			xmlStreamWriter.writeEndElement();
			//start destination element
			xmlStreamWriter.writeStartElement("destination");
			Expression expression = relation.getDestination().getExpression();
			if(expression != null) {
				writeExpressionElem(expression, xmlStreamWriter);
			}
			Measurement measurement = relation.getDestination().getMeasurement();
			if(measurement != null) {
				//start measurement element
				xmlStreamWriter.writeStartElement("measurement");
				Units units = measurement.getUnits();
				//start units element			
				xmlStreamWriter.writeStartElement("units");
				//start/end concept element			
				xmlStreamWriter.writeEmptyElement("concept");
		        xmlStreamWriter.writeAttribute("sctid", units.getConcept().getSctid());
		        xmlStreamWriter.writeAttribute("uuid", units.getConcept().getUuid());
		        xmlStreamWriter.writeAttribute("desc", units.getConcept().getDesc());
				//end units element
		        xmlStreamWriter.writeEndElement();
		        //start point element			
				xmlStreamWriter.writeStartElement("point");
				xmlStreamWriter.writeAttribute("xsi", "", "type", measurement.getPoint().getType());
				//start value element			
				xmlStreamWriter.writeStartElement("value");
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
	
	public void writeTimingElem(Timing timing, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start timing element
		xmlStreamWriter.writeStartElement("timing");
		
		//timing element does not always have a units element
		Units units = timing.getUnits();
		if(units != null) {
			//start units element
			xmlStreamWriter.writeStartElement("units");
			//start/end concept element
			xmlStreamWriter.writeEmptyElement("concept");
			xmlStreamWriter.writeAttribute("sctid", units.getConcept().getSctid());
			xmlStreamWriter.writeAttribute("uuid", units.getConcept().getUuid());
			xmlStreamWriter.writeAttribute("desc", units.getConcept().getDesc());
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
	
	public void writeBoundElem(Bound bound,  XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start bound element
		xmlStreamWriter.writeStartElement("bound");
		String lowerPointInclusive = bound.getLowerPointInclusive();
		if(lowerPointInclusive != null) {
			xmlStreamWriter.writeAttribute("lowerPointInclusive", lowerPointInclusive);
		}
		String upperPointInclusive = bound.getUpperPointInclusive();
		if(upperPointInclusive != null) {
			xmlStreamWriter.writeAttribute("upperPointInclusive", upperPointInclusive);
		}
		Point lowerPoint = bound.getLowerPoint();
		if(lowerPoint != null) {
			//start lowerPoint element
			xmlStreamWriter.writeStartElement("lowerPoint");
			xmlStreamWriter.writeAttribute("xsi", "", "type", lowerPoint.getType());
			//start value element
			xmlStreamWriter.writeStartElement("value");
			xmlStreamWriter.writeCharacters(lowerPoint.getValue());
			//end value element
			xmlStreamWriter.writeEndElement();
			//end lowerPoint element
			xmlStreamWriter.writeEndElement();
		}

		Point upperPoint = bound.getUpperPoint();
		if(upperPoint != null) {
			//start upperPoint element
			xmlStreamWriter.writeStartElement("upperPoint");
			xmlStreamWriter.writeAttribute("xsi", "", "type", upperPoint.getType());
			//start value element
			xmlStreamWriter.writeStartElement("value");
			xmlStreamWriter.writeCharacters(upperPoint.getValue());
			//end value element
			xmlStreamWriter.writeEndElement();
			//end upperPoint element
			xmlStreamWriter.writeEndElement();
		}
		
		//end bound element
		xmlStreamWriter.writeEndElement();
	}
	
	public void writeAssertionComponentElem(List<AssertionComponent> assertionComponents, XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(AssertionComponent assertionComponent : assertionComponents) {
			//start assertionComponent element
			xmlStreamWriter.writeStartElement("assertionComponent");
			//start assertionUUID element
			xmlStreamWriter.writeStartElement("assertionUUID");
			xmlStreamWriter.writeCharacters(assertionComponent.getUuid());
			//end assertionUUID element
			xmlStreamWriter.writeEndElement();
			//start type element
			xmlStreamWriter.writeStartElement("type");
			Type type = assertionComponent.getType();
			//start/end concept element			
			xmlStreamWriter.writeEmptyElement("concept");
			xmlStreamWriter.writeAttribute("sctid", type.getConcept().getSctid());
			xmlStreamWriter.writeAttribute("uuid", type.getConcept().getUuid());
			xmlStreamWriter.writeAttribute("desc", type.getConcept().getDesc());
			//end type element
			xmlStreamWriter.writeEndElement();
			//end assertionComponent element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	/**
	 * Returns a formatted XML representation of the object
	 * @return
	 * @throws TransformerFactoryConfigurationError
	 * @throws TransformerException
	 * @throws XMLStreamException
	 * @throws IOException
	 */
	public String prettyPrintXml() throws TransformerFactoryConfigurationError, TransformerException, XMLStreamException, IOException {
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
	 * @return
	 * @throws XMLStreamException
	 * @throws IOException
	 */
	public String toXml() throws XMLStreamException, IOException {
		String xmlStr = "";
		StringWriter stringWriter = new StringWriter();
		XMLStreamWriter xmlStreamWriter = null;
		try {
			XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();
			xmlStreamWriter = outputFactory.createXMLStreamWriter(stringWriter);			
			//start legoList element
			xmlStreamWriter.writeStartElement("legoList");
			xmlStreamWriter.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
			xmlStreamWriter.writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "noNamespaceSchemaLocation", "LEGO.xsd");
			//start groupName element
			xmlStreamWriter.writeStartElement("groupName");
			xmlStreamWriter.writeCharacters(groupName);
			//end groupName element
			xmlStreamWriter.writeEndElement();
			//start legoListUUID element
			xmlStreamWriter.writeStartElement("legoListUUID");
			xmlStreamWriter.writeCharacters(uuid);
			//end legoListUUID element
			xmlStreamWriter.writeEndElement();
			//start groupDescription element
			xmlStreamWriter.writeStartElement("groupDescription");
			xmlStreamWriter.writeCharacters(groupDescription);
			//end groupDescription element
			xmlStreamWriter.writeEndElement();
			//start comment element
			xmlStreamWriter.writeStartElement("comment");
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
		return "LegoList [groupName=" + groupName + ", uuid=" + uuid + ", groupDescription=" + groupDescription
				+ ", comment=" + comment + ", legos=" + legos + "]";
	}
	
}
