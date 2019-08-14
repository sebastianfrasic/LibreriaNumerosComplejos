package test;


import static org.junit.jupiter.api.Assertions.*;
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
		
		
	}

}
