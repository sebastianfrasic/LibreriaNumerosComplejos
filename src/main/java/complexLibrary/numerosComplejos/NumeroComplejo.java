package complexLibrary.numerosComplejos;

import java.util.ArrayList;

public class NumeroComplejo {

    private double parteReal;
    private double parteImaginaria;
    private double modulo;
    private double fase;

    /**
     * Constructor de un numero complejo en su forma cartesiana
     *
     * @param parteReal       Parte real del numero complejo
     * @param parteImaginaria Parte imaginaria del numero complejo
     */
    public NumeroComplejo(double parteReal, double parteImaginaria) {
        this.parteReal = parteReal;
        this.parteImaginaria = parteImaginaria;
    }

    /**
     * Constructor de un numero complejo en su forma polar
     *
     * @param modulo      Modulo del numero complejo (Longitud del vector)
     * @param fase        Fase del numero complejo (Angulo formado por el vector)
     * @param estaEnPolar true si el numero complejo est� en forma polar,
     *                    false si no
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

    public double getModulo() {
        this.modulo = Math.sqrt((Math.pow(this.parteReal, 2)) + (Math.pow(this.parteImaginaria, 2)));
        return modulo;
    }

    public void setModulo(double modulo) {
        this.modulo = modulo;
    }

    public double getFase() {
        this.fase = Math.round(Math.toDegrees(Math.atan2(parteImaginaria, parteReal)));
        return fase;
    }

    public double getFase(boolean enPolar) {
        return fase;
    }

    public void setFase(double fase) {
        this.fase = fase;
    }

    /**
     * Calcula el conjugado de un numero complejo
     *
     * @return Conjugado (parte imaginaria * -1)
     */
    public NumeroComplejo getConjugado() {
        return new NumeroComplejo(parteReal, parteImaginaria * (-1));
    }

    /**
     * Calcula el inverso de un numero complejo (tanto parte real como parte
     * imaginaria multiplicadas por -1)
     *
     * @return Inverso de un numero complejo
     */
    public NumeroComplejo inversoDeUnNumeroComplejo() {
        this.parteImaginaria = this.parteImaginaria * (-1);
        this.parteReal = this.parteReal * (-1);
        return this;
    }

    /**
     * Pasa un numero complejo de su forma cartesiana a polar
     *
     * @return Numero complejo en su forma polar
     */
    public ArrayList<Double> cartesianoAPolar() {
        ArrayList<Double> polar = new ArrayList<>();

        polar.add(this.getModulo());
        polar.add(this.getFase());

        return polar;
    }

    private double cambiarParteReal() {
        return (double) Math.round((modulo * Math.cos(Math.toRadians(fase))));
    }

    private double cambiarParteImaginaria() {
        return (double) Math.round((modulo * Math.sin(Math.toRadians(fase))));
    }

    /**
     * Pasa un numero complejo de su forma polar a cartesiana
     *
     * @return Numero complejo en forma cartesiana
     */
    public ArrayList<Double> polarACartesiano() {
        ArrayList<Double> cartesiano = new ArrayList<>();

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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        NumeroComplejo other = (NumeroComplejo) obj;
        if (parteImaginaria != other.parteImaginaria) {
            return false;
        }
        return parteReal == other.parteReal;
    }

    @Override
    public String toString() {
        String resultado;
        if (parteReal == 0) {
            resultado = "(" + parteImaginaria + "i)";
        } else if (parteImaginaria == 0) {
            resultado = "(" + parteReal + ")";
        } else {
            resultado = "(" + parteReal + " + " + parteImaginaria + "i)";
        }
        if (parteReal == 0 && parteImaginaria == 0) {
            resultado = "(0)";
        }
        return resultado;
    }

}
