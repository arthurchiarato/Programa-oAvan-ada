package src;

import java.util.ArrayList;
import java.util.List;

abstract class ContaBancaria {
    protected String numeroConta;
    protected String titular;
    protected double saldo;

    public ContaBancaria(String numeroConta, String titular, double saldo) {
        this.numeroConta = numeroConta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public abstract void sacar(double valor);

    public void exibirInformacoes() {
        System.out.println("Conta: " + numeroConta + ", Titular: " + titular + ", Saldo: R$" + saldo);
    }
}

class ContaCorrente extends ContaBancaria {
    private double chequeEspecial;

    public ContaCorrente(String numeroConta, String titular, double saldo, double chequeEspecial) {
        super(numeroConta, titular, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + chequeEspecial >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente, mesmo com cheque especial.");
        }
    }
}

class ContaPoupanca extends ContaBancaria {
    public ContaPoupanca(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
}

class ContaInvestimento extends ContaBancaria {
    public ContaInvestimento(String numeroConta, String titular, double saldo) {
        super(numeroConta, titular, saldo);
    }

    @Override
    public void sacar(double valor) {
        double taxa = valor * 0.02;
        if (saldo >= valor + taxa) {
            saldo -= (valor + taxa);
        } else {
            System.out.println("Saldo insuficiente para saque com taxa.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List<ContaBancaria> contas = new ArrayList<>();
        contas.add(new ContaCorrente("1234", "João", 1000, 500));
        contas.add(new ContaPoupanca("5678", "Maria", 1500));
        contas.add(new ContaInvestimento("91011", "Carlos", 5000));

        for (ContaBancaria conta : contas) {
            conta.exibirInformacoes();
            conta.sacar(500);
            conta.exibirInformacoes();
            System.out.println("-");
        }
    }
}
