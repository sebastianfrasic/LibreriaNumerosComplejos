package complexLibrary;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class NumerosComplejosTest {

    @Test
    public void deberianSumarseDosNumerosComplejos() {

        NumeroComplejo numero1 = new NumeroComplejo(2, 3);
        NumeroComplejo numero2 = new NumeroComplejo(3, 2);

        NumeroComplejo suma = new NumeroComplejo(5, 5);

        //System.out.println("Prueba de la suma de 2 numeros complejos: ");
        //System.out.println(numero1 + " + " + numero2 + " = "+ suma + "\n");
        assertEquals(suma, CalculadoraNumerosComplejos.sumaDeNumerosComplejos(numero1, numero2));
    }

    @Test
    public void deberianRestarseDosNumerosComplejos() {

        NumeroComplejo numero1 = new NumeroComplejo(2, 3);
        NumeroComplejo numero2 = new NumeroComplejo(3, 2);

        NumeroComplejo resta = new NumeroComplejo(-1, 1);

        //System.out.println("Prueba de la resta de 2 numeros complejos: ");
        //System.out.println(numero1 + " - " + numero2 + " = "+ resta + "\n");
        assertEquals(resta, CalculadoraNumerosComplejos.restaDeNumerosComplejos(numero1, numero2));
    }

    @Test
    public void deberianMultiplicarseDosNumerosComplejos() {

        NumeroComplejo numero1 = new NumeroComplejo(3, -2);
        NumeroComplejo numero2 = new NumeroComplejo(6, 8);

        NumeroComplejo multiplicacion = new NumeroComplejo(34, 12);

        //System.out.println("Prueba del producto de 2 numeros complejos: ");
        //System.out.println(numero1 + " * " + numero2 + " = "+ multiplicacion + "\n");
        assertEquals(multiplicacion, CalculadoraNumerosComplejos.productoDeNumerosComplejos(numero1, numero2));
    }

    @Test
    public void deberianDividirseDosNumerosComplejos() {

        NumeroComplejo numero1 = new NumeroComplejo(-3, -1);
        NumeroComplejo numero2 = new NumeroComplejo(1, -2);

        NumeroComplejo division = new NumeroComplejo((double) -1 / 5, (double) -7 / 5);

        //System.out.println("Prueba de la division de 2 numeros complejos: ");
        //System.out.println(numero1 + " / " + numero2 + " = "+ division + "\n");
        try {
            assertEquals(division, CalculadoraNumerosComplejos.divisionDeNumerosComplejos(numero1, numero2));
        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void noDeberianDividirseDosNumerosComplejos() {

        NumeroComplejo numero1 = new NumeroComplejo(-3, -1);
        NumeroComplejo numero2 = new NumeroComplejo(0, 0);

        try {
            CalculadoraNumerosComplejos.divisionDeNumerosComplejos(numero1, numero2);
        } catch (ComplexException e) {
            assertEquals(e.getMessage(), (ComplexException.DIVISION_POR_CERO));
        }

    }

    @Test
    public void deberiaCalcularElModulo() {

        NumeroComplejo numero1 = new NumeroComplejo(-3, 4);

        double respuesta = CalculadoraNumerosComplejos.modulo(numero1);

        //System.out.println("Prueba del modulo de un numero complejo: ");
        //System.out.println(CalculadoraCompleja.modulo(numero1) + "\n");
        assertEquals(5.0, respuesta, 0);

    }

    /*
	@Test
	public void deberiaCalcularElModulo2() {

		NumeroComplejo numero1 = new NumeroComplejo(-0.55, -0.02999999999999997);


		double respuesta = Math.pow(CalculadoraNumerosComplejos.modulo(numero1), 2);
		//System.out.println(respuesta);
		//System.out.println("Prueba del modulo de un numero complejo: ");
		//System.out.println(CalculadoraCompleja.modulo(numero1) + "\n");

		//assertEquals(5.0, respuesta, 0);

	}*/
    @Test
    public void deberiaCalcularElConjugado() {

        NumeroComplejo numero1 = new NumeroComplejo(4, -3);

        //System.out.println("Prueba del conjugado de un numero complejo: ");
        //System.out.println(CalculadoraCompleja.conjugado(numero1) + "\n");
        assertEquals(new NumeroComplejo(4.0, 3.0), numero1.getConjugado());

    }

    @Test
    public void deberiaCambiarDeCartesianoAPolar() {

        NumeroComplejo numero1 = new NumeroComplejo(4, -3);

        ArrayList<Integer> polar = new ArrayList<>();
        polar.add(5);
        polar.add(-37);

        //System.out.println("Prueba de pasar de cartesiano a polar: ");
        //System.out.println(numero1.cartesianoAPolar() + "\n");
        assertEquals(polar, numero1.cartesianoAPolar());

    }

    @Test
    public void deberiaCambiarDePolarACartesiano() {

        NumeroComplejo numero1 = new NumeroComplejo(78, 5, true);

        ArrayList<Integer> cartesiano = new ArrayList<>();
        cartesiano.add(78);
        cartesiano.add(7);

        //System.out.println("Prueba de pasar de polar a cartesiano: ");
        //System.out.println(numero1.polarACartesiano() + "\n");
        assertEquals(cartesiano, numero1.polarACartesiano());

    }

    @Test
    public void deberiaRetornarLaFase() {
        NumeroComplejo numero1 = new NumeroComplejo(78, 5);
        int fase = 4;

        //System.out.println("Prueba de retornar la fase de un numero complejo: ");
        //System.out.println(numero1.getFase() + "\n");
        assertEquals(fase, numero1.getFase(), 0);

    }

    @Test
    public void deberiaRetornarLaFaseEstandoEnFormaPolar() {

        NumeroComplejo numero1 = new NumeroComplejo(78, 5, true);

        int fase = 5;

        //System.out.println("Prueba de retornar la fase de un numero complejo, estando en forma polar: \n"+numero1.getFase(true) + "\n");
        assertEquals(fase, numero1.getFase(true), 0);

    }

}
