package complexLibrary.dinamicas;

import java.util.logging.Level;
import java.util.logging.Logger;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

/**
 * @author juans
 */
public class CalculadoraDinamica {

    public static void main(String[] args) {

        MatrizCompleja matriz = new MatrizCompleja(2, 2);
        MatrizCompleja vectorEstadoInicial = new MatrizCompleja(2, 1);

        try {

            //int size = Rendija.calcularTamañoMatrizDelSistema(2, 2);
            //System.out.println(size + "\n");
            //System.out.println(Rendija.crearVectorDeEstadoInicial(size));					
            matriz.addComplex(0, 0, new NumeroComplejo(0.5, 0));
            matriz.addComplex(0, 1, new NumeroComplejo(0.5, 0));
            matriz.addComplex(1, 0, new NumeroComplejo(0.5, 0));
            matriz.addComplex(1, 1, new NumeroComplejo(0.5, 0));

            vectorEstadoInicial.addComplex(0, 0, new NumeroComplejo(3, 0));
            vectorEstadoInicial.addComplex(1, 0, new NumeroComplejo(4, 0));

            Sistema sistemaClasico = calcularDinamica(TipoSistema.ESTOCASTICO, matriz, vectorEstadoInicial, 1);
            System.out.println(sistemaClasico);
        } catch (ComplexException ex) {
            Logger.getLogger(CalculadoraDinamica.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param tipoDeSistema       Tipo de sistema (clasico, probabilistico o cuantico)
     * @param matriz
     * @param vectorEstadoInicial
     * @param numeroDeClicks
     * @return Un sistema que indica la validez de la matriz según su parámetro
     * ingresado; una matriz M^t; y un vector de estado final
     * @throws complexLibrary.excepciones.ComplexException Si hay un problema al
     *                                                     determinar si es unitaria
     */
    public static Sistema calcularDinamica(TipoSistema tipoDeSistema, MatrizCompleja matriz, MatrizCompleja vectorEstadoInicial, int numeroDeClicks) throws ComplexException {
        if (!vectorEstadoInicial.isVector()) {
            throw new ComplexException(ComplexException.DEBE_SER_VECTOR);
        } else {
            boolean esValida = validarTipoMatriz(matriz, tipoDeSistema);
            MatrizCompleja matrizPotencia = calcularPotencia(matriz, numeroDeClicks);
            MatrizCompleja vectorEstadoFinal = calcularEstadoFinal(matriz, vectorEstadoInicial, numeroDeClicks);
            if (tipoDeSistema == TipoSistema.CUANTICO) {
                vectorEstadoFinal = CalculadoraMatricesComplejas.matrizModuloAlCuadrado(vectorEstadoFinal);
            }
            if (tipoDeSistema == TipoSistema.CUANTICO && matriz.matrizDeDinamicaCuantica() && vectorEstadoInicial.vectorDeDinamicaCuantica()) {
                vectorEstadoFinal = CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vectorEstadoFinal);
            }

            return new Sistema(esValida, matrizPotencia, vectorEstadoFinal);
        }

    }

    /**
     * Realiza la validez de la matriz, según el parametro de dinamica ingresado
     *
     * @param matriz Matriz a validar
     * @param tipo   dinamica clasica, dinamica doblemente estocastica ó dinamica
     *               cuantica
     * @return Si la matriz ingresada es valida
     * @throws ComplexException Si hay un problema al determinar si es unitaria
     */
    public static boolean validarTipoMatriz(MatrizCompleja matriz, TipoSistema tipo) throws ComplexException {
        boolean esValida = false;
        switch (tipo) {
            case CLASICO:
                esValida = matriz.esDeDinamicaClasica();
                break;
            case ESTOCASTICO:
                esValida = matriz.esDeDinamicaDoblementeEstocastica();
                break;
            case CUANTICO:
                esValida = matriz.matrizDeDinamicaCuantica();
            default:
                break;
        }
        return esValida;
    }

    /**
     * @param matriz Matriz dinamica del sistema
     * @param t      Potencia (exponente) que indica el numero de veces que se
     *               multiplicará la matriz con sí msima
     * @return Una matriz resultante de la potencia
     * @throws ComplexException Si las matrices no se pueden multiplicar
     */
    private static MatrizCompleja calcularPotencia(MatrizCompleja matriz, int t) throws ComplexException {
        for (int i = 0; i < t; i++) {
            matriz = CalculadoraMatricesComplejas.productoDeMatrices(matriz, matriz);

        }
        return matriz;
    }

    /**
     * Calcula la dinamica del sistema, es decir, realiza el producto entre
     * matrices (Matriz y vector de estado inicial) tantas veces como sea el
     * numero de clicks
     *
     * @param matriz                Matriz dinamica del sistema
     * @param vectorDeEstadoInicial
     * @param numeroDeClicks
     * @return
     * @throws ComplexException
     */
    private static MatrizCompleja calcularEstadoFinal(MatrizCompleja matriz, MatrizCompleja vectorDeEstadoInicial, int numeroDeClicks) throws ComplexException {
        if (!vectorDeEstadoInicial.isVector()) {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }
        for (int i = 0; i < numeroDeClicks; i++) {
            vectorDeEstadoInicial = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matriz, vectorDeEstadoInicial);

        }

        return vectorDeEstadoInicial;
    }

    public static MatrizCompleja calcularDinamicaConEnsamble(TipoSistema tipo, MatrizCompleja m1, MatrizCompleja v1, MatrizCompleja m2, MatrizCompleja v2, int numeroDeClicks) throws ComplexException {
        if (v1.isVector() && v2.isVector() && validarTipoMatriz(m1, tipo)) {

            MatrizCompleja vectorEnsamblado = CalculadoraMatricesComplejas.productoTensor(v1, v2);
            MatrizCompleja matrizDeLaDinamica = CalculadoraMatricesComplejas.productoTensor(m1, m2);

            if (vectorEnsamblado.getMatriz().length != matrizDeLaDinamica.getMatriz().length) {
                throw new ComplexException(ComplexException.NO_SE_PUDO_CALCULAR);
            } else {
                for (int i = 0; i < numeroDeClicks; i++) {
                    vectorEnsamblado = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matrizDeLaDinamica, vectorEnsamblado);
                }
                if (tipo == TipoSistema.CUANTICO && matrizDeLaDinamica.matrizDeDinamicaCuantica() && vectorEnsamblado.vectorDeDinamicaCuantica()) {
                    vectorEnsamblado = CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vectorEnsamblado);
                }

                return vectorEnsamblado;
            }
        } else {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }

