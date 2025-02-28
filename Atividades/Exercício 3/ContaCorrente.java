package org.example;

public class ContaCorrente extends ContaBancaria {
    private double limiteChequeEspecial;


    public ContaCorrente(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }


    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + limiteChequeEspecial) {
            saldo -= valor;
            return true;
        }
        System.out.println("Saldo insuficiente, incluindo limite de cheque especial.");
        return false;
    }
}
