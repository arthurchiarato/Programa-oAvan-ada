package org.example;

public class ContaInvestimentoAltoRisco extends ContaInvestimento {


    public ContaInvestimentoAltoRisco(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }


    @Override
    public boolean sacar(double valor) {
        if (saldo >= 10000.00) {
            double taxa = valor * 0.05;
            saldo -= (valor + taxa);
            return true;
        } else {
            System.out.println("Saldo mínimo de R$ 10.000,00 exigido para saque.");
            return false;
        }
    }
}