    public static MatrizCompleja calcularDinamicaConEnsamble(TipoSistema tipo, MatrizCompleja m1, MatrizCompleja m2, MatrizCompleja vectorEstadoInicial, int t) throws ComplexException {
        if (vectorEstadoInicial.isVector() && validarTipoMatriz(m1, tipo)) {

            MatrizCompleja matrizDeLaDinamica = CalculadoraMatricesComplejas.productoTensor(m1, m2);

            if (vectorEstadoInicial.getMatriz().length != matrizDeLaDinamica.getMatriz().length) {
                throw new ComplexException(ComplexException.NO_SE_PUDO_CALCULAR);
            } else {
                for (int i = 0; i < t; i++) {
                    vectorEstadoInicial = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matrizDeLaDinamica, vectorEstadoInicial);
                }
                if (tipo == TipoSistema.CUANTICO && matrizDeLaDinamica.matrizDeDinamicaCuantica() && vectorEstadoInicial.vectorDeDinamicaCuantica()) {
                    vectorEstadoInicial = CalculadoraMatricesComplejas.matrizEstocasticaAsociada(vectorEstadoInicial);
                }

                return vectorEstadoInicial;
            }

        } else {
            throw new ComplexException(ComplexException.NO_ES_VECTOR);
        }

    }

}
