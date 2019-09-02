package complexLibrary;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasMinimas {
	
	
	/**
	 * Suma de vectores complejos
	 * @throws ComplexException Si lo que se ingresa no son vectores
	 */
    @Test
    public void deberiaSumarDosVectores() throws ComplexException{

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);
        MatrizCompleja vector2 = new MatrizCompleja(3, 1);
        
        if(vector1.isVector() && vector2.isVector()){
            MatrizCompleja respuesta = new MatrizCompleja(3, 1);
            
            try{
            vector1.addComplex(0, 0, new NumeroComplejo(8, 3));
            vector1.addComplex(1, 0, new NumeroComplejo(-1, -4));
            vector1.addComplex(2, 0, new NumeroComplejo(0, -9));
            
            vector2.addComplex(0, 0, new NumeroComplejo(8, -3));
            vector2.addComplex(1, 0, new NumeroComplejo(2, 5));
            vector2.addComplex(2, 0, new NumeroComplejo(3, 0));
            
            
            respuesta.addComplex(0, 0, new NumeroComplejo(16, 0));
            respuesta.addComplex(1, 0, new NumeroComplejo(1, 1));
            respuesta.addComplex(2, 0, new NumeroComplejo(3, -9));
              
            }catch(ComplexException e){
                e.printStackTrace();
            }

            try{
                assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(vector1, vector2), respuesta);
            }catch(ComplexException ex){
                ex.printStackTrace();
            }
        }else{
            throw new ComplexException(ComplexException.VECTOR_MATRIZ);
        }
    }
    
    
    /**
     * Inverso aditivo de vector complejo
     * @throws ComplexException Si lo que se ingresa no es un vector
     */
    @Test
    public void deberiaCalcularElInversoAditivoDeUnVector() throws ComplexException{

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);
        
        if(vector1.isVector() ){
            MatrizCompleja respuesta = new MatrizCompleja(3, 1);
            
            try{
            vector1.addComplex(0, 0, new NumeroComplejo(-5, 2));
            vector1.addComplex(1, 0, new NumeroComplejo(3, 0));
            vector1.addComplex(2, 0, new NumeroComplejo(0, -1));            
            
            respuesta.addComplex(0, 0, new NumeroComplejo(5, -2));
            respuesta.addComplex(1, 0, new NumeroComplejo(-3, 0));
            respuesta.addComplex(2, 0, new NumeroComplejo(0, 1));
            
            assertEquals(CalculadoraMatricesComplejas.inversaDeUnaMatriz(vector1), respuesta);
              
            }catch(ComplexException e){
                e.printStackTrace();
            }

            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }
    }
    
    
    /**
     * Multiplicación de escalar por vector complejo
     * @throws ComplexException Si lo que se ingresa no es un vector
     */
    @Test
    public void deberiaMultiplicarUnEscalarPorUnVector() throws ComplexException{

        MatrizCompleja v1 = new MatrizCompleja(3, 1);        
        NumeroComplejo escalar = new NumeroComplejo(-1, 1);        
        MatrizCompleja respuesta = new MatrizCompleja(3, 1);
        
        if(v1.isVector()){
            try{
                v1.addComplex(0, 0, new NumeroComplejo(-2, 5));
                v1.addComplex(1, 0, new NumeroComplejo(-1, -1));
                v1.addComplex(2, 0, new NumeroComplejo(2, -9));

                respuesta.addComplex(0, 0, new NumeroComplejo(-3, -7));
                respuesta.addComplex(1, 0, new NumeroComplejo(2, 0));
                respuesta.addComplex(2, 0, new NumeroComplejo(7, 11));
                
                assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(v1, escalar), respuesta);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException("Debe ser un vector, no una matriz.");
        }
    }
    
    
    /**
     * Suma de matrices complejas
     */
    @Test
    public void deberiaSumarDosMatrices(){

        MatrizCompleja m1 = new MatrizCompleja(3, 3);
        MatrizCompleja m2 = new MatrizCompleja(3, 3);
        
        MatrizCompleja respuesta = new MatrizCompleja(3, 3);
        
        try{
        	
            m1.addComplex(0, 0, new NumeroComplejo(-8, -3));
            m1.addComplex(0, 1, new NumeroComplejo(-6, -4));
            m1.addComplex(0, 2, new NumeroComplejo(0, -4));
            m1.addComplex(1, 0, new NumeroComplejo(-1, 8));
            m1.addComplex(1, 1, new NumeroComplejo(6, -10));
            m1.addComplex(1, 2, new NumeroComplejo(8, -5));
            m1.addComplex(2, 0, new NumeroComplejo(4, 0));
            m1.addComplex(2, 1, new NumeroComplejo(8, 5));
            m1.addComplex(2, 2, new NumeroComplejo(-7, -9));
            
            m2.addComplex(0, 0, new NumeroComplejo(-7, -2));
            m2.addComplex(0, 1, new NumeroComplejo(-4, -2));
            m2.addComplex(0, 2, new NumeroComplejo(7, 7));
            m2.addComplex(1, 0, new NumeroComplejo(5, 9));
            m2.addComplex(1, 1, new NumeroComplejo(0, 3));
            m2.addComplex(1, 2, new NumeroComplejo(6, -5));
            m2.addComplex(2, 0, new NumeroComplejo(1, 5));
            m2.addComplex(2, 1, new NumeroComplejo(-6, -6));
            m2.addComplex(2, 2, new NumeroComplejo(5, 8));
            
            
            respuesta.addComplex(0, 0, new NumeroComplejo(-15, -5));
            respuesta.addComplex(0, 1, new NumeroComplejo(-10, -6));
            respuesta.addComplex(0, 2, new NumeroComplejo(7, 3));
            respuesta.addComplex(1, 0, new NumeroComplejo(4, 17));
            respuesta.addComplex(1, 1, new NumeroComplejo(6, -7));
            respuesta.addComplex(1, 2, new NumeroComplejo(14, -10));
            respuesta.addComplex(2, 0, new NumeroComplejo(5, 5));
            respuesta.addComplex(2, 1, new NumeroComplejo(2, -1));
            respuesta.addComplex(2, 2, new NumeroComplejo(-2, -1));            
                        
            assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(m1, m2), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }                
    }
    
    
    /**
     * Inverso aditivo de matriz compleja
     */
    @Test
    public void deberiaCalcularElInversoAditivoDeUnaMatriz(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        try{
            m1.addComplex(0, 0, new NumeroComplejo(7, 3));
            m1.addComplex(0, 1, new NumeroComplejo(-1, 7));
            m1.addComplex(1, 0, new NumeroComplejo(-9, -4));
            m1.addComplex(1, 1, new NumeroComplejo(-7, -9));
            
            respuesta.addComplex(0, 0, new NumeroComplejo(-7, -3));
            respuesta.addComplex(0, 1, new NumeroComplejo(1, -7));
            respuesta.addComplex(1, 0, new NumeroComplejo(9, 4));
            respuesta.addComplex(1, 1, new NumeroComplejo(7, 9));
            
            assertEquals(CalculadoraMatricesComplejas.inversaDeUnaMatriz(m1), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }  
    }
    
    
    
    /**
     * Multiplicación de escalar por matriz compleja
     */
    @Test
    public void deberiaMultiplicarPorUnEscalarUnaMatriz(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 2);        
        NumeroComplejo escalar = new NumeroComplejo(-2, 3);        
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(3, -2));
            m1.addComplex(0, 1, new NumeroComplejo(8, -4));
            m1.addComplex(1, 0, new NumeroComplejo(4, -10));
            m1.addComplex(1, 1, new NumeroComplejo(-2, -8));
            
            respuesta.addComplex(0, 0, new NumeroComplejo(0, 13));
            respuesta.addComplex(0, 1, new NumeroComplejo(-4, 32));
            respuesta.addComplex(1, 0, new NumeroComplejo(22, 32));
            respuesta.addComplex(1, 1, new NumeroComplejo(28, 10));
            
            assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(m1, escalar), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * Transpuesta de matriz compleja
     */
    @Test
    public void deberiaCalcularLaMatrizTranspuesta(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 3);                     
        MatrizCompleja transpuesta = new MatrizCompleja(3, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(5, 9));
            m1.addComplex(0, 1, new NumeroComplejo(-7, -5));
            m1.addComplex(0, 2, new NumeroComplejo(-1, -4));
            m1.addComplex(1, 0, new NumeroComplejo(8, 2));
            m1.addComplex(1, 1, new NumeroComplejo(-3, -7));
            m1.addComplex(1, 2, new NumeroComplejo(7, -8));
            
            transpuesta.addComplex(0, 0, new NumeroComplejo(5, 9));
            transpuesta.addComplex(0, 1, new NumeroComplejo(8, 2));
            transpuesta.addComplex(1, 0, new NumeroComplejo(-7, -5));
            transpuesta.addComplex(1, 1, new NumeroComplejo(-3, -7));
            transpuesta.addComplex(2, 0, new NumeroComplejo(-1, -4));
            transpuesta.addComplex(2, 1, new NumeroComplejo(7, -8));
            
            assertEquals(CalculadoraMatricesComplejas.matrizTranspuesta(m1), transpuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }        
    }
    
    
    
    /**
     * Conjugada de matriz compleja
     */
    @Test
    public void deberiaCalcularLaMatrizConjugada(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 2);                     
        MatrizCompleja conjugada = new MatrizCompleja(2, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(-6, 1));
            m1.addComplex(0, 1, new NumeroComplejo(3, 8));            
            m1.addComplex(1, 0, new NumeroComplejo(2, -6));
            m1.addComplex(1, 1, new NumeroComplejo(3, 0));
            
            conjugada.addComplex(0, 0, new NumeroComplejo(-6, -1));
            conjugada.addComplex(0, 1, new NumeroComplejo(3, -8));
            conjugada.addComplex(1, 0, new NumeroComplejo(2, 6));
            conjugada.addComplex(1, 1, new NumeroComplejo(3, 0));
            
            MatrizCompleja respuesta = CalculadoraMatricesComplejas.matrizConjugada(m1);
            
            assertEquals(respuesta, conjugada);

            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    
    /**
     * Adjunta (daga) de matriz compleja
     */
    @Test
    public void deberiaCalcularLaMatrizAdjunta(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 3);                     
        MatrizCompleja adjunta = new MatrizCompleja(3, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(7, 7));
            m1.addComplex(0, 1, new NumeroComplejo(3, 8));
            m1.addComplex(0, 2, new NumeroComplejo(8, 4));
            m1.addComplex(1, 0, new NumeroComplejo(5, 0));
            m1.addComplex(1, 1, new NumeroComplejo(8, -6));
            m1.addComplex(1, 2, new NumeroComplejo(-10, -1));
  
            
            adjunta.addComplex(0, 0, new NumeroComplejo(7, -7));
            adjunta.addComplex(0, 1, new NumeroComplejo(5, 0));            
            adjunta.addComplex(1, 0, new NumeroComplejo(3, -8));
            adjunta.addComplex(1, 1, new NumeroComplejo(8, 6));            
            adjunta.addComplex(2, 0, new NumeroComplejo(8, -4));
            adjunta.addComplex(2, 1, new NumeroComplejo(-10, 1));            
            
            assertEquals(CalculadoraMatricesComplejas.matrizAdjunta(m1), adjunta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    /**
     * Producto de matrices complejas
     */
    @Test
    public void deberiaMultiplicarDosMatrices(){
        
        MatrizCompleja m1 = new MatrizCompleja(3, 3);                     
        MatrizCompleja m2 = new MatrizCompleja(3, 3);
        
        MatrizCompleja resultado = new MatrizCompleja(3, 3);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(-6, 2));
            m1.addComplex(0, 1, new NumeroComplejo(0, 6));
            m1.addComplex(0, 2, new NumeroComplejo(7, 2));
            m1.addComplex(1, 0, new NumeroComplejo(6, 9));
            m1.addComplex(1, 1, new NumeroComplejo(7, 7));
            m1.addComplex(1, 2, new NumeroComplejo(-6, -6));
            m1.addComplex(2, 0, new NumeroComplejo(5, 8));
            m1.addComplex(2, 1, new NumeroComplejo(-6, 8));
            m1.addComplex(2, 2, new NumeroComplejo(6, 9));            
            
            m2.addComplex(0, 0, new NumeroComplejo(9, -6));
            m2.addComplex(0, 1, new NumeroComplejo(-3, -4));
            m2.addComplex(0, 2, new NumeroComplejo(5, -2));
            m2.addComplex(1, 0, new NumeroComplejo(3, 6));
            m2.addComplex(1, 1, new NumeroComplejo(-1, -5));
            m2.addComplex(1, 2, new NumeroComplejo(0, -5));
            m2.addComplex(2, 0, new NumeroComplejo(9, 9));
            m2.addComplex(2, 1, new NumeroComplejo(8, -4));
            m2.addComplex(2, 2, new NumeroComplejo(-8, -4));
            
            resultado.addComplex(0, 0, new NumeroComplejo(-33, 153));
            resultado.addComplex(0, 1, new NumeroComplejo(120, 0));
            resultado.addComplex(0, 2, new NumeroComplejo(-44, -22));
            resultado.addComplex(1, 0, new NumeroComplejo(87, 0));
            resultado.addComplex(1, 1, new NumeroComplejo(-26, -117));
            resultado.addComplex(1, 2, new NumeroComplejo(107, 70));
            resultado.addComplex(2, 0, new NumeroComplejo(0, 165));
            resultado.addComplex(2, 1, new NumeroComplejo(147, 26));
            resultado.addComplex(2, 2, new NumeroComplejo(69, -36));                        
            
            assertEquals(CalculadoraMatricesComplejas.productoDeMatrices(m1, m2), resultado);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    
    /**
     * No se deberian multiplicar porque la matriz 1 es de tamaño 3x3, y la matriz 2 es de tamaño 2x2
     */
    @Test
    public void noDeberiaMultiplicarDosMatrices() {

        MatrizCompleja m1 = new MatrizCompleja(3, 3);
        MatrizCompleja m2 = new MatrizCompleja(2, 2);
        

        try {
            
            m1.addComplex(0, 0, new NumeroComplejo(2, 1));
            m1.addComplex(0, 1, new NumeroComplejo(3, 0));
            m1.addComplex(0, 2, new NumeroComplejo(1, -1));
            m1.addComplex(1, 0, new NumeroComplejo(0, 0));
            m1.addComplex(1, 1, new NumeroComplejo(0, -2));
            m1.addComplex(1, 2, new NumeroComplejo(7, -3));
            m1.addComplex(2, 0, new NumeroComplejo(3, 0));
            m1.addComplex(2, 1, new NumeroComplejo(0, 0));
            m1.addComplex(2, 2, new NumeroComplejo(1, -2));            
            
            m2.addComplex(0, 0, new NumeroComplejo(0, -1));
            m2.addComplex(0, 1, new NumeroComplejo(1, 0));            
            m2.addComplex(1, 0, new NumeroComplejo(0, 0));
            m2.addComplex(1, 1, new NumeroComplejo(0, 1));

            CalculadoraMatricesComplejas.productoDeMatrices(m1, m2);
        } catch (ComplexException e) {
            assertEquals(e.getMessage(),(ComplexException.NO_SE_PUEDEN_MULTIPLICAR));
        }

    }
    
    /*
    
    @Test
    public void deberiaSerHermitiana() {
    	MatrizCompleja A = new MatrizCompleja(2, 2);
    	
        try {
			A.addComplex(0, 0, new NumeroComplejo(2, 0));
	        A.addComplex(0, 1, new NumeroComplejo(3, -1));
	        A.addComplex(1, 0, new NumeroComplejo(3, 1));
	        A.addComplex(1, 1, new NumeroComplejo(-1, 0));
	        
	        assertTrue(CalculadoraMatricesComplejas.esHermitiana(A));
	        
		} catch (ComplexException e) {
			e.printStackTrace();
		}

    	
    }
    
    
    @Test
    public void noDeberiaSerHermitiana() {
    	MatrizCompleja A = new MatrizCompleja(2, 2);
    	
        try {
			A.addComplex(0, 0, new NumeroComplejo(-2, 0));
	        A.addComplex(0, 1, new NumeroComplejo(5, -1));
	        A.addComplex(1, 0, new NumeroComplejo(41, 1));
	        A.addComplex(1, 1, new NumeroComplejo(-1, 0));
	        
	        assertFalse(CalculadoraMatricesComplejas.esHermitiana(A));
	        
		} catch (ComplexException e) {
			e.printStackTrace();
		}

    	
    }   */ 

}
