package com.example.studentcleanarch.adapter.out.persistent.codegen;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MappingClassDef {
    private String mapperPackageName;
    private String mapperSimpleClassName;

    private String domainPackageName;

    private MappingMethodDef toThisDef;
    private MappingMethodDef fromThisDef;
}
