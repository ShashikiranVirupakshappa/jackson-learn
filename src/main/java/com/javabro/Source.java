package com.javabro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Source {
    private int sourceId;
    private String sourceName;
    private int sourceAge;
}
