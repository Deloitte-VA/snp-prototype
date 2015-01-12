package com.deloitte.mongo.sample;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PocDemo2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemo2.class);

    public static void main(String[] args) throws Exception {
        PocDemo2 poc = new PocDemo2();
        poc.query();
    }

    public void query() {
        // connect to the local database server
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient("192.168.59.103", 27017); //boot2docker ip address
        } catch (UnknownHostException e) {
            LOGGER.error("Unable to connect to MongoDB", e);
            return;
        }

        // get handle for db
        DB db = mongoClient.getDB("test");  //instance name under docker VM

        LOGGER.trace("Displaying the filtered data from encountered collection: ");

        //First, get the "encounters" collection from then database
        DBCollection testCollection = db.getCollection("encounters");

        //Query to get encounters with right arm observations
        BasicDBObject query = new BasicDBObject("observations.name", (Long) 5695930304L)
                .append("observations.name_type", 1);

        //Just for our display purpose
        LOGGER.trace("Filtering query: " + query);

        //Execute the query and get the filtered collection of items
        DBCursor cursor = testCollection.find(query);

        //Display the count of items in the resultant collection
        LOGGER.debug("Filtered data count (length): " + cursor.length());

        //If you want to display the actual records in the result, try the following code block
        cursor = testCollection.find(query); //Get the cursor value afresh before iterating over the collection


        //Get an array of encounters
        List<Encounter> myRightArmEncounters = convertDBObjectToJavaEncounterObj(cursor);
        LOGGER.debug("myRightArmEncounters=" + myRightArmEncounters + ", size=" + myRightArmEncounters.size());

        Set<Long> uniquePatientIds = new HashSet<Long>();
        for (Encounter rightArmEncounter : myRightArmEncounters) {
            LOGGER.debug("***!myRightArmEncounters patientId=" + rightArmEncounter.getPatient_id());

            MinMaxObservationValue minMaxObservation;
            final Long minObservationValue; //final modifier needed for inner class usage
            final Long maxObservationValue; //final modifier needed for inner class usage

            minMaxObservation = findMinMaxObservation(rightArmEncounter.getObservations());
            minObservationValue = minMaxObservation.getMin();
            maxObservationValue = minMaxObservation.getMax();

            final Long patientId = rightArmEncounter.getPatient_id();  //final modifier needed for inner class usage

            BasicDBObject query2 = new BasicDBObject("$and",
                    new ArrayList<BasicDBObject>() {{
                        add(new BasicDBObject("observations.name", (Long) 5695930310L)
                                        .append("observations.name_type", 1)
                                        .append("patient_id", patientId)
                        );
                        add(new BasicDBObject("$or",
                                        new ArrayList<BasicDBObject>() {{
                                            add(new BasicDBObject("observations.value", new BasicDBObject("$gt", maxObservationValue + 10)));
                                            add(new BasicDBObject("observations.value", new BasicDBObject("$lt", minObservationValue - 10)));
                                        }}
                                )
                        );
                    }}
            );

            LOGGER.trace("Filtering query2: " + query2);

            //Execute the query and get the filtered collection of items
            DBCollection testCollection2 = db.getCollection("encounters");
            DBCursor cursor2 = testCollection2.find(query2);

            //Display the count of items in the resultant collection
            LOGGER.debug("Filtered data count (length): " + cursor2.length());

            //To avoid "can't switch cursor access methods" illegal argument exception, which occurs if you try
            //to access cursor.next() method after you access cursor.lenghth() method
            //For more info refer to http://stackoverflow.com/questions/15461138/rare-behavior-with-mongodb-cursor-dbcursor-in-java-even-though-last-element-i

            cursor2 = testCollection2.find(query2);

            //Convert the output resultset into JavaObject
            List<Encounter> myLeftArmEncounters = convertDBObjectToJavaEncounterObj(cursor2);
            LOGGER.debug("myLeftArmEncounters=" + myLeftArmEncounters + ", size=" + myLeftArmEncounters.size());

            myLeftArmEncounters.forEach(enctr -> uniquePatientIds.add(enctr.getPatient_id()));
        }

        //End of Query 2 processing

        // release resources
        mongoClient.close();
    }

    //Helper static function

    //Helper static function
    private static Long doubleToLong(Object aObject) {
        Double a = (Double) aObject;
        Double d = (Double) aObject;
        Long l = (new Double(d)).longValue();

        return l;
    }

    private static String getFieldDataType(Object aObject, String fieldName) {
        final String DATA_TYPE_DOUBLE = "Double";
        final String DATA_TYPE_LONG = "Long";
        final String DATA_TYPE_INTEGER = "Integer";
        final String DATA_TYPE_STRING = "String";
        final String DATA_TYPE_DATE = "Date";
        final String DATA_TYPE_BSONTimeStamp = "BSONTimeStamp";
        //Custom data type
        final String DATA_TYPE_OBSERVATION = "Observation";
        final String DATA_TYPE_BASICDBLIST = "BasicDBList";
        final String DATA_TYPE_ARRAYLIST = "ArrayList";  //Supertype of BasicDBList


        String objectType = "";

        if (aObject instanceof Double) {
            objectType = DATA_TYPE_DOUBLE;
        }
        if (aObject instanceof Long) {
            objectType = DATA_TYPE_LONG;
        }
        if (aObject instanceof Integer) {
            objectType = DATA_TYPE_INTEGER;
        }
        if (aObject instanceof String) {
            objectType = DATA_TYPE_STRING;
        }
        if (aObject instanceof Date) {
            objectType = DATA_TYPE_DATE;
            //Special trace message for date field, just in case
            System.out.println("Field name " + fieldName + " is of type :" + objectType);
        }
        if (aObject instanceof org.bson.types.BSONTimestamp) {
            objectType = DATA_TYPE_BSONTimeStamp;
        }
        if (aObject instanceof ArrayList) {
            objectType = DATA_TYPE_ARRAYLIST;
            System.out.println("Field name " + fieldName + " is of type :" + objectType);
        }
        if (aObject instanceof com.mongodb.BasicDBList) {
            objectType = DATA_TYPE_BASICDBLIST;
        }

        System.out.println("Field name " + fieldName + " is of type :" + objectType);

        return objectType;
    }

    /**
     * Returns the minimum and maximum values from the input observation values.
     * This method is used to obtain the minimum and maximum values from the given observation values.
     * The observation values for an encounter are provided as input parameter (argument) to this method.
     */
    private MinMaxObservationValue findMinMaxObservation(List<Observation> observations) {

        Long min = null;
        Long max = null;

        MinMaxObservationValue minMaxObservationValue = new MinMaxObservationValue();

        for (Observation observation : observations) {
            if (max == null || observation.getValue() > max) {
                max = observation.getValue();
            }
            if (min == null || observation.getValue() < min) {
                min = observation.getValue();
            }
        }

        //Set the minimum and maximum values from the input observations
        minMaxObservationValue.setMin(min);
        minMaxObservationValue.setMax(max);

        //Return the minimum and maximum values
        return minMaxObservationValue;
    }

    private List<Encounter> convertDBObjectToJavaEncounterObj(DBCursor cursor) {

        List<Encounter> encounterList = new ArrayList<Encounter>();

        try {
            while (cursor.hasNext()) {
                //System.out.println(cursor.next());
                DBObject dbObject = cursor.next();
                //Convert to POJO and add it to the encounterList
                System.out.println("encounterJsonStr =" + dbObject);
                //Convert into POJO
                //Encounter encounter = jsonToObject(encounterJsonStr, Encounter.class);
                //encounterList.add(encounter);

                //Display the record
                //System.out.println(dbObject);
                System.out.println("Keyset: " + dbObject.keySet());
                //Keyset: [_id, patient_id, date, type, reason_for_visit, observations]
				/*
            	for(String key: dbObject.keySet()) { 
            		//System.out.print(key+":" + (Long) dbObject.get(key) + "," ); //Casting error from Double to Long
            		System.out.print(key+":" + doubleToLong(dbObject.get(key)) + "," );

            	}
            	System.out.println("");
				 */
                Set<String> keySet = dbObject.keySet();
                String[] keyArray = keySet.toArray(new String[0]);

                //Arrays.asList(keyArray)
                //String[] arr = list.toArray(new String[list.size()]);
                //To convert from array and later list to set
				/*
            	Arrays.asList() would do the trick here.
            	String[] words = {"ace", "boom", "crew", "dog", "eon"};   

            	List<String> wordList = Arrays.asList(words);  
            	 For converting to Set, you can do as below
            	Set<T> mySet = new HashSet<T>(Arrays.asList(words)); 
				 */


                //Populate the POJO by iterationg over the key names
                Encounter encounter = new Encounter();
                //IssuedDate issuedDate = new IssuedDate(); //Not needed
                //Observation observation = new Observation();

                for (String key : keyArray) {
                    //Java 6 can not switch on String (while Java 7 can). So use if-else
                    //Just to know get the field data type
                    //String fieldDataType = getFieldDataType(dbObject.get(key), key);

                    if (key.equalsIgnoreCase("_id")) {

                        encounter.set_id(doubleToLong(dbObject.get(key)));
                        System.out.println("_id:" + encounter.get_id());
                    }
					/* patient_id is found to be of type Double
            		if (key.equalsIgnoreCase("patient_id")) {
            			String patient_id=(String) dbObject.get(key);
            			encounter.setPatient_id(patient_id) ;
            			System.out.println("patient_id: " + encounter.getPatient_id());
            		}
					 */
                    if (key.equalsIgnoreCase("patient_id")) {
                        Double patient_id = (Double) dbObject.get(key);

                        encounter.setPatient_id(doubleToLong(patient_id));
                        System.out.println("patient_id: " + encounter.getPatient_id());
                    }
                    //date field is found to be of type String in localhost MongoDB and of type Date in Docker VM MongoDB
					/*
					if (key.equalsIgnoreCase("date")) {
						String date=(String) dbObject.get(key);
						encounter.setDate(date);
						System.out.println("date: " + encounter.getDate());
					}
					*/


                    if (key.equalsIgnoreCase("date")) {
                        Date date = (Date) dbObject.get(key);
                        encounter.setDate(date);
                        System.out.println("date: " + encounter.getDate());
                    }
					
					
					/*
            		if (key.equalsIgnoreCase("type")) {
            			String type=(String) dbObject.get(key);
            			encounter.setType(type);
            			System.out.println("type: " + encounter.getType());
            		}
					 */
                    if (key.equalsIgnoreCase("type")) {
                        Double type = (Double) dbObject.get(key);
                        encounter.setType(doubleToLong(type));
                        System.out.println("type: " + encounter.getType());
                    }
                    if (key.equalsIgnoreCase("reason_for_visit")) {
                        String reason_for_visit = (String) dbObject.get(key);
                        encounter.setReason_for_visit(reason_for_visit);
                        System.out.println("reason_for_visit: " + encounter.getReason_for_visit());
                    }
					/*
            		if (key.equalsIgnoreCase("observations")) {
            			Observation[] observations =(Observation[]) dbObject.get(key);
            			encounter.setObservations(observations);
            			System.out.println("observations: " + encounter.getObservations());
            		}
					 */
                    if (key.equalsIgnoreCase("observations")) {
                        List<DBObject> observationObjectList = (List<DBObject>) dbObject.get(key);
                        DBObject[] observationObjectArray = observationObjectList.toArray(new DBObject[0]);

                        List<Observation> observationList = new ArrayList<Observation>(); // observationList instance

                        for (DBObject dbobjectObsrvn : observationObjectArray) {
                            System.out.println("Keyset: " + dbobjectObsrvn.keySet());
                            //Keyset: [name, name_type, value, value_type, applies, issued, identifier, subject]
                            Set<String> keySetObsrvn = dbobjectObsrvn.keySet();
                            String[] keyArrayObsrvn = keySetObsrvn.toArray(new String[0]);

                            Observation observation = new Observation();  //New Observation object instance

                            for (String keyObsrvn : keyArrayObsrvn) {
                                //Java 6 can not switch on String (while Java 7 can). So use if-else
                                //Just to know get the field data type

                                String fieldDataTypeObsrvn = getFieldDataType(dbobjectObsrvn.get(keyObsrvn), keyObsrvn);

                                if (keyObsrvn.equalsIgnoreCase("name")) {

                                    observation.setName(doubleToLong(dbobjectObsrvn.get(keyObsrvn)));
                                    System.out.println("name:" + observation.getName());
                                }
                                if (keyObsrvn.equalsIgnoreCase("name_type")) {

                                    observation.setName_type(doubleToLong(dbobjectObsrvn.get(keyObsrvn)));
                                    System.out.println("name_type:" + observation.getName_type());
                                }
                                if (keyObsrvn.equalsIgnoreCase("value")) {

                                    observation.setValue(doubleToLong(dbobjectObsrvn.get(keyObsrvn)));
                                    System.out.println("value:" + observation.getValue());
                                }
                                if (keyObsrvn.equalsIgnoreCase("value_type")) {

                                    observation.setValue_type(doubleToLong(dbobjectObsrvn.get(keyObsrvn)));
                                    System.out.println("value_type:" + observation.getValue_type());
                                }
                                if (keyObsrvn.equalsIgnoreCase("applies")) {
                                    String applies = (String) dbobjectObsrvn.get(keyObsrvn);
                                    observation.setApplies(applies);
                                    System.out.println("applies: " + observation.getApplies());
                                }
                                //issued
								/*
								if (keyObsrvn.equalsIgnoreCase("issued")) {
									String issued=(String) dbobjectObsrvn.get(keyObsrvn);
									observation.setIssued(issued); //issued date information
									System.out.println("issued: " + observation.getIssued());
								}
								*/
                                if (keyObsrvn.equalsIgnoreCase("issued")) {
                                    Date issued = (Date) dbobjectObsrvn.get(keyObsrvn);
                                    observation.setIssued(issued); //issued date information
                                    System.out.println("issued: " + observation.getIssued());
                                }
                                if (keyObsrvn.equalsIgnoreCase("identifier")) {
                                    String identifier = (String) dbobjectObsrvn.get(keyObsrvn);
                                    observation.setIdentifier(identifier);
                                    System.out.println("identifier: " + observation.getIdentifier());
                                }
                                if (keyObsrvn.equalsIgnoreCase("subject")) {
                                    String subject = (String) dbobjectObsrvn.get(keyObsrvn);
                                    observation.setSubject(subject);
                                    System.out.println("subject: " + observation.getSubject());
                                }
                            } //keyset for dbobjectObsrvn iterated.
                            //Observation object instance populated. Add it to the list now
                            observationList.add(observation);
                        } //observationObjectArray iterated
                        //observationList object instance populated. Convert it to array and assign to encounter.setObservations()
                        encounter.setObservations(observationList);
                        //Display
                        System.out.println("observations: " + encounter.getObservations());
                        //System.out.println("observations: " + observationList);
                    }//"observations" field dealt with
                    //encounterList.add(encounter);

                }
                encounterList.add(encounter);
                //Display encounter list
                //System.out.println("encounterList size=" + encounterList.size() + ", encounterList=" + encounterList);
            }
            //Display encounter list
            System.out.println("encounterList size=" + encounterList.size() + ", encounterList=" + encounterList);

        } finally {
            cursor.close();
        }

        //Return
        return encounterList;

    }

}
