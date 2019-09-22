# Librería de números complejos

Este repositorio es una librería de números complejos desarrollada en  **Java**, por **Juan Sebastián Frásica Galeano** para la materia Ciencias Naturales Y Tecnología **(CNYT)**. Es una librería que simula algunos comportamientos de la computación cuántica.


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

### Versión N° 3: Simulador de sistemas determinísticos, estocásticos y cuánticos  

##  ¿Cómo usar la librería?

### Pasos de descarga y uso de pruebas

Clona el repositorio con la siguiente dirección en el terminal (cmd) usando el comando:
``` git clone https://github.com/sebastianfrasic/LibreriaNumerosComplejos.git ```

Luego, se debe abrir la carpeta clonada con algun IDE de Java, como **Eclipse**, **NetBeans** o **Intellij IDEA**. (Recomiendo Eclipse).

Para ejecutar la librería se deben ejecutar los tests, los cuales son pruebas unitarias de cada una de las funcionalidades de la librería.
Dichos tests, están en el paquete __**src\test\java\complexLibrary**__

Hay 3 archivos de pruebas por cada versión del proyecto:

*   NumerosComplejosTest.java
*   MatricesComplejasTest.java
*   SistemasDinamicosTest.java

En la clase MatricesComplejasTest están las ![pruebas mínimas](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/CNYT_Pruebas_Proyecto_2.pdf) requeridas por el docente, y posteriormente hay algunas pruebas adicionales.  

Se pueden ejecutar desde algún IDE de Java, o desde Maven mediante el comando:

``` mvn test ```

#### Ejemplo de ejecución correcta de pruebas

##### Mediante Eclipse  
![prueba1](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/ejecucion.png)  
![prueba2](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/ejecucion2.png)  

##### Mediante Maven
![prueba3](https://github.com/sebastianfrasic/LibreriaNumerosComplejos/blob/master/Recursos/pruebas.PNG)


#### Desarrollado con

*   [Java](https://www.oracle.com/technetwork/es/java/javase/downloads/index.html) - Lenguaje de programación.
*   [Maven](https://maven.apache.org/) - Gestor de dependencias.


## Calidad del código  
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2de9d2b7c70c4ccbbaa5a70a3286faab)](https://www.codacy.com/manual/sebastianfrasic/LibreriaNumerosComplejos?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=sebastianfrasic/LibreriaNumerosComplejos&amp;utm_campaign=Badge_Grade)


## Recomendaciones

*   Para usar los comandos con __mvn__ recuerda haber instalado Maven previamente.
*   Recuerda leer la documentación de los métodos.
*   Ante cualquier inquietud, puedes escribirme a mi correo electrónico: juansebastianfrasica@hotmail.com
