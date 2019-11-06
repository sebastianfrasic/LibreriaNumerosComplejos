/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexLibrary.version3;

import complexLibrary.dinamicas.CalculadoraDinamica;
import complexLibrary.dinamicas.Grafico;
import complexLibrary.dinamicas.TipoSistema;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author 2145120
 */
class SistemasEnsamblados {

    public static void main(String[] args) {

        try {
            MatrizCompleja MA = new MatrizCompleja(4, 4);
            MatrizCompleja MB = new MatrizCompleja(3, 3);
            MatrizCompleja VA = new MatrizCompleja(4, 1);
            MatrizCompleja VB = new MatrizCompleja(3, 1);
            int clicks = 5;

            MA.addComplex(0, 0, new NumeroComplejo(0, 0));
            MA.addComplex(0, 1, new NumeroComplejo(0.2, 0));
            MA.addComplex(0, 2, new NumeroComplejo(0.3, 0));
            MA.addComplex(0, 3, new NumeroComplejo(0.5, 0));

            MA.addComplex(1, 0, new NumeroComplejo(0.3, 0));
            MA.addComplex(1, 1, new NumeroComplejo(0.2, 0));
            MA.addComplex(1, 2, new NumeroComplejo(0.1, 0));
            MA.addComplex(1, 3, new NumeroComplejo(0.4, 0));

            MA.addComplex(2, 0, new NumeroComplejo(0.4, 0));
            MA.addComplex(2, 1, new NumeroComplejo(0.3, 0));
            MA.addComplex(2, 2, new NumeroComplejo(0.2, 0));
            MA.addComplex(2, 3, new NumeroComplejo(0.1, 0));

            MA.addComplex(3, 0, new NumeroComplejo(0.3, 0));
            MA.addComplex(3, 1, new NumeroComplejo(0.3, 0));
            MA.addComplex(3, 2, new NumeroComplejo(0.4, 0));
            MA.addComplex(3, 3, new NumeroComplejo(0, 0));


            MB.addComplex(0, 0, new NumeroComplejo(0, 0));
            MB.addComplex(0, 1, new NumeroComplejo((double) 1 / 6, 0));
            MB.addComplex(0, 2, new NumeroComplejo((double) 5 / 6, 0));

            MB.addComplex(1, 0, new NumeroComplejo((double) 1 / 3, 0));
            MB.addComplex(1, 1, new NumeroComplejo((double) 1 / 2, 0));
            MB.addComplex(1, 2, new NumeroComplejo((double) 1 / 6, 0));

            MB.addComplex(2, 0, new NumeroComplejo((double) 2 / 3, 0));
            MB.addComplex(2, 1, new NumeroComplejo((double) 1 / 3, 0));
            MB.addComplex(2, 2, new NumeroComplejo(0, 0));


            VA.addComplex(0, 0, new NumeroComplejo(0.2, 0));
            VA.addComplex(1, 0, new NumeroComplejo(0.1, 0));
            VA.addComplex(2, 0, new NumeroComplejo(0.6, 0));
            VA.addComplex(3, 0, new NumeroComplejo(0.1, 0));

            VB.addComplex(0, 0, new NumeroComplejo(0.7, 0));
            VB.addComplex(1, 0, new NumeroComplejo(0.15, 0));
            VB.addComplex(2, 0, new NumeroComplejo(0.15, 0));

            MatrizCompleja vectorFinal = CalculadoraDinamica.calcularDinamicaConEnsamble(TipoSistema.ESTOCASTICO, MA, VA, MB, VB, clicks);
            new Grafico(vectorFinal).setVisible(true);
            System.out.println(vectorFinal);

        } catch (ComplexException ex) {
            Logger.getLogger(SistemasEnsamblados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
