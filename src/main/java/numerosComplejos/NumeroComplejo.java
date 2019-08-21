package main.java.numerosComplejos;

import java.util.ArrayList;

public class NumeroComplejo {
	
	private double parteReal;
	private double parteImaginaria;
	private double modulo;
	private double fase;
	
	/**
	 * Constructor de un numero complejo en su forma cartesiana
	 * @param parteReal Parte real del numero complejo
	 * @param parteImaginaria Parte imaginaria del numero complejo
	 */
	public NumeroComplejo(double parteReal, double parteImaginaria) {
		this.parteReal = parteReal;
		this.parteImaginaria = parteImaginaria;
	}
	
	
	/**
	 * Constructor de un numero complejo en su forma polar
	 * @param modulo Modulo del numero complejo (Longitud del vector)
	 * @param fase Fase del numero complejo (Angulo formado por el vector)
	 * @param estaEnPolar true si el numero complejo est� en forma polar, false si no
	 */
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


	public double getModulo(){
		this.modulo = Math.round(Math.sqrt( (Math.pow(this.parteReal, 2)) + (Math.pow(this.parteImaginaria, 2)) ));
		return modulo;
	}


	public void setModulo(double modulo){
		this.modulo = modulo;
	}
	

	public double getFase(){
		this.fase = Math.round(Math.toDegrees(Math.atan(parteImaginaria/parteReal)));
		return fase;
	}
	
	public double getFase(boolean enPolar) {
		return fase;
	}


	public void setFase(double fase) {
		this.fase = fase;
	}
	
	
	public NumeroComplejo getConjugado() {
		this.parteImaginaria = this.parteImaginaria * (-1);
		return this;
	}
	
	
	public ArrayList<Integer> cartesianoAPolar(){
	       ArrayList<Integer> polar = new ArrayList<Integer>();
	       
	       polar.add((int) this.getModulo());
	       polar.add((int) this.getFase());
	       
	       return polar;
	}
	
	
	private int cambiarParteReal() {
		int real = (int) Math.round((modulo * Math.cos(Math.toRadians(fase))));
		return real;
	}
	
	
	private int cambiarParteImaginaria() {
		int i = (int) Math.round((modulo * Math.sin(Math.toRadians(fase))));
		//System.out.println(Math.sin(Math.toRadians(fase)));
		return i;
	}
	
	
	public ArrayList<Integer> polarACartesiano(){
	       ArrayList<Integer> cartesiano = new ArrayList<Integer>();
	       
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
