package com.github.jlgrock.snp.core.model.xml.fhir;

/**
 * This interface declares the constants used parsing
 * FIHR xml documents
 */
public final class FihrXmlConstants {

	/**
     * private constructor for utility class
     */
	private FihrXmlConstants() {}
	
	public static final String BUNDLE = "Bundle";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String ENTRY = "entry";
	public static final String RESOURCE = "resource";
	public static final String CONDITION = "Condition";
	public static final String SUBJECT = "subject";
	public static final String ENCOUNTER = "encounter";
	public static final String ASSERTER = "asserter";
	public static final String DATE_ASSERTED = "dateAsserted";
	public static final String CODE = "code";
	public static final String CODING = "coding";
	public static final String SYSTEM = "system";
	public static final String DISPLAY = "display";
	public static final String CATEGORY = "category";
	public static final String STATUS = "status";
	public static final String ONSET = "onset";
	public static final String ONSET_DATE_TIME = "onsetDateTime";
	public static final String LOCATION = "location";
	public static final String NOTES = "notes";
}
