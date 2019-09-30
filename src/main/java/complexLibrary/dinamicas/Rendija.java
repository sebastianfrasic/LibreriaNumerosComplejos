package complexLibrary.dinamicas;

import complexLibrary.excepciones.ComplexException;
import complexLibrary.matricesComplejas.CalculadoraMatricesComplejas;
import complexLibrary.matricesComplejas.MatrizCompleja;

public class Rendija {
	
	public static Sistema calcularExperimentoDeRendijas(TipoSistema tipoDeSistema, int numeroDeRendijas, int numeroDeBlancosPared, MatrizCompleja vectorDeProbabilidad) throws ComplexException {
		if(vectorDeProbabilidad.getMatriz().length == ((2*numeroDeBlancosPared) + 1)){
			CalculadoraDinamica.validarTipoMatriz(vectorDeProbabilidad, tipoDeSistema);
			
			
			MatrizCompleja vectorEstadoInicial = null;
			MatrizCompleja matrizDelSistema = null;
			
			
			MatrizCompleja vectorEstadoFinal = CalculadoraDinamica.calcularDinamica(tipoDeSistema, matrizDelSistema, vectorEstadoInicial, 2).getVectorEstadoFinal();
			MatrizCompleja matrizPotencia = CalculadoraMatricesComplejas.productoDeMatricesSinRedondear(matrizDelSistema, matrizDelSistema);
			return new Sistema(matrizDelSistema, matrizPotencia, vectorEstadoFinal);
		}else {
			throw new ComplexException(ComplexException.VP_INVALIDO);
		}
		

	}
	
	/*
	private MatrizCompleja crearVectorDeEstadoInicial() {
		
	}
	
	private MatrizCompleja calcularMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared) {
		int size = calcularTamañoMatrizDelSistema(numeroDeRendijas, numeroDeBlancosPared);
		
		return null;
	}*/
	
	private static int calcularTamañoMatrizDelSistema(int numeroDeRendijas, int numeroDeBlancosPared) {
		int paredes = numeroDeRendijas + 1;
		
		int puntosNegros = numeroDeRendijas * numeroDeRendijas;
		int puntosRojos = paredes * numeroDeBlancosPared;
		
		int size = 1 + puntosNegros + puntosRojos;
		
		return size;
	}
	

}
