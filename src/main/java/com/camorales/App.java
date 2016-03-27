package com.camorales;

import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        MongoClient client = new MongoClient();
        MongoDatabase db = client.getDatabase("test").withReadPreference(ReadPreference.secondary());

        MongoCollection<BsonDocument> collection = db.getCollection("test",BsonDocument.class);
    }
}
