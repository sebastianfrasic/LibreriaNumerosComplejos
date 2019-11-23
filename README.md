# Librería de números complejos

Este repositorio es una librería de números complejos desarrollada en  **Java**, por **Juan Sebastián Frásica Galeano** para la materia Ciencias Naturales Y Tecnología **(CNYT)**. Es una librería que simula algunos comportamientos de la computación cuántica.

## Calidad del código  

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2de9d2b7c70c4ccbbaa5a70a3286faab)](https://www.codacy.com/manual/sebastianfrasic/LibreriaNumerosComplejos?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=sebastianfrasic/LibreriaNumerosComplejos&amp;utm_campaign=Badge_Grade)

## Funcionalidades

La librería soporta las siguientes operaciones entre números complejos:

### Versión N° 1: Calculadora de números complejos

*   Suma.
*   Producto.
*   Resta.
*   División.
*   Módulo.
*   Conjugado.
*   Conversión entre representaciones polar y cartesiano.
*   Retornar la fase de un número complejo.

### Versión N° 2: Calculadora de matrices complejas

*   Suma de vectores complejos.
*   Inverso aditivo de vector complejo.
*   Multiplicación de escalar por vector complejo.
*   Suma de matrices complejas.
*   Inverso aditivo de matriz compleja.
*   Multiplicación de escalar por matriz compleja.
*   Transpuesta de matriz compleja.
*   Conjugada de matriz compleja.
*   Adjunta (daga) de matriz compleja .
*   Producto de matrices complejas.
*   Acción de matriz compleja sobre vector complejo.
*   Producto interno de vectores complejos.
*   Norma de vector complejo.
*   Distancia entre dos vectores complejos.
*   ¿Es la matriz compleja una matriz unitaria?.
*   ¿Es la matriz compleja una matriz hermitiana?.
*   Producto tensorial de matrices complejas.

### Versión N° 3: El sato de lo clásico a lo cuántico

Esta versión tiene 3 funciones principales:

La especificación de dichas funciones se encuentra ![aquí](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/Pruebas_Proyecto_3.pdf)

#### 1. Simulador de sistemas determinísticos, estocásticos y cuánticos; junto con su dinámica. Esta función es el método ```calcularDinamica(TipoSistema tipoDeSistema, MatrizCompleja matriz, MatrizCompleja vectorEstadoInicial, int numeroDeClicks)``` que se encuentra en la clase ```CalculadoraDinamica.java```

* Recibe como parámetros:
  * Tipo de sistema.
  * Matriz M.
  * Vector de estado inicial.
  * N° de clicks de tiempo.

* Retorna:
  * Validez de la matriz, según el parámetro de la dinámica ingresada. (Dinámica clásica ó dinámica doblemente estocástica ó dinámica cuántica).
  * Matriz M^t
  * Vector de estado final.

* La prueba de esta función se encuentra en ```\src\test\java\complexLibrary\version3``` en la clase ```DinamicaDeUnSistemaEnElTiempo.java```. Para ejecutarla, primero se debe compilar (Se puede usar el comando de Maven ```mvn package```):   
![package](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/package.PNG)

Debe salir algo similar a esto:   
![packageExitoso](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/packageExitoso.PNG)

Posteriormente, se debe ejecutar el método main(String[] args) de esta clase.

#### 2. Función que ensambla sistemas y sus dinámicas. Esta función es el método ```calcularDinamicaConEnsamble(TipoSistema tipo, MatrizCompleja m1, MatrizCompleja v1, MatrizCompleja m2, MatrizCompleja v2, int t)``` que se encuentra en la clase ```CalculadoraDinamica.java```

* Recibe como parámetros:
  * Matriz 1.
  * Vector 1.
  * Matriz 2.
  * Vector 2.
  * N° de clicks de tiempo.

* Retorna:
  * Vector de estado final.

* La prueba de esta función se encuentra en ```\src\test\java\complexLibrary\version3``` en la clase ```SistemasEnsamblados.java```. Al igual que en la clase anterior, esta clase tambien se debe compilar y ejecutar.   

#### 3. Función que realiza la simulación del experimento de las rendijas. Esta función es el método ```calcularExperimentoDeRendijas(TipoSistema tipoDeSistema, int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja vectorDeProbabilidad)``` que se encuentra en la clase ```Rendija.java```

* Recibe como parámetros:
  * Número de rendijas.
  * Número de blancos por pared.
  * Vector de probabilidades.
  * Tipo de sistema al que corresponde el vector de probabilidades (clásico, estocástico o cuántico).

* Retorna:
  * Matriz asociada al sistema (al grafo).
  * Matriz M^2
  * Vector de estado final, y su resultado es mostrado gráficamente en un diagrama de torta.

* La prueba de esta función se encuentra en ```\src\test\java\complexLibrary\version3``` en la clase ```ExperimentoRendijas.java```. Al igual que en la clase anterior, esta clase tambien se debe compilar y ejecutar.

### Versión N° 4: Teoría cuántica básica

Esta versión tiene 3 funciones nuevas:
La especificación de dichas funciones se encuentra ![aquí](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/Pruebas_Proyecto_4.pdf)

#### Función que calcula la distribución de probabilidad para los estados básicos de una partícula en una recta. Esta función es el método ```calcularProbabilidad(int numeroDePuntos, MatrizCompleja ket)``` que se encuentra en la clase ```CalculadoraCuantica.java```

* Recibe como parámetros:
  * Número de puntos del vector ket.
  * Vector ket.

* Retorna:
  * Vector de la distribución de probabilidad para los estados básicos de una partícula en una recta.


#### Calculadora estadística para observables. Esta función es el método ```calcularExperimentoDeRendijas(TipoSistema tipoDeSistema, int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja vectorDeProbabilidad)``` que se encuentra en la clase ```Rendija.java```

* Recibe como parámetros: 
  * Matriz omega Ω correspondiente al observable.
  * Vector de estado inicial ψ  

* Retorna:
  * Valor esperado.
  * Varianza.


Las pruebas de estas funciones se encuentran en ```\src\test\java\complexLibrary\version4``` en la clase ```TeoriaCuanticaBasicaTest.java```. 

#### Valores y vectores propios de un observable. 

* Esta función se hizo en Python, y se encuentra en ```src\main\python``` en el archivo ```valoresyvectorespropios.py``` 


### Versión N° 5: Esfera de Bloch

Todos los requerimientos se encuentran ![aquí](https://github.com/sergio-tello/actividad-Bloch)

La mitad de las funciones están en:

Y la otra mitad en el siguiente Jupyter Notebook:

![jupiter](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/src/main/python/Esfera%20de%20Bloch.ipynb)

Las transformaciones de los kets con las matrices son las siguientes:

#### Matriz X:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/X.PNG)  

#### Matriz Y:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/Y.PNG) 

#### Matriz Z:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/Z.PNG) 

#### Matriz S:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/S.PNG) 

#### Matriz T:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/T.PNG) 

#### Matriz H:
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/H.PNG) 

#### Matriz R(pi/4):
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/R.PNG) 

