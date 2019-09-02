package complexLibrary;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;
import static org.junit.Assert.*;




public class MatricesComplejasTest {
    
    @Test
    public void deberiaSumarDosVectores() throws ComplexException{

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);
        MatrizCompleja vector2 = new MatrizCompleja(3, 1);
        
        if(vector1.isVector() && vector2.isVector()){
            MatrizCompleja respuesta = new MatrizCompleja(3, 1);
            
            try{
	            vector1.addComplex(0, 0, new NumeroComplejo(4, 2));
	            vector1.addComplex(1, 0, new NumeroComplejo(0, 3));
	            vector1.addComplex(2, 0, new NumeroComplejo(0, 1));
	            
	            vector2.addComplex(0, 0, new NumeroComplejo(0, 3));
	            vector2.addComplex(1, 0, new NumeroComplejo(2, 0));
	            vector2.addComplex(2, 0, new NumeroComplejo(0, 3));
	            
	            
	            respuesta.addComplex(0, 0, new NumeroComplejo(4, 5));
	            respuesta.addComplex(1, 0, new NumeroComplejo(2, 3));
	            respuesta.addComplex(2, 0, new NumeroComplejo(0, 4));
	            
	            assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(vector1, vector2), respuesta);
              
            }catch(ComplexException e){
                e.printStackTrace();
            }

        }else{
        	throw new ComplexException(ComplexException.VECTOR_MATRIZ);
        }
    }

    
    @Test
    public void deberiaCalcularElProductoPorUnEscalarEnUnVector() throws ComplexException{
        
        MatrizCompleja v1 = new MatrizCompleja(3, 1);        
        NumeroComplejo escalar = new NumeroComplejo(6, 2);        
        MatrizCompleja respuesta = new MatrizCompleja(3, 1);
        
        if(v1.isVector()){
            try{
                v1.addComplex(0, 0, new NumeroComplejo(3, 0));
                v1.addComplex(1, 0, new NumeroComplejo(0, 1));
                v1.addComplex(2, 0, new NumeroComplejo(2, -1));

                respuesta.addComplex(0, 0, new NumeroComplejo(18, 6));
                respuesta.addComplex(1, 0, new NumeroComplejo(-2, 6));
                respuesta.addComplex(2, 0, new NumeroComplejo(14, -2));
                
                assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(v1, escalar), respuesta);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException("Debe ser un vector, no una matriz.");
        }
        
        
    }
    
    
    @Test
    public void deberiaSumarDosMatrices(){

        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja m2 = new MatrizCompleja(2, 2);
        
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(1, 1));
            m1.addComplex(0, 1, new NumeroComplejo(2, 2));
            m1.addComplex(1, 0, new NumeroComplejo(3, 3));
            m1.addComplex(1, 1, new NumeroComplejo(4, 4));
            
            m2.addComplex(0, 0, new NumeroComplejo(1, 1));
            m2.addComplex(0, 1, new NumeroComplejo(1, 1));
            m2.addComplex(1, 0, new NumeroComplejo(1, 1));
            m2.addComplex(1, 1, new NumeroComplejo(1, 1));
            
            
            respuesta.addComplex(0, 0, new NumeroComplejo(2, 2));
            respuesta.addComplex(0, 1, new NumeroComplejo(3, 3));
            respuesta.addComplex(1, 0, new NumeroComplejo(4, 4));
            respuesta.addComplex(1, 1, new NumeroComplejo(5, 5));
                        
            assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(m1, m2), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }                
    }
    
    
    
    /**
     * No deberia porque m1 es de tamaño 2x2 y m2 es de tamaño 2x1
     */
    @Test
    public void noDeberiaSumarMatricesDeTamañosDiferentes() {

        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja m2 = new MatrizCompleja(2, 1);
        
        

        try {
            
            m1.addComplex(0, 0, new NumeroComplejo(1, 1));
            m1.addComplex(0, 1, new NumeroComplejo(2, 2));
            m1.addComplex(1, 0, new NumeroComplejo(3, 3));
            m1.addComplex(1, 1, new NumeroComplejo(4, 4));
            
            m2.addComplex(0, 0, new NumeroComplejo(1, 1));
            m2.addComplex(1, 0, new NumeroComplejo(1, 1));

            CalculadoraMatricesComplejas.sumaDeMatrices(m1, m2);
        } catch (ComplexException e) {
            assertEquals(e.getMessage(),(ComplexException.MATRIZ_DE_DIFERENTES_DIMENSIONES));
        }

    }
	
    /**
     * Se le suma una matriz llena de valores en 0, la suma deberia dar como resultado la misma matriz
     */
    @Test
    public void deberiaSumarModulo(){

        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja m2 = new MatrizCompleja(2, 2);
        
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(1, 1));
            m1.addComplex(0, 1, new NumeroComplejo(2, 2));
            m1.addComplex(1, 0, new NumeroComplejo(3, 3));
            m1.addComplex(1, 1, new NumeroComplejo(4, 4));
            
            m2.addComplex(0, 0, new NumeroComplejo(0, 0));
            m2.addComplex(0, 1, new NumeroComplejo(0, 0));
            m2.addComplex(1, 0, new NumeroComplejo(0, 0));
            m2.addComplex(1, 1, new NumeroComplejo(0, 0));
            
            
            respuesta.addComplex(0, 0, new NumeroComplejo(1, 1));
            respuesta.addComplex(0, 1, new NumeroComplejo(2, 2));
            respuesta.addComplex(1, 0, new NumeroComplejo(3, 3));
            respuesta.addComplex(1, 1, new NumeroComplejo(4, 4));
                        
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
        try{
            assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(m1,m2), respuesta);
        }catch(ComplexException ex){
            ex.printStackTrace();
        }
    }
    
    
    @Test
    public void deberiaCalcularLaInversaDeUnaMatriz(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        try{
            m1.addComplex(0, 0, new NumeroComplejo(1, 1));
            m1.addComplex(0, 1, new NumeroComplejo(2, 2));
            m1.addComplex(1, 0, new NumeroComplejo(3, 3));
            m1.addComplex(1, 1, new NumeroComplejo(4, 4));
            
            respuesta.addComplex(0, 0, new NumeroComplejo(-1, -1));
            respuesta.addComplex(0, 1, new NumeroComplejo(-2, -2));
            respuesta.addComplex(1, 0, new NumeroComplejo(-3, -3));
            respuesta.addComplex(1, 1, new NumeroComplejo(-4, -4));
            
            assertEquals(CalculadoraMatricesComplejas.inversaDeUnaMatriz(m1), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }  
    }
    
    
    @Test
    public void deberiaCalcularElProductoPorUnEscalarEnUnaMatriz(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 2);        
        NumeroComplejo escalar = new NumeroComplejo(3, 1);        
        MatrizCompleja respuesta = new MatrizCompleja(2, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(0, 1));
            m1.addComplex(0, 1, new NumeroComplejo(0, -1));
            m1.addComplex(1, 0, new NumeroComplejo(1, 0));
            m1.addComplex(1, 1, new NumeroComplejo(2, 1));
            
            respuesta.addComplex(0, 0, new NumeroComplejo(-1, 3));
            respuesta.addComplex(0, 1, new NumeroComplejo(1, -3));
            respuesta.addComplex(1, 0, new NumeroComplejo(3, 1));
            respuesta.addComplex(1, 1, new NumeroComplejo(5, 5));
            
            assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(m1, escalar), respuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    @Test
    public void deberiaCalcularLaMatrizTranspuesta(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 3);                     
        MatrizCompleja transpuesta = new MatrizCompleja(3, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(2, -1));
            m1.addComplex(0, 1, new NumeroComplejo(0, 1));
            m1.addComplex(0, 2, new NumeroComplejo(4, 3));
            m1.addComplex(1, 0, new NumeroComplejo(3, 1));
            m1.addComplex(1, 1, new NumeroComplejo(0, -1));
            m1.addComplex(1, 2, new NumeroComplejo(0, 2));
            
            transpuesta.addComplex(0, 0, new NumeroComplejo(2, -1));
            transpuesta.addComplex(0, 1, new NumeroComplejo(3, 1));
            transpuesta.addComplex(1, 0, new NumeroComplejo(0, 1));
            transpuesta.addComplex(1, 1, new NumeroComplejo(0, -1));
            transpuesta.addComplex(2, 0, new NumeroComplejo(4, 3));
            transpuesta.addComplex(2, 1, new NumeroComplejo(0, 2));
            
            //System.out.println(CalculadoraMatricesComplejas.matrizTranspuesta(m1));
            //System.out.println(transpuesta);
            
            assertEquals(CalculadoraMatricesComplejas.matrizTranspuesta(m1), transpuesta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    @Test
    public void deberiaCalcularLaMatrizConjugada(){
        
        MatrizCompleja m1 = new MatrizCompleja(2, 3);                     
        MatrizCompleja conjugada = new MatrizCompleja(2, 3);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(2, 1));
            m1.addComplex(0, 1, new NumeroComplejo(0, 1));
            m1.addComplex(0, 2, new NumeroComplejo(4, 3));
            m1.addComplex(1, 0, new NumeroComplejo(3, 1));
            m1.addComplex(1, 1, new NumeroComplejo(0, -1));
            m1.addComplex(1, 2, new NumeroComplejo(0, 2));
            
            conjugada.addComplex(0, 0, new NumeroComplejo(2, -1));
            conjugada.addComplex(0, 1, new NumeroComplejo(0, -1));
            conjugada.addComplex(0, 2, new NumeroComplejo(4, -3));
            conjugada.addComplex(1, 0, new NumeroComplejo(3, -1));
            conjugada.addComplex(1, 1, new NumeroComplejo(0, 1));
            conjugada.addComplex(1, 2, new NumeroComplejo(0, -2));
            
            MatrizCompleja respuesta = CalculadoraMatricesComplejas.matrizConjugada(m1);
            
            
            /*
            System.out.println(CalculadoraMatricesComplejas.matrizConjugada(m1));
            System.out.println(conjugada);
            for(int i = 0; i < conjugada.getM(); i++) {
            	for(int j = 0; j < conjugada.getN(); j++) {
            		System.out.println("comparar "+conjugada.getMatriz()[i][j] +" " +respuesta.getMatriz()[i][j]);
            		System.out.println(conjugada.getMatriz()[i][j].equals(respuesta.getMatriz()[i][j]));
            	}
            }*/
            assertEquals(respuesta, conjugada);

            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    @Test
    public void deberiaCalcularLaMatrizAdjunta(){
        
        MatrizCompleja m1 = new MatrizCompleja(3, 3);                     
        MatrizCompleja adjunta = new MatrizCompleja(3, 3);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(6, -3));
            m1.addComplex(0, 1, new NumeroComplejo(2, 12));
            m1.addComplex(0, 2, new NumeroComplejo(0, -19));
            m1.addComplex(1, 0, new NumeroComplejo(0, 0));
            m1.addComplex(1, 1, new NumeroComplejo(5, 2.1));
            m1.addComplex(1, 2, new NumeroComplejo(17, 0));
            m1.addComplex(2, 0, new NumeroComplejo(1, 0));
            m1.addComplex(2, 1, new NumeroComplejo(2, 5));
            m1.addComplex(2, 2, new NumeroComplejo(3, -4.5));            
            
            adjunta.addComplex(0, 0, new NumeroComplejo(6, 3));
            adjunta.addComplex(0, 1, new NumeroComplejo(0, 0));
            adjunta.addComplex(0, 2, new NumeroComplejo(1, 0));
            adjunta.addComplex(1, 0, new NumeroComplejo(2, -12));
            adjunta.addComplex(1, 1, new NumeroComplejo(5, -2.1));
            adjunta.addComplex(1, 2, new NumeroComplejo(2, -5));
            adjunta.addComplex(2, 0, new NumeroComplejo(0, 19));
            adjunta.addComplex(2, 1, new NumeroComplejo(17, 0));
            adjunta.addComplex(2, 2, new NumeroComplejo(3, 4.5));  
            
            
            assertEquals(CalculadoraMatricesComplejas.matrizAdjunta(m1), adjunta);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    @Test
    public void deberiaMultiplicarDosMatrices(){
        
        MatrizCompleja m1 = new MatrizCompleja(3, 2);                     
        MatrizCompleja m2 = new MatrizCompleja(2, 2);
        
        MatrizCompleja resultado = new MatrizCompleja(3, 2);
        
        try{
            m1.addComplex(0, 0, new NumeroComplejo(4, 5));
            m1.addComplex(0, 1, new NumeroComplejo(1, 0));
            m1.addComplex(1, 0, new NumeroComplejo(0, 0));
            m1.addComplex(1, 1, new NumeroComplejo(6, -2));
            m1.addComplex(2, 0, new NumeroComplejo(-1, 0));
            m1.addComplex(2, 1, new NumeroComplejo(0, -1));            
            
            m2.addComplex(0, 0, new NumeroComplejo(1, -1));
            m2.addComplex(0, 1, new NumeroComplejo(0, -1));
            m2.addComplex(1, 0, new NumeroComplejo(0, 5));
            m2.addComplex(1, 1, new NumeroComplejo(0, 0));

            
            resultado.addComplex(0, 0, new NumeroComplejo(9, 6));
            resultado.addComplex(0, 1, new NumeroComplejo(5, -4));
            resultado.addComplex(1, 0, new NumeroComplejo(10, 30));
            resultado.addComplex(1, 1, new NumeroComplejo(0, 0));
            resultado.addComplex(2, 0, new NumeroComplejo(4, 1));
            resultado.addComplex(2, 1, new NumeroComplejo(0, 1));    
            
            
            assertEquals(CalculadoraMatricesComplejas.productoDeMatrices(m1, m2), resultado);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
    }
    
    
    
    /**
     * No se deberian multiplicar porque la matriz 1 es de tamaño 2x2, y la matriz 2 es de tamaño 1x2
     */
    @Test
    public void noDeberiaMultiplicarDosMatrices() {

        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja m2 = new MatrizCompleja(1, 2);
        

        try {
            
            m1.addComplex(0, 0, new NumeroComplejo(1, 1));
            m1.addComplex(0, 1, new NumeroComplejo(2, 2));
            m1.addComplex(1, 0, new NumeroComplejo(3, 3));
            m1.addComplex(1, 1, new NumeroComplejo(4, 4));
            
            m2.addComplex(0, 0, new NumeroComplejo(1, 1));
            m2.addComplex(0, 1, new NumeroComplejo(1, 1));

            CalculadoraMatricesComplejas.productoDeMatrices(m1, m2);
        } catch (ComplexException e) {
            assertEquals(e.getMessage(),(ComplexException.NO_SE_PUEDEN_MULTIPLICAR));
        }

    }
    
    
    
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

    	
    }
    

}
