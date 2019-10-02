package complexLibrary;

import org.junit.Test;

import complexLibrary.dinamicas.CalculadoraDinamica;
import complexLibrary.dinamicas.TipoSistema;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class Quiz5 {

    @Test
    public void punto3() {
        MatrizCompleja A = new MatrizCompleja(3, 3);
        MatrizCompleja V = new MatrizCompleja(3, 1);

        try {
            A.addComplex(0, 0, new NumeroComplejo(0, 0));
            A.addComplex(0, 1, new NumeroComplejo((double) 1 / 6, 0));
            A.addComplex(0, 2, new NumeroComplejo((double) 5 / 6, 0));
            A.addComplex(1, 0, new NumeroComplejo((double) 1 / 3, 0));
            A.addComplex(1, 1, new NumeroComplejo((double) 1 / 2, 0));
            A.addComplex(1, 2, new NumeroComplejo((double) 1 / 6, 0));
            A.addComplex(2, 0, new NumeroComplejo((double) 2 / 3, 0));
            A.addComplex(2, 1, new NumeroComplejo((double) 1 / 3, 0));
            A.addComplex(2, 2, new NumeroComplejo(0, 0));

            V.addComplex(0, 0, new NumeroComplejo((double) 1 / 5, 0));
            V.addComplex(1, 0, new NumeroComplejo((double) 7 / 10, 0));
            V.addComplex(2, 0, new NumeroComplejo((double) 1 / 10, 0));

            System.out.println(CalculadoraDinamica.calcularDinamica(TipoSistema.ESTOCASTICO, A, V, 4).getVectorEstadoFinal());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void punto4() {
        MatrizCompleja A = new MatrizCompleja(2, 2);
        MatrizCompleja V = new MatrizCompleja(2, 1);

        try {
            A.addComplex(0, 0, new NumeroComplejo((double) 1 / Math.sqrt(2), 0));
            A.addComplex(0, 1, new NumeroComplejo(0, (double) 1 / Math.sqrt(2)));

            A.addComplex(1, 0, new NumeroComplejo((double) 1 / Math.sqrt(2), 0));
            A.addComplex(1, 1, new NumeroComplejo(0, (double) -1 / Math.sqrt(2)));

            V.addComplex(0, 0, new NumeroComplejo((double) 1, 0));
            V.addComplex(1, 0, new NumeroComplejo((double) 0, 0));

            System.out.println(CalculadoraDinamica.calcularDinamica(TipoSistema.CUANTICO, A, V, 1).getVectorEstadoFinal());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
