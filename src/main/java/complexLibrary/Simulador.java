package complexLibrary;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class Simulador {
    
    /**
     * Resuelve un sistema con dinamica determinista
     * @param dinamica Una matriz de 0's y 1's que represente la dinámica de un sistema clásico.
     * @param estadoInicial Un vector que corresponde al estado inicial del sistema.
     * @param numeroDeClicks Un número entero no negativo t que representa el número de clicks de tiempo que se quieren considerar.
     * @return Un vector correspondiente al estado final del sistema después de t clicks.
     * @throws ComplexException Si la matriz ingresada no cumple con las características de una matriz correspondiente a la dinámica de un sistema determinista.
     */
    public static MatrizCompleja sistemaConDinamicaDeterminista(MatrizCompleja dinamica, MatrizCompleja estadoInicial, int numeroDeClicks) throws ComplexException {
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
        return estadoInicial;
    }        
	
    /**
     * 
     * @param m1 Matriz estocástica 1 que representan la dinámica de los sistemas constituyentes.
     * @param m2 Matriz estocástica 2 que representan la dinámica de los sistemas constituyentes.
     * @param estadoInicial Vectores que corresponden al estado inicial de los sistemas constituyentes.
     * @param numeroDeClicks Un número entero no negativo t que representa el número de clicks de tiempo que se quieren considerar.
     * @return Un vector correspondiente al estado final del sistema ensamblado después de t clicks.
     * @throws ComplexException Si el estado inicial no es un vector
     */
    public static MatrizCompleja sistemaConDinamicaEstocastico(MatrizCompleja m1, MatrizCompleja m2, MatrizCompleja estadoInicial, int numeroDeClicks) throws ComplexException {

        if(!estadoInicial.isVector()) {
            throw new ComplexException(ComplexException.DEBE_SER_VECTOR);
        }else {
            MatrizCompleja ensamble = CalculadoraMatricesComplejas.productoTensor(m1, m2);

            for (int i = 0; i < numeroDeClicks; i++) {				
                estadoInicial = CalculadoraMatricesComplejas.productoDeMatrices(ensamble, estadoInicial);
            }
        }
        return estadoInicial;

    }

}
