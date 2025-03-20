package org.example;

public class Produto  {

    public int codigo;
    public String nome;
    public double preco;

    public Produto(String nome, int codigo, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;

    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    void ExibirInformacoes(){
        System.out.println("codigo: " + codigo  + "\nnome: " + nome + "\npreco:R$" + preco);

    }

}
