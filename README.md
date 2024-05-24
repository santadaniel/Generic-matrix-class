A házi feladatomban egy generikus mátrix osztályt hoztam létre.
Implementáltam egy Item nevű abstract osztályt, hogy használni tudjuk a mátrixot, ilyen elemeket kell beletöltenünk.
Az alap típusokra megvalósítottam a működést egy companion object segítségével, ha további típusokra is szeretnénk, hogy
működjön, implementálni kell a megfelelő osztályokat.
A mátrixunk képes az összeadásra, kivonásra, szorzásra és a transzponálásra. A toString() függvénye szépen sorokkal és oszlopokkal
ellátva adja meg a mátrixunkat.
Az osztály helyes működését JUnit tesztekkel ellenőriztem.