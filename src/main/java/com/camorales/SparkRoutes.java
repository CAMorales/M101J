package com.camorales;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by Claudio Morales on 7/02/16.
 */
public class SparkRoutes {
    public static void main(String[] args) {
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World\n";
            }
        });

        Spark.get(new Route("/test") {
            @Override
            public Object handle(Request request, Response response) {
                return "Test Page\n";
            }
        });

        Spark.get(new Route("/echo/:thing") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":thing");
            }
        });
    }
}
