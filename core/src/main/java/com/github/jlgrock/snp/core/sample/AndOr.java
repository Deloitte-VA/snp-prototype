package com.github.jlgrock.snp.core.sample;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.UnknownHostException;
import java.util.ArrayList;

public class AndOr {

    private static final Logger LOGGER = LoggerFactory.getLogger(AndOr.class);

    private AndOr() {}

    private void query() {
        // connect to the local database server
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient( "192.168.59.108" , 27017 );


            // get handle to "mydb"
            DB db = mongoClient.getDB("test");  //instance name under docker VM

            //First, get the "encounters" collection from then database
            DBCollection testCollection = db.getCollection("inventory");

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
            mongoClient.close();
        } catch (UnknownHostException e) {
            LOGGER.error("Unable to Connect to MongoDB", e);
        }
    }

    public static void main(final String[] args) throws Exception {
        AndOr andor = new AndOr();
        andor.query();
    }
}

