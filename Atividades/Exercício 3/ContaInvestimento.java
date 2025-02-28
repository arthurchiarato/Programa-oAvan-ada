package org.example;

public class ContaInvestimento extends ContaBancaria {


    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }


    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            double taxa = valor * 0.02;
            saldo -= (valor + taxa);
            return true;
        }
        System.out.println("Saldo insuficiente para saque.");
        return false;
    }
}
