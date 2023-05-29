### CFG 
  PROG →	DEC | DEC PROG
  DEC →	TYPE IDFR (VARDEC) BLOCK
  VARDEC →	ε | VARDECNE
  VARDECNE →	TYPE IDFR
  |	VARDECNE, TYPE IDFR
  BLOCK →	{ ENE }
  ENE →	EXP | EXP; ENE
  EXP →	IDFR
  |	INTLIT
  |	IDFR := EXP
  |	(EXP BINOP EXP)
  |	IDFR (ARGS)
  |	BLOCK
  |	if EXP then BLOCK else BLOCK
  |	while EXP do BLOCK
  |	repeat BLOCK until EXP
  |	skip
  ARGS →	ε | ARGSNE
  ARGSNE →	EXP | ARGSNE, EXP
  BINOP →	==  |  <  |  >  |  <=  |  >=
  |	 +  |  −  |  *  |   /  |  &&  |  ||  |  ^^
  TYPE →	int | bool | unit
  IDFR →	(an identifier)
  INTLIT →	(an integer)

### Lexems
- Keywords:
- - if , then , else , skip , while , do , repeat , until , int , bool , and unit.
- Integers
- Identifiers
- Operators and Delimeters
- - ;  (  )  ==  <  >  <=  >=  ,  {  }  :=  +  *  -  /  &&  ||  ^^

### Disambiguity
- Longest match policy.
- Preference to keywords.
