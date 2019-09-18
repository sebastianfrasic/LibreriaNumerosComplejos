package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;


public class Clasico extends Sistema{

    public Clasico(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) {
        super(tipo, matrizDinamica, vectorInicial, numeroDeClicks);
    }

    
    /**
     * Resuelve un sistema con dinamica determinista
     * @param dinamica Una matriz de 0's y 1's que represente la din�mica de un sistema cl�sico.
     * @param estadoInicial Un vector que corresponde al estado inicial del sistema.
     * @param numeroDeClicks Un n�mero entero no negativo t que representa el n�mero de clicks de tiempo que se quieren considerar.
     * @return Un vector correspondiente al estado final del sistema despu�s de t clicks.
     * @throws ComplexException Si la matriz ingresada no cumple con las caracter�sticas de una matriz correspondiente a la din�mica de un sistema determinista.
     */
    public static MatrizCompleja determinista(MatrizCompleja dinamica, MatrizCompleja estadoInicial, int numeroDeClicks) throws ComplexException {
        if(!estadoInicial.isVector()) {
            throw new ComplexException(ComplexException.DEBE_SER_VECTOR);
        }
        /*
        NumeroComplejo zero = new NumeroComplejo(0, 0);
        NumeroComplejo uno = new NumeroComplejo(1, 0);
        
        for(int i = 0; i < dinamica.getM(); i++) {
            for(int j = 0; j < dinamica.getN(); j++) {
                if((!dinamica.getMatriz()[i][j].equals(zero)) || (!dinamica.getMatriz()[i][j].equals(uno))){
                    throw new ComplexException(ComplexException.NO_ES_DETERMINISTA);
                }                
            }
        }*/

        for (int i = 0; i < numeroDeClicks; i++) {				
            estadoInicial = CalculadoraMatricesComplejas.productoDeMatrices(dinamica, estadoInicial);
        }
        System.out.println("Entra al metodo determinista()");
        return estadoInicial;
        
    }
    
    
    /**
     * 
     * @param m1 
     * @param m2 
     * @param estadoInicial Vectores que corresponden al estado inicial de los sistemas constituyentes.
     * @param numeroDeClicks Un n�mero entero no negativo t que representa el n�mero de clicks de tiempo que se quieren considerar.
     * @return Un vector correspondiente al estado final del sistema ensamblado despu�s de t clicks.
     * @throws ComplexException Si el estado inicial no es un vector
     */
    public static MatrizCompleja deterministaConEnsamble(MatrizCompleja m1, MatrizCompleja m2, MatrizCompleja estadoInicial, int numeroDeClicks) throws ComplexException {

        if(!estadoInicial.isVector()) {
            throw new ComplexException(ComplexException.DEBE_SER_VECTOR);
        }else {
            MatrizCompleja ensamble = CalculadoraMatricesComplejas.productoTensor(m1, m2);

            for (int i = 0; i < numeroDeClicks; i++) {				
                estadoInicial = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(ensamble, estadoInicial);
            }
        }
        return estadoInicial;

    }      

    public static void calcularSistema(TipoSistema tipo, MatrizCompleja matrizDinamica, MatrizCompleja vectorInicial, int numeroDeClicks) throws ComplexException {
        //validarQueSeaDinamicaClasica();
        for (int i = 0; i < numeroDeClicks; i++) {				
            vectorInicial = CalculadoraMatricesComplejas.productoDeMatrices(matrizDinamica, vectorInicial);
        }
        
              
        System.out.println("El vector de estado final del sistema es: \n" + vectorInicial);
        //return vectorInicial;
        
    }

    private void validarQueSeaDinamicaClasica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
