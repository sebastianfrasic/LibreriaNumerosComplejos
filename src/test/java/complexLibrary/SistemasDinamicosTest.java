
package complexLibrary;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import complexLibrary.dinamicas.CalculadoraDinamica;
import complexLibrary.dinamicas.Sistema;
import complexLibrary.dinamicas.TipoSistema;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

/**
 *
 * @author juans
 */
public class SistemasDinamicosTest {
    
    @Test
    public void laMatrizDeberiaSerDeDinamicaClasica() throws ComplexException{
        MatrizCompleja matriz = new MatrizCompleja(2, 2);
        
        matriz.addComplex(0, 0, new NumeroComplejo(1, 0));
        matriz.addComplex(0, 1, new NumeroComplejo(0, 0));
        matriz.addComplex(1, 0, new NumeroComplejo(0, 0));
        matriz.addComplex(1, 1, new NumeroComplejo(0, 0));
        
        boolean esClasica;        
        esClasica = matriz.esDeDinamicaClasica();
        assertTrue(esClasica);
        
    }
    
    @Test
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica() throws ComplexException{
        MatrizCompleja matriz = new MatrizCompleja(3, 3);
        
        matriz.addComplex(0, 0, new NumeroComplejo(0, 0));
        matriz.addComplex(0, 1, new NumeroComplejo((double)1/6, 0));
        matriz.addComplex(0, 2, new NumeroComplejo((double)5/6, 0));
        matriz.addComplex(1, 0, new NumeroComplejo((double)1/3, 0));
        matriz.addComplex(1, 1, new NumeroComplejo((double)1/2, 0));
        matriz.addComplex(1, 2, new NumeroComplejo((double)1/6, 0));
        matriz.addComplex(2, 0, new NumeroComplejo((double)2/3, 0));
        matriz.addComplex(2, 1, new NumeroComplejo((double)1/3, 0));
        matriz.addComplex(2, 2, new NumeroComplejo(0, 0));
        
        
        boolean esDoblementeEstocastica;
        esDoblementeEstocastica = matriz.esDeDinamicaDoblementeEstocastica();
        assertTrue(esDoblementeEstocastica);
        
    }    
    
    @Test
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica2() throws ComplexException{
        MatrizCompleja matriz = new MatrizCompleja(3, 1);
        
        matriz.addComplex(0, 0, new NumeroComplejo(0.3333333333333334, 0));
        matriz.addComplex(1, 0, new NumeroComplejo(0.2666666666666666, 0));
        matriz.addComplex(2, 0, new NumeroComplejo(0.4, 0));

        boolean esDoblementeEstocastica;
        esDoblementeEstocastica = matriz.esDeDinamicaDoblementeEstocastica();
        assertTrue(esDoblementeEstocastica);
        
    }      
    
    
    @Test
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica3() throws ComplexException{
        MatrizCompleja matriz = new MatrizCompleja(1, 3);
        
        matriz.addComplex(0, 0, new NumeroComplejo(0.3333333333333334, 0));
        matriz.addComplex(0, 1, new NumeroComplejo(0.2666666666666666, 0));
        matriz.addComplex(0, 2, new NumeroComplejo(0.4, 0));
        
        boolean esDoblementeEstocastica;
        esDoblementeEstocastica = matriz.esDeDinamicaDoblementeEstocastica();
        assertTrue(esDoblementeEstocastica);
        
    }  
    
