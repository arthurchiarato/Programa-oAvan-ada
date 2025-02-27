package org.example;

public class Main {
    public static void main(String[] args) {

        ContaBancaria contaCorrente = new ContaCorrente("125", "Matheus Oliveira", 500.0, 200.0);
        ContaBancaria contaPoupanca = new ContaPoupanca("157", "Arthur Chiarato", 1000.0);
        ContaBancaria contaInvestimento = new ContaInvestimento("155", "Gabriel Visenti", 2000.0);


        contaCorrente.depositar(200.0);
        contaPoupanca.depositar(500.0);
        contaInvestimento.depositar(1000.0);


        contaCorrente.exibirInformacoes();
        contaPoupanca.exibirInformacoes();
        contaInvestimento.exibirInformacoes();


        contaCorrente.sacar(600.0);
        contaPoupanca.sacar(1500.0);
        contaInvestimento.sacar(1500.0);


        ContaBancaria contaSalario = new ContaSalario("321", "Pedro", 1500.0, 1000.0);
        ContaBancaria contaInvestimentoAltoRisco = new ContaInvestimentoAltoRisco("654", "Ana", 15000.0);


        contaSalario.sacar(500.0);
        contaSalario.sacar(500.0);
        contaInvestimentoAltoRisco.sacar(2000.0);
    }
}
