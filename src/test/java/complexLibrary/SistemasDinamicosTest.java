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
    public void laMatrizDeberiaSerDeDinamicaClasica() throws ComplexException {
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
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica() throws ComplexException {
        MatrizCompleja matriz = new MatrizCompleja(3, 3);

        matriz.addComplex(0, 0, new NumeroComplejo(0, 0));
        matriz.addComplex(0, 1, new NumeroComplejo((double) 1 / 6, 0));
        matriz.addComplex(0, 2, new NumeroComplejo((double) 5 / 6, 0));
        matriz.addComplex(1, 0, new NumeroComplejo((double) 1 / 3, 0));
        matriz.addComplex(1, 1, new NumeroComplejo((double) 1 / 2, 0));
        matriz.addComplex(1, 2, new NumeroComplejo((double) 1 / 6, 0));
        matriz.addComplex(2, 0, new NumeroComplejo((double) 2 / 3, 0));
        matriz.addComplex(2, 1, new NumeroComplejo((double) 1 / 3, 0));
        matriz.addComplex(2, 2, new NumeroComplejo(0, 0));

        boolean esDoblementeEstocastica;
        esDoblementeEstocastica = matriz.esDeDinamicaDoblementeEstocastica();
        assertTrue(esDoblementeEstocastica);

    }

    @Test
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica2() throws ComplexException {
        MatrizCompleja matriz = new MatrizCompleja(3, 1);

        matriz.addComplex(0, 0, new NumeroComplejo(0.3333333333333334, 0));
        matriz.addComplex(1, 0, new NumeroComplejo(0.2666666666666666, 0));
        matriz.addComplex(2, 0, new NumeroComplejo(0.4, 0));

        boolean esDoblementeEstocastica;
        esDoblementeEstocastica = matriz.esDeDinamicaDoblementeEstocastica();
        assertTrue(esDoblementeEstocastica);

    }

    @Test
    public void laMatrizDeberiaSerDeDinamicaDoblementeEstocastica3() throws ComplexException {
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

        try {
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

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaRealizarSistemaConDinamicaDeterminista1() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);
        MatrizCompleja matrizDinamica = new MatrizCompleja(6, 6);
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 3000;

        try {

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

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaRealizarSistemaConDinamicaDeterminista2() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);
        MatrizCompleja matrizDinamica = new MatrizCompleja(6, 6);
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 3000;

        try {

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

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaRealizarSistemaConDinamicaEstocastica() {

        MatrizCompleja v1 = new MatrizCompleja(3, 1);
        MatrizCompleja v2 = new MatrizCompleja(2, 1);
        MatrizCompleja matrizPosicion = new MatrizCompleja(3, 3);
        MatrizCompleja matrizPersonalidad = new MatrizCompleja(2, 2);
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 2;

        try {

            v1.addComplex(0, 0, new NumeroComplejo(0.01, 0));
            v1.addComplex(1, 0, new NumeroComplejo(0.9, 0));
            v1.addComplex(2, 0, new NumeroComplejo(0.09, 0));

            v2.addComplex(0, 0, new NumeroComplejo(0.05, 0));
            v2.addComplex(1, 0, new NumeroComplejo(0.95, 0));

            vectorFinal.addComplex(0, 0, new NumeroComplejo(0.15012499999999998, 0));
            vectorFinal.addComplex(1, 0, new NumeroComplejo(0.1834861111111111, 0));
            vectorFinal.addComplex(2, 0, new NumeroComplejo(0.16212499999999996, 0));
            vectorFinal.addComplex(3, 0, new NumeroComplejo(0.19815277777777776, 0));
            vectorFinal.addComplex(4, 0, new NumeroComplejo(0.13774999999999996, 0));
            vectorFinal.addComplex(5, 0, new NumeroComplejo(0.1683611111111111, 0));

            matrizPosicion.addComplex(0, 0, new NumeroComplejo(0, 0));
            matrizPosicion.addComplex(0, 1, new NumeroComplejo((double) 1 / 6, 0));
            matrizPosicion.addComplex(0, 2, new NumeroComplejo((double) 5 / 6, 0));

            matrizPosicion.addComplex(1, 0, new NumeroComplejo((double) 1 / 3, 0));
            matrizPosicion.addComplex(1, 1, new NumeroComplejo((double) 1 / 2, 0));
            matrizPosicion.addComplex(1, 2, new NumeroComplejo((double) 1 / 6, 0));

            matrizPosicion.addComplex(2, 0, new NumeroComplejo((double) 2 / 3, 0));
            matrizPosicion.addComplex(2, 1, new NumeroComplejo((double) 1 / 3, 0));
            matrizPosicion.addComplex(2, 2, new NumeroComplejo(0, 0));

            matrizPersonalidad.addComplex(0, 0, new NumeroComplejo((double) 1 / 3, 0));
            matrizPersonalidad.addComplex(0, 1, new NumeroComplejo((double) 2 / 3, 0));

            matrizPersonalidad.addComplex(1, 0, new NumeroComplejo((double) 2 / 3, 0));
            matrizPersonalidad.addComplex(1, 1, new NumeroComplejo((double) 1 / 3, 0));

            MatrizCompleja respuesta = CalculadoraDinamica.calcularDinamicaConEnsamble(TipoSistema.ESTOCASTICO, matrizPosicion, v1, matrizPersonalidad, v2, numeroDeClicks);

            assertEquals(vectorFinal, respuesta);

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaRealizarSistemaConDinamicaEstocastica1() {

        MatrizCompleja vectorInicial = new MatrizCompleja(6, 1);
        MatrizCompleja matrizPosicion = new MatrizCompleja(3, 3);
        MatrizCompleja matrizPersonalidad = new MatrizCompleja(2, 2);
        MatrizCompleja vectorFinal = new MatrizCompleja(6, 1);
        int numeroDeClicks = 4;

        try {
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
            matrizPosicion.addComplex(0, 1, new NumeroComplejo((double) 1 / 6, 0));
            matrizPosicion.addComplex(0, 2, new NumeroComplejo((double) 5 / 6, 0));

            matrizPosicion.addComplex(1, 0, new NumeroComplejo((double) 1 / 3, 0));
            matrizPosicion.addComplex(1, 1, new NumeroComplejo((double) 1 / 2, 0));
            matrizPosicion.addComplex(1, 2, new NumeroComplejo((double) 1 / 6, 0));

            matrizPosicion.addComplex(2, 0, new NumeroComplejo((double) 2 / 3, 0));
            matrizPosicion.addComplex(2, 1, new NumeroComplejo((double) 1 / 3, 0));
            matrizPosicion.addComplex(2, 2, new NumeroComplejo(0, 0));

            matrizPersonalidad.addComplex(0, 0, new NumeroComplejo((double) 1 / 3, 0));
            matrizPersonalidad.addComplex(0, 1, new NumeroComplejo((double) 2 / 3, 0));

            matrizPersonalidad.addComplex(1, 0, new NumeroComplejo((double) 2 / 3, 0));
            matrizPersonalidad.addComplex(1, 1, new NumeroComplejo((double) 1 / 3, 0));

            MatrizCompleja respuesta = CalculadoraDinamica.calcularDinamicaConEnsamble(TipoSistema.ESTOCASTICO, matrizPosicion, matrizPersonalidad, vectorInicial, numeroDeClicks);

            assertEquals(vectorFinal, respuesta);

        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deberiaCalcularElVectorEstocasticoAsociado() {
        MatrizCompleja vector = new MatrizCompleja(3, 1);
        MatrizCompleja vectorEstocasticoAsociado = new MatrizCompleja(3, 1);
        try {
            vector.addComplex(0, 0, new NumeroComplejo((double) 1 / (Math.sqrt(3)), 0));
            vector.addComplex(1, 0, new NumeroComplejo(0, (double) 2 / (Math.sqrt(15))));
            vector.addComplex(2, 0, new NumeroComplejo(Math.sqrt(2) / Math.sqrt(5), 0));

            vectorEstocasticoAsociado.addComplex(0, 0, new NumeroComplejo(0.3333333333333334, 0));
            vectorEstocasticoAsociado.addComplex(1, 0, new NumeroComplejo(0.2666666666666666, 0));
            vectorEstocasticoAsociado.addComplex(2, 0, new NumeroComplejo(0.4, 0));

            //System.out.println("Matriz estocastica asociada: \n" + CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vector));
            //System.out.println("La vector es estocastica? " + CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vector).esDeDinamicaDoblementeEstocastica());
            assertEquals(vectorEstocasticoAsociado, CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vector));
        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deberiaCalcularDinamicaCuantica() {
        MatrizCompleja matriz = new MatrizCompleja(2, 2);
        MatrizCompleja estadoInicial = new MatrizCompleja(2, 1);
        MatrizCompleja estadoFinal = new MatrizCompleja(2, 1);
        try {
            matriz.addComplex(0, 0, new NumeroComplejo((double) 1 / (Math.sqrt(2)), 0));
            matriz.addComplex(0, 1, new NumeroComplejo(0, (double) 1 / (Math.sqrt(2))));
            matriz.addComplex(1, 0, new NumeroComplejo((double) 1 / (Math.sqrt(2)), 0));
            matriz.addComplex(1, 1, new NumeroComplejo(0, (double) -1 / (Math.sqrt(2))));

            estadoFinal.addComplex(0, 0, new NumeroComplejo(0.4999999999999999, 0));
            estadoFinal.addComplex(1, 0, new NumeroComplejo(0.4999999999999999, 0));

            estadoInicial.addComplex(0, 0, new NumeroComplejo(1, 0));
            estadoInicial.addComplex(1, 0, new NumeroComplejo(0, 0));

            Sistema respuesta = CalculadoraDinamica.calcularDinamica(TipoSistema.CUANTICO, matriz, estadoInicial, 1);

            assertEquals(estadoFinal, respuesta.getVectorEstadoFinal());

        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

}
