package com.example.studentcleanarch.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MaskingObjectGenerator {

    private static final String DEFAULT_MASK = "***";

    public static Object mask(Object input, Pattern multilinePattern) {
        if (Objects.isNull(input)) {
            return input;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = objectMapper.convertValue(input, HashMap.class);
        } catch (Exception e) {

        }
        if (Objects.isNull(jsonMap)) {
            return input;
        }
        for (Map.Entry<String, Object> entry : jsonMap.entrySet()) {
            if (multilinePattern.matcher(entry.getKey()).matches()) {
                entry.setValue(DEFAULT_MASK);
                continue;
            }
            Object value = entry.getValue();
            if (value instanceof Map) {
                entry.setValue(mask(entry.getValue(), multilinePattern));
            }
            if (value instanceof List) {
                List<Object> newList = new ArrayList<>();
                ((List<Object>) value).stream().forEach(ob -> newList.add(mask(ob, multilinePattern)));
                entry.setValue(newList);
            }
        }
        return jsonMap;
    }

    public static Pattern loadMaskFields(List<String> maskFields) {
        return Pattern.compile(
                maskFields.stream().map(s -> ".*" + s + ".*").collect(Collectors.joining("|")), Pattern.MULTILINE);
    }
}
