package com.javabro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Target {
    //@JsonAlias("sourceId")
    private Integer targetId;
    //@JsonProperty("sourceAge")
    private Integer targetAge;
    //@JsonProperty("sourceName")
    private String targetName;
}
