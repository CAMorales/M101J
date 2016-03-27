package com.camorales;

import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Claudio Morales on 27/03/16.
 */
public class DocumentTest {
    public static void main(String[] args) {
        Document doc = new Document().append("str","MongoDB, Hello")
                .append("int",42)
                .append("long",1l)
                .append("double",1.1)
                .append("bool",false)
                .append("date", new Date())
                .append("objectId", new ObjectId())
                .append("null",null)
                .append("embeddedDoc", new Document("x",0))
                .append("list", Arrays.asList(1,2,3));

        String str = doc.getString("str");
    }
}
