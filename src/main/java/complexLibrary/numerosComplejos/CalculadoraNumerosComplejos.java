package complexLibrary.numerosComplejos;

import complexLibrary.ComplexException;



public class CalculadoraNumerosComplejos {
	
    private static CalculadoraNumerosComplejos calculadora = null;

    private CalculadoraNumerosComplejos() {

    }


    /**
     * 
     * @return Una unica instancia de la calculadora de numeros complejos
     */
    public static CalculadoraNumerosComplejos getCalculadoraCompleja() {

        if(calculadora == null) {
            calculadora = new CalculadoraNumerosComplejos();
        }

        return calculadora;
    }


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
    public static NumeroComplejo productoDeNumerosComplejos (NumeroComplejo a, NumeroComplejo b){

        double parteReal = (a.getParteReal()*b.getParteReal()) - (a.getParteImaginaria()*b.getParteImaginaria());
        double parteImaginaria = (a.getParteReal()*b.getParteImaginaria()) + (a.getParteImaginaria()*b.getParteReal());

        return new NumeroComplejo(parteReal, parteImaginaria);
    }


    /**
     * @param a Primer numero complejo
     * @param b Segundo numero complejo
     * @return La division entre dos numeros complejos
     * @throws ComplexException si se divide por cero
     */
    public static NumeroComplejo divisionDeNumerosComplejos (NumeroComplejo a, NumeroComplejo b) throws ComplexException{

        if(b.getParteReal() == 0 && b.getParteImaginaria() == 0) {
            throw new ComplexException(ComplexException.DIVISION_POR_CERO);
        }else{
            double dividendo = (Math.pow(b.getParteReal(),2) + Math.pow(b.getParteImaginaria(),2));

            double parteA =  (a.getParteReal() * b.getParteReal()) + (a.getParteImaginaria() * b.getParteImaginaria()) ;
            double parteB = (a.getParteImaginaria() * b.getParteReal()) - (a.getParteReal()*b.getParteImaginaria());
        
            return new NumeroComplejo(parteA/dividendo, parteB/dividendo);
        }
    }

    /**
     * @param a Numero complejo a calcular su modulo
     * @return El modulo del numero complejo dado
     */
    public static double modulo(NumeroComplejo a){
        return a.getModulo();
    }


    /**
     * @param a Numero complejo a calcular su conjugado
     * @return El conjugado del numero complejo dado
     */
    public static NumeroComplejo conjugado(NumeroComplejo a){
        return a.getConjugado();
    }
	
	
	
	
	
	
	

}