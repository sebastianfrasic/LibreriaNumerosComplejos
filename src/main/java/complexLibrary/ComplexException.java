package complexLibrary;

public class ComplexException extends Exception {

    public static final String DIVISION_POR_CERO = "Error, no es posible realizar una division por cero.";
    public static final String MATRIZ_DE_DIFERENTES_DIMENSIONES = "Para realizar la operación, las matrices deben tener el mismo tamaño.";
    public static final String NO_SE_PUEDEN_MULTIPLICAR = "Error, las matrices no se pueden multiplicar.";
    public static String FUERA_DE_RANGO = "Los indices de la matriz estan fuera de rango.";


    public ComplexException(String message) {
        super(message);
    }
}
