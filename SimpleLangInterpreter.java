import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleLangInterpreter {

    static class Variable {
        enum Type { INTEGER, REAL, STRING }
        Type type;
        Object value;

        Variable(Type type, Object value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    static Map<String, Variable> memory = new HashMap<>();  
    static Scanner scanner = new Scanner(System.in);        
    
    public static void main(String[] args) throws Exception {

        String code = new String(Files.readAllBytes(Paths.get("Linguagem.sl")));

        CharStream input = CharStreams.fromString(code);
        SimpleLangLexer lexer = new SimpleLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(tokens);


        ParseTree tree = parser.programa();


        translate(tree);

        execute(tree);
    }

    public static void translate(ParseTree tree) {
        SimpleLangVisitorImpl translator = new SimpleLangVisitorImpl(true);
        translator.visit(tree);

        try (FileWriter writer = new FileWriter("Traduzido.java")) {
            writer.write(translator.getJavaCode());
            System.out.println("Código Java traduzido foi gerado com sucesso no arquivo 'Traduzido.java'.");
        } catch (IOException e) {
            System.out.println("Erro ao gerar o arquivo traduzido: " + e.getMessage());
        }
    }

    
    public static void execute(ParseTree tree) {
        SimpleLangVisitorImpl executor = new SimpleLangVisitorImpl(false);
        executor.visit(tree);
    }


    static class SimpleLangVisitorImpl extends SimpleLangBaseVisitor<Integer> {

        private boolean isTranslating;
        private StringBuilder javaCode = new StringBuilder();
        private boolean scannerDeclared = false;  

        public SimpleLangVisitorImpl(boolean isTranslating) {
            this.isTranslating = isTranslating;
        }

        public String getJavaCode() {
            return javaCode.toString();
        }

        @Override
        public Integer visitPrograma(SimpleLangParser.ProgramaContext ctx) {
            if (isTranslating) {
               
                javaCode.append("import java.util.Scanner;\n");  
                javaCode.append("public class Traduzido {\n");
                javaCode.append("    public static void main(String[] args) {\n");
                visitChildren(ctx); 
                javaCode.append("    }\n");
                javaCode.append("}\n");
            } else {
      
                visitChildren(ctx); 
            }
            return 0;
        }

        @Override
        public Integer visitDeclareStmt(SimpleLangParser.DeclareStmtContext ctx) {
            SimpleLangParser.TipoContext tipoCtx = ctx.tipo();  
            Variable.Type varType;

            if (tipoCtx.getText().equals("inteiro")) {
                varType = Variable.Type.INTEGER;
            } else if (tipoCtx.getText().equals("real")) {
                varType = Variable.Type.REAL;
            } else {
                varType = Variable.Type.STRING;
            }

            for (TerminalNode idNode : ctx.ID()) {
                String id = idNode.getText();
                if (!SimpleLangInterpreter.memory.containsKey(id)) {
                    Object initialValue = switch (varType) {
                        case INTEGER -> 0;
                        case REAL -> 0.0;
                        case STRING -> "";
                    };
                    SimpleLangInterpreter.memory.put(id, new Variable(varType, initialValue));
                }

                if (isTranslating) {
                    String javaType = switch (varType) {
                        case INTEGER -> "int";
                        case REAL -> "double";
                        case STRING -> "String";
                    };
                    javaCode.append("    ").append(javaType).append(" ").append(id).append(" = ");
                    switch (varType) {
                        case INTEGER -> javaCode.append("0;\n");
                        case REAL -> javaCode.append("0.0;\n");
                        case STRING -> javaCode.append("\"\";\n");
                    }
                }
            }
            return 0;
        }

        @Override
        public Integer visitWhileStmt(SimpleLangParser.WhileStmtContext ctx) {
            if (isTranslating) {
         
                javaCode.append("    while (").append(ctx.expr().getText()).append(") {\n");
                for (SimpleLangParser.StmtContext stmt : ctx.stmts().stmt()) {
             
                }
                javaCode.append("    }\n");
            } else {
        
                while (visit(ctx.expr()) != 0) {
                    visit(ctx.stmts());
                }
            }
            return 0;
        }

        @Override
        public Integer visitForStmt(SimpleLangParser.ForStmtContext ctx) {
            if (isTranslating) {
            
                javaCode.append("    for (").append(ctx.assignStmt(0).getText().replace(":=", "=").replace(".", ""))
                        .append("; ").append(ctx.expr().getText()).append("; ")
                        .append(ctx.assignStmt(1).getText().replace(":=", "=").replace(".", "")).append(") {\n");

           
                for (SimpleLangParser.StmtContext stmt : ctx.stmts().stmt()) {
                    visit(stmt);
                }

                javaCode.append("    }\n");  
            } else {
               
                visit(ctx.assignStmt(0));  
                while (visit(ctx.expr()) != 0) {  
                    visit(ctx.stmts()); 
                    visit(ctx.assignStmt(1)); 
                }
            }
            return 0;
        }

        @Override
        public Integer visitWriteStmt(SimpleLangParser.WriteStmtContext ctx) {
            if (ctx.STRING() != null) {
                String text = ctx.STRING().getText();
                if (isTranslating) {
                    javaCode.append("    System.out.print(").append(text).append(");\n");  // Sem quebra de linha
                } else {
                    System.out.print(text.substring(1, text.length() - 1));  // Remove aspas e não quebra a linha
                }
            } else if (ctx.ID() != null) {
                String var = ctx.ID().getText();
                if (SimpleLangInterpreter.memory.containsKey(var)) {
                    if (isTranslating) {
                        javaCode.append("    System.out.print(").append(var).append(");\n");  // Sem quebra de linha
                    } else {
                        System.out.print(SimpleLangInterpreter.memory.get(var));  // Imprime valor e não quebra a linha
                    }
                } else {
                    System.out.println("Erro: variável " + var + " não foi declarada.");
                }
            }
            return 0;
        }

        @Override
        public Integer visitWritelnStmt(SimpleLangParser.WritelnStmtContext ctx) {
            if (ctx.STRING() != null) {
                String text = ctx.STRING().getText();
                if (isTranslating) {
                    javaCode.append("    System.out.println(").append(text).append(");\n");
                } else {
                    System.out.println(text.substring(1, text.length() - 1));  // Remove aspas e quebra a linha
                }
            } else if (ctx.ID() != null) {
                String var = ctx.ID().getText();
                if (SimpleLangInterpreter.memory.containsKey(var)) {
                    if (isTranslating) {
                        javaCode.append("    System.out.println(").append(var).append(");\n");
                    } else {
                        System.out.println(SimpleLangInterpreter.memory.get(var));  // Imprime valor e quebra a linha
                    }
                } else {
                    System.out.println("Erro: variável " + var + " não foi declarada.");
                }
            }
            return 0;
        }

        @Override
        public Integer visitReadStmt(SimpleLangParser.ReadStmtContext ctx) {
            String var = ctx.ID().getText();
            Variable variable = SimpleLangInterpreter.memory.get(var);

            if (isTranslating) {
                // Declarar o scanner apenas uma vez
                if (!scannerDeclared) {
                    javaCode.append("    Scanner scanner = new Scanner(System.in);\n");
                    scannerDeclared = true;
                }

                javaCode.append("    ").append(var).append(" = ");
                switch (variable.type) {
                    case INTEGER -> {
                        javaCode.append("scanner.nextInt();\n");
                        javaCode.append("    scanner.nextLine(); // Consumir o \\n após o número inteiro\n");
                    }
                    case REAL -> {
                        javaCode.append("scanner.nextDouble();\n");
                    }
                    case STRING -> javaCode.append("scanner.nextLine();\n");
                }
            } else {
                // Execução da leitura
                switch (variable.type) {
                    case INTEGER -> {
                        variable.value = SimpleLangInterpreter.scanner.nextInt();
                        SimpleLangInterpreter.scanner.nextLine(); // Consumir o \n após o número inteiro
                    }
                    case REAL -> {
                        if (SimpleLangInterpreter.scanner.hasNextDouble()) {
                            variable.value = SimpleLangInterpreter.scanner.nextDouble();
                            SimpleLangInterpreter.scanner.nextLine(); // Consumir o \n após o número real
                        } else {
                            System.out.println("Erro: valor inserido não é um número real válido.");
                            SimpleLangInterpreter.scanner.next(); // Pular o valor inválido
                        }
                    }
                    case STRING -> variable.value = SimpleLangInterpreter.scanner.nextLine();
                }
            }
            return 0;
        }

        @Override
        public Integer visitAssignStmt(SimpleLangParser.AssignStmtContext ctx) {
            String var = ctx.ID().getText();
            Variable variable = SimpleLangInterpreter.memory.get(var);

            Object value = visit(ctx.expr()); // Avalia a expressão
            if (isTranslating) {
                javaCode.append("    ").append(var).append(" = ").append(ctx.expr().getText()).append(";\n");
            } else {
                // Atribui o valor à variável conforme o tipo
                switch (variable.type) {
                    case INTEGER -> variable.value = Integer.parseInt(value.toString());
                    case REAL -> variable.value = Double.parseDouble(value.toString());
                    case STRING -> variable.value = value.toString();
                }
            }
            return 0;
        }

        @Override
        public Integer visitExpr(SimpleLangParser.ExprContext ctx) {
            if (ctx.getChildCount() == 3) {
                int left = visit(ctx.expr(0));
                int right = visit(ctx.expr(1));
                String op = ctx.op.getText();
                switch (op) {
                    case "+": return left + right;
                    case "-": return left - right;
                    case "*": return left * right;
                    case "/": return left / right;
                    case "<": return left < right ? 1 : 0;
                    case ">": return left > right ? 1 : 0;
                    case "==": return left == right ? 1 : 0;
                }
            } else if (ctx.ID() != null) {
                Variable var = SimpleLangInterpreter.memory.get(ctx.ID().getText());
                if (var.type == Variable.Type.INTEGER) {
                    return (Integer) var.value;
                } else if (var.type == Variable.Type.REAL) {
                    return ((Double) var.value).intValue(); // Convertendo double para int para comparação
                }
            } else if (ctx.INT() != null) {
                return Integer.parseInt(ctx.INT().getText());
            } else if (ctx.FLOAT() != null) {
                // Solução para o erro: use uma variável intermediária
                double floatValue = Double.parseDouble(ctx.FLOAT().getText());
                return (int) floatValue; // Converte o valor float para int
            }
            return 0;
        }
    }
}
