package complexLibrary.cuantica;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

import java.util.ArrayList;

/**
 * @author 2145120
 */
public class CalculadoraCuantica {

    public static MatrizCompleja calcularProbabilidad(MatrizCompleja ket) throws ComplexException {
        if (!ket.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            ket = normalizarVector(ket);
            MatrizCompleja respuesta = new MatrizCompleja(ket.getM(), ket.getN());

            for (int i = 0; i < ket.getM(); i++) {
                respuesta.getMatriz()[i][0] = new NumeroComplejo(CalculadoraNumerosComplejos.moduloElevadoAlCuadrado(ket.getMatriz()[i][0]) / CalculadoraMatricesComplejas.norma(ket), 0);
            }

            return respuesta;

        }
    }

    public static MatrizCompleja calcularProbabilidad(int numeroDePuntos, MatrizCompleja ket) throws ComplexException {
        if (!ket.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }
        if (ket.getMatriz().length != numeroDePuntos) {
            throw new ComplexException("El número de puntos no coincide con la longitud del ket ingresado.");
        } else {
            ket = normalizarVector(ket);
            MatrizCompleja respuesta = new MatrizCompleja(ket.getM(), ket.getN());

            for (int i = 0; i < ket.getM(); i++) {
                respuesta.getMatriz()[i][0] = new NumeroComplejo(CalculadoraNumerosComplejos.moduloElevadoAlCuadrado(ket.getMatriz()[i][0]) / CalculadoraMatricesComplejas.norma(ket), 0);
            }

            return respuesta;

        }
    }

    public static MatrizCompleja calcularBra(MatrizCompleja ket) throws ComplexException {
        if (!ket.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            return CalculadoraMatricesComplejas.matrizAdjunta(ket);
        }
    }

    private static MatrizCompleja normalizarVector(MatrizCompleja ket) throws ComplexException {
        if (!ket.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            return CalculadoraMatricesComplejas.productoPorEscalarDeUnVector(ket, new NumeroComplejo((double) 1 / CalculadoraMatricesComplejas.norma(ket), 0));

        }
    }

    public static NumeroComplejo calcularAmplitudDeTransicion(MatrizCompleja psi, MatrizCompleja phi) throws ComplexException {
        psi = normalizarVector(psi);
        phi = normalizarVector(phi);
        return CalculadoraMatricesComplejas.productoInterno(true, phi, psi);
    }

    public static NumeroComplejo calcularValorEsperado(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        if (!CalculadoraMatricesComplejas.esHermitiana(omega)) {
            throw new ComplexException(ComplexException.NO_ES_HERMITIANA);
        }
        if (!psi.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            return calcular(omega, psi);
        }
    }

    private static NumeroComplejo calcular(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        psi = normalizarVector(psi);
        MatrizCompleja omegaXpsi = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(omega, psi);

        return CalculadoraMatricesComplejas.productoInterno(true, omegaXpsi, psi);
    }

    public static MatrizCompleja calcularOperadorDelta(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        MatrizCompleja matrizIdentidad = CalculadoraMatricesComplejas.crearIdentidad(omega);
        NumeroComplejo valorEsperado = calcularValorEsperado(omega, psi);
        return CalculadoraMatricesComplejas.restaDeMatrices(omega, CalculadoraMatricesComplejas.productoPorEscalar(matrizIdentidad, valorEsperado));
    }

    public static NumeroComplejo calcularVarianza(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        MatrizCompleja operadorDelta = calcularOperadorDelta(omega, psi);
        return calcular(CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(operadorDelta, operadorDelta), psi);
    }

    public static double calcularDesviacionEstandar(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        return Math.sqrt(calcularVarianza(omega, psi).getParteReal());
    }

    /**
     * Dado un ket calcula sus coordenadas esféricas
     * @param ket
     * @return Una lista de doubles con las coordenadas esfericas del vector. El primer elemento es la latitud(theta), el segundo elemento es la longitud(phi)
     * @throws ComplexException
     */
    public static ArrayList<Double> ketAEsferaDeBloch(MatrizCompleja ket) throws ComplexException {
        if(!ket.isVector()){
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }else{


            ArrayList<Double> respuesta = new ArrayList<>();

            ket = CalculadoraMatricesComplejas.pasarAVectorPorColumnas(ket);
            ket = CalculadoraCuantica.normalizarVector(ket);

            ArrayList<Double> numero1 = ket.getNumeroComplejo(0, 0).cartesianoAPolar();
            ArrayList<Double> numero2 = ket.getNumeroComplejo(1, 0).cartesianoAPolar();

            double retorno1 = (double)Math.round(Math.toDegrees(Math.acos(numero1.get(0))) * 1d) / 1d;
            double retorno2 = numero2.get(1) - numero1.get(1);


            respuesta.add(retorno1);
            respuesta.add(retorno2);

            return respuesta;

        }
    }



}
