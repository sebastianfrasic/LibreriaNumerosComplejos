
package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.MatrizCompleja;


public class Cuantico extends Sistema{

    public Cuantico(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) {
        super(tipo, matrizDinamica, vectorInicial, numeroDeClicks);
    }

    public static void calcularSistema(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) throws ComplexException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
