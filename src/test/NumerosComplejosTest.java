package test;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import src.*;
import org.junit.jupiter.api.Test;

class NumerosComplejosTest {
	
	CalculadoraCompleja calculadora = CalculadoraCompleja.getCalculadoraCompleja();
	

	@Test
	public void deberianSumarseDosNumerosComplejos() {
		
		NumeroComplejo numero1 = new NumeroComplejo(2, 3);
		NumeroComplejo numero2 = new NumeroComplejo(3, 2);
		
		NumeroComplejo suma = new NumeroComplejo(5, 5);
		
		System.out.println("Prueba de la suma de 2 numeros complejos: ");
		System.out.println(numero1 + " + " + numero2 + " = "+ suma + "\n");
		assertEquals(suma, calculadora.sumaDeNumerosComplejos(numero1, numero2));
		

	}
	
	
	@Test
	public void deberianRestarseDosNumerosComplejos() {
		
		NumeroComplejo numero1 = new NumeroComplejo(2, 3);
		NumeroComplejo numero2 = new NumeroComplejo(3, 2);
		
		NumeroComplejo resta = new NumeroComplejo(-1, 1);
		
		
		System.out.println("Prueba de la resta de 2 numeros complejos: ");
		System.out.println(numero1 + " - " + numero2 + " = "+ resta + "\n");
		
		assertEquals(resta, calculadora.restaDeNumerosComplejos(numero1, numero2));
	}
	
	
	@Test
	public void deberianMultiplicarseDosNumerosComplejos() {
		
		NumeroComplejo numero1 = new NumeroComplejo(3, -2);
		NumeroComplejo numero2 = new NumeroComplejo(6, 8);
		
		NumeroComplejo multiplicacion = new NumeroComplejo(34, 12);
		
		System.out.println("Prueba del producto de 2 numeros complejos: ");
		System.out.println(numero1 + " * " + numero2 + " = "+ multiplicacion + "\n");
		
		assertEquals(multiplicacion, calculadora.productoDeNumerosComplejos(numero1, numero2));
	}
	

	@Test
	public void deberianDividirseDosNumerosComplejos() {
		
		NumeroComplejo numero1 = new NumeroComplejo(-3, -1);
		NumeroComplejo numero2 = new NumeroComplejo(1, -2);
		
		NumeroComplejo division = new NumeroComplejo((double) -1/5, (double)-7/5);
		
		System.out.println("Prueba de la division de 2 numeros complejos: ");
		System.out.println(numero1 + " / " + numero2 + " = "+ division + "\n");
		
		assertEquals(division, calculadora.divisionDeNumerosComplejos(numero1, numero2));
		
	}

	@Test
	public void deberiaCalcularElModulo() {
		
		NumeroComplejo numero1 = new NumeroComplejo(-3, 4);
		
		System.out.println("Prueba del modulo de un numero complejo: ");
		System.out.println(calculadora.modulo(numero1) + "\n");
		
		assertEquals(5.0, calculadora.modulo(numero1));
		
	}
	
	@Test
	public void deberiaCalcularElConjugado() {
	
		NumeroComplejo numero1 = new NumeroComplejo(4,-3);  
		
		System.out.println("Prueba del conjugado de un numero complejo: ");
		System.out.println(calculadora.conjugado(numero1) + "\n");
		
        assertEquals(new NumeroComplejo(4.0, -3.0), numero1.getConjugado()); 
	
	}
	
	@Test
	public void deberiaCambiarDeCartesianoAPolar() {
	
		NumeroComplejo numero1 = new NumeroComplejo(4,-3);  
		
		
		
		ArrayList<Double> polar = new ArrayList<Double>();
	    polar.add(5.0);
	    polar.add(-0.6435011087932844);
	    
	    
	    System.out.println("Prueba de pasar de cartesiano a polar un numero complejo: ");
		System.out.println(polar + "\n");
	    
	    assertEquals(polar, numero1.cartesianoAPolar());
		
	
	}
	
}
