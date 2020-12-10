# Ejercicios de estructuras repetitivas

## Ejercicio 1

Crea una aplicación que permita adivinar un número. La aplicación genera un número aleatorio del 1 al 100. A continuación va pidiendo números y va respondiendo si el número a adivinar es mayor o menor que el introducido,a demás de los intentos que te quedan (tienes 10 intentos para acertarlo). El programa termina cuando se acierta el número (además te dice en cuantos intentos lo has acertado), si se llega al limite de intentos te muestra el número que había generado.

Para usar números aleatorios en Python: http://www.mclibre.org/consultar/python/lecciones/python-biblioteca-random.html

## Ejercicio 2

Realizar un programa que pida números (se pedirá por teclado la cantidad de números a introducir). El programa debe informar de cuantos números introducidos son mayores que 0, menores que 0 e iguales a 0.

## Ejercicio 3

Programa que pida caracteres e imprima ‘VOCAL’ si son vocales y ‘NO VOCAL’ en caso contrario, el programa termina cuando se introduce un espacio.

## Ejercicio 4

Escribir un programa que imprima todos los números pares entre dos números que se le pidan al usuario.

## Ejercicio 5

Escribe un programa que pida el limite inferior y superior de un intervalo. Si el límite inferior es mayor que el superior lo tiene que volver a pedir. 

A continuación se van introduciendo números hasta que introduzcamos el 0. Cuando termine el programa dará las siguientes informaciones:

La suma de los números que están dentro del intervalo (intervalo abierto).
Cuantos números están fuera del intervalo.
Informa si hemos introducido algún número igual a los límites del intervalo.

## Ejercicio 6

Escribe un programa que dados dos números, uno real (base) y un entero positivo (exponente), saque por pantalla el resultado de la potencia. No se puede utilizar el operador de potencia ni la función.

## Ejercicio 7

Una persona adquirió un producto para pagar en 20 meses. El primer mes pagó 10 €, el segundo 20 €, el tercero 40 € y así sucesivamente. Realizar un programa para determinar cuánto debe pagar mensualmente y el total de lo que pagará después de los 20 meses.

## Ejercicio 8

Hacer un programa que muestre un cronometro, indicando las horas, minutos y segundos.

Para hacer una espera en Python podemos usar el método sleep del módulo time.

## Ejercicio 9

Mostrar en pantalla los N primero número primos. Se pide por teclado la cantidad de números primos que queremos mostrar.

## Ejercicio 10

Pide una cadena y un carácter por teclado y muestra cuantas veces aparece el carácter en la cadena.

## Ejercicio 11

Suponiendo que hemos introducido una cadena por teclado que representa una frase (palabras separadas por espacios), realiza un programa que cuente cuantas palabras tiene.

## Ejercicio 12

Pide una cadena y dos caracteres por teclado (valida que sea un carácter), sustituye la aparición del primer carácter en la cadena por el segundo carácter.

## Ejercicio 13

Realizar un programa que lea una cadena por teclado y convierta las mayúsculas a minúsculas y viceversa.

## Ejercicio 14

Realizar un programa que compruebe si una cadena contiene una subcadena. Las dos cadenas se introducen por teclado.

## Ejercicio 15

Introducir una cadena de caracteres e indicar si es un palíndromo. Una palabra palíndroma es aquella que se lee igual adelante que atrás.

## Ejercicio 16

Realiza un conversor del sistema decimal al sistema de “palotes”.

Ejemplo:  
Por favor, introduzca un número entero positivo: 47021  
El 47021 en decimal es el | | | | - | | | | | | | - - | | - | en el sistema de palotes.  

*Ejercicio 37 (bucles) del libro "Aprende Java con Ejercicios" (edición 2019) de Luis J. Sánchez.*

## Ejercicio 17

Programa que pinta la letra U por pantalla hecha con asteriscos. 
El programa pedirá la altura. 
El programa inserta un espacio y pinta dos asteriscos menos en la base para 
simular la curvatura de las esquinas inferiores.

Ejemplo 1:
Introduzca la altura de la U: 5

    *     *
    *     *
    *     *
    *     *
     * * *
 
