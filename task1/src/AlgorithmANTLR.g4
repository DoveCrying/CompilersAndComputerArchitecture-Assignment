grammar AlgorithmANTLR;
topLevel : prog;

prog: dec | dec prog;

dec: type idfr LParen vardec RParen block;

vardec:  | vardecne;

vardecne: type idfr | vardecne Comma type idfr;

block: LBrace ene RBrace;

ene: exp | exp Semicolon ene;

exp: idfr # IdExpr
    | intlit # IntExpr
    | idfr Assign exp # AsgmtExpr
    | LParen exp binop exp RParen # BinOpExpr
    | idfr LParen args RParen # FunInvocExpr
    | block # BlockExpr
    | If exp Then block Else block # IfExpr
    | While exp Do block # WhileExpr
    | Repeat block Until exp # RepeatExpr
    | Skip # SkipExpr;

args:  | argsne;

argsne: exp | argsne Comma exp;

binop: Assign | LessEq | Eq | GtrEq | Less | Plus | Minus | And | Xor | Gtr | Times | Div | Or;

type: IntType | BoolType | UnitType;

idfr: Idfr;

intlit: IntLit;

//Type tokens
IntType  : 'int' ;
BoolType : 'bool';
UnitType : 'unit';

//Operator tokens
Assign : ':=';
LessEq : '<=';
Eq     : '==';
GtrEq  : '>=';
Less   : '<' ;
Plus   : '+' ;
Minus  : '-' ;
And    : '&&';
Xor    : '^^';
Gtr    : '>' ;
Times  : '*' ;
Div    : '/' ;
Or     : '||';

//Control flow tokens
While  : 'while';
Do     : 'do';
Repeat : 'repeat' ;
Until  : 'until' ;
If     : 'if';
Then   : 'then' ;
Else   : 'else' ;

//Delimiter tokens
LParen : '(';
Comma  : ',';
RParen : ')';
LBrace : '{';
Semicolon : ';';
RBrace : '}';

//Expression tokens
Skip   : 'skip';
Idfr   : [a-z][A-Za-z0-9_]* ;
IntLit : '0' | [1-9][0-9]*  ;
Ignore : [ \n\r\t]+ -> skip ;
