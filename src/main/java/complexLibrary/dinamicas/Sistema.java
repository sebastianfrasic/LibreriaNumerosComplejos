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
    private MatrizCompleja matrizDelSistema;
    
    private boolean imprimirValidez;

    public Sistema(boolean esValido, MatrizCompleja matrizPotencia, MatrizCompleja vectorEstadoFinal) {
        this.esValido = esValido;
        this.matrizPotencia = matrizPotencia;
        this.vectorEstadoFinal = vectorEstadoFinal;
        this.imprimirValidez = true;
        
    }
    
    public Sistema(MatrizCompleja matrizDelSistema, MatrizCompleja matrizPotencia, MatrizCompleja vectorEstadoFinal) {
    	this.matrizDelSistema = matrizDelSistema;
    	this.matrizPotencia = matrizPotencia;
    	this.vectorEstadoFinal = vectorEstadoFinal;
    	this.imprimirValidez = false;
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
    	String respuesta = "";
    	if (imprimirValidez) {
    		respuesta ="Dinamica del sistema:" + "\n ¿El sistema es válido? = " + esValido + "\n" + 
                    "\n Matriz elevada al número de clicks = \n" + matrizPotencia + 
                    "\n Vector de estado final = \n" + vectorEstadoFinal ; 
    	}else {
    		respuesta = "pto sebas";
    	}
        return respuesta;
    }
    
    
}
