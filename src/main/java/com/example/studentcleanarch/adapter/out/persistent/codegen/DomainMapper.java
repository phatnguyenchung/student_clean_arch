package com.example.studentcleanarch.adapter.out.persistent.codegen;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainMapper {
    String domainClass();

    String mapToThisMethod() default "mapToJpaEntity";

    String mapFromThisMethod() default "mapToDomainEntity";

    String[] excludedFields() default {"modifiedAt"};
}
