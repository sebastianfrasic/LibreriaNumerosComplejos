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

/**
 *
 * @author 2145120
 */
public class DinamicaDeUnSistemaEnElTiempo {

    public static void main(String[] args) {
        MatrizCompleja matriz = new MatrizCompleja(13, 13);
        MatrizCompleja vectorInicial = new MatrizCompleja(13, 1);
        int clicks = 25;

        try {

            matriz.addComplex(0, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(0, 12, new NumeroComplejo(1, 0));

            matriz.addComplex(1, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 10, new NumeroComplejo(1, 0));
            matriz.addComplex(1, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(1, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(2, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(2, 11, new NumeroComplejo(1, 0));
            matriz.addComplex(2, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(3, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 2, new NumeroComplejo(1, 0));
            matriz.addComplex(3, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(3, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(4, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 3, new NumeroComplejo(1, 0));
            matriz.addComplex(4, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(4, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(5, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 6, new NumeroComplejo(1, 0));
            matriz.addComplex(5, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(5, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(6, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 5, new NumeroComplejo(1, 0));
            matriz.addComplex(6, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 9, new NumeroComplejo(1, 0));
            matriz.addComplex(6, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(6, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(7, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 4, new NumeroComplejo(1, 0));
            matriz.addComplex(7, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(7, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(8, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 1, new NumeroComplejo(1, 0));
            matriz.addComplex(8, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(8, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(9, 0, new NumeroComplejo(1, 0));
            matriz.addComplex(9, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(9, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(10, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 8, new NumeroComplejo(1, 0));
            matriz.addComplex(10, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(10, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(11, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 7, new NumeroComplejo(1, 0));
            matriz.addComplex(11, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(11, 12, new NumeroComplejo(0, 0));

            matriz.addComplex(12, 0, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 1, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 2, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 3, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 4, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 5, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 6, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 7, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 8, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 9, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 10, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 11, new NumeroComplejo(0, 0));
            matriz.addComplex(12, 12, new NumeroComplejo(0, 0));

            //Vector inicial
            vectorInicial.addComplex(0, 0, new NumeroComplejo(10, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(4, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(1, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(7, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(2, 0));
            vectorInicial.addComplex(6, 0, new NumeroComplejo(11, 0));
            vectorInicial.addComplex(7, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(8, 0, new NumeroComplejo(3, 0));
            vectorInicial.addComplex(9, 0, new NumeroComplejo(1, 0));
            vectorInicial.addComplex(10, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(11, 0, new NumeroComplejo(5, 0));
            vectorInicial.addComplex(12, 0, new NumeroComplejo(2, 0));

            System.out.println(CalculadoraDinamica.calcularDinamica(TipoSistema.CLASICO, matriz, vectorInicial, clicks));
            new Grafico(CalculadoraDinamica.calcularDinamica(TipoSistema.CLASICO, matriz, vectorInicial, clicks).getVectorEstadoFinal()).setVisible(true);
        } catch (ComplexException ex) {
            ex.printStackTrace();
        }
    }

}
