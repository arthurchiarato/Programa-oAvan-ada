package org.example;

public class ContaSalario extends ContaCorrente {
    private boolean saqueGratuitoUsado = false;


    public ContaSalario(String numeroConta, String titular, double saldo, double limiteChequeEspecial) {
        super(numeroConta, titular, saldo, limiteChequeEspecial);
    }


    @Override
    public boolean sacar(double valor) {
        if (!saqueGratuitoUsado) {
            if (super.sacar(valor)) {
                saqueGratuitoUsado = true;
                return true;
            }
        } else {
            if (saldo >= valor + 5.0) {
                saldo -= (valor + 5.0);
                return true;
            }
            System.out.println("Saldo insuficiente para saque com taxa.");
        }
        return false;
    }
}
