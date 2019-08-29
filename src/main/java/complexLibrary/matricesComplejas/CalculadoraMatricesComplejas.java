package complexLibrary.matricesComplejas;
import complexLibrary.ComplexException;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class CalculadoraMatricesComplejas {



    private CalculadoraMatricesComplejas() {

    }
    
    

    
    /**
     * Suma dos matrices de numeros complejos
     *
     * @param A Primera matriz de numeros complejos
     * @param B Segunda matriz de numeros complejos
     * @return Una matriz de numeros complejos resultante de la suma de las matrices a y b
     * @throws ComplexException
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
    
    
    public static MatrizCompleja matrizTranspuesta(MatrizCompleja A){
        MatrizCompleja transpuesta = new MatrizCompleja(A.getN(), A.getM());
        
        for(int i = 0; i < transpuesta.getM(); i++){
            for(int j = 0; j < transpuesta.getN(); j++){
                transpuesta.getMatriz()[i][j] = A.getMatriz()[j][i];
            }
        }
        
        return transpuesta;
    }
    
    
    public static MatrizCompleja matrizConjugada(MatrizCompleja A) {
        MatrizCompleja conjugada = new MatrizCompleja(A.getM(), A.getN());     
        for(int i = 0; i < A.getM(); i++){
            for(int j = 0; j < A.getN(); j++){
                conjugada.getMatriz()[i][j] = CalculadoraNumerosComplejos.conjugado(A.getMatriz()[i][j]);
            }
        }
        return conjugada;
    }

}
