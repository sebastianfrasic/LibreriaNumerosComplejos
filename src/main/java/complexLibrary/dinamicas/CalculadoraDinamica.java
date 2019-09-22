package complexLibrary.dinamicas;

import java.util.logging.Level;
import java.util.logging.Logger;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;


/**
 *
 * @author juans
 */
public class CalculadoraDinamica {

	public static void main(String[] args) {

		MatrizCompleja matriz = new MatrizCompleja(2, 2);
		MatrizCompleja vectorEstadoInicial = new MatrizCompleja(2, 1);

		try {
			matriz.addComplex(0, 0, new NumeroComplejo(0.5, 0));
			matriz.addComplex(0, 1, new NumeroComplejo(0.5, 0));
			matriz.addComplex(1, 0, new NumeroComplejo(0.5, 0));
			matriz.addComplex(1, 1, new NumeroComplejo(0.5, 0));  

			vectorEstadoInicial.addComplex(0, 0, new NumeroComplejo(3, 0));
			vectorEstadoInicial.addComplex(1, 0, new NumeroComplejo(4, 0));

			Sistema sistemaClasico = CalcularDinamica(TipoSistema.ESTOCASTICO, matriz, vectorEstadoInicial, 1);
			System.out.println(sistemaClasico);
		} catch (ComplexException ex) {
			Logger.getLogger(CalculadoraDinamica.class.getName()).log(Level.SEVERE, null, ex);
		}



	}

	/**
	 * 
	 * @param tipoDeSistema
	 * @param matriz
	 * @param vectorEstadoInicial
	 * @param numeroDeClicks 
	 * @return Un sistema que indica la validez de la matriz seg�n su par�metro ingresado; una matriz M^t; y un vector de estado final
	 * @throws complexLibrary.excepciones.ComplexException Si hay un problema al determinar si es unitaria
	 */
	public static Sistema CalcularDinamica(TipoSistema tipoDeSistema, MatrizCompleja matriz, MatrizCompleja vectorEstadoInicial, int numeroDeClicks) throws ComplexException{

		boolean esValida = validarTipoMatriz(matriz, tipoDeSistema);
		MatrizCompleja matrizPotencia = calcularPotencia(matriz, numeroDeClicks);
		MatrizCompleja vectorEstadoFinal = calcularEstadoFinal(matriz, vectorEstadoInicial, numeroDeClicks);        

		return new Sistema(esValida, matrizPotencia, vectorEstadoFinal);
	}


	/**
	 * Realiza la validez de la matriz, seg�n el parametro de dinamica ingresado
	 * @param matriz Matriz a validar
	 * @param tipo dinamica clasica, dinamica doblemente estocastica � dinamica cuantica
	 * @return Si la matriz ingresada es valida
	 * @throws ComplexException Si hay un problema al determinar si es unitaria
	 */
	private static boolean validarTipoMatriz(MatrizCompleja matriz, TipoSistema tipo) throws ComplexException{
		boolean esValida = false;
		switch(tipo){
		case CLASICO:
			esValida = matriz.esDeDinamicaClasica();
			break;
		case ESTOCASTICO:
			esValida = matriz.esDeDinamicaDoblementeEstocastica();
			break;
		case CUANTICO:
			esValida = matriz.esDeDinamicaCuantica();
		default:
			break;                
		}
		return esValida;
	}

	/**
	 * 
	 * @param matriz Matriz dinamica del sistema
	 * @param t Potencia (exponente) que indica el numero de veces que se multiplicar� la matriz con s� msima
	 * @return Una matriz resultante de la potencia
	 * @throws ComplexException Si las matrices no se pueden multiplicar
	 */
	private static MatrizCompleja calcularPotencia(MatrizCompleja matriz, int t) throws ComplexException{
		for (int i = 0; i < t; i++) {
			matriz = CalculadoraMatricesComplejas.productoDeMatrices(matriz, matriz);

		}
		return matriz;
	}


	private static MatrizCompleja calcularEstadoFinal(MatrizCompleja matriz, MatrizCompleja vectorDeEstadoInicial, int numeroDeClicks) throws ComplexException{
		if(!vectorDeEstadoInicial.isVector()){
			throw new ComplexException(ComplexException.NO_ES_VECTOR);
		}
		for (int i = 0; i < numeroDeClicks; i++) {
			vectorDeEstadoInicial = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matriz, vectorDeEstadoInicial);

		}
		return vectorDeEstadoInicial;
	}
}