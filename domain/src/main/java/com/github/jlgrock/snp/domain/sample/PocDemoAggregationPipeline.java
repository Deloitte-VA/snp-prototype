package com.github.jlgrock.snp.domain.sample;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.apis.sample.SampleQuery;
import com.mongodb.AggregationOptions;
import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

/**
 * Simple example of how to implement Query 1 using Java for semantic normalization prototype using MongoDB
 * Java driver library and aggregation framework.
 */
@Service
public class PocDemoAggregationPipeline implements SampleQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemoAggregationPipeline.class);

    private final MongoDbFactory mongoDbFactory;

    /**
     * Will set up the class for querying
     * @param mongoDbFactoryIn the mongoDB access
     */
    @Inject
    public PocDemoAggregationPipeline(final MongoDbFactory mongoDbFactoryIn) {
        mongoDbFactory = mongoDbFactoryIn;
    }

    @Override
    public void query() throws DataAccessException {
        // get handle to database
        DB db = mongoDbFactory.db();

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
            LOGGER.debug("Number of patients= " + dbObject.get("sum") );
        }
        
        //Close cursor
        cursor.close();

        mongoDbFactory.destroy();
    }

}
