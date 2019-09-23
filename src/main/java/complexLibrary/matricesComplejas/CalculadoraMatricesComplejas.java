package complexLibrary.matricesComplejas;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class CalculadoraMatricesComplejas {

    
     /**
     * Suma dos vectores de numeros complejos
     *
     * @param A Primer vector de numeros complejos
     * @param B Segundo vector de numeros complejos
     * @return Un vector de numeros complejos resultante de la suma de los vectores A y B
     * @throws ComplexException Si los vectores no tienen la misma dimension
     */
    public static MatrizCompleja sumaDeVectores(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        if(A.isVector() && B.isVector()){
            verificarMatricesMismaDimension(A, B);
            MatrizCompleja suma = new MatrizCompleja(A.getM(), A.getN());
            for(int i = 0; i < A.getM(); i++) {
                for(int j = 0; j < B.getN(); j++) {
                    suma.getMatriz()[i][j] = CalculadoraNumerosComplejos.sumaDeNumerosComplejos(A.getMatriz()[i][j], B.getMatriz()[i][j]);
                }
            }
            return suma;
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } 
    }
    
    
    /**
     * Suma dos matrices de numeros complejos
     *
     * @param A Primera matriz de numeros complejos
     * @param B Segunda matriz de numeros complejos
     * @return Una matriz de numeros complejos resultante de la suma de las matrices A y B
     * @throws ComplexException Si las matrices no tienen la misma dimension
     */
    public static MatrizCompleja sumaDeMatrices(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        verificarMatricesMismaDimension(A, B);
        MatrizCompleja suma = new MatrizCompleja(A.getM(), A.getN());
        for(int i = 0; i < A.getM(); i++) {
            for(int j = 0; j < B.getN(); j++) {
                suma.getMatriz()[i][j] = CalculadoraNumerosComplejos.sumaDeNumerosComplejos(A.getMatriz()[i][j], B.getMatriz()[i][j]);
            }
        }
        return suma;
    }
    
    
    /**
     * Resta dos matrices de numeros complejos
     *
     * @param A Primera matriz de numeros complejos
     * @param B Segunda matriz de numeros complejos
     * @return Una matriz de numeros complejos resultante de la resta de las matrices a y b
     * @throws ComplexException Si las matrices no tienen la misma dimension
     */
    public static MatrizCompleja restaDeMatrices(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        verificarMatricesMismaDimension(A, B);
        MatrizCompleja resta = new MatrizCompleja(A.getM(), A.getN());
        for(int i = 0; i < A.getM(); i++) {
            for(int j = 0; j < B.getN(); j++) {
            	resta.getMatriz()[i][j] = CalculadoraNumerosComplejos.restaDeNumerosComplejos(A.getMatriz()[i][j], B.getMatriz()[i][j]);
            }
        }
        return resta;
    }
    
    
    /**
     * Verifica si dos matrices tienen la misma dimension
     * @param a Primera MatrizCompleja
     * @param b Segunda MatrizCompleja
     * @throws ComplexException Si las matrices no tienen la misma dimension
     */
    private static void verificarMatricesMismaDimension(MatrizCompleja A, MatrizCompleja B) throws ComplexException{
        if(A.getN() != B.getN() || A.getM()!= B.getM()){
            throw new ComplexException(ComplexException.MATRIZ_DE_DIFERENTES_DIMENSIONES);
        }
    }
    
    
    
     /**
     * Calcula y retorna la inversa de una matriz, es decir, cada uno de sus elementos (tanto parte real como parte imaginaria) por -1
     * @param A Matriz de numeros complejos
     * @return Inversa de la matriz A
     */
    public static MatrizCompleja inversaDeUnVector(MatrizCompleja A) throws ComplexException {
        
        if(A.isVector()){
            MatrizCompleja inversa = new MatrizCompleja(A.getM(), A.getN());
            for(int i = 0; i < A.getM(); i++){
                for(int j = 0; j < A.getN(); j++){
                    inversa.getMatriz()[i][j] = A.getMatriz()[i][j].inversoDeUnNumeroComplejo();
                }
            }
            return inversa;
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }        

    }
    
    
     /**
     * Calcula y retorna la inversa de una matriz, es decir, cada uno de sus elementos (tanto parte real como parte imaginaria) por -1
     * @param A Matriz de numeros complejos
     * @return Inversa de la matriz A
     */
    public static MatrizCompleja inversaDeUnaMatriz(MatrizCompleja A) {
        MatrizCompleja inversa = new MatrizCompleja(A.getM(), A.getN());
        for(int i = 0; i < A.getM(); i++){
            for(int j = 0; j < A.getN(); j++){
                inversa.getMatriz()[i][j] = A.getMatriz()[i][j].inversoDeUnNumeroComplejo();
            }
        }
        return inversa;
    }    
    
    
    /**
     * Calcula y retorna el producto de un escalar por un vector
     * @param A Vector de numeros complejos
     * @param B escalar a multiplicar
     * @return A*B
     * @throws complexLibrary.excepciones.ComplexException Si A no es un vector
     */
    public static MatrizCompleja productoPorEscalarDeUnVector(MatrizCompleja A, NumeroComplejo B) throws ComplexException{
        
        if(A.isVector()){
            MatrizCompleja resultado = new MatrizCompleja(A.getM(), A.getN());

            for(int i = 0; i < A.getM(); i++){
                for(int j = 0; j < A.getN(); j++){
                    resultado.getMatriz()[i][j] = CalculadoraNumerosComplejos.productoDeNumerosComplejos(A.getMatriz()[i][j], B);
                }
            }
        
            return resultado;
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }           

    }    
    
    /**
     * Calcula y retorna el producto de un escalar por una matriz
     * @param A Matriz de numeros complejos
     * @param B escalar a multiplicar
     * @return A*B
     */
    public static MatrizCompleja productoPorEscalar(MatrizCompleja A, NumeroComplejo B){
        MatrizCompleja resultado = new MatrizCompleja(A.getM(), A.getN());
        
        for(int i = 0; i < A.getM(); i++){
            for(int j = 0; j < A.getN(); j++){
                resultado.getMatriz()[i][j] = CalculadoraNumerosComplejos.productoDeNumerosComplejos(A.getMatriz()[i][j], B);
            }
        }
        
        return resultado;
    }
    
    /**
     * Retorna la matriz transpuesta de A
     * @param A Matriz compleja
     * @return La matriz transpuesta de A
     */
    public static MatrizCompleja matrizTranspuesta(MatrizCompleja A){
        MatrizCompleja transpuesta = new MatrizCompleja(A.getN(), A.getM());
        
        for(int i = 0; i < transpuesta.getM(); i++){
            for(int j = 0; j < transpuesta.getN(); j++){
                transpuesta.getMatriz()[i][j] = A.getMatriz()[j][i];
            }
        }
        
        return transpuesta;
    }
    
    
    /**     
     * Retorna la matriz conjugada de A
     * @param A Matriz compleja
     * @return La matriz conjugada de A
     */
    public static MatrizCompleja matrizConjugada(MatrizCompleja A) {
        MatrizCompleja conjugada = new MatrizCompleja(A.getM(), A.getN());     
        for(int i = 0; i < A.getM(); i++){
            for(int j = 0; j < A.getN(); j++){
                conjugada.getMatriz()[i][j] = CalculadoraNumerosComplejos.conjugado(A.getMatriz()[i][j]);
            }
        }
        return conjugada;
    }
    
    /**     
     * Retorna la matriz adjunta de A
     * @param A Matriz compleja
     * @return La matriz adjunta (daga) de A
     */
    public static MatrizCompleja matrizAdjunta(MatrizCompleja A) {
        MatrizCompleja adjunta = new MatrizCompleja(A.getM(), A.getN());     
        
        adjunta = matrizTranspuesta(matrizConjugada(A));
        
        return adjunta;
    }
    
    
    /**
     * Realiza la multiplicación entre dos matrices complejas
     * @param A Primera matriz compleja
     * @param B Segunda matriz compleja
     * @return Matriz resultante del producto entre A y B
     * @throws ComplexException Si las dimensiones de las matrices A y B son incompatibles
     */
    public static MatrizCompleja productoDeMatrices(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        if(A.getN() != B.getM()) {
            throw new ComplexException(ComplexException.NO_SE_PUEDEN_MULTIPLICAR);
        }else {
            MatrizCompleja resultado = new MatrizCompleja(A.getM(), B.getN());

            for (int i = 0; i < A.getM(); i++) {
                for (int j = 0; j < B.getN(); j++) {
                    NumeroComplejo x = new NumeroComplejo(0, 0);
                    for (int k = 0; k < A.getN(); k++) {
                        x = CalculadoraNumerosComplejos.sumaDeNumerosComplejos(x, CalculadoraNumerosComplejos.productoDeNumerosComplejos(A.getMatriz()[i][k], B.getMatriz()[k][j]));
                    }
                    resultado.getMatriz()[i][j] = x;
                }
            }

            return resultado;
        }	
    }
    
    /**
     * Realiza la multiplicación entre dos matrices complejas
     * @param A Primera matriz compleja
     * @param B Segunda matriz compleja
     * @return Matriz resultante del producto entre A y B
     * @throws ComplexException Si las dimensiones de las matrices A y B son incompatibles
     */
    public static MatrizCompleja productoDeMatricesSinRedondear(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        if(A.getN() != B.getM()) {
            throw new ComplexException(ComplexException.NO_SE_PUEDEN_MULTIPLICAR);
        }else {
            MatrizCompleja resultado = new MatrizCompleja(A.getM(), B.getN());

            for (int i = 0; i < A.getM(); i++) {
                for (int j = 0; j < B.getN(); j++) {
                    NumeroComplejo x = new NumeroComplejo(0, 0);
                    for (int k = 0; k < A.getN(); k++) {
                        x = CalculadoraNumerosComplejos.sumaDeNumerosComplejos(x, CalculadoraNumerosComplejos.productoDeNumerosComplejosSinRedondear(A.getMatriz()[i][k], B.getMatriz()[k][j]));
                    }
                    resultado.getMatriz()[i][j] = x;
                }
            }

            return resultado;
        }	
    }    
    
    
    /**
     * Determina si dada una matriz A, es hermitiana o no
     * @param A Matriz de complejos
     * @return Si es hermitiana
     */
    public static boolean esHermitiana(MatrizCompleja A) {
    	boolean esHermitiana = false;
    	if(A.equals(matrizAdjunta(A))) {
            esHermitiana = true;
    	}
    	
    	return esHermitiana;
    }
    
    /**
     * Calcula el producto interno entre dos matrices 
     * @param A Primera matriz de complejos
     * @param B Segunda matriz de complejos
     * @return Producto interno entre A y B
     * @throws ComplexException si el producto de matrices es incompatible
     */
    public static MatrizCompleja productoInterno(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
    	MatrizCompleja productoInterno = new MatrizCompleja(A.getM(), B.getN());
    	
    	productoInterno = productoDeMatrices(matrizAdjunta(A), B);
    	
    	return productoInterno;
    }

    
    /**
     * Calcula el producto interno entre dos vectores 
     * @param A Primera matriz de complejos
     * @param B Segunda matriz de complejos
     * @param esMatriz1x1 Si es una matriz 1x1 (un numero real)
     * @return El producto interno 
     * @throws ComplexException si el producto de matrices es incompatible
     */
    public static double productoInterno(MatrizCompleja A, MatrizCompleja B, boolean esMatriz1x1) throws ComplexException {    	
        double parteReal;
        MatrizCompleja productoInterno = new MatrizCompleja(A.getM(), B.getN());    	
        productoInterno = productoDeMatrices(matrizAdjunta(A), B);    	
        NumeroComplejo numero = productoInterno.getNumeroComplejo(0, 0);    	
        parteReal =  numero.getParteReal();  	

        return parteReal;
    	
    }

    /**
     * Calcula y retorna la norma de un vector
     * @param A Vector para calcular la norma
     * @return Norma del vector
     * @throws ComplexException si el producto de matrices es incompatible
     */
    public static double norma(MatrizCompleja A) throws ComplexException {
        double norma = Math.sqrt(productoInterno(A, A, true));
        return norma;
    }
	
	
    /**
     * Calcula y retorna la distancia entre dos vectores
     * @param A Vector 1
     * @param B Vector 2
     * @return Distancia entre A y B
     * @throws ComplexException Si la resta de los vectores no se puede realizar.
     */
    public static double distancia(MatrizCompleja A, MatrizCompleja B) throws ComplexException {
        double distancia;
        distancia = norma(restaDeMatrices(A, B));
        return distancia;
    }
	
    /**
     * Crea y retorna la matriz identidad de una matriz dada
     * @param A Matriz de numeros complejos
     * @return Matriz identidad de A
     * @throws ComplexException Si A no es cuadrada
     */
    public static MatrizCompleja crearIdentidad(MatrizCompleja A) throws ComplexException {
        int dimension = 0;
        if(A.esCuadrada() || A.isVector()) {
            dimension = A.getM();
        }else {
            throw new ComplexException(ComplexException.NO_ES_CUADRADA);
        }

        MatrizCompleja matrizIdentidad = new MatrizCompleja(dimension, dimension);

        for(int i = 0; i < matrizIdentidad.getM(); i++){
            for(int j = 0; j < matrizIdentidad.getN(); j++){
                if(i == j) {
                    matrizIdentidad.getMatriz()[i][j] =  new NumeroComplejo(1, 0);

                }else {
                    matrizIdentidad.getMatriz()[i][j] = new NumeroComplejo(0, 0);
                }
            }
        }

        return matrizIdentidad;

    }
    
    /**
     * Dice si una matriz dada es unitaria o no (Si el producto de la matriz por su adjunta es igual a la matriz identidad).
     * @param A Matriz de numeros complejos
     * @return Si la matriz es unitaria
     * @throws ComplexException Si el producto de matrices no se puede realizar
     */
    public static boolean esUnitaria(MatrizCompleja A) throws ComplexException {
        boolean esUnitaria = false;
        //System.out.println(productoDeMatrices(A, matrizAdjunta(A)));
        //System.out.println(crearIdentidad(A));
                

        if(productoDeMatrices(A, matrizAdjunta(A)).equals(crearIdentidad(A))) {
            esUnitaria = true;
        }			
        return esUnitaria;
    }
	
    /**
     * Calcula el producto tensor entre dos matrices
     * @param A Matriz 1 de numeros complejos
     * @param B Matriz 2 de numeros complejos
     * @return Producto tensor entre A y B
     */
    public static MatrizCompleja productoTensor(MatrizCompleja A, MatrizCompleja B) {
        int m = A.getM();
        int n = A.getN();
        int p = B.getM();
        int q = B.getN();

        int filasProductoTensor = m*p;
        int columnasProductoTensor = n*q;

        MatrizCompleja productoTensor = new MatrizCompleja(filasProductoTensor, columnasProductoTensor);

        for(int i = 0; i < productoTensor.getM(); i++){
            for(int j = 0; j < productoTensor.getN(); j++){
                //productoTensor.getMatriz()[i][j] = A.getMatriz()[j][i];
                productoTensor.getMatriz()[i][j] = CalculadoraNumerosComplejos.productoDeNumerosComplejosSinRedondear((A.getMatriz()[i/p] [j/q]), B.getMatriz()[i%p][j%q]);
            }
        }
            return productoTensor;
        }
    
    
    public static MatrizCompleja matrizEstocasticaAsociada(MatrizCompleja A) throws ComplexException {

        MatrizCompleja matrizEstocasticaAsociada = new MatrizCompleja(A.getM(), A.getN());     
        for(int i = 0; i < A.getM(); i++){
            for(int j = 0; j < A.getN(); j++){
            	matrizEstocasticaAsociada.getMatriz()[i][j] = new NumeroComplejo(CalculadoraNumerosComplejos.moduloElevadoAlCuadrado(A.getMatriz()[i][j]), 0);
            }
        }
        if(matrizEstocasticaAsociada.esDeDinamicaDoblementeEstocastica()) {
        	return matrizEstocasticaAsociada;    
        }else {
        	throw new ComplexException(ComplexException.NO_SE_PUDO_CALCULAR_ESTOCASTICA_ASOCIADA);
        }


    }
    
    
	public static MatrizCompleja matrizModuloAlCuadrado(MatrizCompleja A) {
		MatrizCompleja matrizModulo = new MatrizCompleja(A.getM(), A.getN());
		for (int i = 0; i < matrizModulo.getM(); i++) {
			for (int j = 0; j < matrizModulo.getN(); j++) {			
				matrizModulo.getMatriz()[i][j] = new NumeroComplejo(CalculadoraNumerosComplejos.moduloElevadoAlCuadrado(A.getMatriz()[i][j]), 0);
			}
			
		}
		return matrizModulo;
	}
	
    
    


}
