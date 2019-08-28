package complexLibrary.matricesComplejas;
import complexLibrary.ComplexException;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;

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
     * @param b Second MatrizCompleja
     * @throws ComplexException Si las matrices no tienen la misma dimension
     */
    private static void verificarMatricesMismaDimension(MatrizCompleja a, MatrizCompleja b) throws ComplexException{
        if(a.getN() != b.getN() || a.getM()!= b.getM()){
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
    
    

}
