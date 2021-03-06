package complexLibrary.matricesComplejas;

import java.util.Arrays;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.numerosComplejos.CalculadoraNumerosComplejos;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class MatrizCompleja {

    private int m;  //Filas de la matriz
    private int n;  //Columnas de la matriz
    private NumeroComplejo[][] matriz;  //Matriz rellenada con numeros complejos

    /**
     * Construye una matriz de un tamaño dado
     *
     * @param m Numero de filas
     * @param n Numero de columnas
     */
    public MatrizCompleja(int m, int n) {
        this.m = m;
        this.n = n;
        this.matriz = new NumeroComplejo[m][n];
    }

    /**
     * Construye una matriz dado un arreglo de arreglos de numeros complejos
     *
     * @param matriz Matriz donde se agregará el arreglo de arreglos
     */
    public MatrizCompleja(NumeroComplejo[][] matriz) {
        this.matriz = matriz;
    }


    /**
     * Verifica si las coordenadas dadas estan fuera de rango o no.
     *
     * @param i fila
     * @param j columna
     * @throws ComplexException Si las coordenadas estan fuera de rango.
     */
    private void verificarRango(int i, int j) throws ComplexException {
        if ((i < 0) || (j < 0) || (i >= m) || (j >= n)) {
            throw new ComplexException(ComplexException.FUERA_DE_RANGO);
        }
    }

    /**
     * Agrega un numero complejo a la matriz
     *
     * @param i      Posicion i de la matriz
     * @param j      Posicion j de la matriz
     * @param numero Numero complejo que se va a agregar
     * @throws ComplexException Si los elementos que se agregan se salen del
     *                          rango de la matriz
     */
    public void addComplex(int i, int j, NumeroComplejo numero) throws ComplexException {
        verificarRango(i, j);
        this.matriz[i][j] = numero;
    }

    /**
     * @param i fila
     * @param j columna
     * @return Un numero complejo indexado en las coordenadas dadas.
     * @throws ComplexException si las coordenadas estan fuera de rango
     */
    public NumeroComplejo getNumeroComplejo(int i, int j) throws ComplexException {
        verificarRango(i, j);
        return matriz[i][j];
    }

    /**
     * @return Cantidad de filas de la matriz
     */
    public int getM() {
        return m;
    }

    /**
     * Establece un numero de filas a una matriz
     *
     * @param m Cantidad de filas de la matriz
     */
    public void setM(int m) {
        this.m = m;
    }

    /**
     * @return Cantidad de columnas de la matriz
     */
    public int getN() {
        return n;
    }

    /**
     * Establece un numero de columnas a una matriz
     *
     * @param n Cantidad de columnas de la matriz
     */
    public void setN(int n) {
        this.n = n;
    }

    /**
     * @return La matriz de numeros complejos
     */
    public NumeroComplejo[][] getMatriz() {
        return matriz;
    }

    /**
     * Establece una matriz de numeros complejos
     *
     * @param matriz Matriz donde se establecerá el arreglo de arreglos
     */
    public void setMatriz(NumeroComplejo[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * @return Si la matriz que se ingresa es un vector
     */
    public boolean isVector() {
        boolean respuesta = false;
        if ((this.getM() == 1 && this.getN() > 1) || (this.getN() == 1 && this.getM() > 1)) {
            respuesta = true;
        }
        return respuesta;
    }

    /**
     * Indica si la matriz es cuadrada, es decir, si el número de dimension es
     * igual tanto en fila como en columna
     *
     * @return
     */
    @SuppressWarnings("JavaDoc")
    public boolean esCuadrada() {
        boolean esCuadrada;
        esCuadrada = this.getM() == this.getN();
        return esCuadrada;

    }

    /**
     * Indica si la matriz es de dinámica clasica. Es decir, si está llena
     * solamente de 1´s y 0´s. Y por columna el numero de 1´s debe ser menor
     * igual a 1
     *
     * @return
     */
    public boolean esDeDinamicaClasica() {
        boolean esClasica = true;

        NumeroComplejo cero = new NumeroComplejo(0, 0);
        NumeroComplejo uno = new NumeroComplejo(1, 0);

        int cantidadDeUnos;

        for (int i = 0; i < this.getMatriz()[0].length; i++) {
            cantidadDeUnos = 0;
            for (int j = 0; j < this.getMatriz().length; j++) {
                if (this.getMatriz()[j][i].equals(uno)) {
                    cantidadDeUnos++;
                }
            }
            if (cantidadDeUnos > 1) {
                esClasica = false;
            }
        }

        return esClasica;
    }

    public String dimension() {
        return this.getM() + " x " + this.getN();
    }

    public boolean esVectorPorFilas() {
        boolean esVectorPorFilas = true;
        if (this.getM() > this.getN()) {
            esVectorPorFilas = false;
        }
        return esVectorPorFilas;
    }

    public boolean esVectorPorColumnas() {
        boolean esVectorPorColumnas = true;
        if (this.getM() < this.getN()) {
            esVectorPorColumnas = false;
        }
        return esVectorPorColumnas;
    }



    /**
     * Indica si la matriz es de dinámica doblemente estocástica. Es decir, si
     * la suma tanto por filas como por columnas es igual a 1
     *
     * @return
     */
    public boolean esDeDinamicaDoblementeEstocastica() {
        boolean esDoblementeEstocastica = true;

        NumeroComplejo uno = new NumeroComplejo(1, 0);
        //noinspection UnusedAssignment
        NumeroComplejo suma = new NumeroComplejo(0, 0);

        if (!this.isVector()) {
            for (int i = 0; i < this.getM(); i++) {
                suma = new NumeroComplejo(0, 0);
                for (int j = 0; j < this.getN(); j++) {
                    suma = CalculadoraNumerosComplejos.sumaDeNumerosComplejosRedondeando(suma, this.getMatriz()[i][j]);
                }
                if (!suma.equals(uno)) {
                    esDoblementeEstocastica = false;
                }
            }

            for (int i = 0; i < this.getN(); i++) {
                suma = new NumeroComplejo(0, 0);
                for (int j = 0; j < this.getM(); j++) {
                    suma = CalculadoraNumerosComplejos.sumaDeNumerosComplejosRedondeando(suma, this.getMatriz()[j][i]);
                }
                if (!suma.equals(uno)) {
                    esDoblementeEstocastica = false;
                }
            }
        } else {
            if (!this.esCuadrada()) {
                suma = sumarElementosDeLaMatriz();
                if (!suma.equals(uno)) {
                    esDoblementeEstocastica = false;
                }
            }
        }
        return esDoblementeEstocastica;
    }

    private NumeroComplejo sumarElementosDeLaMatriz() {
        NumeroComplejo suma = new NumeroComplejo(0, 0);
        for (int i = 0; i < this.getM(); i++) {
            for (int j = 0; j < this.getN(); j++) {
                suma = CalculadoraNumerosComplejos.sumaDeNumerosComplejosRedondeando(suma, this.getMatriz()[i][j]);
            }

        }
        return suma;
    }

    /**
     * Indica si la matriz es de dinamica cuántica. Es decir, si la matriz es
     * unitaria
     *
     * @return
     * @throws ComplexException Si el producto de matrices no se puede realizar
     */
    public boolean matrizDeDinamicaCuantica() throws ComplexException {
        return CalculadoraMatricesComplejas.esUnitaria(this);
    }

    public boolean vectorDeDinamicaCuantica() throws ComplexException {
        if (this.isVector()) {
            MatrizCompleja vector = CalculadoraMatricesComplejas.matrizModuloAlCuadrado(this);

            return vector.esDeDinamicaDoblementeEstocastica();

        } else {
            throw new ComplexException(ComplexException.DEBE_SER_VECTOR);
        }

    }

    @Override
    public String toString() {
        StringBuilder matriz = new StringBuilder();
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                matriz.append("Fila: ").append(i).append(", Columna: ").append(j).append(" ---> ").append(this.matriz[i][j]).append("    ");
            }
            matriz.append("\n");
        }
        return matriz.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + m;
        result = prime * result + Arrays.deepHashCode(matriz);
        result = prime * result + n;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MatrizCompleja other = (MatrizCompleja) obj;
        if (m != other.m) {
            return false;
        }
        if (!Arrays.deepEquals(matriz, other.matriz)) {
            return false;
        }
        return n == other.n;
    }

}
