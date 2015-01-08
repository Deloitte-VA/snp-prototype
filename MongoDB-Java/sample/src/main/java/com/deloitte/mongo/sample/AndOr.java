package com.deloitte.mongo.sample;

import com.mongodb.*;

import java.util.ArrayList;

/**
 * Created by jlgrock on 1/8/15.
 */
public class AndOr {
    public static void main(String[] args) throws Exception {
        // connect to the local database server
        MongoClient mongoClient = new MongoClient( "192.168.59.108" , 27017 );

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

        System.out.println("count: " + cursor.size());
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
