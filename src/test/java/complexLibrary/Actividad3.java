/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package complexLibrary;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import complexLibrary.dinamicas.*;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Juan Sebastian Frasica G
 */
public class Actividad3 {
    
	

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
            assertEquals(vectorFinal, Clasico.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
        
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
            assertEquals(vectorFinal, Clasico.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }
	
	
    @Test
    public void deberiaRealizarSistemaConDinamicaEstocastica() {

        MatrizCompleja v1 = new MatrizCompleja(3, 1);
        MatrizCompleja v2 = new MatrizCompleja(2, 1);
        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);
        MatrizCompleja matrizPosicion = new MatrizCompleja(3, 3);
        MatrizCompleja matrizPersonalidad = new MatrizCompleja(2, 2);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 897894;
        
        try{
            
            v1.addComplex(0, 0, new NumeroComplejo(0.01, 0));
            v1.addComplex(1, 0, new NumeroComplejo(0.9, 0));
            v1.addComplex(2, 0, new NumeroComplejo(0.09, 0));
            
            v2.addComplex(0, 0, new NumeroComplejo(0.05, 0));
            v2.addComplex(1, 0, new NumeroComplejo(0.95, 0));
            
            vectorInicial = CalculadoraMatricesComplejas.productoTensor(v1, v2);
            System.out.println("Punto 1: \n");
            System.out.println(vectorInicial);
            
            /*
            vectorInicial.addComplex(0, 0, new NumeroComplejo(0.8, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(0.2, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(0, 0));	*/

            matrizPosicion.addComplex(0, 0, new NumeroComplejo(0, 0));
            matrizPosicion.addComplex(0, 1, new NumeroComplejo((double)1/6, 0));
            matrizPosicion.addComplex(0, 2, new NumeroComplejo((double)5/6, 0));

            matrizPosicion.addComplex(1, 0, new NumeroComplejo((double)1/3, 0));
            matrizPosicion.addComplex(1, 1, new NumeroComplejo((double)1/2, 0));
            matrizPosicion.addComplex(1, 2, new NumeroComplejo((double)1/6, 0));

            matrizPosicion.addComplex(2, 0, new NumeroComplejo((double)2/3, 0));
            matrizPosicion.addComplex(2, 1, new NumeroComplejo((double)1/3, 0));
            matrizPosicion.addComplex(2, 2, new NumeroComplejo(0, 0));


            matrizPersonalidad.addComplex(0, 0, new NumeroComplejo((double)1/3, 0));
            matrizPersonalidad.addComplex(0, 1, new NumeroComplejo((double)2/3, 0));

            matrizPersonalidad.addComplex(1, 0, new NumeroComplejo((double)2/3, 0));
            matrizPersonalidad.addComplex(1, 1, new NumeroComplejo((double)1/3, 0));
            
            
            System.out.println(Clasico.deterministaConEnsamble(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
            
            /*
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0.24000000000000002, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(0.23, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(0.16, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(0.16, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(0.1, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0.11, 0));*/

            //System.out.println("Con " + numeroDeClicks + " clicks: \n" );
            //System.out.println(Simulador.sistemaConDinamicaEstocastico(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
            
            //assertEquals(vectorFinal, SistemaClasicoDeterminista.deterministaConEnsamble(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }
    
    @Test
    public void deberiaRealizarSistemaConDinamicaCuantica() {

        MatrizCompleja vectorInicial = new MatrizCompleja(3, 1);        
        MatrizCompleja matrizDinamica = new MatrizCompleja(3, 3);        
        MatrizCompleja vectorFinal = new MatrizCompleja(3, 1);
        int numeroDeClicks = 4;
        
        try{
            /*
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(6, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(9, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0, 0));*/
            
            vectorInicial.addComplex(0, 0, new NumeroComplejo((double)1/Math.sqrt(3), 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(0, (double)2/Math.sqrt(15)));
            vectorInicial.addComplex(2, 0, new NumeroComplejo((double)Math.sqrt(2/5), 0));	

            matrizDinamica.addComplex(0, 0, new NumeroComplejo((double)1/Math.sqrt(2), 0));
            matrizDinamica.addComplex(0, 1, new NumeroComplejo((double)1/Math.sqrt(2), 0));
            matrizDinamica.addComplex(0, 2, new NumeroComplejo(0, 0));


            matrizDinamica.addComplex(1, 0, new NumeroComplejo(0, (double)-1/Math.sqrt(2)));
            matrizDinamica.addComplex(1, 1, new NumeroComplejo(0, (double)1/Math.sqrt(2)));
            matrizDinamica.addComplex(1, 2, new NumeroComplejo(0, 0));


            matrizDinamica.addComplex(2, 0, new NumeroComplejo(0, 0));
            matrizDinamica.addComplex(2, 1, new NumeroComplejo(1, 0));
            matrizDinamica.addComplex(2, 2, new NumeroComplejo(0, -1));

            
            System.out.println("Punto 8: \n");
            System.out.println(Clasico.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
            
            //System.out.println(Simulador.sistemaConDinamicaDeterminista(matrizDinamica, vectorInicial, numeroDeClicks));
            //System.out.println(vectorFinal);
            //assertEquals(vectorFinal, SistemaClasicoDeterminista.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }    
}
