package complexLibrary.matricesComplejas;

import complexLibrary.ComplexException;
import complexLibrary.numerosComplejos.*;
import java.util.Arrays;


public class MatrizCompleja {
    
    private int m;  //Filas de la matriz
    private int n;  //Columnas de la matriz
    private NumeroComplejo[][] matriz;  //Matriz rellenada con numeros complejos
        

    public MatrizCompleja(int m, int n){
        this.m = m;
        this.n = n;
        this.matriz = new NumeroComplejo[m][n];
    }
    
    
    
    public MatrizCompleja(NumeroComplejo[][] matriz){
        this.matriz = matriz;
    }

    
    
     /**
     * Verifica si las coordenadas dadas estan fuera de rango o no.
     * @param i fila
     * @param j columna
     * @throws ComplexException Si las coordenadas estan fuera de rango.
     */
    private void verificarRango(int i,int j) throws ComplexException{
        if((i<0) || (j<0) || (i >= m) || (j >= n)){
            throw new ComplexException(ComplexException.FUERA_DE_RANGO);
        }
    }

    
    /**
     * Agrega un numero complejo a la matriz
     * @param i Posicion i de la matriz
     * @param j Posicion j de la matriz
     * @param numero Numero complejo que se va a agregar
     * @throws ComplexException Si los elementos que se agregan se salen del rango de la matriz
     */
    public void addComplex(int i, int j, NumeroComplejo numero) throws ComplexException{
        verificarRango(i, j);
        this.matriz [i][j] = numero;
    }
    
    /**
     * @param i fila
     * @param j columna
     * @return Un numero complejo indexado en las coordenadas dadas.
     * @throws ComplexException si las coordenadas estan fuera de rango
     */
    public NumeroComplejo getNumeroComplejo(int i,int j) throws ComplexException {
        verificarRango(i,j);
        return matriz[i][j];
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public NumeroComplejo[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(NumeroComplejo[][] matriz) {
        this.matriz = matriz;
    }
    
    
    /**
     * 
     * @return Si la matriz que se ingresa es un vector
     */
    public boolean isVector(){
        boolean respuesta = false;
        if((this.getM()==1 && this.getN()>1) || (this.getN()==1 && this.getM()>1)){
            respuesta = true;
        }
        return respuesta;
    }
    
  

    @Override
    public String toString() {
        String matriz = "";
        for (int i=0 ; i< this.m; i++){
            for (int j=0; j<this.n;j++){
                matriz += "Fila :" +i+ " Columna: "+j+"  ---> " + this.matriz [i][j] + " ";
            }
            matriz+="\n";
        }
        return matriz;
    }



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + m;
		result = prime * result + Arrays.deepHashCode(matriz);
		result = prime * result + n;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatrizCompleja other = (MatrizCompleja) obj;
		if (m != other.m)
			return false;		
		if (n != other.n)
			return false;
		if (!Arrays.deepEquals(matriz, other.matriz))
			return false;
		return true;
	}


    

	
	

}
