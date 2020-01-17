grammar GrammarOfGrammar;

start : strings EOF;

strings : ('[' atrType nullValue ']' ';')? rule_ ';' strings | ;

atrType : 'Integer' | 'Boolean' | 'Double';

nullValue : .+;

rule_ : mainNotTerminal ':' expr (atrCode)? ( '|' expr (atrCode)?)*;

atrCode : AtrCode;

AtrCode : '{' .+? '}';

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

