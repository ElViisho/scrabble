# Scrabble

![http://creativecommons.org/licenses/by/4.0/](https://i.creativecommons.org/l/by/4.0/88x31.png)

Interactive graphic programming language heavily inspired by 
[Scratch](https://scratch.mit.edu).
This work is licensed under a
[Creative Commons Attribution 4.0 International License](http://creativecommons.org/licenses/by/4.0/), 
and aims purely to be used with the purpose of teaching in the context of the course 
_CC3002 Metodologías de Diseño y programación_ of the 
[_Computer Sciences Department (DCC)_](https://www.dcc.uchile.cl) of the 
_University of Chile_.

---

## Uso interfaz gráfica
Se abre la carpeta como proyecto de IntelliJ. Dentro se navega a la carpeta main y dentro de ella, se va
al paquete gui. Dentro se abre la clase Scrabble y se corre el programa con Gradle. En la interfaz hay
varios botones, divididos entre operaciones y datos. Los botones de operaciones no quedaron implementados.
Los de los datos, al apretarlos se genera un campo de texto donde se puede ingresar el valor que se quiere
que tenga, y luego de confirmar, se genera el dato con el valor. Está el botón `C` que borra todo lo ingresado.

## Uso tests
Se abre la carpeta como proyecto de IntelliJ. Dentro se navega a la carpeta test y dentro de ella hay dos 
paquetes. El paquete dataTypes contiene 5 clases de testeo, que prueban las funcionalidades de los tipos
de scrabble:
- scrabbleBinaryTest: se testean los métodos de la clase que implementa a los binarios de la aplicación
- scrabbleBoolTest: se testean los métodos de la clase que implementa a los booleanos de la aplicación
- scrabbleFloatTest: se testean los métodos de la clase que implementa a los floats de la aplicación
- scrabbleIntTest: se testean los métodos de la clase que implementa a los enteros de la aplicación
- scrabbleStringTest: se testean los métodos de la clase que implementa a los strings de la aplicación

Existe también el paquete composite, que prueba distintos comportamientos del patrón composite utilizado para simular
problemas como árboles. Hay 4 clases de testeo:
- BasicLogicTest: se testean los nodos de operaciones lógicas
- BasicMathOperationsTest: se testean los nodos de operaciones matemáticas
- NullTest: se testean todas las operaciones que deben retornar null
- TreeTest: testea árboles complejos de operaciones y transformaciones

Dentro de cada clase, se pueden correr los tests por separado yendo a cada uno, o todos corriendo la clase
completa. Existe una variable `N` que determina la cantidad de repeticiones que se hacen por test, cada una con
valores aleatorios diferentes.

## Funcionamiento
Se creó una interfaz base, `IdataTypes`, para los 5 tipos de datos de la aplicación. Esta interfaz es implementada por una clase
abstracta, `AbstractDataType`, de la cual extienden las clases de los tipos. La interfaz tiene los métodos básicos como `equals` y
`hashcode`, y las transformaciones entre los tipos, además del método `toString` y la concatenación de strings. Estas son 
implementadas por la clase abstracta, y en casos especiales que se necesiten funcionalidades más específicas las implementan las
clases hijas de los tipos.  
Se tiene otra interfaz, `SString`, que solo tiene la suma de strings con otros tipos, implementada por la clase de string 
`scrabbleString`.  
Hay otra interfaz, `SNumber`, la cual tiene las diversas operaciones matemáticas básicas entre números, suma, resta, multiplicación
y división. Esta es implementada por una clase abstracta, hija de `AbstractDataType`, de la cual se extienden los enteros, floats y
binarios. Algunos métodos que tienen la misma funcionalidad para todos son implementados dentro de la clase abstracta, mientras que
otros más específicos los implementa cada clase.  
Existe una última interfaz, `SLogic`, que tiene la conjunción, disyunción y negación lógicas. Esta es implementada por los binarios
y los booleanos, que hacen uso de las operaciones anteriores.

Todas las transformaciones y operaciones generan una nueva instancia con el valor equivalente correspondiente, en vez de modificar
la instancia original. Para las operaciones se utilizó la metodología de double dispatch entre los tipos.

A todo lo anterior se le agregaron dos funcionalidades. Primero, los tipos ahora son creados con una fábrica *flyweight*
para ahorrar memoria. Todas las partes del proyecto que antes generaban instancias, ahora lo hacen a través de la fábrica. 
Para esto se creó una utility class `TypeFactory` la cual nunca es instanciada. Esta tiene métodos estáticos para generar
los nuevos objetos y los va guardando dentro de un mapa de hash para el caso de tener dos variables con el mismo valor.  
Segundo, se implementó el patrón de diseño *composite* para poder modelar las operaciones y transformaciones entre
objetos como un árbol, lo cual facilita al usuario visualizar un problema de manera más clara. Se elaboró una nueva 
interfaz `Component` la cual es implementada por todas las clases que serán instanciadas (datos y operaciones). 
`IdataTypes` extiende de esta clase, siendo los datos los nodos hoja del *composite*. También se creó una interfaz
`Operation` la cual es implementada por todas las clases que son operaciones, siendo estas los nodos compuestos del
*composite*.

Para la interfaz gráfica se utilizó el patrón *Modelo-Vista-Controlador*. Siendo el *Modelo* el paquete dataTypes, el cual
contiene toda la lógica de funcionamiento del programa. La *Vista* es el paquete gui, la cual muestra toda la información
necesaria al usuario del programa. Y por último, el *Controlador* es el paquete composite, el cual se encarga de generar
la comunicación entre el *Modelo* y la *Vista*.
