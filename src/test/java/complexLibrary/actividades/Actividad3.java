package complexLibrary.actividades;

import org.junit.Test;

import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import cuantica.CalculadoraCuantica;

public class Actividad3 {

    /*
    @Test
    public void primeraParte() {        
        MatrizCompleja psi = new MatrizCompleja(10, 1);
        MatrizCompleja phi = new MatrizCompleja(10, 1);
        

        try {
            psi.addComplex(0, 0, new NumeroComplejo(2, 1));
            psi.addComplex(1, 0, new NumeroComplejo(-1, 2));
            psi.addComplex(2, 0, new NumeroComplejo(0, 1));
            psi.addComplex(3, 0, new NumeroComplejo(1, 0));
            psi.addComplex(4, 0, new NumeroComplejo(3, -1));
            psi.addComplex(5, 0, new NumeroComplejo(2, 0));
            psi.addComplex(6, 0, new NumeroComplejo(0, -2));
            psi.addComplex(7, 0, new NumeroComplejo(-2, 1));
            psi.addComplex(8, 0, new NumeroComplejo(1, -3));
            psi.addComplex(9, 0, new NumeroComplejo(0, -1));
            
            
            phi.addComplex(0, 0, new NumeroComplejo(-1, -4));
            phi.addComplex(1, 0, new NumeroComplejo(2, -3));
            phi.addComplex(2, 0, new NumeroComplejo(-7, 6));
            phi.addComplex(3, 0, new NumeroComplejo(-1, 1));
            phi.addComplex(4, 0, new NumeroComplejo(-5, -3));
            phi.addComplex(5, 0, new NumeroComplejo(5, 0));
            phi.addComplex(6, 0, new NumeroComplejo(5, 8));
            phi.addComplex(7, 0, new NumeroComplejo(4, -4));
            phi.addComplex(8, 0, new NumeroComplejo(8, -7));
            phi.addComplex(9, 0, new NumeroComplejo(2, -7));
            
            //System.out.println(CalculadoraCuantica.calcularProbabilidad(psi));
            //System.out.println(CalculadoraCuantica.calcularProbabilidad(psi).sumarElementosDeLaMatriz());
            System.out.println(CalculadoraCuantica.calcularAmplitudDeTransicion(psi, phi));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void punto5() {
        MatrizCompleja psi = new MatrizCompleja(10, 1);
        MatrizCompleja phi = new MatrizCompleja(10, 1);
        

        try {
            psi.addComplex(0, 0, new NumeroComplejo(1, 0));
            psi.addComplex(1, 0, new NumeroComplejo(0, 0));
            psi.addComplex(2, 0, new NumeroComplejo(0, 0));
            psi.addComplex(3, 0, new NumeroComplejo(0, 0));
            psi.addComplex(4, 0, new NumeroComplejo(0, 0));
            psi.addComplex(5, 0, new NumeroComplejo(0, 0));
            psi.addComplex(6, 0, new NumeroComplejo(0, 0));
            psi.addComplex(7, 0, new NumeroComplejo(0, 0));
            psi.addComplex(8, 0, new NumeroComplejo(0, 0));
            psi.addComplex(9, 0, new NumeroComplejo(0, 0));
            
            
            phi.addComplex(0, 0, new NumeroComplejo(0, 0));
            phi.addComplex(1, 0, new NumeroComplejo(1, 0));
            phi.addComplex(2, 0, new NumeroComplejo(0, 0));
            phi.addComplex(3, 0, new NumeroComplejo(0, 0));
            phi.addComplex(4, 0, new NumeroComplejo(0, 0));
            phi.addComplex(5, 0, new NumeroComplejo(0, 0));
            phi.addComplex(6, 0, new NumeroComplejo(0, 0));
            phi.addComplex(7, 0, new NumeroComplejo(0, 0));
            phi.addComplex(8, 0, new NumeroComplejo(0, 0));
            phi.addComplex(9, 0, new NumeroComplejo(0, 0));
            
            //System.out.println(CalculadoraCuantica.calcularProbabilidad(psi));
            //System.out.println(CalculadoraCuantica.calcularProbabilidad(psi).sumarElementosDeLaMatriz());
            System.out.println(CalculadoraCuantica.calcularAmplitudDeTransicion(phi, psi));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void ejercicio2() {
        MatrizCompleja psi = new MatrizCompleja(2, 1);
        MatrizCompleja omega = new MatrizCompleja(2, 2);

        try {
            psi.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            psi.addComplex(1, 0, new NumeroComplejo(0, 1 / (Math.sqrt(2))));

            omega.addComplex(0, 0, new NumeroComplejo(2, 0));
            omega.addComplex(0, 1, new NumeroComplejo(1, 1));
            omega.addComplex(1, 0, new NumeroComplejo(1, -1));
            omega.addComplex(1, 1, new NumeroComplejo(3, 0));


            System.out.println("Valor esperado: " + CalculadoraCuantica.calcularValorEsperado(omega, psi));
            System.out.println("Operador delta: \n" + CalculadoraCuantica.calcularOperadorDelta(omega, psi));
            System.out.println("Varianza: " + CalculadoraCuantica.calcularVarianza(omega, psi));
            System.out.println("Desviación estándar: " + CalculadoraCuantica.calcularDesviacionEstandar(omega, psi));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
