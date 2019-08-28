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
    public void noDeberiaSumarUnVectorConUnaMatriz() throws ComplexException{
    }
    
    
    @Test
    public void deberiaSumarDosMatrices(){

        MatrizCompleja m1 = new MatrizCompleja(2,2);
        MatrizCompleja m2 = new MatrizCompleja(2,2);
        
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

        MatrizCompleja m1 = new MatrizCompleja(2,2);
        MatrizCompleja m2 = new MatrizCompleja(2,1);
        
        

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

        MatrizCompleja m1 = new MatrizCompleja(2,2);
        MatrizCompleja m2 = new MatrizCompleja(2,2);
        
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
        
        MatrizCompleja m1 = new MatrizCompleja(2,2);
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
    

}
