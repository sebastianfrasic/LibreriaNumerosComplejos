package complexLibrary;

public class ComplexException extends Exception {

    public static final String DIVISION_POR_CERO = "Error, no es posible realizar una division por cero.";
    public static final String MATRIZ_DE_DIFERENTES_DIMENSIONES = "Para realizar la operación, las matrices deben tener el mismo tamaño.";
    public static final String NO_SE_PUEDEN_MULTIPLICAR = "Error, las matrices no se pueden multiplicar porque no tienen dimensiones compatibles.";
    public static String FUERA_DE_RANGO = "Los indices de la matriz estan fuera de rango.";
    public static String VECTOR_MATRIZ = "No se puede sumar un vector con una matriz.";
    public static String NO_ES_VECTOR = "Error, no es un vector.";
    public static String NO_ES_CUADRADA = "La matriz identidad debe ser cuadrada.";


    public ComplexException(String message) {
        super(message);
    }
}
