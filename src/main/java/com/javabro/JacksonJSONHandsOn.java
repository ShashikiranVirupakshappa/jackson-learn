package com.javabro;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class JacksonJSONHandsOn {
    public static void main(String[] args) {
        UserDTO userDTO = new UserDTO(1L,"shashi","kiran", "shash", "shash");
        ObjectMapper objectMapper = new ObjectMapper();
        String outputJsonString = "";
        try {
            /*outputJsonString = objectMapper.writeValueAsString(userDTO);
            System.out.println("outputJsonString ======> "+outputJsonString);
            objectMapper.writeValue(new File("src/main/resources/UserDTO.json"), userDTO);
            String jsonString = """
                    {
                        "id": 1,
                        "firstName": "shashi",
                        "lastName": "kiran",
                        "userName": "shash",
                        "password": "shash"
                    }
                    """;

            UserDTO userDTO1 = objectMapper.readValue(jsonString, UserDTO.class);
            System.out.println(userDTO1);*/


            UserDTO userDTO2 = objectMapper.readValue(new File("src/main/resources/UserDTO.json"), UserDTO.class);
            System.out.println(userDTO2);

            UserDTO userDTO3 = objectMapper.readValue(new URL("file:src/main/resources/UserDTO.json"), UserDTO.class);
            System.out.println(userDTO3);

            JsonParser jsonParser = objectMapper.createParser(new File("src/main/resources/UserDTO.json"));
            System.out.println(jsonParser);
            while(jsonParser.nextToken() != null) {
                JsonToken token = jsonParser.currentToken();
                if (token == JsonToken.FIELD_NAME) {
                    String fieldName = jsonParser.getCurrentName();
                    jsonParser.nextToken(); // Move to value
                    String value = jsonParser.getText();
                    System.out.println(fieldName + ": " + value);
                }
            }
            JsonNode objectNode = objectMapper.createObjectNode();
            JsonNode UserDTORootNode = objectMapper.readTree(new File("src/main/resources/UserDTO.json"));
            JsonNode userNameJSONNode = UserDTORootNode.get("userName");
            System.out.println("userNameJSONNode ======> "+userNameJSONNode.asText());

            String jsonArrAsString = """
                    [
                        {
                            "id": 1,
                            "firstName": "shashi",
                            "lastName": "kiran",
                            "userName": "shash",
                            "password": "shash"
                        },
                        {
                            "id": 2,
                            "firstName": "raj",
                            "lastName": "kiran",
                            "userName": "raj",
                            "password": "raj"
                        }
                    ]
                    """;

            objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
            UserDTO[] userDTOS = objectMapper.readValue(jsonArrAsString, UserDTO[].class);
            Arrays.stream(userDTOS).forEach(System.out::println);

            List<UserDTO> userDTOList = objectMapper.readValue(jsonArrAsString, new TypeReference<List<UserDTO>>() {
            });
            System.out.println(userDTOList);



        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
