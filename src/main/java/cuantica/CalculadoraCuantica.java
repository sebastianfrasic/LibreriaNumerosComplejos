/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cuantica;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

/**
 *
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

    public static MatrizCompleja normalizarVector(MatrizCompleja ket) throws ComplexException {
        if (!ket.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            return CalculadoraMatricesComplejas.productoPorEscalarDeUnVector(ket, new NumeroComplejo((double) 1 / CalculadoraMatricesComplejas.norma(ket), 0));

        }
    }

    public static MatrizCompleja calcularAmplitudDeTransicion(MatrizCompleja psi, MatrizCompleja phi) throws ComplexException {
        System.out.println("psi " + CalculadoraMatricesComplejas.norma(psi));
        System.out.println("phi " + CalculadoraMatricesComplejas.norma(phi));
        psi = normalizarVector(psi);
        phi = normalizarVector(phi);

        return CalculadoraMatricesComplejas.productoInterno(phi, psi);
    }

    public static NumeroComplejo calcularValorEsperado(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        if (!CalculadoraMatricesComplejas.esHermitiana(omega)) {
            throw new ComplexException(ComplexException.NO_ES_HERMITIANA);
        }
        if (!psi.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        } else {
            MatrizCompleja omegaXpsi = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(omega, psi);
            NumeroComplejo respuesta = CalculadoraMatricesComplejas.productoInterno(true, omegaXpsi, psi);

            return respuesta;
        }
    }
    
    private static MatrizCompleja agregarAMatriz(NumeroComplejo N) throws ComplexException{
        MatrizCompleja matriz = new MatrizCompleja(1, 1);
        matriz.addComplex(0, 0, N);
        System.out.println(matriz);
        return matriz;
    }

    public static MatrizCompleja calcularOperadorDelta(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        MatrizCompleja matrizIdentidad = CalculadoraMatricesComplejas.crearIdentidad(omega);
        System.out.println(matrizIdentidad);
        System.out.println(omega);
        System.out.println(psi.isVector());
        System.out.println(calcularValorEsperado(omega, psi));
        System.out.println(CalculadoraMatricesComplejas.productoPorEscalar(matrizIdentidad, calcularValorEsperado(omega, psi)));
        MatrizCompleja respuesta = CalculadoraMatricesComplejas.restaDeMatrices(omega, CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(agregarAMatriz(calcularValorEsperado(omega, psi)), matrizIdentidad));
        return respuesta;
    }

    public static MatrizCompleja calcularVarianza(MatrizCompleja omega, MatrizCompleja psi) throws ComplexException {
        MatrizCompleja valorEsperado = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(calcularOperadorDelta(omega, psi), calcularOperadorDelta(omega, psi));
        MatrizCompleja respuesta = calcularValorEsperado(valorEsperado, psi);
        return respuesta;
    }

}
