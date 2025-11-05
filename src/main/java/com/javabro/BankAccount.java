package com.javabro;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
//@JsonPropertyOrder({"holderName", "id"})       --- specify the order of property during serialization process
//@JsonPropertyOrder(alphabetic = true/false)    --- order of property during serialization process is alphabetic if set to true be default it is false or defined order of entity
@JsonRootName(value = "bankAccountDetails")
public class BankAccount {
    private Long id;
    //@JsonValue
    // --- by this annotation, we will get only the value associated to this property/attribute for that entity during JSON serialization in output file
    private String holderName;
    //@JsonAnyGetter(enabled = false)
    private Map<String, String> properties;
    //@JsonRawValue
    private String json;
}
