package com.example.studentcleanarch.adapter.out.persistent.codegen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MappingPropertyDef {
    private String property;
    private String type;
}
