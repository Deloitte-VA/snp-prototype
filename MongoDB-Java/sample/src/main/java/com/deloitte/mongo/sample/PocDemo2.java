package com.deloitte.mongo.sample;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.deloitte.mongo.domain.Encounter;
import com.deloitte.mongo.domain.Observation;
import com.deloitte.mongo.domain.converters.EncounterReadConverter;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PocDemo2 {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemo2.class);
    
    @Autowired
    EncounterReadConverter encounterReadConverter;

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
            LOGGER.debug("***!myRightArmEncounters patientId=" + rightArmEncounter.getPatient().getId());

            MinMaxObservationValue minMaxObservation;
            final Long minObservationValue; //final modifier needed for inner class usage
            final Long maxObservationValue; //final modifier needed for inner class usage

            minMaxObservation = findMinMaxObservation(rightArmEncounter.getObservations());
            minObservationValue = minMaxObservation.getMin();
            maxObservationValue = minMaxObservation.getMax();

            final Long patientId = rightArmEncounter.getPatient().getId();  //final modifier needed for inner class usage

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

            myLeftArmEncounters.forEach(enctr -> uniquePatientIds.add(enctr.getPatient().getId()));
        }

        //End of Query 2 processing

        // release resources
        mongoClient.close();
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

    /**
     * Converts the DBObjects from the result set (DBCursor) into list of Encounter objects.
     * Note that to convert from JSON DBObject to Encounter POJO, autowired encounterReadConverter class is used.
     * @param cursor
     * @return
     */
    private List<Encounter> convertDBObjectToJavaEncounterObj(DBCursor cursor) {

        List<Encounter> encounterList = new ArrayList<Encounter>();

        try {
            while (cursor.hasNext()) {
                DBObject dbObject = cursor.next();
                //Convert to POJO and add it to the encounterList
                LOGGER.debug("encounterJsonStr =" + dbObject);
                
                // Use the converter class's convert() method to create POJO. 
                //AutoWired encounterReadConverter object
                //EncounterReadConverter encounterReadConverter = new EncounterReadConverter();
                Encounter encounter = encounterReadConverter.convert(dbObject);
                
                encounterList.add(encounter);
                //Display encounter list
                //LOGGER.debug("encounterList size=" + encounterList.size() + ", encounterList=" + encounterList);
            }
            //Display encounter list
            LOGGER.debug("encounterList size=" + encounterList.size() + ", encounterList=" + encounterList);

        } finally {
            cursor.close();
        }
        //Return
        return encounterList;
    }

}
