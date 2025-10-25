package com.javabro;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonPropertyOrder({"holderName", "id"})
public class BankAccount {
    private Long id;
    //@JsonValue
    // --- by this annotation, we will get only the value associated to this property/attribute for that entity during JSON serialization in output file
    private String holderName;
    @JsonAnyGetter(enabled = false)
    private Map<String, String> properties;
    @JsonRawValue
    private String json;
}
