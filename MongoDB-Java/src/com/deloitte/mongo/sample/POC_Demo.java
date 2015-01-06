package com.deloitte.mongo.sample;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class POC_Demo {

    public static void main(String[] args) throws Exception {

        // connect to the local database server
        //MongoClient mongoClient = new MongoClient();  //Works, with local MongoDB instance
    	//To use the Docker VM MongoDB process, use the IP address of Docker VM ("boot2docker ip" command output)
        MongoClient mongoClient = new MongoClient( "192.168.59.103" , 27017 ); //192.168.59.103 - docker VM IP addr //"localhost"

        // get handle to "mydb"
        //DB db = mongoClient.getDB("pocdb"); //local instance db name
        DB db = mongoClient.getDB("test");  //instance name under docker VM
        
        //System.out.println("Connected to pocdb!!!");  //for local
        System.out.println("Connected to test db!!!");  //for docker VM
        
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
        
        System.out.println("Displaying the filtered data from encountered collection: " );
        
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
        System.out.println("Filtering query: " + query );
        
        //Execute the query and get the filtered collection of items
        DBCursor cursor = testCollection.find(query);
        
        //Display the count of items in the resultant collection
        System.out.println("Filtered data count (length): " + cursor.length());

        //If you want to display the actual records in the result, try the following code block
        cursor = testCollection.find(query); //Get the cursor value afresh before iterating over the collection
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next()); //Note that the output may not be formatted cleanly
            }
        } finally {
            cursor.close();
        }

        // release resources
        mongoClient.close();
    }
}
