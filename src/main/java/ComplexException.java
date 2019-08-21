package main.java;

public class ComplexException extends Exception {

    public static final String DIVISION_POR_CERO = "Error, no es posible realizar una division por cero.";


    public ComplexException(String message) {
        super(message);
    }
}
