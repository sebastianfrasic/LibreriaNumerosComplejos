package complexLibrary.version4;

import complexLibrary.cuantica.CalculadoraCuantica;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeoriaCuanticaBasicaTest {

    //Pruebas Minimas
    @Test
    public void particulaEnUnaRecta() {
        MatrizCompleja psi = new MatrizCompleja(10, 1);
        MatrizCompleja respuestaEsperada = new MatrizCompleja(10, 1);

        try {
            respuestaEsperada.addComplex(0, 0, new NumeroComplejo(0.0249, 0));
            respuestaEsperada.addComplex(1, 0, new NumeroComplejo(0.0452, 0));
            respuestaEsperada.addComplex(2, 0, new NumeroComplejo(0.1878, 0));
            respuestaEsperada.addComplex(3, 0, new NumeroComplejo(0.2587, 0));
            respuestaEsperada.addComplex(4, 0, new NumeroComplejo(0.0964, 0));
            respuestaEsperada.addComplex(5, 0, new NumeroComplejo(0, 0));
            respuestaEsperada.addComplex(6, 0, new NumeroComplejo(0.0964, 0));
            respuestaEsperada.addComplex(7, 0, new NumeroComplejo(0.2587, 0));
            respuestaEsperada.addComplex(8, 0, new NumeroComplejo(0.0329, 0));
            respuestaEsperada.addComplex(9, 0, new NumeroComplejo(0.01, 0));


            psi.addComplex(0, 0, new NumeroComplejo(2, -1));
            psi.addComplex(1, 0, new NumeroComplejo(-1.5, 2.5));
            psi.addComplex(2, 0, new NumeroComplejo(-3.5, 5));
            psi.addComplex(3, 0, new NumeroComplejo(-4, 6));
            psi.addComplex(4, 0, new NumeroComplejo(-3.5, 2.5));
            psi.addComplex(5, 0, new NumeroComplejo(0, 0));
            psi.addComplex(6, 0, new NumeroComplejo(-3.5, 2.5));
            psi.addComplex(7, 0, new NumeroComplejo(6, -4));
            psi.addComplex(8, 0, new NumeroComplejo(0, 2.5));
            psi.addComplex(9, 0, new NumeroComplejo(-1, 1));

            MatrizCompleja respuesta = CalculadoraCuantica.calcularProbabilidad(10, psi);
            respuesta = CalculadoraMatricesComplejas.redondearAXDecimalesUnaMatriz(respuesta,4);

            assertEquals(respuestaEsperada, respuesta);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void calculadoraEstadisticaParaObservables() {
        MatrizCompleja psi = new MatrizCompleja(4, 1);
        MatrizCompleja omega = new MatrizCompleja(4, 4);
        double valorEsperado = 1.9;
        double varianza = 13.0;


        try {
            psi.addComplex(0, 0, new NumeroComplejo(-2, 1));
            psi.addComplex(1, 0, new NumeroComplejo(1, 0));
            psi.addComplex(2, 0, new NumeroComplejo(0, -1));
            psi.addComplex(3, 0, new NumeroComplejo(3, 2));

            omega.addComplex(0, 0, new NumeroComplejo(0, 0));
            omega.addComplex(0, 1, new NumeroComplejo(0, -0.5));
            omega.addComplex(0, 2, new NumeroComplejo(0, -1));
            omega.addComplex(0, 3, new NumeroComplejo((double)-7/2, 0));
            omega.addComplex(1, 0, new NumeroComplejo(0, (double)1/2));
            omega.addComplex(1, 1, new NumeroComplejo(0, 0));
            omega.addComplex(1, 2, new NumeroComplejo((double)7/2, 0));
            omega.addComplex(1, 3, new NumeroComplejo(0, -1));
            omega.addComplex(2, 0, new NumeroComplejo(0, 1));
            omega.addComplex(2, 1, new NumeroComplejo((double)7/2, 0));
            omega.addComplex(2, 2, new NumeroComplejo(0, 0));
            omega.addComplex(2, 3, new NumeroComplejo(0, (double)-1/2));
            omega.addComplex(3, 0, new NumeroComplejo((double)-7/2, 0));
            omega.addComplex(3, 1, new NumeroComplejo(0, 1));
            omega.addComplex(3, 2, new NumeroComplejo(0, (double)1/2));
            omega.addComplex(3, 3, new NumeroComplejo(0, 0));

            NumeroComplejo respuestaValorEsperado = CalculadoraCuantica.calcularValorEsperado(omega, psi);
            NumeroComplejo respuestVarianza = CalculadoraCuantica.calcularVarianza(omega, psi);
            //System.out.println("Valor esperado: " + respuestaValorEsperado);
            //System.out.println("Varianza: " + respuestVarianza);

            double rtaValorEsperado = CalculadoraNumerosComplejos.redondearAXDecimalesUnaNumeroComplejo(respuestaValorEsperado, 2).getParteReal();
            double rtaVarianza = CalculadoraNumerosComplejos.redondearAXDecimalesUnaNumeroComplejo(respuestVarianza, 0).getParteReal();


            assertEquals(valorEsperado, rtaValorEsperado, 0);
            assertEquals(varianza, rtaVarianza, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
