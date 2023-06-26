package com.example.studentcleanarch.adapter.out.persistent.codegen;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;

public class JavaFileBuilder {

    public String build(MappingClassDef classDef) {
        StringWriter stringWriter = new StringWriter();
        try (PrintWriter out = new PrintWriter(stringWriter)) {
            if (Objects.nonNull(classDef.getMapperPackageName())) {
                out.print("package ");
                out.print(classDef.getMapperPackageName());
                out.println(";\n");
                buildImports(classDef, out);
                out.println();
            }

            out.println("@Component");
            out.print("public class ");
            out.print(classDef.getMapperSimpleClassName());
            out.println(" {");
            out.println();

            out.println(buildMappingMethod(classDef.getToThisDef()));
            out.println("");
            out.println(buildMappingMethod(classDef.getFromThisDef()));
            out.println("}");
        }
        return stringWriter.toString();
    }

    private void buildImports(MappingClassDef classDef, PrintWriter out) {
        out.println(String.format(
                "import %s.%s;",
                classDef.getDomainPackageName(), classDef.getToThisDef().getSourceClassName()));
        out.println("import org.springframework.stereotype.Component;");
    }

    private String buildMappingMethod(MappingMethodDef classDef) {
        StringBuilder builder = new StringBuilder();
        String mapToLeftMethodName = String.format(
                "    public %s %s(%s value) {\n",
                classDef.getDestClassName(), classDef.getMethodName(), classDef.getSourceClassName());
        builder.append(mapToLeftMethodName);

        builder.append(String.format("        return %s.builder()\n", classDef.getDestClassName()));
        for (MappingPropertyDef property : classDef.getProperties()) {
            builder.append(
                    String.format("                .%s(value.%s())\n", property.getProperty(), toGetter(property)));
        }
        builder.append("                .build();\n");
        builder.append("    }");
        return builder.toString();
    }

    private String toGetter(MappingPropertyDef property) {
        String name = property.getProperty();
        String type = property.getType();
        if ("boolean".equalsIgnoreCase(type)) {
            return "is" + name.substring(0, 1).toUpperCase() + name.substring(1);
        }
        return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);
    }
}
