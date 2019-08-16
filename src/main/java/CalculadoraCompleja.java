package main.java;

public class CalculadoraCompleja {
	
	private static CalculadoraCompleja calculadora = null;
	
	private CalculadoraCompleja() {
		
	}
	
	
	/**
	 * 
	 * @return Una unica instancia de la calculadora compleja
	 */
	public static CalculadoraCompleja getCalculadoraCompleja() {
		
		if(calculadora == null) {
			calculadora = new CalculadoraCompleja();
		}
		
		return calculadora;
	}
	
	
	/**
	 * @param a Primer numero complejo
	 * @param b Segundo numero complejo
	 * @return La suma entre dos numeros complejos
	 */
	public NumeroComplejo sumaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {
		
		return new NumeroComplejo(a.getParteReal() + b.getParteReal(), a.getParteImaginaria() + b.getParteImaginaria());
		
	}
	
	
	/**
	 * @param a Primer numero complejo
	 * @param b Segundo numero complejo
	 * @return La resta entre dos numeros complejos
	 */
	public NumeroComplejo restaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {
		
		return new NumeroComplejo(a.getParteReal() - b.getParteReal(), a.getParteImaginaria() - b.getParteImaginaria());
		
	}
	
	
	
	/**
	 * @param a Primer numero complejo
	 * @param b Segundo numero complejo
	 * @return El producto entre dos numeros complejos
	 */
	public NumeroComplejo productoDeNumerosComplejos (NumeroComplejo a, NumeroComplejo b){
    	
        double parteReal = (a.getParteReal()*b.getParteReal()) - (a.getParteImaginaria()*b.getParteImaginaria());
        double parteImaginaria = (a.getParteReal()*b.getParteImaginaria()) + (a.getParteImaginaria()*b.getParteReal());
        
        return new NumeroComplejo(parteReal, parteImaginaria);
    }
    
    
	/**
	 * @param a Primer numero complejo
	 * @param b Segundo numero complejo
	 * @return La division entre dos numeros complejos
	 */
	public NumeroComplejo divisionDeNumerosComplejos (NumeroComplejo a, NumeroComplejo b){
    	
    	double dividendo = (Math.pow(b.getParteReal(),2) + Math.pow(b.getParteImaginaria(),2));
    	
        double parteA =  (a.getParteReal() * b.getParteReal()) + (a.getParteImaginaria() * b.getParteImaginaria()) ;
        double parteB = (a.getParteImaginaria() * b.getParteReal()) - (a.getParteReal()*b.getParteImaginaria());
        
   
        return new NumeroComplejo(parteA/dividendo, parteB/dividendo);
    }
    
    /**
     * @param a Numero complejo a calcular su modulo
     * @return El modulo del numero complejo dado
     */
	public double modulo(NumeroComplejo a){
    	return a.getModulo();
    }
    

    /**
     * @param a Numero complejo a calcular su conjugado
     * @return El conjugado del numero complejo dado
     */
	public NumeroComplejo conjugado(NumeroComplejo a){
    	return a.getConjugado();
    }
	
	
	
	
	
	
	

}
