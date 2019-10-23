package complexLibrary.actividades;

import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;
import complexLibrary.cuantica.CalculadoraCuantica;
import org.junit.Test;

public class Quiz6 {


    @Test
    public void pregunta3y4() {
        MatrizCompleja psi = new MatrizCompleja(2, 1);
        MatrizCompleja omega = new MatrizCompleja(2, 2);

        try {
            psi.addComplex(0, 0, new NumeroComplejo(1 / (Math.sqrt(2)), 0));
            psi.addComplex(1, 0, new NumeroComplejo(0, 1 / (Math.sqrt(2))));

            omega.addComplex(0, 0, new NumeroComplejo(0, 0));
            omega.addComplex(0, 1, new NumeroComplejo(0, -1));
            omega.addComplex(1, 0, new NumeroComplejo(0, 1));
            omega.addComplex(1, 1, new NumeroComplejo(0, 0));


            System.out.println("Valor esperado: " + CalculadoraCuantica.calcularValorEsperado(omega, psi));
            System.out.println("Operador delta: \n" + CalculadoraCuantica.calcularOperadorDelta(omega, psi));
            System.out.println("Varianza: " + CalculadoraCuantica.calcularVarianza(omega, psi));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ejercicio429Libro() {
        MatrizCompleja psi = new MatrizCompleja(2, 1);
        MatrizCompleja omega = new MatrizCompleja(2, 2);

        try {
            psi.addComplex(0, 0, new NumeroComplejo((Math.sqrt(2)) / 2, 0));
            psi.addComplex(1, 0, new NumeroComplejo(-(Math.sqrt(2)) / 2, 0));

            omega.addComplex(0, 0, new NumeroComplejo(3, 0));
            omega.addComplex(0, 1, new NumeroComplejo(1, 2));
            omega.addComplex(1, 0, new NumeroComplejo(1, -2));
            omega.addComplex(1, 1, new NumeroComplejo(-1, 0));

            MatrizCompleja respuesta = CalculadoraMatricesComplejas.productoDeMatrices(omega, psi);
            System.out.println("Ejercicio \n" + CalculadoraCuantica.calcularBra(respuesta));


            System.out.println("Valor esperado: " + CalculadoraCuantica.calcularValorEsperado(omega, psi));
            /*
            System.out.println("Operador delta: \n" + CalculadoraCuantica.calcularOperadorDelta(omega, psi));
            System.out.println("Varianza: " + CalculadoraCuantica.calcularVarianza(omega, psi));
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ejemplo425libro() {
        MatrizCompleja psi = new MatrizCompleja(2, 1);
        MatrizCompleja omega = new MatrizCompleja(2, 2);

        try {
            psi.addComplex(0, 0, new NumeroComplejo((Math.sqrt(2)) / 2, 0));
            psi.addComplex(1, 0, new NumeroComplejo(0, (Math.sqrt(2)) / 2));

            omega.addComplex(0, 0, new NumeroComplejo(1, 0));
            omega.addComplex(0, 1, new NumeroComplejo(0, -1));
            omega.addComplex(1, 0, new NumeroComplejo(0, 1));
            omega.addComplex(1, 1, new NumeroComplejo(2, 0));

            MatrizCompleja respuesta = CalculadoraMatricesComplejas.productoDeMatrices(omega, psi);
            System.out.println("Ejemplo \n" + CalculadoraCuantica.calcularBra(respuesta));


            System.out.println("Valor esperado: " + CalculadoraCuantica.calcularValorEsperado(omega, psi));
            /*
            System.out.println("Operador delta: \n" + CalculadoraCuantica.calcularOperadorDelta(omega, psi));
            System.out.println("Varianza: " + CalculadoraCuantica.calcularVarianza(omega, psi));
*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ejericio441ibro() {
        MatrizCompleja m1 = new MatrizCompleja(2, 2);
        MatrizCompleja m2 = new MatrizCompleja(2, 2);

        try {
            m1.addComplex(0, 0, new NumeroComplejo(0, 0));
            m1.addComplex(0, 1, new NumeroComplejo(1, 0));
            m1.addComplex(1, 0, new NumeroComplejo(1, 0));
            m1.addComplex(1, 1, new NumeroComplejo(0, 0));

            m2.addComplex(0, 0, new NumeroComplejo((Math.sqrt(2)) / 2, 0));
            m2.addComplex(0, 1, new NumeroComplejo((Math.sqrt(2)) / 2, 0));
            m2.addComplex(1, 0, new NumeroComplejo((Math.sqrt(2)) / 2, 0));
            m2.addComplex(1, 1, new NumeroComplejo(-(Math.sqrt(2)) / 2, 0));

            MatrizCompleja producto = CalculadoraMatricesComplejas.productoDeMatrices(m1,m2);
            System.out.println("Producto de matrices: \n" + producto);

            System.out.println("La matriz 1 es unitaria? " + CalculadoraMatricesComplejas.esUnitaria(m1));
            System.out.println("La matriz 2 es unitaria? " + CalculadoraMatricesComplejas.esUnitaria(m2));
            System.out.println("El producto es unitario? " + CalculadoraMatricesComplejas.esUnitaria(producto));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
