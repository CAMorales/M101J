package com.camorales;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Claudio Morales on 7/02/16.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        //Configure freemarker
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(SparkFormHandling.class,"/");

        //Configure routes
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                try {
                    Map<String, Object> fruitsMap = new HashMap<String, Object>();
                    fruitsMap.put("fruits", Arrays.asList("apple",
                            "orange","banana","peach"));

                    Template fruitPickerTemplate =
                            configuration.getTemplate("fruitPicker.ftl");
                    StringWriter writer = new StringWriter();
                    fruitPickerTemplate.process(fruitsMap,writer);
                    return writer;
                }catch (Exception ex){
                    halt(500);
                    return null;
                }
            }
        });

        Spark.post(new Route("/favorite_fruit") {
            @Override
            public Object handle(Request request, Response response) {
                final String fruit = request.queryParams("fruit");
                if (fruit==null){
                    return "No fruit?";
                }else{
                    return  "your favorite fruit is " + fruit;
                }
            }
        });
    }
}
