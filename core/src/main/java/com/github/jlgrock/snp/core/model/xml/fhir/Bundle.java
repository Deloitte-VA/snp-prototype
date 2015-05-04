package com.github.jlgrock.snp.core.model.xml.fhir;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.google.common.base.MoreObjects;
/**
 * Represents the content of FIHR XML document
 *
 */
public class Bundle {
	private Id id;
	private Type type;
	private List<Entry> entries = new ArrayList<>();
	
	public Id getId() {
		return id;
	}

	public void setId(final Id pId) {
		id = pId;
	}

	public Type getType() {
		return type;
	}

	public void setType(final Type pType) {
		type = pType;
	}

	public List<Entry> getEntries() {
		return entries;
	}

	public void setEntries(final List<Entry> pEntries) {
		entries = pEntries;
	}

	/**
	 * Appends the Entry to the end of a list
	 * @param entry Entry to be appended to the list
	 */
	public void addEntry(final Entry entry) {
		entries.add(entry);
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
			//start Bundle element
			xmlStreamWriter.writeStartElement(FihrXmlConstants.BUNDLE);
			xmlStreamWriter.writeNamespace("", "http://hl7.org/fhir");
			//start/end id element
			xmlStreamWriter.writeEmptyElement(FihrXmlConstants.ID);
            xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, id.getValue());
            //start/end type element
			xmlStreamWriter.writeEmptyElement(FihrXmlConstants.TYPE);
            xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, type.getValue());	
			
			writeEntryElem(xmlStreamWriter);
			
			//end Bundle element
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
	
	/**
	 * Write the Entry class as an XML element
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeEntryElem(final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		for(Entry entry : entries) {
			//start entry element
			xmlStreamWriter.writeStartElement(FihrXmlConstants.ENTRY);
			
			writeResourceElem(entry.getResource(), xmlStreamWriter);
			
            //end entry element
			xmlStreamWriter.writeEndElement();
		}
	}
	
	/**
	 * Write the Resource class as an XML element
	 * @param resource Resource
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeResourceElem(final Resource resource, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start resource element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.RESOURCE);
		
		writeConditionElem(resource.getCondition(), xmlStreamWriter);
		
		//end resource element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Condition class as an XML element
	 * @param condition Condition
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeConditionElem(final Condition condition, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start Condition element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.CONDITION);
		//start subject element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.SUBJECT);
		xmlStreamWriter.writeCharacters(condition.getSubject());
		//end subject element
		xmlStreamWriter.writeEndElement();
		//start encounter element
		if(condition.getEncounter().trim().isEmpty()) {
			//start/end encounter element
			xmlStreamWriter.writeEmptyElement(FihrXmlConstants.ENCOUNTER);
		} else {
			xmlStreamWriter.writeStartElement(FihrXmlConstants.ENCOUNTER);
			xmlStreamWriter.writeCharacters(condition.getEncounter());
			//end encounter element
			xmlStreamWriter.writeEndElement();
		}
		
		//start asserter element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.ASSERTER);
		xmlStreamWriter.writeCharacters(condition.getAsserter());
		//end asserter element
		xmlStreamWriter.writeEndElement();
		//start dateAsserted element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.DATE_ASSERTED);
		xmlStreamWriter.writeCharacters(condition.getDateAsserted());
		//end dateAsserted element
		xmlStreamWriter.writeEndElement();
		
		writeCodeElem(condition.getCode(), xmlStreamWriter);
		
		writeCategoryElem(condition.getCategory(), xmlStreamWriter);
		
		//start/end status element
		xmlStreamWriter.writeEmptyElement(FihrXmlConstants.STATUS);
		xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, condition.getStatus().getValue());
		
		writeOnsetElem(condition.getOnset(), xmlStreamWriter);
		
		writeLocationElem(condition.getLocation(), xmlStreamWriter);
		
		//start notes element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.NOTES);
		xmlStreamWriter.writeCharacters(condition.getNotes());
		//end notes element
		xmlStreamWriter.writeEndElement();		
		//end Condition element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Code class as an XML element
	 * @param code Code
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeCodeElem(final Code code, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start code element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.CODE);
		//start coding element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.CODING);
		//start/end system element
		xmlStreamWriter.writeEmptyElement(FihrXmlConstants.SYSTEM);
        xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, code.getCoding().getSystem().getValue());
        //start/end code element
      	xmlStreamWriter.writeEmptyElement(FihrXmlConstants.CODE);
        xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, code.getCoding().getCode().getValue());
        //start/end display element
      	xmlStreamWriter.writeEmptyElement(FihrXmlConstants.DISPLAY);
        xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, code.getCoding().getDisplay().getValue());
		//end coding element
		xmlStreamWriter.writeEndElement();
		//end code element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Category class as an XML element
	 * @param category Category
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeCategoryElem(final Category category, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start category element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.CATEGORY);
		
		writeCodeElem(category.getCode(), xmlStreamWriter);
		
		//end category element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Onset class as an XML element
	 * @param onset Onset
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeOnsetElem(final Onset onset, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start onset element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.ONSET);
		//start/end onsetDateTime element
      	xmlStreamWriter.writeEmptyElement(FihrXmlConstants.ONSET_DATE_TIME);
        xmlStreamWriter.writeAttribute(FihrXmlConstants.VALUE, onset.getOnsetDateTime().getValue());
		//end onset element
		xmlStreamWriter.writeEndElement();
	}
	
	/**
	 * Write the Location class as an XML element
	 * @param location Location
	 * @param xmlStreamWriter XMLStreamWriter
	 * @throws XMLStreamException XMLStreamException
	 */
	public void writeLocationElem(final Location location, final XMLStreamWriter xmlStreamWriter) throws XMLStreamException {
		//start location element
		xmlStreamWriter.writeStartElement(FihrXmlConstants.LOCATION);
		
		writeCodeElem(location.getCode(), xmlStreamWriter);
		
		//end location element
		xmlStreamWriter.writeEndElement();
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
		.add("id", id)
		.add("type", type)
		.add("entries", entries)
		.toString();
	}
	
}
