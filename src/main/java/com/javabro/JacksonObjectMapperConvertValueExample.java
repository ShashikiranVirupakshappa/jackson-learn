package com.javabro;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectMapperConvertValueExample {
    public static void main(String[] args) {
        ObjectMapper objectMapper  = new ObjectMapper();
        Source source = new Source();
        source
                .setSourceName("source1");
        source.setSourceAge(35);
        source.setSourceId(1);
        Target target = objectMapper.convertValue(source, Target.class);
        System.out.println(target);
    }
}
