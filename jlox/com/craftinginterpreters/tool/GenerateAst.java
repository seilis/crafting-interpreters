package com.craftinginterpreters.tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class GenerateAst {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: generate_ast <output_directory>");
            System.exit(64);
        }
        String outputDir = args[0];

        defineAst(outputDir, "Expr", Arrays.asList(
            "Binary  : Expr left, Token operator, Expr right",
            "Grouping: Expr expression",
            "Literal : Object value",
            "Variable: Token name",
            "Unary   : Token operator, Expr right"
            )
        );

        defineAst(outputDir, "Stmt", Arrays.asList(
            "Expression : Expr expression",
            "Print      : Expr expression",
            "Var        : Token name, Expr initializer"
        ));
    }

    private static void defineAst(
        String outputDir, String baseName, List<String> types)
        throws IOException
    {
        String path = outputDir + "/" + baseName + ".java";
        PrintWriter writer = new PrintWriter(path, "UTF-8");

        writer.println("package com.craftinginterpreters.lox;");
        writer.println();
        writer.println("import java.util.List;");
        writer.println();
        writer.println("abstract class " + baseName + " {");

        defineVisitor(writer, baseName, types);

        for (String type : types) {
            String className = type.split(":")[0].trim();
            String fields = type.split(":")[1].trim();
            defineType(writer, baseName, className, fields);
        }

        // The base accept() method.
        writer.println();
        writer.println("  abstract <R> R accept(Visitor<R> visitor);");

        writer.println("}");
        writer.close();
    }

    private static void defineType(
        PrintWriter writer, String baseName,
        String className, String fieldList)
    {
        writer.println("  static class " + className + " extends " + baseName + " {");

        // Constructor
        writer.println("    " + className + "(" + fieldList + ") {");

        // Store parameters in fields
        String[] fields = fieldList.split(", ");
        for (String field : fields) {
            String name = field.split(" ")[1];
            writer.println("      this." + name + " = " + name + ";");
        }

        writer.println("    }");

        // Visitor pattern.
        writer.println();
        writer.println("    @Override");
        writer.println("    <R> R accept(Visitor<R> visitor) {");
        writer.println("      return visitor.visit" + className + baseName + "(this);");
        writer.println("    }");

        // fields
        writer.println();
        for (String field : fields) {
            writer.println("    final " + field + ";");
        }

        writer.println("  }");
    }

    private static void defineVisitor(
        PrintWriter writer, String baseName, List<String> types)
    {
        writer.println("  interface Visitor<R> {");

        for (String type : types) {
            String typeName = type.split(":")[0].trim();
            writer.println("    R visit" + typeName + baseName + "(" +
                            typeName + " " + baseName.toLowerCase() + ");");
        }

        writer.println("  }");
    }
}
