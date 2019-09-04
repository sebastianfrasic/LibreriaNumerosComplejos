package complexLibrary;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;
import static org.junit.Assert.*;



public class MatricesComplejasTest {

	//Pruebas Minimas
	
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
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
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
    
    
    /**
     *  Acción de matriz compleja sobre vector complejo
     * @throws ComplexException Si m1 y m2 no son vectores
     */
    @Test
    public void deberiaCalcularLaAccionDeUnaMatrizSobreUnVectorComplejo() throws ComplexException{
        
        MatrizCompleja m1 = new MatrizCompleja(3, 3);                     
        MatrizCompleja m2 = new MatrizCompleja(3, 1);
        
        MatrizCompleja resultado = new MatrizCompleja(3, 1);
        
        if(m1.isVector() || m2.isVector() ){
        	try{
                m1.addComplex(0, 0, new NumeroComplejo(-1, 5));
                m1.addComplex(0, 1, new NumeroComplejo(1, -7));
                m1.addComplex(0, 2, new NumeroComplejo(-6, 3));
                m1.addComplex(1, 0, new NumeroComplejo(-3, -9));
                m1.addComplex(1, 1, new NumeroComplejo(2, -5));
                m1.addComplex(1, 2, new NumeroComplejo(1, -10));
                m1.addComplex(2, 0, new NumeroComplejo(-6, 5));
                m1.addComplex(2, 1, new NumeroComplejo(6, -5));
                m1.addComplex(2, 2, new NumeroComplejo(3, -2));            
                
                m2.addComplex(0, 0, new NumeroComplejo(1, -3));
                m2.addComplex(1, 0, new NumeroComplejo(4, 3));
                m2.addComplex(2, 0, new NumeroComplejo(-3, 1));

                
                resultado.addComplex(0, 0, new NumeroComplejo(54, -32));
                resultado.addComplex(1, 0, new NumeroComplejo(0, 17));
                resultado.addComplex(2, 0, new NumeroComplejo(41, 30));                      
                
                assertEquals(CalculadoraMatricesComplejas.productoDeMatrices(m1, m2), resultado);
                
            }catch(ComplexException e){
                e.printStackTrace();
            }
                     
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }
        
        
    }
    
    
    /**
     *  Producto interno de vectores complejos
     * @throws ComplexException Si lo que se ingresa no es un vector.
     */
    @Test
    public void deberiaCalcularElProductoInternoDeUnVector() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);                        
        MatrizCompleja vector2 = new MatrizCompleja(3, 1);
        MatrizCompleja respuesta = new MatrizCompleja(1, 1);
        
        if(vector1.isVector() && vector2.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(2, -1));
                vector1.addComplex(1, 0, new NumeroComplejo(-8, -5));
                vector1.addComplex(2, 0, new NumeroComplejo(-2, -6));

                vector2.addComplex(0, 0, new NumeroComplejo(6, -3));
                vector2.addComplex(1, 0, new NumeroComplejo(5, -1));
                vector2.addComplex(2, 0, new NumeroComplejo(-6, -2));
                
                respuesta.addComplex(0, 0, new NumeroComplejo(4, 1));
                
                assertEquals(CalculadoraMatricesComplejas.productoInterno(vector1, vector2), respuesta);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    
    /**
     *  Norma de vector complejo
     * @throws ComplexException Si lo que se ingresa no es un vector.
     */
    @Test
    public void deberiaCalcularLaNormaDeUnVector() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);                        
        double respuesta = 10.0;
        
        if(vector1.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(4, 5));
                vector1.addComplex(1, 0, new NumeroComplejo(3, 1));
                vector1.addComplex(2, 0, new NumeroComplejo(0, -7));
                
                assertEquals(CalculadoraMatricesComplejas.norma(vector1), respuesta, 0);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    /**
     *  Distancia entre dos vectores complejos
     * @throws ComplexException Si lo que se ingresa no es un vector.
     */
    @Test
    public void deberiaCalcularLaDistanciaEntreDosVectores() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);  
        MatrizCompleja vector2 = new MatrizCompleja(3, 1);  
        double respuesta = 12;
        
        if(vector1.isVector() && vector2.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(2, 7));
                vector1.addComplex(1, 0, new NumeroComplejo(4, -1));
                vector1.addComplex(2, 0, new NumeroComplejo(2, -4));
                
                vector2.addComplex(0, 0, new NumeroComplejo(7, 8));
                vector2.addComplex(1, 0, new NumeroComplejo(2, -8));
                vector2.addComplex(2, 0, new NumeroComplejo(1, 4));                
                
                assertEquals(CalculadoraMatricesComplejas.distancia(vector1, vector2), respuesta, 0);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    /**
     *  Distancia entre dos vectores complejos
     * @throws ComplexException Si lo que se ingresa no es un vector.
     */
    @Test
    public void deberiaCalcularLaDistanciaEntreDosVectores2() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(2, 1);  
        MatrizCompleja vector2 = new MatrizCompleja(2, 1);  
        double respuesta = Math.sqrt(50);
        
        if(vector1.isVector() && vector2.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(9, -7));
                vector1.addComplex(1, 0, new NumeroComplejo(-1, -6));                
                
                vector2.addComplex(0, 0, new NumeroComplejo(7, -8));
                vector2.addComplex(1, 0, new NumeroComplejo(5, -9));
                
                assertEquals(CalculadoraMatricesComplejas.distancia(vector1, vector2), respuesta, 0);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    
    /**
     * ¿Es la matriz compleja una matriz unitaria?  ----> True
     */
    @Test
    public void deberiaSerUnitaria() {
    	
    	MatrizCompleja m1 = new MatrizCompleja(2, 2);
		try {
			m1.addComplex(0, 0, new NumeroComplejo(1/(Math.sqrt(2)), 0));
			m1.addComplex(0, 1, new NumeroComplejo(0, 1/(Math.sqrt(2))));
			m1.addComplex(1, 0, new NumeroComplejo(0, 1/(Math.sqrt(2))));
			m1.addComplex(1, 1, new NumeroComplejo(1/(Math.sqrt(2)), 0));

			assertTrue(CalculadoraMatricesComplejas.esUnitaria(m1));

		} catch (ComplexException e) {
			e.printStackTrace();
		}    	  
    }
    
 
    /**
     * ¿Es la matriz compleja una matriz unitaria?  ----> False
     */
    @Test
    public void noDeberiaSerUnitaria() {
    	
    	MatrizCompleja m1 = new MatrizCompleja(3, 3);
		try {
			m1.addComplex(0, 0, new NumeroComplejo(0, 1));
			m1.addComplex(0, 1, new NumeroComplejo(1, 0));
			m1.addComplex(0, 2, new NumeroComplejo(0, 0));
			m1.addComplex(1, 0, new NumeroComplejo(0, 0));
			m1.addComplex(1, 1, new NumeroComplejo(0, 1));
			m1.addComplex(1, 2, new NumeroComplejo(1, 0));
			m1.addComplex(2, 0, new NumeroComplejo(1, 0));
			m1.addComplex(2, 1, new NumeroComplejo(0, 0));
			m1.addComplex(2, 2, new NumeroComplejo(0, 1));

			assertFalse(CalculadoraMatricesComplejas.esUnitaria(m1));

		} catch (ComplexException e) {
			e.printStackTrace();
		}    	  
    }    
    
    
    
    /**
     *  ¿Es la matriz compleja una matriz hermitiana? ---> True
     */
    @Test
    public void deberiaSerHermitiana() {
    	MatrizCompleja m1 = new MatrizCompleja(3, 3);
    	
        try {
            m1.addComplex(0, 0, new NumeroComplejo(3, 0));
            m1.addComplex(0, 1, new NumeroComplejo(2, -1));
            m1.addComplex(0, 2, new NumeroComplejo(0, -3));
            m1.addComplex(1, 0, new NumeroComplejo(2, 1));
            m1.addComplex(1, 1, new NumeroComplejo(0, 0));
            m1.addComplex(1, 2, new NumeroComplejo(1, -1));
            m1.addComplex(2, 0, new NumeroComplejo(0, 3));
            m1.addComplex(2, 1, new NumeroComplejo(1, 1));
            m1.addComplex(2, 2, new NumeroComplejo(0, 0)); 
            
            assertTrue(CalculadoraMatricesComplejas.esHermitiana(m1));
	    
            } catch (ComplexException e) {
                e.printStackTrace();                
            }

    	
    }
    
    /**
     *  ¿Es la matriz compleja una matriz hermitiana? ---> False
     */
    @Test
    public void noDeberiaSerHermitiana() {
    	MatrizCompleja A = new MatrizCompleja(2, 2);
    	
        try {
            A.addComplex(0, 0, new NumeroComplejo(1, 0));
            A.addComplex(0, 1, new NumeroComplejo(3, -1));
            A.addComplex(1, 0, new NumeroComplejo(3, 1));
            A.addComplex(1, 1, new NumeroComplejo(0, 1));
	        
            assertFalse(CalculadoraMatricesComplejas.esHermitiana(A));
	        
            } catch (ComplexException e) {
                e.printStackTrace();
            }

    	
    }   
	
	
    
    
    
    
    //Pruebas adicionales
    
    @Test
    public void deberiaSumarDosVectores2() throws ComplexException{

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
    public void deberiaSumarDosMatrices2(){

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
    public void deberiaCalcularLaMatrizTranspuesta2(){
        
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
    public void deberiaCalcularLaMatrizConjugada2(){
        
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
    public void deberiaCalcularLaMatrizAdjunta2(){
        
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
    public void deberiaMultiplicarDosMatrices2(){
        
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
    public void noDeberiaMultiplicarDosMatrices2() {

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
    public void deberiaCalcularElProductoInternoDeUnVector2() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(2, 1);                        
        MatrizCompleja vector2 = new MatrizCompleja(2, 1);
        MatrizCompleja respuesta = new MatrizCompleja(1, 1);
        
        if(vector1.isVector() && vector2.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(1, 1));
                vector1.addComplex(1, 0, new NumeroComplejo(3, 0));                

                vector2.addComplex(0, 0, new NumeroComplejo(1, 1));
                vector2.addComplex(1, 0, new NumeroComplejo(0, 1));                
                
                respuesta.addComplex(0, 0, new NumeroComplejo(2, 3));
                
                assertEquals(CalculadoraMatricesComplejas.productoInterno(vector1, vector2), respuesta);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    @Test
    public void deberiaCalcularElProductoInternoDeUnVector3() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(2, 1);                        
        MatrizCompleja vector2 = new MatrizCompleja(2, 1);
        MatrizCompleja respuesta = new MatrizCompleja(1, 1);
        
        if(vector1.isVector() && vector2.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(1, 1));
                vector1.addComplex(1, 0, new NumeroComplejo(3, 0));                

                vector2.addComplex(0, 0, new NumeroComplejo(1, 1));
                vector2.addComplex(1, 0, new NumeroComplejo(0, 1));                
                
                respuesta.addComplex(0, 0, new NumeroComplejo(2, -3));
                
                assertEquals(CalculadoraMatricesComplejas.productoInterno(vector2, vector1), respuesta);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    @Test
    public void deberiaCalcularElProductoInternoDeUnVector4() throws ComplexException {

        MatrizCompleja vector1 = new MatrizCompleja(3, 1);                        
        NumeroComplejo numero = new NumeroComplejo(100, 0);
        double respuesta = numero.getParteReal();
        
        if(vector1.isVector()){
            try{
                vector1.addComplex(0, 0, new NumeroComplejo(4, 5));
                vector1.addComplex(1, 0, new NumeroComplejo(3, 1)); 
                vector1.addComplex(2, 0, new NumeroComplejo(0, -7));                                    
                               
                assertEquals(CalculadoraMatricesComplejas.productoInterno(vector1, vector1, true), respuesta, 0);
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            
        }else{
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }
    
    
    @Test
    public void deberiaSerHermitiana2() {
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
    public void noDeberiaSerHermitiana2() {
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
