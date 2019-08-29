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
              
            }catch(ComplexException e){
                e.printStackTrace();
            }

            try{
                assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(vector1, vector2), respuesta);
            }catch(ComplexException ex){
                ex.printStackTrace();
            }
        }else{
            throw new ComplexException("No se puede sumar un vector con una matriz.");
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
            
            }catch(ComplexException e){
                e.printStackTrace();
            }            
            assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(v1, escalar), respuesta);
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
                        
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
        try{
            assertEquals(CalculadoraMatricesComplejas.sumaDeMatrices(m1,m2), respuesta);
        }catch(ComplexException ex){
            ex.printStackTrace();
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
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        
        assertEquals(CalculadoraMatricesComplejas.inversaDeUnaMatriz(m1), respuesta);
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
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        assertEquals(CalculadoraMatricesComplejas.productoPorEscalar(m1, escalar), respuesta);
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
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        assertEquals(CalculadoraMatricesComplejas.matrizTranspuesta(m1), transpuesta);
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
            
            System.out.println(CalculadoraMatricesComplejas.matrizConjugada(m1));
            System.out.println(conjugada);
            
        }catch(ComplexException e){
            e.printStackTrace();
        }
        assertEquals(CalculadoraMatricesComplejas.matrizConjugada(m1), conjugada);
    }
    
    

}
