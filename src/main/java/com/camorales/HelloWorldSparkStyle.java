package com.camorales;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by azazel on 31/01/16.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World from Spark";
            }
        });
    }
}
