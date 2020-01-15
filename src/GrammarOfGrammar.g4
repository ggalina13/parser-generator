grammar GrammarOfGrammar;

start : strings EOF;

strings : (terminalRule | notTerminalRule) ';' strings | ;

notTerminalRule : mainNotTerminal ':' expr ( '|' expr)*;

terminalRule : terminal ':' terminalExpr;

mainNotTerminal : notTerminal;

TokenName : [a-zA-Z0-9]+;

notTerminal : TokenName;

terminal : TokenName | epsilon;

epsilon : 'ε';

expr : token |
        '(' expr ')' |
        expr expr;

token : notTerminal |
        terminalExpr;

terminalExpr : Rgx;

Rgx : '\'' .+? '\'';

WS
   : [ \n\t\r]+ -> skip;

