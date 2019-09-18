package complexLibrary;

import complexLibrary.dinamicas.*;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;
import static org.junit.Assert.*;

public class Quiz {
    
    
    @Test
    public void xd() {
        MatrizCompleja A = new MatrizCompleja(3, 3);
    	MatrizCompleja V = new MatrizCompleja(3, 1);
        
        try{
            A.addComplex(0, 0, new NumeroComplejo(0, 0));
            A.addComplex(0, 1, new NumeroComplejo((double)1/6, 0));
            A.addComplex(0, 2, new NumeroComplejo((double)5/6, 0));
            A.addComplex(1, 0, new NumeroComplejo((double)1/3, 0));
            A.addComplex(1, 1, new NumeroComplejo((double)1/2, 0));
            A.addComplex(1, 2, new NumeroComplejo((double)1/6, 0));
            A.addComplex(2, 0, new NumeroComplejo((double)2/3, 0));
            A.addComplex(2, 1, new NumeroComplejo((double)1/3, 0));
            A.addComplex(2, 2, new NumeroComplejo(0, 0));
            
            V.addComplex(0, 0, new NumeroComplejo((double)1/5, 0));
            V.addComplex(1, 0, new NumeroComplejo((double)7/10, 0));
            V.addComplex(2, 0, new NumeroComplejo((double)1/10, 0));
            
            System.out.println(Clasico.determinista(A, V, 4));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    @Test
    public void xdd() {
        MatrizCompleja A = new MatrizCompleja(2, 2);
    	MatrizCompleja V = new MatrizCompleja(2, 1);
        
        try{
            A.addComplex(0, 0, new NumeroComplejo((double)1/Math.sqrt(2), 0));
            A.addComplex(0, 1, new NumeroComplejo(0, (double)1/Math.sqrt(2)));
            
            A.addComplex(1, 0, new NumeroComplejo((double)1/Math.sqrt(2), 0));
            A.addComplex(1, 1, new NumeroComplejo(0, (double)-1/Math.sqrt(2)));
            
            V.addComplex(0, 0, new NumeroComplejo((double)1, 0));
            V.addComplex(1, 0, new NumeroComplejo((double)0, 0));
            
            
            System.out.println(Clasico.determinista(A, V, 1));
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    /**
     * ¿Es la matriz compleja una matriz unitaria?  ---- True
     */
    @Test
    public void deberiaSerUnitaria() {
    	
    	MatrizCompleja m1 = new MatrizCompleja(2, 2);
    	MatrizCompleja m2 = new MatrizCompleja(2, 2);
        try {

            m1.addComplex(0, 0, new NumeroComplejo(0, 0));
            m1.addComplex(0, 1, new NumeroComplejo(1, 0));
            m1.addComplex(1, 0, new NumeroComplejo(1, 0));
            m1.addComplex(1, 1, new NumeroComplejo(0, 0));

            m2.addComplex(0, 0, new NumeroComplejo(1/(Math.sqrt(2)), 0));
            m2.addComplex(0, 1, new NumeroComplejo(1/(Math.sqrt(2)), 0));
            m2.addComplex(1, 0, new NumeroComplejo(1/(Math.sqrt(2)), 0));
            m2.addComplex(1, 1, new NumeroComplejo(-1/(Math.sqrt(2)), 0));

            System.out.println("Producto tensor: " + CalculadoraMatricesComplejas.productoTensor(m1, m2));
            System.out.println("Es unitaria: " + CalculadoraMatricesComplejas.esUnitaria(m1));
            System.out.println("Es hermitiana: " + CalculadoraMatricesComplejas.esHermitiana(m1));
            //assertTrue(CalculadoraMatricesComplejas.esUnitaria(m1));
            //assertTrue(CalculadoraMatricesComplejas.esHermitiana(m1));

        } catch (ComplexException e) {
                e.printStackTrace();
        }    	  
    }
    
    

}
