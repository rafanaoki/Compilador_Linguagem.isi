grammar SimpleLang;


programa: 'programa' declarations stmts 'fimprog' ;

declarations: (declareStmt)+ ;

declareStmt: 'declare' tipo ID (',' ID)* '.' ;



tipo: 'inteiro' | 'real' | 'string' ;

stmts: stmt+ ;

stmt: 
      assignStmt
    | writeStmt
    | writelnStmt
    | readStmt
    | ifStmt
    | whileStmt
    | forStmt
    ;

assignStmt: ID ':=' expr ('.')? ;

writeStmt: 'escreva' '(' (STRING | ID) ')' '.' ;

writelnStmt: 'escrevaln' '(' (STRING | ID) ')' '.' ;

readStmt: 'leia' '(' ID ')' '.' ;

ifStmt: 'if' '(' expr ')' '{' stmts '}' 'else' '{' stmts '}' ;

whileStmt: 'while' '(' expr ')' '{' stmts '}' ;

forStmt: 'for' '(' assignStmt expr '.' assignStmt ')' '{' stmts '}' ;

expr: expr op=('*'|'/') expr
    | expr op=('+'|'-') expr
    | expr op=('<'|'>'|'==') expr
    | ID
    | INT
    | FLOAT
    | STRING
    ;

ID: [a-zA-Z]+([0-9])*;
INT: [0-9]+ ;
FLOAT: [0-9]+'.'[0-9]+ ;
STRING: '"' .*? '"' ;

WS: [ \t\r\n]+ -> skip ;




