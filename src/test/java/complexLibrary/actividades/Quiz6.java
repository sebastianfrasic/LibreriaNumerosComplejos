package complexLibrary.actividades;

import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import cuantica.CalculadoraCuantica;
import org.junit.Test;

public class Quiz6 {


    @Test
    public void pregunta3y4() {
        MatrizCompleja psi = new MatrizCompleja(2, 1);
        MatrizCompleja omega = new MatrizCompleja(2, 2);

        try {
            psi.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            psi.addComplex(1, 0, new NumeroComplejo(0, 1 / (Math.sqrt(2))));

            omega.addComplex(0, 0, new NumeroComplejo(0, 0));
            omega.addComplex(0, 1, new NumeroComplejo(0, -1));
            omega.addComplex(1, 0, new NumeroComplejo(0, 1));
            omega.addComplex(1, 1, new NumeroComplejo(0, 0));


            System.out.println("Valor esperado: " + CalculadoraCuantica.calcularValorEsperado(omega, psi));
            System.out.println("Operador delta: \n" + CalculadoraCuantica.calcularOperadorDelta(omega, psi));
            System.out.println("Varianza: " + CalculadoraCuantica.calcularVarianza(omega, psi));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
