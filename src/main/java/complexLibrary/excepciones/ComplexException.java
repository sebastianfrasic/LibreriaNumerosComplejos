package complexLibrary.excepciones;

public class ComplexException extends Exception {

    public static final String DIVISION_POR_CERO = "Error, no es posible realizar una division por cero.";
    public static final String MATRIZ_DE_DIFERENTES_DIMENSIONES = "Para realizar la operacion, las matrices deben tener el mismo tamaño.";
    public static final String NO_SE_PUEDEN_MULTIPLICAR = "Error, las matrices no se pueden multiplicar porque no tienen dimensiones compatibles.";
    public static final String FUERA_DE_RANGO = "Los indices de la matriz estan fuera de rango.";
    public static final String VECTOR_MATRIZ = "No se puede sumar un vector con una matriz.";
    public static final String NO_ES_VECTOR = "Error, no es un vector.";
    public static final String NO_ES_CUADRADA = "La matriz identidad debe ser cuadrada.";
    public static final String NO_ES_DETERMINISTA = "La matriz que representa la dinamica del sistema debe tener 0´s y 1´s.";
    public static final String DEBE_SER_VECTOR = "El estado inicial del sistema debe ser un vector.";
    public static final String NO_SE_PUDO_CALCULAR_ESTOCASTICA_ASOCIADA = "No se pudo realizar el calculo de la matriz estocastica asociada. La suma por filas y columnas debe dar 1.";
    public static final String DEBE_SER_CUANTICA = "El calculo de matriz estocastica asociada solamente está definida para matrices de dinamica cuantica";
    public static final String TIPO_INVALIDO = "El tipo de sistema ingresado es incorrecto, por favor verifique.";
    public static final String NO_SE_PUDO_CALCULAR = "No se pudo realizar el calculo del vector final.";
    public static final String VP_INVALIDO = "El vector de probabilidades que ingresó es inválido";
    public static final String NO_ES_HERMITIANA = "La matriz observable Omega no es hermitiana";

    public ComplexException(String message) {
        super(message);
    }
}