    @Test
    public void deberiaRealizarSistemaConDinamicaDeterminista() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);        
        MatrizCompleja matrizDinamica = new MatrizCompleja(6, 6);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 2019;
        
        try{
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(1, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0, 0));
            
            
            vectorInicial.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(1, 0));	

            matrizDinamica.addComplex(0, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(1, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 3, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(1, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(2, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 1, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(2, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 5, new NumeroComplejo(1, 0));

            matrizDinamica.addComplex(3, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 2, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(3, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(4, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 4, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(4, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(5, 0, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(5, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 5, new NumeroComplejo(0, 0));
            
            //System.out.println("Con " + numeroDeClicks + " clicks: \n" );
            //System.out.println(Simulador.sistemaConDinamicaDeterminista(matrizDinamica, vectorInicial, numeroDeClicks));
            assertEquals(vectorFinal, CalculadoraDinamica.calcularDinamica(TipoSistema.CLASICO, matrizDinamica, vectorInicial, numeroDeClicks).getVectorEstadoFinal());
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }
	
	
    @Test
    public void deberiaRealizarSistemaConDinamicaDeterminista1() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);        
        MatrizCompleja matrizDinamica = new MatrizCompleja(6, 6);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 3000;
        
        try{
            
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(6, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(9, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0, 0));
            
            vectorInicial.addComplex(0, 0, new NumeroComplejo(6, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(5, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(3, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(1, 0));	

            matrizDinamica.addComplex(0, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(1, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 3, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(1, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(2, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 1, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(2, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 5, new NumeroComplejo(1, 0));

            matrizDinamica.addComplex(3, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 2, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(3, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(4, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 4, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(4, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(5, 0, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(5, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 5, new NumeroComplejo(0, 0));
            
            //System.out.println(Simulador.sistemaConDinamicaDeterminista(matrizDinamica, vectorInicial, numeroDeClicks));
            //System.out.println(vectorFinal);
            assertEquals(vectorFinal, CalculadoraDinamica.calcularDinamica(TipoSistema.CLASICO, matrizDinamica, vectorInicial, numeroDeClicks).getVectorEstadoFinal());
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }	
    
   
	
	
    @Test
    public void deberiaRealizarSistemaConDinamicaDeterminista2() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);        
        MatrizCompleja matrizDinamica = new MatrizCompleja(6, 6);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 3000;
        
        try{
            
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(6, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(9, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0, 0));
            
            vectorInicial.addComplex(0, 0, new NumeroComplejo(6, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(5, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(3, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(1, 0));	

            matrizDinamica.addComplex(0, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(0, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(1, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 3, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(1, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(1, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(2, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 1, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(2, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 5, new NumeroComplejo(1, 0));

            matrizDinamica.addComplex(3, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 2, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(3, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(3, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(4, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(4, 4, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(4, 5, new NumeroComplejo(0, 0));

            matrizDinamica.addComplex(5, 0, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(5, 1, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 2, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 3, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 4, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(5, 5, new NumeroComplejo(0, 0));
            
            
            //System.out.println(Simulador.sistemaConDinamicaDeterminista(matrizDinamica, vectorInicial, numeroDeClicks));
            //System.out.println(vectorFinal);
            assertEquals(vectorFinal, CalculadoraDinamica.calcularDinamica(TipoSistema.CLASICO, matrizDinamica, vectorInicial, numeroDeClicks).getVectorEstadoFinal());
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    } 
    
    @Test
    public void deberiaCalcularElVectorEstocasticoAsociado() {
    	MatrizCompleja prueba = new MatrizCompleja(3, 1);
		try {
			prueba.addComplex(0, 0, new NumeroComplejo((double)1/(Math.sqrt(3)), 0));
			prueba.addComplex(1, 0, new NumeroComplejo(0, (double)2/(Math.sqrt(15))));
			prueba.addComplex(2, 0, new NumeroComplejo(Math.sqrt(2)/Math.sqrt(5), 0));
			
			//System.out.println("Matriz estocastica asociada: \n" + CalculadoraMatricesComplejas.matrizEstocasticaAsociada(prueba));
			//System.out.println("La prueba es estocastica? " + CalculadoraMatricesComplejas.matrizEstocasticaAsociada(prueba).esDeDinamicaDoblementeEstocastica());
			
		} catch (ComplexException e) {		
			e.printStackTrace();
		}

    }
    
    @Test
    public void deberiaCalcularDinamicaCuantica() {
    	MatrizCompleja matriz = new MatrizCompleja(2, 2);
    	MatrizCompleja estadoInicial = new MatrizCompleja(2, 1);
		try {
			matriz.addComplex(0, 0, new NumeroComplejo((double)1/(Math.sqrt(2)), 0));
			matriz.addComplex(0, 1, new NumeroComplejo(0, (double)1/(Math.sqrt(2))));
			matriz.addComplex(1, 0, new NumeroComplejo((double)1/(Math.sqrt(2)), 0));
			matriz.addComplex(1, 1, new NumeroComplejo(0, (double)-1/(Math.sqrt(2))));
			
			System.out.println(matriz);
			
			estadoInicial.addComplex(0, 0, new NumeroComplejo(1, 0));
			estadoInicial.addComplex(1, 0, new NumeroComplejo(0, 0));

			
			System.out.println(matriz.esDeDinamicaCuantica());
			
			Sistema respuesta = CalculadoraDinamica.calcularDinamica(TipoSistema.CUANTICO, matriz, estadoInicial, 1);
			System.out.println(respuesta);
			
		
			
		} catch (ComplexException e) {		
			e.printStackTrace();
		}

    }
}
