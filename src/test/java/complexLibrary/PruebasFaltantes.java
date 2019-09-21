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
public class PruebasFaltantes {    


	
    /*
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

            //assertEquals(vectorFinal, SistemaClasicoDeterminista.deterministaConEnsamble(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }
    
    @Test
    public void deberiaRealizarSistemaConDinamicaCuantica() {

        MatrizCompleja vectorInicial = new MatrizCompleja(3, 1);        
        MatrizCompleja matrizDinamica = new MatrizCompleja(3, 3);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 4;
        
        try{
            
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(6, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(4, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(9, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(2, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0, 0));
            
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

            assertEquals(vectorFinal, CalculadoraDinamica.CalcularDinamica(TipoSistema.CUANTICO, matrizDinamica, vectorInicial, numeroDeClicks).getVectorEstadoFinal());
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }    */
    
    
    /*	
    @Test
    public void deberiaRealizarSistemaConDinamicaEstocastica() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);
        MatrizCompleja matrizPosicion = new MatrizCompleja(3, 3);
        MatrizCompleja matrizPersonalidad = new MatrizCompleja(2, 2);        
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 4;
        
        try{
            vectorFinal.addComplex(0, 0, new NumeroComplejo(0.2401920438957476, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(0.23665980795610425, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(0.156241426611797, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(0.15394375857338818, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(0.10727023319615911, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0.10569272976680383, 0));
            
            
            
            vectorInicial.addComplex(0, 0, new NumeroComplejo(0.8, 0));
            vectorInicial.addComplex(1, 0, new NumeroComplejo(0.2, 0));
            vectorInicial.addComplex(2, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(3, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(4, 0, new NumeroComplejo(0, 0));
            vectorInicial.addComplex(5, 0, new NumeroComplejo(0, 0));	

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

            //System.out.println("Con " + numeroDeClicks + " clicks: \n" );
            System.out.println(Clasico.deterministaConEnsamble(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
            
            assertEquals(vectorFinal, Clasico.deterministaConEnsamble(matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }*/
}
