grammar GrammarOfGrammar;

start : strings EOF;

strings : rule_ ';' strings | ;

rule_ : mainNotTerminal ':' expr ( '|' expr)*;

mainNotTerminal : notTerminal;

TokenName : [a-zA-Z0-9]+;

notTerminal : TokenName;

expr : token |
        '(' expr ')' |
        expr expr;

token : notTerminal |
        terminalExpr;

terminalExpr : Rgx;

Rgx : '\'' .*? '\'';

WS
   : [ \n\t\r]+ -> skip;

