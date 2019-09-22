package complexLibrary.excepciones;

public class ComplexException extends Exception {

    public static final String DIVISION_POR_CERO = "Error, no es posible realizar una division por cero.";
    public static final String MATRIZ_DE_DIFERENTES_DIMENSIONES = "Para realizar la operaci√≥n, las matrices deben tener el mismo tama√±o.";
    public static final String NO_SE_PUEDEN_MULTIPLICAR = "Error, las matrices no se pueden multiplicar porque no tienen dimensiones compatibles.";
    public static final String FUERA_DE_RANGO = "Los indices de la matriz estan fuera de rango.";
    public static final String VECTOR_MATRIZ = "No se puede sumar un vector con una matriz.";
    public static final String NO_ES_VECTOR = "Error, no es un vector.";
    public static final String NO_ES_CUADRADA = "La matriz identidad debe ser cuadrada.";
    public static final String NO_ES_DETERMINISTA = "La matriz que representa la dinamica del sistema debe tener 0¥s y 1¥s.";
    public static final String DEBE_SER_VECTOR = "El estado inicial del sistema debe ser un vector.";
    public static final String NO_SE_PUDO_CALCULAR_ESTOCASTICA_ASOCIADA = "No se pudo realizar el calculo de la matriz estocastica asociada.";
    public static final String DEBE_SER_CUANTICA = "El calculo de matriz estocastica asociada solamente est· definida para matrices de dinamica cuantica";

    public ComplexException(String message) {
        super(message);
    }
}
