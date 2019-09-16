package complexLibrary;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;
import static org.junit.Assert.*;

public class Quiz {

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
