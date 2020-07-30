/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica.binarios.con.decimal;

/**
 *
 * @author bryan
 */
public class Numero {
    private int base;
    private double numero;
    private boolean negativo;
    
    public Numero(int base, double numero) {
        this.base = base;
        this.numero = numero;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(double numero) {
        this.numero = numero;
    }

    public boolean isNegativo() {
        return negativo;
    }

    public void setNegativo(boolean negativo) {
        this.negativo = negativo;
    }

    
}
