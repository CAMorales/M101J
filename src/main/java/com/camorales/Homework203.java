package com.camorales;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Filters.gte;
import static com.mongodb.client.model.Sorts.ascending;

/**
 * Created by azazel on 27/03/16.
 */
public class Homework203 {
    public static void main(String[] args) {
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("students");
        MongoCollection<Document> collection = database.getCollection("grades");

        Bson sort = ascending("student_id","score");
        Bson filter = eq("type","homework");

        List<Document> all = collection.find(filter).sort(sort).into(new ArrayList<Document>());

        int prevStudentId=-1;
        int studentId;
        for (Document cur : all) {
            studentId = cur.getInteger("student_id");
            if(prevStudentId != studentId){
                prevStudentId=studentId;
                collection.deleteOne(eq("_id",cur.getObjectId("_id")));
            }
        }

        //collection.deleteOne(eq("_id", 4));
    }
}
