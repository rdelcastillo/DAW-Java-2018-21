## Ejercicio 1

Crea la clase iterable ListaPrimos que permita iterar sobre la lista de números primos, desde 2 hasta uno dado como máximo.

Ejemplo: "var lista = ListaPrimos(15)" iterará sobre 2,3,5,7,11,13

## Ejercicio 2

Haz el ejercicio anterior usando una lista interna y eliminando elementos con el algoritmo de la [criba de Eratóstenes](https://es.wikipedia.org/wiki/Criba_de_Erat%C3%B3stenes).

## Ejercicio 3 

Crea la clase iterable Sucesion que permita iterar sobre los N primeros números de una sucesión de números enteros (long) representada por una expresión lambda que devuelve el término iésimo de la sucesión.

## Ejercicio 4

Vamos a probar los streams de Java, que están muy relacionados con las expresiones lambda, para ello, usando [este artículo][streams] como referencia, vamos a crear una lista de 1000 números enteros aleatorios entre -5000 y 5000 y usando streams vamos a averiguar:

- El máximo de los números pares.
- El mínimo de los números múltiplos de 3.
- El total de números negativos.
- El total de números primos.
- El máximo número primo.

[streams]: https://www.ecodeup.com/ejemplos-practicos-de-expresiones-lambda-en-java-8/