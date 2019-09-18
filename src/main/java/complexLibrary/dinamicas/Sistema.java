
package complexLibrary.dinamicas;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;

public class Sistema {
    protected TipoSistema tipo;
    protected MatrizCompleja matrizDinamica;
    protected MatrizCompleja vectorInicial;
    protected MatrizCompleja vectorFinal;
    protected MatrizCompleja matrizPotencia;
    protected int numeroDeClicks;

    public Sistema(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) {
        this.tipo = tipo;
        this.matrizDinamica = matrizDinamica;
        this.vectorInicial = vectorInicial;
        this.numeroDeClicks = numeroDeClicks;
    }

    public TipoSistema getTipo() {
        return tipo;
    }

    public void setTipo(TipoSistema tipo) {
        this.tipo = tipo;
    }

    public MatrizCompleja getMatrizDinamica() {
        return matrizDinamica;
    }

    public void setMatrizDinamica(MatrizCompleja matrizDinamica) {
        this.matrizDinamica = matrizDinamica;
    }

    public MatrizCompleja getVectorInicial() {
        return vectorInicial;
    }

    public void setVectorInicial(MatrizCompleja vectorInicial) {
        this.vectorInicial = vectorInicial;
    }

    public MatrizCompleja getVectorFinal() {
        return vectorFinal;
    }

    public void setVectorFinal(MatrizCompleja vectorFinal) {
        this.vectorFinal = vectorFinal;
    }

    public int getNumeroDeClicks() {
        return numeroDeClicks;
    }

    public void setNumeroDeClicks(int numeroDeClicks) {
        this.numeroDeClicks = numeroDeClicks;
    }
            
    
    public static void calcularSistema(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) throws ComplexException{
        
    }
    

    @Override
    public String toString() {
        return "Sistema{" + "tipo=" + tipo + ", matrizDinamica=" + matrizDinamica + ", vectorInicial=" + vectorInicial + ", vectorFinal=" + vectorFinal + ", numeroDeClicks=" + numeroDeClicks + '}';
    }
    
    
    
    
}
