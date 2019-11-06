package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class Rendija {

    private static final int numeroDeClicks = 2;

    public static Sistema calcularExperimentoDeRendijas(TipoSistema tipoDeSistema, int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja vectorDeProbabilidad) throws ComplexException {
        if (vectorDeProbabilidad.getMatriz().length == ((2 * numeroDeBlancosPared) + 1)) {
            CalculadoraDinamica.validarTipoMatriz(vectorDeProbabilidad, tipoDeSistema);

            int size = calcularTamanoMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);

            MatrizCompleja vectorEstadoInicial = crearVectorDeEstadoInicial(size);

            MatrizCompleja matrizDelSistema = calcularMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared, vectorDeProbabilidad);

            MatrizCompleja matrizPotencia = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matrizDelSistema, matrizDelSistema);

            MatrizCompleja vectorEstadoFinal = CalculadoraDinamica.calcularDinamica(tipoDeSistema, matrizDelSistema, vectorEstadoInicial, numeroDeClicks).getVectorEstadoFinal();
            return new Sistema(matrizDelSistema, matrizPotencia, vectorEstadoFinal);
        } else {
            throw new ComplexException(ComplexException.VP_INVALIDO);
        }

    }

    private static MatrizCompleja crearVectorDeEstadoInicial(int size) throws ComplexException {
        MatrizCompleja vectorDeEstadoInicial = new MatrizCompleja(size, 1);
        vectorDeEstadoInicial.addComplex(0, 0, new NumeroComplejo(1, 0));
        NumeroComplejo cero = new NumeroComplejo(0, 0);

        for (int i = 1; i < vectorDeEstadoInicial.getM(); i++) {
            vectorDeEstadoInicial.addComplex(i, 0, cero);
        }
        //System.out.println(vectorDeEstadoInicial);
        return vectorDeEstadoInicial;

    }

    private static MatrizCompleja calcularMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja VP) {

        int size = calcularTamanoMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);
        MatrizCompleja matrizDelSistema = new MatrizCompleja(size, size);
        llenarMatrizDeCeros(matrizDelSistema);
        llenarColumna0(matrizDelSistema, numeroDeRendijas);
        llenarDe1s(matrizDelSistema, numeroDeRendijas);
        llenarDeVP(matrizDelSistema, VP, numeroDeRendijas, numeroDeBlancosPared);

        return matrizDelSistema;
    }

    private static int calcularTamanoMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared) {
        int paredes = numeroDeRendijas + 1;

        int puntosNegros = 2 * numeroDeRendijas;
        int puntosRojos = paredes * numeroDeBlancosPared;

        int size = 1 + puntosNegros + puntosRojos;

        return size;
    }

    private static void llenarMatrizDeCeros(MatrizCompleja M) {
        for (int i = 0; i < M.getM(); i++) {
            for (int j = 0; j < M.getN(); j++) {
                M.getMatriz()[i][j] = new NumeroComplejo(0, 0);
            }
        }
    }

    private static void llenarColumna0(MatrizCompleja M, int numeroRendijas) {
        for (int i = 0; i < numeroRendijas; i++) {
            M.getMatriz()[i + 1][0] = new NumeroComplejo((double) 1 / (Math.sqrt(numeroRendijas)), 0);
        }
    }

    private static void llenarDe1s(MatrizCompleja M, int numeroRendijas) {
        for (int i = numeroRendijas + 1; i < M.getMatriz().length; i++) {
            M.getMatriz()[i][i] = new NumeroComplejo(1, 0);
        }
    }

    private static void llenarDeVP(MatrizCompleja M, MatrizCompleja VP, int numRendijas, int numeroBlancos) {
        int blankSpaces = VP.getMatriz().length - numeroBlancos;
        int inicio = numRendijas + 1;
        for (int j = 1; j < numRendijas + 1; j++) {
            for (int i = 0; i < VP.getMatriz().length; i++) {
                M.getMatriz()[inicio + i][j] = VP.getMatriz()[i][0];
            }
            inicio += blankSpaces;
        }

    }

    public static void main(String[] args) {
        MatrizCompleja vectorDeProbabilidad = new MatrizCompleja(7, 1);
        try {
            vectorDeProbabilidad.addComplex(0, 0, new NumeroComplejo(0.2, 0));
            vectorDeProbabilidad.addComplex(1, 0, new NumeroComplejo(0.2, 0));
            vectorDeProbabilidad.addComplex(2, 0, new NumeroComplejo(0.3, 0));
            vectorDeProbabilidad.addComplex(3, 0, new NumeroComplejo(0.05, 0));
            vectorDeProbabilidad.addComplex(4, 0, new NumeroComplejo(0.1, 0));
            vectorDeProbabilidad.addComplex(5, 0, new NumeroComplejo(0.1, 0));
            vectorDeProbabilidad.addComplex(6, 0, new NumeroComplejo(0.05, 0));

            System.out.println(Rendija.calcularExperimentoDeRendijas(TipoSistema.ESTOCASTICO, 2, 3, vectorDeProbabilidad));

            MatrizCompleja vectorFinal = Rendija.calcularExperimentoDeRendijas(TipoSistema.ESTOCASTICO, 2, 3, vectorDeProbabilidad).getVectorEstadoFinal();
            new Grafico(vectorFinal).setVisible(true);
        } catch (ComplexException e) {
            e.printStackTrace();
        }

    }

}
