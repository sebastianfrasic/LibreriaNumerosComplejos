package complexLibrary.cuantica;

import complexLibrary.dinamicas.Grafico;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

import static complexLibrary.matricesComplejas.CalculadoraMatricesComplejas.*;

public class Deutsch {


    public static MatrizCompleja crearHadamard() throws ComplexException {
        MatrizCompleja hadamard = new MatrizCompleja(2, 2);
        hadamard.addComplex(0, 0, new NumeroComplejo(1 / Math.sqrt(2), 0));
        hadamard.addComplex(0, 1, new NumeroComplejo(1 / Math.sqrt(2), 0));
        hadamard.addComplex(1, 0, new NumeroComplejo(1 / Math.sqrt(2), 0));
        hadamard.addComplex(1, 1, new NumeroComplejo(-1 / Math.sqrt(2), 0));

        return hadamard;
    }


    public static MatrizCompleja crearU0() throws ComplexException {
        MatrizCompleja U0 = new MatrizCompleja(4, 4);
        U0.addComplex(0, 0, new NumeroComplejo(1, 0));
        U0.addComplex(0, 1, new NumeroComplejo(0, 0));
        U0.addComplex(0, 2, new NumeroComplejo(0, 0));
        U0.addComplex(0, 3, new NumeroComplejo(0, 0));

        U0.addComplex(1, 0, new NumeroComplejo(0, 0));
        U0.addComplex(1, 1, new NumeroComplejo(1, 0));
        U0.addComplex(1, 2, new NumeroComplejo(0, 0));
        U0.addComplex(1, 3, new NumeroComplejo(0, 0));

        U0.addComplex(2, 0, new NumeroComplejo(0, 0));
        U0.addComplex(2, 1, new NumeroComplejo(0, 0));
        U0.addComplex(2, 2, new NumeroComplejo(1, 0));
        U0.addComplex(2, 3, new NumeroComplejo(0, 0));

        U0.addComplex(3, 0, new NumeroComplejo(0, 0));
        U0.addComplex(3, 1, new NumeroComplejo(0, 0));
        U0.addComplex(3, 2, new NumeroComplejo(0, 0));
        U0.addComplex(3, 3, new NumeroComplejo(1, 0));
        return U0;
    }

    public static MatrizCompleja crearU1() throws ComplexException {
        MatrizCompleja U1 = new MatrizCompleja(4, 4);
        U1.addComplex(0, 0, new NumeroComplejo(0, 0));
        U1.addComplex(0, 1, new NumeroComplejo(1, 0));
        U1.addComplex(0, 2, new NumeroComplejo(0, 0));
        U1.addComplex(0, 3, new NumeroComplejo(0, 0));

        U1.addComplex(1, 0, new NumeroComplejo(1, 0));
        U1.addComplex(1, 1, new NumeroComplejo(0, 0));
        U1.addComplex(1, 2, new NumeroComplejo(0, 0));
        U1.addComplex(1, 3, new NumeroComplejo(0, 0));

        U1.addComplex(2, 0, new NumeroComplejo(0, 0));
        U1.addComplex(2, 1, new NumeroComplejo(0, 0));
        U1.addComplex(2, 2, new NumeroComplejo(0, 0));
        U1.addComplex(2, 3, new NumeroComplejo(1, 0));

        U1.addComplex(3, 0, new NumeroComplejo(0, 0));
        U1.addComplex(3, 1, new NumeroComplejo(0, 0));
        U1.addComplex(3, 2, new NumeroComplejo(1, 0));
        U1.addComplex(3, 3, new NumeroComplejo(0, 0));

        return U1;
    }

