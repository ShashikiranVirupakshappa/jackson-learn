package com.javabro;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.json.XML;

public class ObjectToXMLConversion {
    public static void main(String[] args) {

        String customerJSONAsString = "{ \"customer\": { \"id\": 101, \"name\": \"John Doe\", \"email\": \"john@example.com\" } }";

        JSONObject customerJSONObject = new JSONObject(customerJSONAsString);

        String customerXML = XML.toString(customerJSONObject);
        System.out.println(customerXML);

    }
}
