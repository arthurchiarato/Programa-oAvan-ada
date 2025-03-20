package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java .util.Scanner;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer, Produto> ListaDeProdutos = new HashMap<>();
        Scanner  scanner= new Scanner (System.in);
        int opcao;

        do{
            System.out.println("\n------ menu-------");
            System.out.println("1- cadastrar produto");
            System.out.println("2- buscar produto por código");
            System.out.println("escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opção de cadastro selecionado.");
                    System.out.println("digite o código do produto");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite o nome do produto");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o preço do produto");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    Produto produto = new Produto(nome, codigo, preco);
                    ListaDeProdutos.put(codigo, produto);

                    System.out.println("Produto cadastrado com sucesso!!!");
                break;
                case 2:
                    System.out.println("Opção de cadasrto selcionado.");
                    System.out.println("Digite o codigo do produto a ser buscado: ");
                    int codigoBusca = scanner.nextInt();

                    Produto produtobusca = ListaDeProdutos.get(codigoBusca);
                    if(produtobusca != null) {
                    produtobusca.ExibirInformacoes();

                    }else {
                        System.out.println("produto não encontrado");
                    }
                    break;

                case 3:
                    System.out.println("ssaindo...");

                    break;

                default:
                    System.out.println("opção inválida. tente novamemte.");

            }
        } while (opcao != 3);
        scanner.close();
    }



}
