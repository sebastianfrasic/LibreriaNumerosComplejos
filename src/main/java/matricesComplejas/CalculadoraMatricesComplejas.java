package main.java.matricesComplejas;

import main.java.numerosComplejos.CalculadoraNumerosComplejos;

public class CalculadoraMatricesComplejas {
	
	private static CalculadoraMatricesComplejas calculadora = null;
	
	private CalculadoraMatricesComplejas() {
		
	}
	
	
	/**
	 * 
	 * @return Una unica instancia de la calculadora de matrices complejas
	 */
	public static CalculadoraMatricesComplejas getCalculadoraCompleja() {
		
		if(calculadora == null) {
			calculadora = new CalculadoraMatricesComplejas();
		}
		
		return calculadora;
	}

}
