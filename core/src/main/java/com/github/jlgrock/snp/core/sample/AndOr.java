package com.github.jlgrock.snp.core.sample;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.apis.sample.SampleQuery;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
/**
 * 
 * Simple example of how to do nested AND and OR statements using the MongoDB driver library.
 */
public class AndOr implements SampleQuery {

    private static final Logger LOGGER = LoggerFactory.getLogger(AndOr.class);

    private final MongoDbFactory mongoDbFactory;

    /**
     * Will set up the class for querying
     * @param mongoDbFactoryIn the mongoDB access
     */
    @Inject
    public AndOr(final MongoDbFactory mongoDbFactoryIn) {
        mongoDbFactory = mongoDbFactoryIn;
    }

    @Override
    public void query() throws DataAccessException {
        // First, get the "inventory" collection from then database
        DBCollection testCollection = mongoDbFactory.db().getCollection("inventory");

        //
        //Example for the following code:
        // db.inventory.find( {
        // $and : [
        // { $or : [ { price : 99 }, { price : 199 } ] },
        // { $or : [ { sale : true }, { qty : { $lt : 20 } } ] }
        // ]
        // } )
        //

        //Now try to construct the query in Java similar to the Javascript query
        //Note: For the observation.name value the sequence of digits is cast to Long as default Integer
        //can't hold the value as Integer.MAX_VALUE is 2147483647
        BasicDBObject query = new BasicDBObject("$and",
                new ArrayList<BasicDBObject>() {{
                    add(new BasicDBObject("$or", new ArrayList<BasicDBObject>(){{
                        add(new BasicDBObject("price", 99));
                        add(new BasicDBObject("price", 199));
                    }}));
                    add(new BasicDBObject("$or", new ArrayList<BasicDBObject>(){{
                        add(new BasicDBObject("sale", true));
                        add(new BasicDBObject("qty", new BasicDBObject("$lt", 20)));
                    }}));
                }});

        DBCursor cursor = testCollection.find(query);

        LOGGER.debug("Filtered data count (length): " + cursor.length());
        cursor = testCollection.find(query); //Get the cursor value afresh before iterating over the collection
        try {
            while (cursor.hasNext()) {
                LOGGER.info(cursor.next().toString()); //Note that the output may not be formatted cleanly
            }
        } finally {
            cursor.close();
        }

        // release resources
        mongoDbFactory.destroy();
    }
}

