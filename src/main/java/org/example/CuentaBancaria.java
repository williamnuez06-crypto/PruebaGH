package org.example;


public class CuentaBancaria {

    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }
        // cambio en GH
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad; // Cambio en IJ para conflicto
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && saldo >= cantidad) {
            saldo -= cantidad;
            return true;
        }
        return false;
    }

    public double consultarSaldo() {
        return saldo;
    }

}
