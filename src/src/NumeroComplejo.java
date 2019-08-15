package src;

import java.util.ArrayList;

public class NumeroComplejo {
	
	private double parteReal;
	private double parteImaginaria;
	private double modulo;
	private double fase;
	
	/**
	 * Constructor de un numero complejo
	 * @param parteReal Parte real del numero complejo
	 * @param parteImaginaria Parte imaginaria del numero complejo
	 */
	public NumeroComplejo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}
	
	
	
	public NumeroComplejo(double modulo, double fase, boolean estaEnPolar) {
		this.modulo = modulo;
		this.fase = fase;
	}
	
	
	
	
	public double getParteReal() {
		return parteReal;
	}
	
	public void setParteReal(int parteReal) {
		this.parteReal = parteReal;
	}
	
	public double getParteImaginaria() {
		return parteImaginaria;
	}
	
	public void setParteImaginaria(int parteImaginaria) {
		this.parteImaginaria = parteImaginaria;
	}


	public double getModulo() {
		this.modulo = Math.sqrt( (Math.pow(this.parteReal, 2)) + (Math.pow(this.parteImaginaria, 2)) );
		return modulo;
	}


	public void setModulo(double modulo) {
		this.modulo = modulo;
	}
	


	public double getFase() {
		this.fase = Math.toDegrees(Math.atan(parteImaginaria/parteReal));
		return fase;
	}


	public void setFase(double fase) {
		this.fase = fase;
	}
	
	
	public NumeroComplejo getConjugado() {
		this.parteImaginaria = this.parteImaginaria * (-1);
		return this;
	}
	
	
	public ArrayList<Double> cartesianoAPolar(){
	       ArrayList<Double> polar = new ArrayList<Double>();
	       
	       polar.add(this.getModulo());
	       polar.add(this.getFase());
	       
	       return polar;
	    }
	
	
	
	
	private double cambiarParteReal() {
		double real = modulo * Math.cos(fase);
		return real;
	}
	
	private double cambiarParteImaginaria() {
		double i = modulo * Math.sin(fase);
		return i;
	}
	
	public ArrayList<Double> polarACartesiano(){
	       ArrayList<Double> cartesiano = new ArrayList<Double>();
	       
	       cartesiano.add(this.cambiarParteReal());
	       cartesiano.add(this.cambiarParteImaginaria());
	       
	       return cartesiano;
	    }
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(fase);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(modulo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(parteImaginaria);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(parteReal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NumeroComplejo other = (NumeroComplejo) obj;
		if (parteImaginaria != other.parteImaginaria)
			return false;
		if (parteReal != other.parteReal)
			return false;
		return true;
	}


	@Override
	public String toString() {
		
		String resultado;
		if(parteReal == 0) {
			resultado = "(" + parteImaginaria + "i)";
		}else if(parteImaginaria == 0) {
			resultado = "(" + parteReal + ")";
		}else {
			resultado = "(" + parteReal + " + " + parteImaginaria + "i)";
		}
		
		return resultado;
	}
	
	
	
	
	
	
	
	

}
