package com.github.jlgrock.snp.core.sample;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.AggregationOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MapReduceCommand;
import com.mongodb.MapReduceOutput;
import com.mongodb.MongoClient;

public class PocDemoMapReduce extends BasePocDemo {

    private static Logger LOGGER = LoggerFactory.getLogger(PocDemoMapReduce.class);

    private PocDemoMapReduce() {}

    private void query() {
        // connect to the database server and get the db
    	setUp();

        //The following query (Query 1) from Javascript would be tried in java
        /*
				         db.encounters.aggregate([
				    {
				        $match: {
				            "observations.name": {$in: [5695930304, 5695930310]},
				            "observations.name_type": 1,
				            "observations.value": {$gt: 140}    
				        }
				    },
				    {
				        $group: {
				            _id: "$patient_id",
				            patientsum: { $sum: 1 }
				        }
				    },
				    {
				        $group: {
				            _id: 1,
				            sum: { $sum: 1 }
				        }
				    }
				]).next().sum;
         */
        
        //First, get the "encounters" collection from then database
        DBCollection testCollection = db.getCollection("encounters");
        
        /*
        String map = "function() {emit(this.cust_id, this.price);}";
        String reduce = "function(keyCustId, valuesPrices) {return Array.sum(valuesPrices);}";
        String outputTarget = "{ out: \"map_reduce_example\" }";
        */
        
        String map = "function() {emit(this.patient_id, 1);}";
        String reduce = "function(key, keyvalues) {return Array.sum(keyvalues);}";
        String outputTarget = "map_reduce_example";
        
        DBObject query = new BasicDBObject("observations.name", (Long) 5695930304L)
        .append("observations.name_type", 1)
        .append("observations.value", new BasicDBObject("$gt", 140));
        
        /*
        MapReduceOutput mapReduce(String map,
                String reduce,
                String outputTarget,
                MapReduceCommand.OutputType outputType,
                DBObject query)
         throws MongoException
         */
        MapReduceOutput output = testCollection.mapReduce(   map,
											                 reduce,
											                 outputTarget,
											                MapReduceCommand.OutputType.REPLACE,
											                 query);       
         //throws MongoException       
        System.out.println("Mapreduce output = " + output.toString() );
        
        /*
        
        //Now try to construct the query in Java similar to the Javascript query
        //Note: For the observation.name value the sequence of digits is cast to Long as default Integer
        //can't hold the value as Integer.MAX_VALUE is 2147483647
        
        // create our pipeline operations, first with the $match
        DBObject match = new BasicDBObject("$match", new BasicDBObject("observations.name", (Long) 5695930304L)
        .append("observations.name_type", 1)
        .append("observations.value", new BasicDBObject("$gt", 140)) );
        
        // Now the $group operation based on patient_id
        DBObject groupFields = new BasicDBObject( "_id", "$patient_id");
        groupFields.put("patientsum", new BasicDBObject( "$sum", 1));
        DBObject group = new BasicDBObject("$group", groupFields);
        
        // Now the second (or final) $group operation based on the 1st column to get count
        DBObject finalGroupFields = new BasicDBObject( "_id", 1);  //or could you also try null instead of 1?
        finalGroupFields.put("sum", new BasicDBObject( "$sum", 1));
        DBObject finalGroup = new BasicDBObject("$group", finalGroupFields);
        
        // run aggregation
        List<DBObject> pipeline = Arrays.asList(match, group, finalGroup);
        
        //Cursor option approach
        AggregationOptions aggregationOptions = AggregationOptions.builder()
                .batchSize(100)
                .outputMode(AggregationOptions.OutputMode.CURSOR)
                .allowDiskUse(true)
                .build();

        Cursor cursor = testCollection.aggregate(pipeline, aggregationOptions);
        
        //There would be only one row in the result, based on the final grouping
        if (cursor.hasNext()) {
            DBObject dbObject = cursor.next();
            System.out.println(dbObject + ", Number of patients= " + dbObject.get("sum") );
            LOGGER.debug("Number of patients= " + dbObject.get("sum") );
        }
        
        //Close cursor
        cursor.close();
        */
        
        // release resources
        //mongoClient.close();
        tearDown();
    }

    public static void main(String[] args) throws Exception {
        PocDemoMapReduce pocDemo = new PocDemoMapReduce();
        pocDemo.query();
    }
}
