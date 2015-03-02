package com.github.jlgrock.snp.core.sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
/**
 * 
 * Simple example of how to implement Query 1 using Java for semantic normalization prototype 
 * using MongoDB Java driver library.
 */
public class PocDemo {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemo.class);

    private PocDemo() {}

    private void query() {
        // connect to the local database server
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "192.168.59.103" , 27017 ); //boot2docker ip address
        } catch (UnknownHostException e) {
            LOGGER.error("Unable to connect to MongoDB", e);
            return;
        }

        // get handle to "mydb"
        DB db = mongoClient.getDB("test");  //instance name under docker VM

        //The following query (Query 1) from Javascript would be tried in java
        /*
         db.runCommand(
		{
			distinct: "encounters",
			key: "patient_id",
			query: {
				"observations.name": 5695930304,
				"observations.name_type": 1,
				"observations.value": {$gt: 140}
			}
		}			   ).values.length;
        */

        //First, get the "encounters" collection from then database
        DBCollection testCollection = db.getCollection("encounters");

        //Now try to construct the query in Java similar to the Javascript query
        //Note: For the observation.name value the sequence of digits is cast to Long as default Integer
        //can't hold the value as Integer.MAX_VALUE is 2147483647
        BasicDBObject query = new BasicDBObject("distinct", "encounters")
                .append("key", "patient_id")
                .append("query",
                        new BasicDBObject("observations.name", (Long) 5695930304L)
                                .append("observations.name_type", 1)
                                .append("observations.value",
                                        new BasicDBObject("$gt", 140))
                );

        //Just for our display purpose
        LOGGER.debug("Filtering query: " + query );

        //Execute the query and get the filtered collection of items
        DBCursor cursor = testCollection.find(query);

        //Display the count of items in the resultant collection
        LOGGER.debug("Filtered data count (length): " + cursor.length());

        //If you want to display the actual records in the result, try the following code block
        cursor = testCollection.find(query); //Get the cursor value afresh before iterating over the collection
        try {
            while (cursor.hasNext()) {
                LOGGER.info(cursor.next().toString()); //Note that the output may not be formatted cleanly
            }
        } finally {
            cursor.close();
        }

        // release resources
        mongoClient.close();
    }
    /**
     * 
     * @param args string command line arguments
     * 
     */
    public static void main(final String[] args){
        PocDemo pocDemo = new PocDemo();
        pocDemo.query();
    }
}

