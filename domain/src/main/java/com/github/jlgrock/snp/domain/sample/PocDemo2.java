package com.github.jlgrock.snp.domain.sample;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.apis.sample.SampleQuery;
import com.github.jlgrock.snp.domain.converters.EncounterReadConverter;
import com.github.jlgrock.snp.domain.types.Encounter;
import com.github.jlgrock.snp.domain.types.Assertion;
import com.github.jlgrock.snp.domain.types.primitives.IntegerPrimitive;
import com.github.jlgrock.snp.domain.types.primitives.PrimitiveType;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Simple example of how to implement Query 2 using Java for semantic normalization prototype 
 * using MongoDB Java driver library.
 */
@Service
public class PocDemo2 implements SampleQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemo2.class);

    private final EncounterReadConverter encounterReadConverter;

    private final MongoDbFactory mongoDbFactory;

    /**
     * Will set up the class for querying
     *
     * @param encounterReadConverterIn the converter to allow quick serialization of the Encounter domain object
     * @param mongoDbFactoryIn the mongoDB access
     */
    @Inject
    public PocDemo2(final EncounterReadConverter encounterReadConverterIn, final MongoDbFactory mongoDbFactoryIn) {
        encounterReadConverter = encounterReadConverterIn;
        mongoDbFactory = mongoDbFactoryIn;
    }

    @Override
    public void query() throws DataAccessException {
        // get handle for db
        MongoDatabase db = mongoDbFactory.db();  //instance name under docker VM

        LOGGER.trace("Displaying the filtered data from encountered collection: ");

        //First, get the "encounters" collection from then database
        MongoCollection<Document> testCollection = db.getCollection("encounters");

        //Query to get encounters with right arm assertions
        BasicDBObject query = new BasicDBObject("assertions.observable", 5695930304L)
                .append("assertions.observable_type", 1);

        //Just for our display purpose
        LOGGER.trace("Filtering query: " + query);

        //Execute the query and get the filtered collection of items
        FindIterable<Document> cursor = testCollection.find(query);
        List documents = new ArrayList<>();
        cursor.into(documents);
        //Display the count of items in the resultant collection
        LOGGER.debug("Filtered data count (length): " + documents.size());

        //Get an array of encounters
        List<Encounter> myRightArmEncounters = convertDBObjectToJavaEncounterObj(documents);
        LOGGER.debug("myRightArmEncounters=" + myRightArmEncounters + ", size=" + myRightArmEncounters.size());

        Set<ObjectId> uniquePatientIds = new HashSet<>();
        for (Encounter rightArmEncounter : myRightArmEncounters) {
            LOGGER.debug("***!myRightArmEncounters patientId=" + rightArmEncounter.getId());

            MinMaxAssertionValue minMaxAssertion;
            final Long minAssertionValue; //final modifier needed for inner class usage
            final Long maxAssertionValue; //final modifier needed for inner class usage

            minMaxAssertion = findMinMaxAssertion(rightArmEncounter.getAssertions());
            minAssertionValue = minMaxAssertion.getMin();
            maxAssertionValue = minMaxAssertion.getMax();

            final ObjectId patientId = rightArmEncounter.getId();  //final modifier needed for inner class usage

            BasicDBObject query2 = new BasicDBObject("$and",
                    new ArrayList<BasicDBObject>() {{
                        add(new BasicDBObject("assertions.observable", (Long) 5695930310L)
                                        .append("assertions.observable_type", 1)
                                        .append("patient_id", patientId)
                        );
                        add(new BasicDBObject("$or",
                                        new ArrayList<BasicDBObject>() {{
                                            add(new BasicDBObject("assertions.value", new BasicDBObject("$gt", maxAssertionValue + 10)));
                                            add(new BasicDBObject("assertions.value", new BasicDBObject("$lt", minAssertionValue - 10)));
                                        }}
                                )
                        );
                    }}
            );

            LOGGER.trace("Filtering query2: " + query2);

            //Execute the query and get the filtered collection of items
            MongoCollection<Document> testCollection2 = db.getCollection("encounters");
            List<Document> documents2 = new ArrayList<>();
            testCollection2.find(query2).into(documents2);

            //Display the count of items in the resultant collection
            LOGGER.debug("Filtered data count (length): " + documents2.size());

            //Convert the output resultset into JavaObject
            List<Encounter> myLeftArmEncounters = convertDBObjectToJavaEncounterObj(documents2);
            LOGGER.debug("myLeftArmEncounters=" + myLeftArmEncounters + ", size=" + myLeftArmEncounters.size());

            myLeftArmEncounters.forEach(enctr -> uniquePatientIds.add(enctr.getId()));
        }
        //Display unique patient IDs
        LOGGER.debug("Patient IDs with diparity of more than between left and right arm blood pressure readings: " + "Size =" + uniquePatientIds.size() + ", List = " + uniquePatientIds);

        //End of Query 2 processing

        mongoDbFactory.destroy();
    }

    /**
     * Returns the minimum and maximum values from the input assertion values.
     * This method is used to obtain the minimum and maximum values from the given assertion values.
     * The assertion values for an encounter are provided as input parameter (argument) to this method.
     */
    private MinMaxAssertionValue findMinMaxAssertion(final List<Assertion> assertions) {

        Long min = null;
        Long max = null;

        MinMaxAssertionValue minMaxAssertionValue = new MinMaxAssertionValue();

        for (Assertion assertion : assertions) {
            if (assertion.getValue().getType() == PrimitiveType.INTEGER) {
                IntegerPrimitive integerPrimitive = (IntegerPrimitive) assertion.getValue();
                if (max == null || integerPrimitive.getValue() > max) {
                    max = integerPrimitive.getValue();
                }
                if (min == null || integerPrimitive.getValue() < min) {
                    min = integerPrimitive.getValue();
                }

            }
        }

        //Set the minimum and maximum values from the input a
        minMaxAssertionValue.setMin(min);
        minMaxAssertionValue.setMax(max);

        //Return the minimum and maximum values
        return minMaxAssertionValue;
    }

    /**
     * Converts the DBObjects from the result set (DBCursor) into list of Encounter objects.
     * Note that to convert from JSON DBObject to Encounter POJO, autowired encounterReadConverter class is used.
     * @param documents MongoDB cursor input
     * @return encounterList
     */
    public List<Encounter> convertDBObjectToJavaEncounterObj(final List<Document> documents) {

        List<Encounter> encounterList = new ArrayList<>();

        for (Document document : documents) {
            // Use the converter class's convert() method to create POJO.
            Encounter encounter = encounterReadConverter.convert(document);
        }

        //Display encounter list
        LOGGER.debug("encounterList size=" + encounterList.size() + ", encounterList=" + encounterList);

        //Return
        return encounterList;
    }
    
}