#### Matriz Rx(pi/4):
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/Rx.PNG) 

#### Matriz Ry(pi/4):
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/Ry.PNG) 

#### Matriz Rz(pi/4):
![foto](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/recursos/Esfera%20de%20Bloch/Esferas%20transformadas/Rz.PNG) 






## ¿Cómo usar la librería?

### Pasos de descarga y uso de pruebas

Clona el repositorio con la siguiente dirección en el terminal (cmd) usando el comando:
```git clone https://github.com/sebastianfrasic/LibreriaNumerosComplejos.git```

Luego, se debe abrir la carpeta clonada con algun IDE de Java, como **Eclipse**, **NetBeans** o **Intellij IDEA**. (Recomiendo Eclipse).

Para ejecutar la librería se deben ejecutar los tests, los cuales son pruebas unitarias de cada una de las funcionalidades de la librería.
Dichos tests, están en el paquete __**src\test\java\complexLibrary**__

Hay 3 archivos de pruebas por cada versión del proyecto:

*   NumerosComplejosTest.java
*   MatricesComplejasTest.java
*   SistemasDinamicosTest.java

En la clase MatricesComplejasTest están las ![pruebas mínimas](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/CNYT_Pruebas_Proyecto_2.pdf) requeridas por el docente, y posteriormente hay algunas pruebas adicionales.  

Se pueden ejecutar desde algún IDE de Java, o desde Maven mediante el comando:

```mvn test```

#### Ejemplo de ejecución correcta de pruebas

##### Mediante Eclipse

![prueba1](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/ejecucion.png)  
![prueba2](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/ejecucion2.png)  

##### Mediante Maven

![prueba3](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/pruebas.PNG)

#### Desarrollado con

* [Java](https://www.oracle.com/technetwork/es/java/javase/downloads/index.html) - Lenguaje de programación.
* [Maven](https://maven.apache.org/) - Gestor de dependencias.



## Recomendaciones

*   Para usar los comandos con __mvn__ recuerda haber instalado Maven previamente.
*   Recuerda leer la documentación de los métodos.
*   Ante cualquier inquietud, puedes escribirme a mi correo electrónico: juansebastianfrasica@hotmail.com
