package org.example;

import entities.Product;
import entities.User;
import repository.ProductRepository;
import repository.UserRepository;

import java.sql.*;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:database.db"; // URL do banco de dados SQLite
        try {
            // Registrar o driver do SQLite manualmente
            Class.forName("org.sqlite.JDBC");

            // Abrir conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url);

            // Criar tabelas caso não existam
            try (Statement stmt = connection.createStatement()) {
                String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                        "uuid TEXT PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "email TEXT NOT NULL," +
                        "password TEXT NOT NULL" +
                        ")";
                stmt.executeUpdate(createUsersTable);

                String createProductsTable = "CREATE TABLE IF NOT EXISTS products (" +
                        "uuid TEXT PRIMARY KEY," +
                        "name TEXT NOT NULL," +
                        "price REAL NOT NULL" +
                        ")";
                stmt.executeUpdate(createProductsTable);
            }

            // Criar repositórios
            UserRepository userRepository = new UserRepository(connection);
            ProductRepository productRepository = new ProductRepository(connection);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Cadastrar Usuário");
                System.out.println("2. Listar Usuários");
                System.out.println("3. Cadastrar Produto");
                System.out.println("4. Listar Produtos");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                int option = scanner.nextInt();
                scanner.nextLine();  // Limpa o buffer

                if (option == 1) {
                    // Cadastro de usuário
                    System.out.print("Nome: ");
                    String name = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha: ");
                    String password = scanner.nextLine();

                    User user = new User(UUID.randomUUID(), name, email, password);
                    userRepository.save(user);
                    System.out.println("Usuário cadastrado com sucesso!");

                } else if (option == 2) {
                    // Listagem de usuários
                    List<User> users = userRepository.findAll();
                    for (User u : users) {
                        System.out.println("ID: " + u.getUuid() + " | Nome: " + u.getName() + " | Email: " + u.getEmail());
                    }

                } else if (option == 3) {
                    // Cadastro de produto
                    System.out.print("Nome do produto: ");
                    String name = scanner.nextLine();
                    System.out.print("Preço: ");
                    double price = scanner.nextDouble();

                    Product product = new Product(UUID.randomUUID(), name, price);
                    productRepository.save(product);
                    System.out.println("Produto cadastrado com sucesso!");

                } else if (option == 4) {
                    // Listagem de produtos
                    List<Product> products = productRepository.findAll();
                    for (Product p : products) {
                        System.out.println("ID: " + p.getUuid() + " | Nome: " + p.getName() + " | Preço: " + p.getPrice());
                    }

                } else if (option == 5) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Erro: Driver do SQLite não encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
