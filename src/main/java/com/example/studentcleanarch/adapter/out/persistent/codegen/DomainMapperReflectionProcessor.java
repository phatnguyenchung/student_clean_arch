package com.example.studentcleanarch.adapter.out.persistent.codegen;

import io.swagger.v3.core.util.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class DomainMapperReflectionProcessor {

    public static Set<String> ignoredFields = new HashSet<>(Arrays.asList("log", "serialVersionUID"));
    public static List<Class<?>> jpaEntities;

    static {
        jpaEntities = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        new DomainMapperReflectionProcessor().process(jpaEntities);
    }

    public void process(List<Class<?>> classes) throws IOException {
        for (Class<?> clazz : classes) {
            MappingClassDef classDef = createClassDef(clazz);
            if (Objects.nonNull(classDef)) {
                writeJavaFile(classDef);
            }
        }
    }

    private MappingClassDef createClassDef(Class<?> clazz) {
        DomainMapper annotation = ReflectionUtils.getAnnotation(clazz, DomainMapper.class);
        if (Objects.isNull(annotation)) {
            log.info(
                    "Class {} does not have annotation {}. Skip",
                    clazz.getSimpleName(),
                    DomainMapper.class.getSimpleName());
            return null;
        }

        MappingClassDef classDef = new MappingClassDef();
        classDef.setDomainPackageName(getPackage(annotation.domainClass()));
        classDef.setMapperSimpleClassName(getSimpleClassName(annotation.domainClass()) + "Mapper");
        classDef.setMapperPackageName(getPackage(clazz.getName()));

        Set<String> excludedFields = new HashSet<>(Arrays.asList(annotation.excludedFields()));
        List<MappingPropertyDef> properties = Stream.of(clazz.getDeclaredFields())
                .filter(item -> !excludedFields.contains(item.getName()))
                .map(this::toMappingPropertyDef)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        classDef.setFromThisDef(MappingMethodDef.builder()
                .methodName(annotation.mapFromThisMethod())
                .sourceClassName(clazz.getSimpleName())
                .destClassName(getSimpleClassName(annotation.domainClass()))
                .properties(properties)
                .build());
        classDef.setToThisDef(MappingMethodDef.builder()
                .methodName(annotation.mapToThisMethod())
                .sourceClassName(getSimpleClassName(annotation.domainClass()))
                .destClassName(clazz.getSimpleName())
                .properties(properties)
                .build());
        return classDef;
    }

    private String getPackage(String fullClazzName) {
        int lastDot = fullClazzName.lastIndexOf(".");
        return fullClazzName.substring(0, lastDot);
    }

    private String getSimpleClassName(String fullClazzName) {
        int lastDot = fullClazzName.lastIndexOf(".");
        return fullClazzName.substring(lastDot + 1);
    }

    private MappingPropertyDef toMappingPropertyDef(Field variable) {
        String name = variable.getName();
        if (ignoredFields.contains(name)) {
            return null;
        }
        return MappingPropertyDef.builder()
                .property(name)
                .type(variable.getType().getTypeName())
                .build();
    }

    private void writeJavaFile(MappingClassDef classDef) throws IOException {
        String packagePath = classDef.getMapperPackageName().replaceAll("\\.", "/");
        String folder = "./src/main/java/" + packagePath;

        String javaContent = new JavaFileBuilder().build(classDef);
        System.out.println("----------------------------------");
        System.out.println("Write file");
        System.out.println(javaContent);

        FileOutputStream outputStream =
                new FileOutputStream(folder + "/" + classDef.getMapperSimpleClassName() + ".java");
        PrintWriter writer = new PrintWriter(outputStream);
        writer.print(javaContent);
        writer.close();
        outputStream.close();
    }
}
