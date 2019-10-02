/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexLibrary.version3;

import complexLibrary.dinamicas.CalculadoraDinamica;
import complexLibrary.dinamicas.Grafico;
import complexLibrary.dinamicas.Rendija;
import complexLibrary.dinamicas.Sistema;
import complexLibrary.dinamicas.TipoSistema;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

/**
 *
 * @author 2145120
 */
public class ExperimentoRendijas {
    
    public static void main(String[] args) {
        int numeroRendijas = 2;
        int numeroBlancosPared = 5;
        MatrizCompleja vectorDeAmplitudes = new MatrizCompleja(11, 1);
        try {
            double r = 1/(Math.sqrt(22));
            
            vectorDeAmplitudes.addComplex(0, 0, new NumeroComplejo(r, r));
            vectorDeAmplitudes.addComplex(1, 0, new NumeroComplejo(-r, -r));
            vectorDeAmplitudes.addComplex(2, 0, new NumeroComplejo(-r, r));
            vectorDeAmplitudes.addComplex(3, 0, new NumeroComplejo(-r, -r));
            vectorDeAmplitudes.addComplex(4, 0, new NumeroComplejo(r, -r));
            vectorDeAmplitudes.addComplex(5, 0, new NumeroComplejo(-r, -r));
            vectorDeAmplitudes.addComplex(6, 0, new NumeroComplejo(-r, -r));
            vectorDeAmplitudes.addComplex(7, 0, new NumeroComplejo(-r, -r));
            vectorDeAmplitudes.addComplex(8, 0, new NumeroComplejo(r, -r));
            vectorDeAmplitudes.addComplex(9, 0, new NumeroComplejo(r, -r));
            vectorDeAmplitudes.addComplex(10, 0, new NumeroComplejo(-r, r));
            
            Sistema s = Rendija.calcularExperimentoDeRendijas(TipoSistema.CUANTICO, numeroRendijas, numeroBlancosPared, vectorDeAmplitudes);
            MatrizCompleja vectorFinal = s.getVectorEstadoFinal();
            System.out.println(vectorFinal);
            new Grafico(vectorFinal).setVisible(true);           
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
