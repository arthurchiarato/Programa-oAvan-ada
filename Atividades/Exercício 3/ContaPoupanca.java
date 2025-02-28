package org.example;

public class ContaPoupanca extends ContaBancaria {


    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }


    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        System.out.println("Saldo insuficiente para saque.");
        return false;
    }
}
