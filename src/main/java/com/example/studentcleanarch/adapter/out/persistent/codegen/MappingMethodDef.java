package com.example.studentcleanarch.adapter.out.persistent.codegen;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MappingMethodDef {
    private String methodName;

    private String destClassName;
    private String sourceClassName;

    private List<MappingPropertyDef> properties;
}
