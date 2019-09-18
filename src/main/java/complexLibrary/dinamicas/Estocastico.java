
package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;


public class Estocastico extends Sistema {

    public Estocastico(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) {
        super(tipo, matrizDinamica, vectorInicial, numeroDeClicks);
    }

    public static void calcularSistema(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) throws ComplexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  
}
