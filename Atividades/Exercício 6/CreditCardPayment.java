package strategy;

import java.util.Scanner;

public class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do cartão: ");
        String cardNumber = scanner.nextLine();
        System.out.println("Pagamento via Cartão de Crédito realizado.");
        System.out.println("Número do Cartão: " + cardNumber);
        System.out.println("Valor: R$" + amount);
    }
}