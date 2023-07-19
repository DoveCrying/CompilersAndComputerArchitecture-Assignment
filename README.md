### CFG 
```
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
```

### Tasks
#### Task 1
Lexer and Parser
Relevant Work can be found at: task1/src/AlgorithmANTLRAnalyser.java

#### Task 2
Type Checker
Relevant work can be found at: task2/src/SExpressionsAnalyser.java

#### Task 3
Code Generation
Relevant work can be found at: task3/src/SExpressionsAnalyser.java

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

### Execution model
- Utilises a main program int main(), which needs to occurr at least once in the function declarations.

### Example Programs
#### Example #1
```
  int fun(int x, int y, int z) {
    if (x == y) then { z } else { 0 } }

  int main() { fun(1, 2, 3) }
```
#### Example #2
```
  int main() { fibo(10) }
  int fibo(int n) {
    if (n < 2)
    then { n } 
    else { (fibo((n - 1)) + fibo((n - 2))) } }
```
Example #3
```
  unit doLoop (int i, int a) {
    while (i <= 100) do {
      a := (a + i);
      i := (i + 1) } }

  int main() {
    doLoop(0, 5);
    1337 }
```
#### Example #4
```
  int main() { fact(10) }

  int fact(int n) {
    if (n == 0)
    then { 1 } 
    else { (n * fact((n - 1))) } }
```
