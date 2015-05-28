package com.github.jlgrock.snp.domain.sample;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.apis.sample.SampleQuery;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * Simple example of how to implement Query 1 using Java for semantic normalization prototype 
 * using MongoDB Java driver library.
 */
@Service
@Named
public class PocDemo implements SampleQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(PocDemo.class);

    @Inject
    MongoDbFactory mongoDbFactory;

    @Override
    public void query() throws DataAccessException {
        // First, get the "encounters" collection from then database
        DBCollection testCollection = mongoDbFactory.db().getCollection("encounters");

        // Now try to construct the query in Java similar to the Javascript query
        // Note: For the observation.name value the sequence of digits is cast to Long as default Integer
        // can't hold the value as Integer.MAX_VALUE is 2147483647
        BasicDBObject query = new BasicDBObject("distinct", "encounters")
                .append("key", "patient_id")
                .append("query",
                        new BasicDBObject("observations.name", (Long) 5695930304L)
                                .append("observations.name_type", 1)
                                .append("observations.value",
                                        new BasicDBObject("$gt", 140))
                );

        // Just for our display purpose
        LOGGER.debug("Filtering query: " + query );

        // Execute the query and get the filtered collection of items
        DBCursor cursor = testCollection.find(query);

        // Display the count of items in the resultant collection
        LOGGER.debug("Filtered data count (length): " + cursor.length());

        // Get the cursor value a fresh before iterating over the collection
        cursor = testCollection.find(query);
        try {
            while (cursor.hasNext()) {
                //Note that the output may not be formatted cleanly
                LOGGER.info(cursor.next().toString());
            }
        } finally {
            cursor.close();
        }

        mongoDbFactory.destroy();
    }

}

