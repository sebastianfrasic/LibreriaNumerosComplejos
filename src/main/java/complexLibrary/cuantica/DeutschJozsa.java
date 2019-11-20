package complexLibrary.cuantica;

import complexLibrary.dinamicas.Grafico;
import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

import static complexLibrary.cuantica.Deutsch.crearHadamard;
import static complexLibrary.cuantica.Deutsch.crearKet0;
import static complexLibrary.matricesComplejas.CalculadoraMatricesComplejas.*;

public class DeutschJozsa {

    public static MatrizCompleja crearMatrizNoConstanteNiBalanceada() throws ComplexException {
        MatrizCompleja U1 = new MatrizCompleja(8, 8);
        U1.addComplex(0, 0, new NumeroComplejo(1, 0));
        U1.addComplex(0, 1, new NumeroComplejo(0, 0));
        U1.addComplex(0, 2, new NumeroComplejo(0, 0));
        U1.addComplex(0, 3, new NumeroComplejo(0, 0));
        U1.addComplex(0, 4, new NumeroComplejo(0, 0));
        U1.addComplex(0, 5, new NumeroComplejo(0, 0));
        U1.addComplex(0, 6, new NumeroComplejo(0, 0));
        U1.addComplex(0, 7, new NumeroComplejo(0, 0));


        U1.addComplex(1, 0, new NumeroComplejo(0, 0));
        U1.addComplex(1, 1, new NumeroComplejo(1, 0));
        U1.addComplex(1, 2, new NumeroComplejo(0, 0));
        U1.addComplex(1, 3, new NumeroComplejo(0, 0));
        U1.addComplex(1, 4, new NumeroComplejo(0, 0));
        U1.addComplex(1, 5, new NumeroComplejo(0, 0));
        U1.addComplex(1, 6, new NumeroComplejo(0, 0));
        U1.addComplex(1, 7, new NumeroComplejo(0, 0));

        U1.addComplex(2, 0, new NumeroComplejo(0, 0));
        U1.addComplex(2, 1, new NumeroComplejo(0, 0));
        U1.addComplex(2, 2, new NumeroComplejo(1, 0));
        U1.addComplex(2, 3, new NumeroComplejo(0, 0));
        U1.addComplex(2, 4, new NumeroComplejo(0, 0));
        U1.addComplex(2, 5, new NumeroComplejo(0, 0));
        U1.addComplex(2, 6, new NumeroComplejo(0, 0));
        U1.addComplex(2, 7, new NumeroComplejo(0, 0));

        U1.addComplex(3, 0, new NumeroComplejo(0, 0));
        U1.addComplex(3, 1, new NumeroComplejo(0, 0));
        U1.addComplex(3, 2, new NumeroComplejo(0, 0));
        U1.addComplex(3, 3, new NumeroComplejo(1, 0));
        U1.addComplex(3, 4, new NumeroComplejo(0, 0));
        U1.addComplex(3, 5, new NumeroComplejo(0, 0));
        U1.addComplex(3, 6, new NumeroComplejo(0, 0));
        U1.addComplex(3, 7, new NumeroComplejo(0, 0));

        U1.addComplex(4, 0, new NumeroComplejo(0, 0));
        U1.addComplex(4, 1, new NumeroComplejo(0, 0));
        U1.addComplex(4, 2, new NumeroComplejo(0, 0));
        U1.addComplex(4, 3, new NumeroComplejo(0, 0));
        U1.addComplex(4, 4, new NumeroComplejo(0, 0));
        U1.addComplex(4, 5, new NumeroComplejo(1, 0));
        U1.addComplex(4, 6, new NumeroComplejo(0, 0));
        U1.addComplex(4, 7, new NumeroComplejo(0, 0));


        U1.addComplex(5, 0, new NumeroComplejo(0, 0));
        U1.addComplex(5, 1, new NumeroComplejo(0, 0));
        U1.addComplex(5, 2, new NumeroComplejo(0, 0));
        U1.addComplex(5, 3, new NumeroComplejo(0, 0));
        U1.addComplex(5, 4, new NumeroComplejo(1, 0));
        U1.addComplex(5, 5, new NumeroComplejo(0, 0));
        U1.addComplex(5, 6, new NumeroComplejo(0, 0));
        U1.addComplex(5, 7, new NumeroComplejo(0, 0));

        U1.addComplex(6, 0, new NumeroComplejo(0, 0));
        U1.addComplex(6, 1, new NumeroComplejo(0, 0));
        U1.addComplex(6, 2, new NumeroComplejo(0, 0));
        U1.addComplex(6, 3, new NumeroComplejo(0, 0));
        U1.addComplex(6, 4, new NumeroComplejo(0, 0));
        U1.addComplex(6, 5, new NumeroComplejo(0, 0));
        U1.addComplex(6, 6, new NumeroComplejo(1, 0));
        U1.addComplex(6, 7, new NumeroComplejo(0, 0));

        U1.addComplex(7, 0, new NumeroComplejo(0, 0));
        U1.addComplex(7, 1, new NumeroComplejo(0, 0));
        U1.addComplex(7, 2, new NumeroComplejo(0, 0));
        U1.addComplex(7, 3, new NumeroComplejo(0, 0));
        U1.addComplex(7, 4, new NumeroComplejo(0, 0));
        U1.addComplex(7, 5, new NumeroComplejo(0, 0));
        U1.addComplex(7, 6, new NumeroComplejo(0, 0));
        U1.addComplex(7, 7, new NumeroComplejo(1, 0));



        return U1;
    }

    private static void simulacionAlgoritmoDeDeutschJozsa() throws ComplexException {
        MatrizCompleja ceroTensorCero = potenciaTensor(crearKet0(), 2);
        MatrizCompleja phi_0 = productoTensor(ceroTensorCero, Deutsch.crearKet1());

        MatrizCompleja HHH = potenciaTensor(crearHadamard(), 3);
        MatrizCompleja phi_1 = productoDeMatricesSinRedondear(HHH, phi_0);
        MatrizCompleja phi_2 = productoDeMatricesSinRedondear(crearMatrizNoConstanteNiBalanceada(), phi_1);

        MatrizCompleja HH = productoTensor(crearHadamard(), crearHadamard());
        MatrizCompleja HHI = productoTensor(HH, crearIdentidad(2));

        MatrizCompleja phi_3 = productoDeMatricesSinRedondear(HHI, phi_2);
        MatrizCompleja respuesta = matrizModuloAlCuadrado(phi_3);
        System.out.println(respuesta);

        new Grafico(respuesta, true).setVisible(true);

    }

    public static void main(String[] args) {
        try {
            simulacionAlgoritmoDeDeutschJozsa();
        } catch (ComplexException e) {
            e.printStackTrace();
        }
    }



}
