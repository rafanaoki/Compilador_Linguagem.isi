# COMO USAR

Navegue até o direório do projeto pelo terminal e execute:

java -jar antlr-4.13.2-complete.jar -visitor -o antlr SimpleLang.g4
javac -cp ".;antlr-4.13.2-complete.jar" antlr/*.java SimpleLangInterpreter.java
java -cp ".;antlr-4.13.2-complete.jar;antlr" SimpleLangInterpreter