package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;
import complexLibrary.numerosComplejos.NumeroComplejo;

public class Rendija {
	
	public static Sistema calcularExperimentoDeRendijas(TipoSistema tipoDeSistema, int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja vectorDeProbabilidad) throws ComplexException {
		if(vectorDeProbabilidad.getMatriz().length == ((2*numeroDeBlancosPared) + 1)){
			CalculadoraDinamica.validarTipoMatriz(vectorDeProbabilidad, tipoDeSistema);
			
			int size = calcularTamañoMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);
			
			MatrizCompleja vectorEstadoInicial = crearVectorDeEstadoInicial(size);
			
			MatrizCompleja matrizDelSistema = calcularMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);
			
			
			
			MatrizCompleja matrizPotencia = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matrizDelSistema, matrizDelSistema);
			
			MatrizCompleja vectorEstadoFinal = CalculadoraDinamica.calcularDinamica(tipoDeSistema, matrizDelSistema, vectorEstadoInicial, 2).getVectorEstadoFinal();
			return new Sistema(matrizDelSistema, matrizPotencia, vectorEstadoFinal);
		}else {
			throw new ComplexException(ComplexException.VP_INVALIDO);
		}
		

	}
	
	
	public static MatrizCompleja crearVectorDeEstadoInicial(int size) throws ComplexException {
		MatrizCompleja vectorDeEstadoInicial = new MatrizCompleja(size, 1);
		vectorDeEstadoInicial.addComplex(0, 0, new NumeroComplejo(1, 0));
		NumeroComplejo cero = new NumeroComplejo(0,0);
		
		for (int i = 1; i < vectorDeEstadoInicial.getM(); i++) {
			vectorDeEstadoInicial.addComplex(i, 0, cero);			
		}
		System.out.println(vectorDeEstadoInicial);
		return vectorDeEstadoInicial;
		
		
	}
	
	private static MatrizCompleja calcularMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared) {
		int size = calcularTamañoMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);
		
		return null;
	}
	
	public static int calcularTamañoMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared) {
		int paredes = numeroDeRendijas + 1;
		
		int puntosNegros = 2*numeroDeRendijas;
		int puntosRojos = paredes * numeroDeBlancosPared;
		
		int size = 1 + puntosNegros + puntosRojos;
		
		return size;
	}
	

}
