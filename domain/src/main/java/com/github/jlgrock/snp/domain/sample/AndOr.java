package com.github.jlgrock.snp.domain.sample;

import com.github.jlgrock.snp.apis.connection.MongoDbFactory;
import com.github.jlgrock.snp.apis.exceptions.DataAccessException;
import com.github.jlgrock.snp.apis.sample.SampleQuery;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

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
        MongoCollection<Document> testCollection = mongoDbFactory.db().getCollection("inventory");

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
        //Note: For the assertion.observable value the sequence of digits is cast to Long as default Integer
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

        FindIterable<Document> cursor = testCollection.find(query);
        List<Document> documents = new ArrayList<>();
        cursor.into(documents);

        LOGGER.debug("Filtered data count (length): " + documents.size());
        for (Document document : documents) {
                LOGGER.info(document.toJson());
        }

        // release resources
        mongoDbFactory.destroy();
    }
}

