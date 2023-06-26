package com.example.studentcleanarch.adapter.out.persistent.codegen;

import lombok.extern.slf4j.Slf4j;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes(" com.example.studentcleanarch.adapter.out.persistent.autogen.DomainMapper")
public class DomainMapperAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement typeAnnotation : annotations) {
            MappingClassDef classDef = new MappingClassDef();
            Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(typeAnnotation);
            for (Element element : annotatedElements) {
                TypeElement clazz = (TypeElement) element;

                DomainMapper annotation = clazz.getAnnotation(DomainMapper.class);
                classDef.setDomainPackageName(getPackage(annotation.domainClass()));
                classDef.setMapperSimpleClassName(getSimpleClassName(annotation.domainClass()) + "Mapper");
                classDef.setMapperPackageName(
                        getPackage(clazz.getQualifiedName().toString()) + ".mapper");

                List<MappingPropertyDef> properties = clazz.getEnclosedElements().stream()
                        .filter(item -> item instanceof VariableElement)
                        .map(item -> (VariableElement) item)
                        .map(this::toMappingPropertyDef)
                        .filter(Objects::nonNull)
                        .collect(Collectors.toList());
                classDef.setFromThisDef(MappingMethodDef.builder()
                        .methodName(annotation.mapFromThisMethod())
                        .sourceClassName(clazz.getSimpleName().toString())
                        .destClassName(getSimpleClassName(annotation.domainClass()))
                        .properties(properties)
                        .build());
                classDef.setToThisDef(MappingMethodDef.builder()
                        .methodName(annotation.mapToThisMethod())
                        .sourceClassName(getSimpleClassName(annotation.domainClass()))
                        .destClassName(clazz.getSimpleName().toString())
                        .properties(properties)
                        .build());
            }

            buildJavaFile(classDef);
        }
        return true;
    }

    private String getPackage(String fullClazzName) {
        int lastDot = fullClazzName.lastIndexOf(".");
        return fullClazzName.substring(0, lastDot);
    }

    private String getSimpleClassName(String fullClazzName) {
        int lastDot = fullClazzName.lastIndexOf(".");
        return fullClazzName.substring(lastDot + 1);
    }

    private MappingPropertyDef toMappingPropertyDef(VariableElement variable) {
        String name = variable.getSimpleName().toString();
        if ("createdAt".equalsIgnoreCase(name) || "modifiedAt".equalsIgnoreCase(name)) {
            return null;
        }
        return MappingPropertyDef.builder()
                .property(name)
                .type(variable.asType().toString())
                .build();
    }

    private void buildJavaFile(MappingClassDef classDef) {
        String javaContent = new JavaFileBuilder().build(classDef);
        try {
            JavaFileObject javaFile = processingEnv
                    .getFiler()
                    .createSourceFile(classDef.getMapperPackageName() + "." + classDef.getMapperSimpleClassName());
            PrintWriter writer = new PrintWriter(javaFile.openOutputStream());
            writer.print(javaContent);
            writer.close();
        } catch (IOException e) {
            log.error("Cannot create Java File - {}", e.getMessage(), e);
        }
    }
}
