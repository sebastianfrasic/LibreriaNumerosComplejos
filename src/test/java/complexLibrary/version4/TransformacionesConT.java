package complexLibrary.version4;

import complexLibrary.cuantica.CalculadoraCuantica;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import org.junit.Test;

import java.util.ArrayList;

import static complexLibrary.cuantica.CalculadoraCuantica.*;
import static complexLibrary.matricesComplejas.CalculadoraMatricesComplejas.*;
import static org.junit.Assert.assertTrue;

public class TransformacionesConT {

    @Test
    public void ketUp() {
        double parametro1 = 0;
        double parametro2 = 0;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);


            ket.addComplex(0, 0, new NumeroComplejo(1, 0));
            ket.addComplex(1, 0, new NumeroComplejo(0, 0));
            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            //System.out.println(ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket up: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ketDown() {
        double parametro1 = 90;
        double parametro2 = 0;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);
            ket.addComplex(0, 0, new NumeroComplejo(0, 0));
            ket.addComplex(1, 0, new NumeroComplejo(1, 0));
            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket down: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void ketIn() {
        double parametro1 = 45;
        double parametro2 = 90;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);
            ket.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            ket.addComplex(1, 0, new NumeroComplejo(0, 1 / (Math.sqrt(2))));
            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket in: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ketOut() {
        double parametro1 = 45;
        double parametro2 = -90;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);
            ket.addComplex(0, 0, new NumeroComplejo(0, 1 / (Math.sqrt(2))));
            ket.addComplex(1, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));

            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket out: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ketMas() {
        double parametro1 = 45;
        double parametro2 = 0;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);
            ket.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            ket.addComplex(1, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));

            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket mas: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ketMenos() {
        double parametro1 = 45;
        double parametro2 = 180;
        try {
            MatrizCompleja ket = new MatrizCompleja(2, 1);
            ket.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            ket.addComplex(1, 0, new NumeroComplejo(-1 / (Math.sqrt(2)), 0));

            ket = productoDeMatricesSinRedondear(crearMatrizT(), ket);
            ArrayList<Double> respuesta = ketAEsferaDeBloch(ket);
            System.out.println("Ket menos: ");
            System.out.println(respuesta);
            //assertTrue(parametro1 == respuesta.get(0) && parametro2 == respuesta.get(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
