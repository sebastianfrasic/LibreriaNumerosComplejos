package complexLibrary;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import complexLibrary.dinamicas.*;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Juan Sebastian Frasica G
 */
public class Version3Test {    	

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
            
            Clasico.calcularSistema(TipoSistema.CLASICO, matrizDinamica, vectorInicial, numeroDeClicks);
            
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
            
            System.out.println(Clasico.calcularSistema(TipoSistema.CLASICO, matrizDinamica, vectorInicial, numeroDeClicks));
            System.out.println(Clasico.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
            
            //System.out.println(Simulador.sistemaConDinamicaDeterminista(matrizDinamica, vectorInicial, numeroDeClicks));
            //System.out.println(vectorFinal);
            assertEquals(vectorFinal, Clasico.determinista(matrizDinamica, vectorInicial, numeroDeClicks));
        
        }catch(ComplexException e){
            e.printStackTrace();
        }            
    }
	
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
