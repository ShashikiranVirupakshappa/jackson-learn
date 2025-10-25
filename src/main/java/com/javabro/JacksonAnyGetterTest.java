package com.javabro;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JacksonAnyGetterTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1L, "shashi", Map.of("key1", "value1", "key2", "value2", "key3","value3", "key4","value4"),"""
                    {
                        "id": 1,
                        "firstName": "shashi",
                        "lastName": "kiran",
                        "userName": "shash",
                        "password": "shash"
                    }
                    """);
        BankAccount bankAccount2 = new BankAccount(1L, "shashi", Map.of("key1", "value1", "key2", "value2", "key3","value3", "key4","value4"),
                "{\"id\": 1,\"firstName\": \"shashi\",\"lastName\": \"kiran\",\"userName\": \"shash\",\"password\": \"shash\"}");

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("src/main/resources/bankAccount.json"), bankAccount);
            objectMapper.writeValue(new File("src/main/resources/bankAccount1.json"), bankAccount2);


            //BankAccount ba = objectMapper.readValue(new File("src/main/resources/bankAccount.json"), BankAccount.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
