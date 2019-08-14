package src;

public class CalculadoraCompleja {
	
	private static CalculadoraCompleja calculadora = null;
	
	private CalculadoraCompleja() {
		
	}
	
	public static CalculadoraCompleja getCalculadoraCompleja() {
		
		if(calculadora == null) {
			calculadora = new CalculadoraCompleja();
		}
		
		return calculadora;
	}
	
	
	public NumeroComplejo sumaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {
		
		return new NumeroComplejo(a.getParteReal() + b.getParteReal(), a.getParteImaginaria() + b.getParteImaginaria());
		
	}
	

	public NumeroComplejo restaDeNumerosComplejos(NumeroComplejo a, NumeroComplejo b) {
		
		return new NumeroComplejo(a.getParteReal() - b.getParteReal(), a.getParteImaginaria() - b.getParteImaginaria());
		
	}
	
	
    public NumeroComplejo productoDeNumerosComplejos (NumeroComplejo a, NumeroComplejo b){
    	
        double parteReal = (a.getParteReal()*b.getParteReal()) - (a.getParteImaginaria()*b.getParteImaginaria());
        double parteImaginaria = (a.getParteReal()*b.getParteImaginaria()) + (a.getParteImaginaria()*b.getParteReal());
        
        return new NumeroComplejo(parteReal, parteImaginaria);
    }
    
    
    /**
     * Divide dos numeros complejos en su representacion cartesiana. Teniendo en cuenta la formula del libro.
     * @param a
     * @param b
     * @return
     */
    public NumeroComplejo divisionDeNumerosComplejos ( NumeroComplejo a, NumeroComplejo b){
    	
    	double dividendo = (Math.pow(b.getParteReal(),2) + Math.pow(b.getParteImaginaria(),2));
    	
        double parteA = ((a.getParteReal()*b.getParteReal()) + (a.getParteImaginaria()*b.getParteImaginaria()) / dividendo);
        double parteB = ((a.getParteImaginaria() * b.getParteReal()) - (a.getParteReal()*b.getParteImaginaria()) / dividendo);
        
        return new NumeroComplejo(parteA, parteB);
    }
	
	
	
	
	
	
	

}
