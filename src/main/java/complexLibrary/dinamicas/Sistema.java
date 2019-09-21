package complexLibrary.dinamicas;

import complexLibrary.matricesComplejas.MatrizCompleja;

/**
 *
 * @author juans
 */
public class Sistema {
    
    private boolean esValido;    
    private MatrizCompleja matrizPotencia;
    private MatrizCompleja vectorEstadoFinal;

    public Sistema(boolean esValido, MatrizCompleja matrizPotencia, MatrizCompleja vectorEstadoFinal) {
        this.esValido = esValido;
        this.matrizPotencia = matrizPotencia;
        this.vectorEstadoFinal = vectorEstadoFinal;
    }
    

    public boolean isEsValido() {
        return esValido;
    }

    public void setEsValido(boolean esValido) {
        this.esValido = esValido;
    }

    public MatrizCompleja getMatrizPotencia() {
        return matrizPotencia;
    }

    public void setMatrizPotencia(MatrizCompleja matrizPotencia) {
        this.matrizPotencia = matrizPotencia;
    }

    public MatrizCompleja getVectorEstadoFinal() {
        return vectorEstadoFinal;
    }

    public void setVectorEstadoFinal(MatrizCompleja vectorEstadoFinal) {
        this.vectorEstadoFinal = vectorEstadoFinal;
    }

    @Override
    public String toString() {
        return "Sistema {" + "\n ¿El sistema es válido? = " + esValido + 
                ",\n Matriz elevada al número de clicks = \n" + matrizPotencia + 
                ",\n Vector de estado final = \n" + vectorEstadoFinal + '}';
    }
    
    
}
