package com.javabro;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class JacksonJSONPropertyTest {
    public static void main(String[] args) {
        CarDTO carDTO = new CarDTO(1L, "Toyota");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.writeValueAsString(carDTO));
            objectMapper.writeValue(new File("src/main/resources/CarDTO.json"),carDTO);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