    private static MatrizCompleja crearUi() throws ComplexException {
        MatrizCompleja Ui = new MatrizCompleja(4, 4);
        Ui.addComplex(0, 0, new NumeroComplejo(1, 0));
        Ui.addComplex(0, 1, new NumeroComplejo(0, 0));
        Ui.addComplex(0, 2, new NumeroComplejo(0, 0));
        Ui.addComplex(0, 3, new NumeroComplejo(0, 0));

        Ui.addComplex(1, 0, new NumeroComplejo(0, 0));
        Ui.addComplex(1, 1, new NumeroComplejo(1, 0));
        Ui.addComplex(1, 2, new NumeroComplejo(0, 0));
        Ui.addComplex(1, 3, new NumeroComplejo(0, 0));

        Ui.addComplex(2, 0, new NumeroComplejo(0, 0));
        Ui.addComplex(2, 1, new NumeroComplejo(0, 0));
        Ui.addComplex(2, 2, new NumeroComplejo(0, 0));
        Ui.addComplex(2, 3, new NumeroComplejo(1, 0));

        Ui.addComplex(3, 0, new NumeroComplejo(0, 0));
        Ui.addComplex(3, 1, new NumeroComplejo(0, 0));
        Ui.addComplex(3, 2, new NumeroComplejo(1, 0));
        Ui.addComplex(3, 3, new NumeroComplejo(0, 0));

        return Ui;
    }

    public static MatrizCompleja crearUc() throws ComplexException {
        MatrizCompleja Uc = new MatrizCompleja(4, 4);
        Uc.addComplex(0, 0, new NumeroComplejo(0, 0));
        Uc.addComplex(0, 1, new NumeroComplejo(1, 0));
        Uc.addComplex(0, 2, new NumeroComplejo(0, 0));
        Uc.addComplex(0, 3, new NumeroComplejo(0, 0));

        Uc.addComplex(1, 0, new NumeroComplejo(1, 0));
        Uc.addComplex(1, 1, new NumeroComplejo(0, 0));
        Uc.addComplex(1, 2, new NumeroComplejo(0, 0));
        Uc.addComplex(1, 3, new NumeroComplejo(0, 0));

        Uc.addComplex(2, 0, new NumeroComplejo(0, 0));
        Uc.addComplex(2, 1, new NumeroComplejo(0, 0));
        Uc.addComplex(2, 2, new NumeroComplejo(1, 0));
        Uc.addComplex(2, 3, new NumeroComplejo(0, 0));

        Uc.addComplex(3, 0, new NumeroComplejo(0, 0));
        Uc.addComplex(3, 1, new NumeroComplejo(0, 0));
        Uc.addComplex(3, 2, new NumeroComplejo(0, 0));
        Uc.addComplex(3, 3, new NumeroComplejo(1, 0));
        return Uc;
    }

    public static MatrizCompleja crearKet0() throws ComplexException {
        MatrizCompleja ket0 = new MatrizCompleja(2, 1);
        ket0.addComplex(0, 0, new NumeroComplejo(1, 0));
        ket0.addComplex(1, 0, new NumeroComplejo(0, 0));
        return  ket0;
    }

    public static MatrizCompleja crearKet1() throws ComplexException {
        MatrizCompleja ket1 = new MatrizCompleja(2, 1);
        ket1.addComplex(0, 0, new NumeroComplejo(0, 0));
        ket1.addComplex(1, 0, new NumeroComplejo(1, 0));
        return ket1;
    }

    private static MatrizCompleja crearIdentidadDimension2() throws ComplexException {
        return CalculadoraMatricesComplejas.crearIdentidad(crearHadamard());
    }



    private static void simulacionAlgoritmoDeDeutsch() throws ComplexException {
        MatrizCompleja phi_0 = productoTensor(crearKet0(), crearKet1());

        MatrizCompleja HH = productoTensor(crearHadamard(), crearHadamard());
        MatrizCompleja HI = productoTensor(crearHadamard(), crearIdentidad(2));
        MatrizCompleja phi_1 = productoDeMatricesSinRedondear(HH, phi_0);
        MatrizCompleja phi_2 = productoDeMatricesSinRedondear(crearUi(), phi_1);
        MatrizCompleja phi_3 = productoDeMatricesSinRedondear(HI, phi_2);

        MatrizCompleja respuesta = matrizModuloAlCuadrado(phi_3);
        new Grafico(respuesta, true).setVisible(true);
        System.out.println(respuesta);


    }


    public static void main(String[] args) throws ComplexException {
        simulacionAlgoritmoDeDeutsch();
    }
}