Ejemplo 2:
Introduzca la altura de la U: 4

    *    *
    *    *
    *    *
     *  *

*Ejercicio 33 (bucles) del libro "Aprende Java con Ejercicios" (edición 2019) de Luis J. Sánchez.*

## Ejercicio 18

Programa que sea capaz de insertar un dígito dentro de un número
indicando la posición. El nuevo dígito se colocará en la posición indicada y el
resto de dígitos se desplazará hacia la derecha. 

Las posiciones se cuentan de izquierda a derecha empezando por el 1. 
 
Ejemplo:  
Por favor, introduzca un número entero positivo: 406783  
Introduzca la posición donde quiere insertar: 3  
Introduzca el dígito que quiere insertar: 5  
El número resultante es 4056783.  

*Ejercicio 44 (bucles) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*

## Ejercicio 19

Realiza un programa que pinte por pantalla una serpiente con un “serpenteo”
aleatorio. La cabeza se representará con el carácter @ y se debe colocar
exactamente en la posición 13 (con 12 espacios delante). A partir de ahí,
el cuerpo irá serpenteando de la siguiente manera: se generará de forma
aleatoria un valor entre tres posibles que hará que el siguiente carácter se
coloque una posición a la izquierda del anterior, alineado con el anterior o una
posición a la derecha del anterior. La longitud de la serpiente se pedirá por
teclado y se supone que el usuario introducirá un dato correcto.

*Ejercicio 22 (números aleatorios) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*
            
## Ejercicio 20

Programa que calcule el máximo, mínimo, media y varianza de 10 notas introducidas por el usuario.

## Ejercicio 21

Programa que muestre tres apuestas de la quiniela en tres columnas para los 14 partidos y el pleno al quince (15 filas) de forma que la probabilidad de que salga un 1 sea  de 1/2, la probabilidad de que salga X sea de 1/3 y la probabilidad de que salga 2 sea de 1/6. 

Pista: 1/2 = 3/6 y 1/3 = 2/6.

## Ejercicio 22

Programa que pida la temperatura media que ha hecho en cada mes de un determinado año 
y que muestre a continuación un diagrama de barras horizontales con esos datos. 
Las barras del diagrama se pueden dibujar a base de asteriscos o cualquier otro carácter.

*Ejercicio 8 (arrays unidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*

## Ejercicio 23

Programa que genere 20 números enteros aleatorios entre 0 y 100 y que los almacene en un array. El programa debe ser capaz de pasar todos los números pares a las primeras posiciones del array (del 0 en adelante) y todos los números impares a las celdas restantes. Utiliza arrays auxiliares si es necesario.

*Ejercicio 10 (arrays unidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*

## Ejercicio 24

Programa que genere 20 números enteros aleatorios entre 100 y 999 y los introduzca en un array de 4 filas por 5 columnas. 

El programa mostrará el array con las sumas parciales de filas y columnas igual que si de una hoja de cálculo se tratara. La suma total debe aparecer en la esquina inferior derecha.

*Ejercicio 3 (arrays bidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*

## Ejercicio 25

Realiza un programa que rellene un array de 6 filas por 10 columnas con
números enteros positivos aleatorios comprendidos entre 0 y 1000 (ambos incluidos) de tal forma que no se repita ningún número.

A continuación, el programa deberá dar la posición tanto del máximo como del mínimo.

*Ejercicio 6 (arrays bidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*

## Ejercicio 26

Realiza un programa que calcule la estatura media, mínima y máxima en
centímetros de personas de diferentes países. El array que contiene los
nombres de los paises es el siguiente: pais = {“España”, “Rusia”, “Japón”,
“Australia”}. 

Los datos sobre las estaturas se deben simular mediante un array de 4 filas por 10 columnas con números aleatorios generados al azar entre 140 y 210. Los decimales de la media se pueden despreciar. 

Los nombres de los países se deben mostrar utilizando el array de países (no se pueden escribir directamente).

*Ejercicio 13 (arrays bidimensionales) de "Aprende Java con Ejercicios" (Ed.2019) de Luis José Sánchez González.*