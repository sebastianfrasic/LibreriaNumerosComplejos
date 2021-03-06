package complexLibrary.numerosComplejos;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;

import java.text.DecimalFormat;

public class CalculadoraNumerosComplejos {

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return La suma entre dos numeros complejos
     */
    public static NumeroComplejo sumaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {

        return new NumeroComplejo(a.getParteReal() + b.getParteReal(), a.getParteImaginaria() + b.getParteImaginaria());
    }

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return La suma entre dos numeros complejos redondeado a 2 decimales
     */
    public static NumeroComplejo sumaDeNumerosComplejosRedondeando(NumeroComplejo a, NumeroComplejo b) {
        double parteReal = ((double) Math.round((a.getParteReal() + b.getParteReal()) * 100d) / 100d) - ((double) Math.round((a.getParteImaginaria() + b.getParteImaginaria()) * 100d) / 100d);
        double parteImaginaria = ((double) Math.round((a.getParteReal() * b.getParteImaginaria()) * 100d) / 100d) + ((double) Math.round((a.getParteImaginaria() * b.getParteReal()) * 100d) / 100d);

        return new NumeroComplejo(parteReal, parteImaginaria);
    }

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return La resta entre dos numeros complejos
     */
    public static NumeroComplejo restaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {

        return new NumeroComplejo(a.getParteReal() - b.getParteReal(), a.getParteImaginaria() - b.getParteImaginaria());

    }

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return El producto entre dos numeros complejos
     */
    public static NumeroComplejo productoDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {

        double parteReal = ((double) Math.round((a.getParteReal() * b.getParteReal()) * 100d) / 100d) - ((double) Math.round((a.getParteImaginaria() * b.getParteImaginaria()) * 100d) / 100d);
        double parteImaginaria = ((double) Math.round((a.getParteReal() * b.getParteImaginaria()) * 100d) / 100d) + ((double) Math.round((a.getParteImaginaria() * b.getParteReal()) * 100d) / 100d);

        return new NumeroComplejo(parteReal, parteImaginaria);
    }

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return El producto entre dos numeros complejos
     */
    public static NumeroComplejo productoDeNumerosComplejosSinRedondear(NumeroComplejo a, NumeroComplejo b) {

        double parteReal = (a.getParteReal() * b.getParteReal()) - (a.getParteImaginaria() * b.getParteImaginaria());
        double parteImaginaria = (a.getParteReal() * b.getParteImaginaria()) + (a.getParteImaginaria() * b.getParteReal());

        return new NumeroComplejo(parteReal, parteImaginaria);
    }

    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return La division entre dos numeros complejos
     * @throws ComplexException si se divide por cero
     */
    public static NumeroComplejo divisionDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) throws ComplexException {

        if (b.getParteReal() == 0 && b.getParteImaginaria() == 0) {
            throw new ComplexException(ComplexException.DIVISION_POR_CERO);
        } else {
            double dividendo = (Math.pow(b.getParteReal(), 2) + Math.pow(b.getParteImaginaria(), 2));

            double parteA = (a.getParteReal() * b.getParteReal()) + (a.getParteImaginaria() * b.getParteImaginaria());
            double parteB = (a.getParteImaginaria() * b.getParteReal()) - (a.getParteReal() * b.getParteImaginaria());

            return new NumeroComplejo(parteA / dividendo, parteB / dividendo);
        }
    }

    /**
     * @param a Numero complejo a calcular su modulo
     * @return El modulo del numero complejo dado
     */
    public static double modulo(NumeroComplejo a) {
        return a.getModulo();
    }

    public static double moduloElevadoAlCuadrado(NumeroComplejo a) {
        return Math.pow(modulo(a), 2);
    }

    /**
     * @param a Numero complejo a calcular su conjugado
     * @return El conjugado del numero complejo dado
     */
    public static NumeroComplejo conjugado(NumeroComplejo a) {

        return a.getConjugado();
    }

    public static NumeroComplejo redondearAXDecimalesUnaNumeroComplejo(NumeroComplejo M, int numeroDeDecimales) {
        String format = "#." + CalculadoraMatricesComplejas.generarCeros(numeroDeDecimales);
        DecimalFormat df = new DecimalFormat(format);
        M = new NumeroComplejo(Double.parseDouble(df.format(M.getParteReal())), Double.parseDouble(df.format(M.getParteImaginaria())));
        return M;
    }


}
